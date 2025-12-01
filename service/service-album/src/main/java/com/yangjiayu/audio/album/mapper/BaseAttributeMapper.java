package com.yangjiayu.audio.album.mapper;

import com.yangjiayu.audio.model.album.BaseAttribute;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BaseAttributeMapper extends BaseMapper<BaseAttribute> {

    /**
     * 根据一级分类Id获取属性与属性值集合
     * @param category1Id
     * @return
     */
    List<BaseAttribute> selectAttributeByCategory1Id(@Param("category1Id") Long category1Id);

}
