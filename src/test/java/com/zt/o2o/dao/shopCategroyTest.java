package com.zt.o2o.dao;



import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zt.o2o.BaseTest;
import com.zt.o2o.dto.ShopCategeryDao;
import com.zt.o2o.entity.ShopCategory;

public class shopCategroyTest extends BaseTest{
  @Autowired
  private ShopCategeryDao shopCategeryDao;
  
  @Test
  public  void shopTest(){
//	  List<ShopCategory> shopCategoryList = shopCategeryDao.queryShopCategory(new ShopCategory());
//      assertEquals(18,shopCategoryList.size());
  }
	
}
