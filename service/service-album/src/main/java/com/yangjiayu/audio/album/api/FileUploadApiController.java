package com.yangjiayu.audio.album.api;

import com.yangjiayu.audio.album.config.MinioConstantProperties;
import com.yangjiayu.audio.common.result.Result;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.MinioException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Tag(name = "上传管理接口")
@RestController
@RequestMapping("api/album")
public class FileUploadApiController {

    @Autowired
    private MinioConstantProperties minioConstantProperties;

    /**
     * 文件上传
     * @param file 参数名称不能变，因为前端传递的时候，name的值就是file; contentType 类型： text/html; application/json;
     * @return
     */
    @Operation(summary="文件上传")
    @PostMapping("/fileUpload")
    public Result fileUpload(MultipartFile file) {
        // 看文件的路径
        String url = "";
        try {
            // Create a minioClient with the MinIO server playground, its access key and secret key.
            MinioClient minioClient =
                    MinioClient.builder()
                            .endpoint(minioConstantProperties.getEndpointUrl())
                            .credentials(minioConstantProperties.getAccessKey(), minioConstantProperties.getSecreKey())
                            .build();

            // Make 'asiatrip' bucket if not exist.
            boolean found =
                    minioClient.bucketExists(BucketExistsArgs.builder().bucket(minioConstantProperties.getBucketName()).build());
            if (!found) {
                // Make a new bucket called 'asiatrip'.
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(minioConstantProperties.getBucketName()).build());
            } else {
                System.out.println("Bucket "+minioConstantProperties.getBucketName()+" already exists.");
            }

            // Upload '/home/user/Photos/asiaphotos.zip' as object name 'asiaphotos-2015.zip' to bucket
            // 'asiatrip'.
            // Upload known sized input stream.
            String originalFilename = file.getOriginalFilename();  //at.yjy.yjy.jpg
            //获取文件的后缀名
            String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileName = UUID.randomUUID().toString().replaceAll( "-", "")+fileSuffix;
            minioClient.putObject(
                    PutObjectArgs.builder().bucket(minioConstantProperties.getBucketName()).object(fileName).stream(
                                    file.getInputStream(), file.getSize(), -1)
                            .contentType(file.getContentType())
                            .build());

            url =  minioConstantProperties.getEndpointUrl()+"/"+minioConstantProperties.getBucketName()+"/"+fileName;
            System.out.println( "File uploaded successfully.url:"+url);
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
            System.out.println("HTTP trace: " + e.httpTrace());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
        //返回图片地址
        return Result.ok(url);
    }

}
