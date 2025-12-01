package com.yangjiayu.audio.album.client;

import com.yangjiayu.audio.album.client.impl.TrackInfoDegradeFeignClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * 产品列表API接口
 * </p>
 *
 */
@FeignClient(value = "service-album", fallback = TrackInfoDegradeFeignClient.class)
public interface TrackInfoFeignClient {

}