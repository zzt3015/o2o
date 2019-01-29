package com.zt.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zt.o2o.BaseTest;
import com.zt.o2o.dto.ShopException;
import com.zt.o2o.entity.Area;
import com.zt.o2o.entity.Shop;
import com.zt.o2o.entity.ShopCategory;

public class shopTest extends BaseTest{

	@Autowired
	private ShopService shopService;

	@Test
	public void testAddShop() throws Exception {
//		Shop shop = new Shop();
//		shop.setOwnerId(1);
//		Area area = new Area();
//		area.setAreaId(1);
//		ShopCategory sc = new ShopCategory();
//		sc.setShopCategoryId(1);
//		shop.setShopName("mytest1");
//		shop.setShopDesc("mytest1");
//		shop.setShopAddr("testaddr1");
//		shop.setPhone("13810524526");
//		shop.setShopImg("test1");
//		shop.setLongitude(1D);
//		shop.setLatitude(1D);
//		shop.setCreateTime(new Date());
//		shop.setLastEditTime(new Date());
//		shop.setEnableStatus(0);
//		shop.setAdvice("…Û∫À÷–");
//		shop.setArea(area);
//		shop.setShopCategory(sc);
//		File shopImg = new File("E:/456.jpg");
//		InputStream is = new FileInputStream(shopImg);
//		ShopException se = shopService.addShop(shop,is,shopImg.getName());
//		assertEquals("mytest1", se.getShop().getShopName());
		
		Shop shop = shopService.queryShop(11);
		System.out.println(shop.getArea().getAreaId());
		System.out.println(shop.getArea().getAreaName());
	}

	
}
