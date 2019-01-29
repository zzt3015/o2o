package com.zt.o2o.dao;

import java.util.List;

import com.zt.o2o.entity.Area;

public interface AreaMapper {
	
	
	List<Area> queryArea();
	
    int deleteByPrimaryKey(Integer areaId);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer areaId);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
}