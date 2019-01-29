package com.zt.o2o.service.Impl;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.zt.o2o.dao.AreaMapper;
import com.zt.o2o.entity.Area;
import com.zt.o2o.service.AreaService;


@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaMapper areaDao;


	public List<Area> getAreaList() throws JsonParseException,
			JsonMappingException, IOException {
		
		return areaDao.queryArea();
	}

	
}
