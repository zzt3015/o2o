package com.zt.o2o.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.zip.InflaterInputStream;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.zt.o2o.BaseTest;
import com.zt.o2o.entity.Area;
import com.zt.o2o.entity.Shop;
import com.zt.o2o.entity.ShopCategory;
import com.zt.o2o.service.ShopService;

public class ShopTest extends BaseTest{

	@Autowired
	private ShopMapper shopDao;
	
	@Autowired
	private ShopService shopService;
	
	@Test
	public void testmodify() throws FileNotFoundException{
		Shop shop = new Shop();
//		shop.setOwnerId((int) 1L);
		shop.setShopId(11);
		File file = new File("E:/Test/123.jpg");
		InputStream is = (InputStream) new FileInputStream(file);
		shopService.modifyShop(shop, (MultipartFile) is, "123.jpg");
		
	}
	
	@Test
	public void testShop(){
		Shop shop = new Shop();
		shop.setOwnerId((int) 1L);
//		Area area = new Area();
//		area.setAreaId(1L);
//		ShopCategory sc = new ShopCategory();
//		sc.setShopCategoryId(1L);
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
//		int effectedNum = shopDao.insertShop(shop);
//		assertEquals(1, effectedNum);
	}
	
}
