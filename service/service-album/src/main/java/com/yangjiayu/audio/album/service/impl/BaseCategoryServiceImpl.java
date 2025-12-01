package com.yangjiayu.audio.album.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yangjiayu.audio.album.mapper.*;
import com.yangjiayu.audio.album.service.BaseCategoryService;
import com.yangjiayu.audio.model.album.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@SuppressWarnings({"all"})
public class BaseCategoryServiceImpl extends ServiceImpl<BaseCategory1Mapper, BaseCategory1> implements BaseCategoryService {

	@Autowired
	private BaseCategory1Mapper baseCategory1Mapper;

	@Autowired
	private BaseCategory2Mapper baseCategory2Mapper;

	@Autowired
	private BaseCategory3Mapper baseCategory3Mapper;


	@Autowired
	private BaseCategoryViewMapper baseCategoryViewMapper;

	@Autowired
	private BaseAttributeMapper baseAttributeMapper;


    @Override
    public List<JSONObject> getBaseCategoryList() {
        // 声明一个集合
        List<JSONObject> list = new ArrayList<>();

        //  查询所有分类在视图中
        List<BaseCategoryView> baseCategoryViewList = baseCategoryViewMapper.selectList(null);
        // 需要使用一级分类Id,分组：分组之后，将一级分类Id 变为map的key;value等于一级分类Id下的所有集合数据！
        // map的长度：15次
        Map<Long, List<BaseCategoryView>> map = baseCategoryViewList.stream()
                .collect(Collectors.groupingBy(BaseCategoryView::getCategory1Id));
        //循环遍历数据
        Iterator<Map.Entry<Long, List<BaseCategoryView>>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            // 获取map集合中的对象
            Map.Entry<Long, List<BaseCategoryView>> entry = iterator.next();

            Long category1Id = entry.getKey();
            //获取一级分类名称
            List<BaseCategoryView> categoryViewList = entry.getValue();

            // 先存储一级分类数据
            JSONObject category1 = new JSONObject();
            category1.put("categoryId", category1Id);
            category1.put("categoryName", categoryViewList.get(0).getCategory1Name());
            // 获取二级分类数据! key = category2Id value = category2List 也就是下面所有数据集合
            Map<Long, List<BaseCategoryView>> listMap = categoryViewList.stream()
                    .collect(Collectors.groupingBy(BaseCategoryView::getCategory2Id));
            // 获取二级分类数据
            Iterator<Map.Entry<Long, List<BaseCategoryView>>> iterator1 = listMap.entrySet().iterator();
            // 定义一个存储二级分类对象的集合列表
            ArrayList<JSONObject> category2ChildList = new ArrayList<>();
            while (iterator1.hasNext()) {
                // 获取集合对象
                Map.Entry<Long, List<BaseCategoryView>> entry1 = iterator1.next();
                Long category2Id = entry1.getKey();
                List<BaseCategoryView> categoryViewList1 = entry1.getValue();
                // 创建二级分类对象
                JSONObject category2 = new JSONObject();
                category2.put("categoryId", category2Id);
                //因为集合中的名称都一致！获取集合数据第一条数据即可！
                category2.put("categoryName", categoryViewList1.get(0).getCategory2Name());


                // 获取三级分类对象添加到集合中
                // 获取集合中的n个属性，组成一个新的集合，在这种情况下，可以使用stream流的map映射！
                List<JSONObject> category3ChildList = categoryViewList1.stream().map(baseCategoryView -> {
                    // 创建一个三级分类对象
                    JSONObject category3 = new JSONObject();
                    category3.put("categoryId", baseCategoryView.getCategory3Id());
                    category3.put("categoryName", baseCategoryView.getCategory3Name());
                    return category3;
                }).collect(Collectors.toList());

                //将三级分类集合添加到二级分类对象中

                category2.put("categoryChild",category3ChildList);

                // 将二级分类对象添加到集合中
                category2ChildList.add(category2);
            }
            // 一级中存储二级分类集合
            category1.put("categoryChild", category2ChildList);
            //将所有一级分类对象添加到集合
            list.add(category1);
        }
        // 返回数据
        return list;
    }

    @Override
    public List<BaseAttribute> findAttribute(Long category1Id) {
        // 调用mapper层方法；
        List<BaseAttribute> baseAttributeList = this.baseAttributeMapper.selectAttributeByCategory1Id(category1Id);
        return baseAttributeList;
    }

    @Override
//    @TsCache(prefix = "category:view:")
    public BaseCategoryView getBaseCategoryViewByCategoryId(Long category3Id) {
        // 返回数据
        return baseCategoryViewMapper.selectById(category3Id);
    }

    @Override
    public JSONObject getBaseCategoryList(Long category1Id) {
        // 创建一个一级分类对象
        JSONObject category1 = new JSONObject();
        // 存储数据；
        category1.put("category1Id",category1Id);
        // 根据一级分类Id获取一级分类名称；
//		BaseCategory1 baseCategory1 = baseCategory1Mapper.selectById(category1Id);
        //BaseCategory1 byId = this.getById(category1Id);
        // select * from base_category_view where category1_id = 1;
        List<BaseCategoryView> baseCategoryViewList = baseCategoryViewMapper.selectList(
                new LambdaQueryWrapper<BaseCategoryView>().eq(BaseCategoryView::getCategory1Id, category1Id));
        // 获取一级分类名称；
//		category1.put("categoryName",baseCategory1.getName());
        category1.put("categoryName",baseCategoryViewList.get(0).getCategory1Name());
        // 利用二级分类Id进行分组获取数据;key = category2Id,value = BaseCategoryView
        Map<Long, List<BaseCategoryView>> listMap = baseCategoryViewList.stream()
                .collect(Collectors.groupingBy(BaseCategoryView::getCategory2Id));
        Iterator<Map.Entry<Long, List<BaseCategoryView>>> iterator = listMap.entrySet().iterator();
        // 创建二级分类集合；
        ArrayList<JSONObject> category2ChildList = new ArrayList<>();
        while(iterator.hasNext()){

            Map.Entry<Long, List<BaseCategoryView>> entry = iterator.next();
            Long category2Id = entry.getKey();
            List<BaseCategoryView> categoryViewList = entry.getValue();
            // 创建一个二级分类对象;
            JSONObject category2 = new JSONObject();
            category2.put("categroyId",category2Id);
            category2.put("categoryName",categoryViewList.get(0).getCategory2Name());
            // 利用stream流的map
            List<JSONObject> category3ChildList = categoryViewList.stream().map(baseCategoryView -> {
                // 创建三级分类对象
                JSONObject category3 = new JSONObject();
                category3.put("categoryId", baseCategoryView.getCategory3Id());
                category3.put("categoryName", baseCategoryView.getCategory3Name());
                return category3;
            }).collect(Collectors.toList());
            // 将三级分类集合添加到二级分类中
            category2.put("categoryChild",category3ChildList);
            // 将二级分类对象添加到集合中
            category2ChildList.add(category2);

        }
        // 将二级分类集合添加到一级分类中
        category1.put("categoryChild",category2ChildList);
        // 返回数据
        return category1;
    }

    /**
     * 根据一级分类Id获取置顶数据
     * @param category1Id
     * @return
     */
    public List<BaseCategory3> findTopBaseCategory3(Long category1Id) {
        // 根据一级分类Id 查询二级分类数据
        // select * from base_category2 where category1_id = 2; # 104 105
        // wrapper 是什么意思？封装查询条件
        LambdaQueryWrapper<BaseCategory2> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BaseCategory2::getCategory1Id,category1Id);
        List<BaseCategory2> baseCategory2List = baseCategory2Mapper.selectList(queryWrapper);
        // 获取baseCategory2List 这个集合的id
        List<Long> baseCategory2IdList = baseCategory2List.stream().map(BaseCategory2::getId).collect(Collectors.toList());

        // select * from base_category3 where category2_id in (104,105) and is_top = 1 limit7;
        LambdaQueryWrapper<BaseCategory3> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(BaseCategory3::getCategory2Id,baseCategory2IdList).eq(BaseCategory3::getIsTop,1).last("limit 7");
        return baseCategory3Mapper.selectList(wrapper);
    }


	
}
