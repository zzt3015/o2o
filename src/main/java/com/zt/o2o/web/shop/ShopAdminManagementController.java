package com.zt.o2o.web.shop;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zt.o2o.entity.ShopCategory;
import com.zt.o2o.service.ShopCategoryService;
import com.zt.o2o.service.ShopService;


@Controller
@RequestMapping("/shopAdmin")
public class ShopAdminManagementController {

	@Autowired
	private ShopService shopService;
	
	@Autowired
	private ShopCategoryService shopCategoryService;
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String adminShop() throws IOException {
      
		List<ShopCategory> shopList =  shopCategoryService.getShopCategoryList(new ShopCategory());
		
		return "/shop/shoplist";
	}
	
	
	
}
