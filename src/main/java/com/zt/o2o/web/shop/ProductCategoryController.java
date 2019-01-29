package com.zt.o2o.web.shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zt.o2o.entity.ProductCategory;
import com.zt.o2o.entity.Shop;
import com.zt.o2o.service.ProductCategoryService;

@Controller
@RequestMapping("/product")
public class ProductCategoryController {

	@Autowired
	private ProductCategoryService productCategoryService;
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> selectList(HttpServletRequest request){
		Map<String,Object> productMap = new HashMap<String, Object>();
		Shop shop = new Shop();
		shop.setShopId(20);
		request.getSession().setAttribute("currentShop", shop);
		Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
		List<ProductCategory> productList = productCategoryService.selectAll(currentShop.getShopId());
		if(productList.size()>0){
			productMap.put("data", productList);
			productMap.put("success", true);
		}else{
			productMap.put("success", false);
		}
		return productMap;
	}
}
