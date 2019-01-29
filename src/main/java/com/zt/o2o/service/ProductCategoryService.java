package com.zt.o2o.service;

import java.util.List;

import com.zt.o2o.entity.ProductCategory;

public interface ProductCategoryService {

	List<ProductCategory> selectAll(int shopId);
}
