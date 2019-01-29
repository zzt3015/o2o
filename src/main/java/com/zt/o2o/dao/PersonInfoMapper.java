package com.zt.o2o.dao;

import com.zt.o2o.entity.PersonInfo;

public interface PersonInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(PersonInfo record);

    int insertSelective(PersonInfo record);

    PersonInfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(PersonInfo record);

    int updateByPrimaryKey(PersonInfo record);
}