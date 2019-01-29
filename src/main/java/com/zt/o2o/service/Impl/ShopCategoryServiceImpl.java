package com.zt.o2o.service.Impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zt.o2o.dao.ShopCategoryMapper;
import com.zt.o2o.entity.ShopCategory;
import com.zt.o2o.service.ShopCategoryService;
;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

   @Autowired
   private ShopCategoryMapper shopCategeryDao;
	
	public List<ShopCategory> getFirstLevelShopCategoryList() throws IOException {
	
		return null;
	}

	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategory) throws IOException {
	
		return shopCategeryDao.queryShopCategory(shopCategory);
	}

	public List<ShopCategory> getAllSecondLevelShopCategory() throws IOException {
		
		return null;
	}

	public ShopCategory getShopCategoryById(Long shopCategoryId) {
		
		return null;
	}
	
	}

