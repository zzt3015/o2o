package com.zt.o2o.dao;

import com.zt.o2o.entity.ShopAuthMap;

public interface ShopAuthMapMapper {
    int deleteByPrimaryKey(Integer shopAuthId);

    int insert(ShopAuthMap record);

    int insertSelective(ShopAuthMap record);

    ShopAuthMap selectByPrimaryKey(Integer shopAuthId);

    int updateByPrimaryKeySelective(ShopAuthMap record);

    int updateByPrimaryKey(ShopAuthMap record);
}