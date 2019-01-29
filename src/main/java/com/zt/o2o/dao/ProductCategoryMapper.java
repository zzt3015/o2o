package com.zt.o2o.dao;

import java.util.List;

import com.zt.o2o.entity.ProductCategory;

public interface ProductCategoryMapper {
    int deleteByPrimaryKey(Integer productCategoryId);

    int insert(ProductCategory record);

    int insertSelective(ProductCategory record);

    ProductCategory selectByPrimaryKey(Integer productCategoryId);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);
    
    List<ProductCategory> selectAll(int shopId);
}