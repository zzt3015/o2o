package com.zt.o2o.dao;

import com.zt.o2o.entity.UserProductMap;

public interface UserProductMapMapper {
    int deleteByPrimaryKey(Integer userProductId);

    int insert(UserProductMap record);

    int insertSelective(UserProductMap record);

    UserProductMap selectByPrimaryKey(Integer userProductId);

    int updateByPrimaryKeySelective(UserProductMap record);

    int updateByPrimaryKey(UserProductMap record);
}