package com.zt.o2o.service;


import org.springframework.web.multipart.MultipartFile;

import com.zt.o2o.dto.ShopException;
import com.zt.o2o.entity.Shop;

public interface ShopService {
  
	ShopException addShop(Shop shop ,MultipartFile file,String fileName) throws RuntimeException;
	
	Shop queryShop(int shopId);
	
	ShopException modifyShop(Shop shop ,MultipartFile file,String fileName) throws RuntimeException;
	
	ShopException getShopList(Shop shopCondition, int pageIndex, int pageSize);
}
