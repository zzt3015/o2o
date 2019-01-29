package com.zt.o2o.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zt.o2o.dao.ProductCategoryMapper;
import com.zt.o2o.entity.ProductCategory;
import com.zt.o2o.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    
	@Autowired
	private ProductCategoryMapper productCategoryMapper;
	
	public List<ProductCategory> selectAll(int shopId) {
		 
		return productCategoryMapper.selectAll(shopId);
	}

}
