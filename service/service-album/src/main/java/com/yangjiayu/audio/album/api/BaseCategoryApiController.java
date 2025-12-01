package com.yangjiayu.audio.album.api;

import com.alibaba.fastjson.JSONObject;
import com.yangjiayu.audio.album.service.BaseCategoryService;
import com.yangjiayu.audio.common.result.Result;
import com.yangjiayu.audio.model.album.BaseAttribute;
import com.yangjiayu.audio.model.album.BaseCategory1;
import com.yangjiayu.audio.model.album.BaseCategory3;
import com.yangjiayu.audio.model.album.BaseCategoryView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "分类管理")
@RestController
@RequestMapping(value="/api/album/category")
@SuppressWarnings({"all"})
public class BaseCategoryApiController {
	
	@Autowired
	private BaseCategoryService baseCategoryService;

    /*
    base_category_view : 存储了所有分类的一个数据
    [
 {
    "categoryName":"音乐",   #一级分类名称
    "categoryId":1,                       #一级分类ID
    "categoryChild":[                     #当前一级分类包含的二级分类集合
        {
            "categoryName":"音乐音效",     #二级分类名称
            "categoryId":101,               #二级分类ID
            "categoryChild":[             #当前二级分类包含的三级分类集合
               {
                  "categoryName": "催眠音乐",
                  "categoryId": 1001
                },
                {
                  "categoryName": "放松音乐",
                  "categoryId": 1002
                },
                {
                  "categoryName": "提神音乐",
                  "categoryId": 1003
                }
            ]
        }
    ]
},
{
    "categoryName":"有声书",
    "categoryId":2,
    "categoryChild":[
        {
            "categoryName":"男频小说",
            "categoryId":104,
            "categoryChild":[
                {
                    "categoryName":"军事小说",
                    "categoryId":1009
                }
            ]
        }
    ]
 }
]
     */


    /**
     * 获取全部一级分类
     *
     * @return
     */
    @Operation(summary = "获取全部一级分类数据")
    @GetMapping("/findAllCategory1")
    public Result<List<BaseCategory1>> findAllCategory1() {
        //  返回数据;
        return Result.ok(baseCategoryService.list());
    }


    /**
     * 根据一级分类Id获取置顶数据
     * @param category1Id
     * @return
     */
    @Operation(summary = "根据一级分类Id获取三级分类的置顶数据")
    @GetMapping("/findTopBaseCategory3/{category1Id}")
    public Result<List<BaseCategory3>> findTopBaseCategory3(@PathVariable Long category1Id){
        // 调用服务层方法
        List<BaseCategory3> baseCategory3List = baseCategoryService.findTopBaseCategory3(category1Id);
        // 返回数据
        return Result.ok(baseCategory3List);
    }


    /**
     * 根据一级分类Id获取到分类数据
     * @param category1Id
     * @return
     */
    @Operation(summary = "根据一级分类Id获取到分类数据")
    @GetMapping("/getBaseCategoryList/{category1Id}")
    public Result getBaseCategoryList(@PathVariable Long category1Id){
        // 调用服务层方法，根据一级分类Id 获取到一个分类对象{包含多个二级数据 二级数据中包含多个三级数据}
        JSONObject category1 = baseCategoryService.getBaseCategoryList(category1Id);
        // 返回数据
        return Result.ok(category1);
    }


    /**
     * 根据分类Id获取分类信息
     * @param category3Id
     * @return
     */
    @Operation(summary = "根据三级分类Id获取分类信息")
    @GetMapping("/getBaseCategoryViewByCategoryId/{category3Id}")
    public Result<BaseCategoryView> getBaseCategoryViewByCategoryId(@PathVariable Long category3Id){
        // 调用服务层方法
        BaseCategoryView baseCategoryView = baseCategoryService.getBaseCategoryViewByCategoryId(category3Id);
        return Result.ok(baseCategoryView);
    }


    @Operation(summary = "根据一级分类Id获取属性与属性值集合")
    @GetMapping("/findAttribute/{category1Id}")
    public Result findAttribute(@PathVariable Long category1Id){
        // 调用服务层方法
        List<BaseAttribute>baseAttributeList = baseCategoryService.findAttribute(category1Id);
        // 返回数据
        return Result.ok(baseAttributeList);
    }




    // /getBaseCategoryList

    /**
     * 获取分页数据
     * @return
     */
    @Operation(summary = "获取分类列表")
    @GetMapping("/getBaseCategoryList")
    public Result getBaseCategoryList() {
        // 调用服务层的方法: 包含：一级，二级，三级分类数据！ 2.方法的参数：0 查询所有的一级分类数据集合！
        //3.返回数据的时候：T包含三个属性，T看作一个实体类型一个Map集合；
		/*
		@Data
		public class Param {
			private String categoryId;
			private String categoryName;
			private String categoryChild;
		}
		param.setCategoryId(1);
		param.setCategoryName("音乐");
		param.setCategoryId(list);
		return Result.ok(param);
		前端获取数据 parade.categoryId();param.categoryList()

		HashMap<String,Object>map = new HashMap<>();
		map.put("categoryId",1);
		map.put("categoryName","音乐");
		map.put("categoryChild","二级分类集合");
		return Result.ok(map);
		前端获取数据 parade.get("categoryId");parade.get("categoryName");parade.get("categoryChild");

		实体类属性相当于map的key;实体类的属性值相当于map的value
		 */

        List<JSONObject>list =  baseCategoryService.getBaseCategoryList();
        // 返回数据
        return Result.ok(list);
    }

}

