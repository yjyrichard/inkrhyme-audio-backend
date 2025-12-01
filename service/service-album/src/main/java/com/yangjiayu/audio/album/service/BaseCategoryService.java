package com.yangjiayu.audio.album.service;

import com.alibaba.fastjson.JSONObject;
import com.yangjiayu.audio.model.album.BaseAttribute;
import com.yangjiayu.audio.model.album.BaseCategory1;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yangjiayu.audio.model.album.BaseCategory3;
import com.yangjiayu.audio.model.album.BaseCategoryView;

import java.util.List;

public interface BaseCategoryService extends IService<BaseCategory1> {

    /**
     * 获取分类列表
     * @return
     */
    List<JSONObject> getBaseCategoryList();

    /**
     * 根据一级分类Id获取属性与属性值集合
     * @param category1Id
     * @return
     */
    List<BaseAttribute> findAttribute(Long category1Id);

    BaseCategoryView getBaseCategoryViewByCategoryId(Long category3Id);

    /**
     * 根据一级分类Id获取分类数据
     * @param category1Id
     * @return
     */
    JSONObject getBaseCategoryList(Long category1Id);

    /**
     *根据一级分类Id获取置顶数据
     * @param category1Id
     * @return
     */
    List<BaseCategory3> findTopBaseCategory3(Long category1Id);


}
