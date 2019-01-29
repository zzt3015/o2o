package com.zt.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zt.o2o.entity.Shop;

public interface ShopMapper {

	int insertShop(Shop record);

	int deleteByPrimaryKey(Integer shopId);

	int insert(Shop record);

	int updateShop(Shop record);

	int insertSelective(Shop record);

	Shop selectByPrimaryKey(Integer shopId);

	int updateByPrimaryKeySelective(Shop record);

	int updateByPrimaryKey(Shop record);

	Shop queryByShopId(Integer shopId);

	List<Shop> queryCondition(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex,
			@Param("pageSize") int pageSize);

	int queryShopCount(@Param("shopCondition") Shop shopCondition);
}