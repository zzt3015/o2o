package com.zt.o2o.dao;

import com.zt.o2o.entity.UserAwardMap;

public interface UserAwardMapMapper {
    int deleteByPrimaryKey(Integer userAwardId);

    int insert(UserAwardMap record);

    int insertSelective(UserAwardMap record);

    UserAwardMap selectByPrimaryKey(Integer userAwardId);

    int updateByPrimaryKeySelective(UserAwardMap record);

    int updateByPrimaryKey(UserAwardMap record);
}