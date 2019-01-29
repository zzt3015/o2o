package com.zt.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zt.o2o.entity.ShopCategory;

public interface ShopCategoryMapper {
    int deleteByPrimaryKey(Integer shopCategoryId);

    int insert(ShopCategory record);

    int insertSelective(ShopCategory record);

    ShopCategory selectByPrimaryKey(Integer shopCategoryId);

    int updateByPrimaryKeySelective(ShopCategory record);

    int updateByPrimaryKey(ShopCategory record);
    
    List<ShopCategory> queryShopCategory(
			@Param("shopCategoryCondition") ShopCategory shopCategoryCondition); 
}