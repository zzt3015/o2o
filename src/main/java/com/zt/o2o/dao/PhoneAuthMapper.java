package com.zt.o2o.dao;

import com.zt.o2o.entity.PhoneAuth;

public interface PhoneAuthMapper {
    int deleteByPrimaryKey(Integer phoneAuthId);

    int insert(PhoneAuth record);

    int insertSelective(PhoneAuth record);

    PhoneAuth selectByPrimaryKey(Integer phoneAuthId);

    int updateByPrimaryKeySelective(PhoneAuth record);

    int updateByPrimaryKey(PhoneAuth record);
}