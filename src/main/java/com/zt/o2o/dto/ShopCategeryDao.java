package com.zt.o2o.dto;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zt.o2o.entity.ShopCategory;

public interface ShopCategeryDao {

	List<ShopCategory> queryShopCategory(
			@Param("shopCategoryCondition") ShopCategory shopCategoryCondition); 
}
