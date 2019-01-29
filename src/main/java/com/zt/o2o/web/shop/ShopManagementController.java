package com.zt.o2o.web.shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zt.o2o.dto.ShopException;
import com.zt.o2o.entity.Area;
import com.zt.o2o.entity.PersonInfo;
import com.zt.o2o.entity.Shop;
import com.zt.o2o.entity.ShopCategory;
import com.zt.o2o.enums.ShopStateEnum;
import com.zt.o2o.service.AreaService;
import com.zt.o2o.service.ShopCategoryService;
import com.zt.o2o.service.ShopService;
import com.zt.o2o.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/shop")
public class ShopManagementController {

	@Autowired
	private ShopService shopService;
	@Autowired
	private ShopCategoryService shopcategroy;
	@Autowired
	private AreaService area;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	private String testShop() {
		Shop shop = shopService.queryShop(11);
		return shop.getArea().getAreaName() + shop.getArea().getAreaId();
	}

	
	@RequestMapping(value = "/productcategorymanage",method = RequestMethod.GET)	
	private String productCategory(){
		return "/shop/productcategorymanage";
	}
	
	
	@RequestMapping(value = "/shopoperation", method = RequestMethod.GET)
	private String adminShop() {

		return "/shop/shopedit";
	}
	
	@RequestMapping(value = "/shopmanage", method = RequestMethod.GET)
	private Map<String, Object> getShopMangementInfo(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
//		int shopId = (Integer) request.getSession().getAttribute("shopId");
		int shopId = HttpServletRequestUtil.getInt(request, "shopId");
		if (shopId < 0) {
			Object currentShopObj = request.getSession().getAttribute("currentShop");
			if (currentShopObj == null) {
				modelMap.put("redirect", true);
				modelMap.put("url", "o2o/shop/shoplist");
			} else {
				Shop currentShop = (Shop) currentShopObj;
				modelMap.put("redirect", false);
				modelMap.put("shopId", currentShop.getShopId());
			}
		} else {
			Shop currentShop = new Shop();
			currentShop.setShopId(shopId);
			request.getSession().setAttribute("currentShop", currentShop);
			modelMap.put("redirect", false);
		}
		return modelMap;
	}

	@RequestMapping(value = "/getShopById", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getShopById(HttpServletRequest request) throws Exception {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int shopId = HttpServletRequestUtil.getInt(request, "shopId");
		if (shopId > -1) {
			try {
				Shop shop = shopService.queryShop(shopId);
				List<Area> areaList = area.getAreaList();
				modelMap.put("shop", shop);
				modelMap.put("areaList", areaList);
				modelMap.put("succes", true);
			} catch (Exception e) {
				modelMap.put("false", false);
			}
		} else {
			modelMap.put("false", false);
		}
		return modelMap;
	}

	@RequestMapping(value = "/queryShopCondition", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> queryShopCondition(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		PersonInfo user = new PersonInfo();
		Shop shop = new Shop();
		user.setUserId(8);
		request.getSession().setAttribute("user", user);
		user = (PersonInfo) request.getSession().getAttribute("user");
		try {
			shop.setOwner(user);
			ShopException se = shopService.getShopList(shop, 0, 100);
			modelMap.put("shopList", se.getShopList());
			modelMap.put("user", user);
			modelMap.put("success", true);
		} catch (Exception e) {
			modelMap.put("false", false);
		}
		return modelMap;
	}

	@RequestMapping(value = "/selectshop", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> selectShop(HttpServletRequest request) {
		List<ShopCategory> shopCategoryList = new ArrayList<ShopCategory>();
		List<Area> areaList = new ArrayList<Area>();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		PersonInfo user = new PersonInfo();
		try {
			shopCategoryList = shopcategroy.getShopCategoryList(new ShopCategory());
			areaList = area.getAreaList();
			user.setName("test");
			request.getSession().setAttribute("user", user);
			user = (PersonInfo) request.getSession().getAttribute("user");	
			System.out.println("地域=" + areaList);
			System.out.println("商店类目=" + shopCategoryList);
		} catch (IOException e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		modelMap.put("shopCategoryList", shopCategoryList);
		modelMap.put("areaList", areaList);
		modelMap.put("user", user);
		modelMap.put("success", true);
		return modelMap;
	}

	@RequestMapping(value = "/modifyShop", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> modifyShop(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();

		ObjectMapper mapper = new ObjectMapper();
		// if (!CodeUtil.checkVerifyCode(request)) {
		// modelMap.put("success", false);
		// modelMap.put("errMsg", "验证码错误");
		// return modelMap;
		// }

		Shop shop = null;
		String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
		MultipartHttpServletRequest multipartHttpServletRequest = null;
		CommonsMultipartFile shopImg = null;
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (commonsMultipartResolver.isMultipart(request)) {
			multipartHttpServletRequest = (MultipartHttpServletRequest) request;
			shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
		}

		try {
			shop = mapper.readValue(shopStr, Shop.class);
		} catch (IOException e) {
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
			return modelMap;
		}

		if (null != shop && null != shop.getShopId()) {
			ShopException se;
			try {
				if (shopImg == null) {
					se = shopService.modifyShop(shop, null, null);
				} else {
					se = shopService.modifyShop(shop, shopImg, shopImg.getOriginalFilename());
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
		return modelMap;
	}

	@RequestMapping(value = "/registershop", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> registerShop(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();

		ObjectMapper mapper = new ObjectMapper();
		// if (!CodeUtil.checkVerifyCode(request)) {
		// modelMap.put("success", false);
		// modelMap.put("errMsg", "验证码错误");
		// return modelMap;	
		// }

		Shop shop = null;
		String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
		MultipartHttpServletRequest multipartHttpServletRequest = null;
		CommonsMultipartFile shopImg = null;
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (commonsMultipartResolver.isMultipart(request)) {
			multipartHttpServletRequest = (MultipartHttpServletRequest) request;
			shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "上传图片不能为空");
			return modelMap;
		}

		try {
			shop = mapper.readValue(shopStr, Shop.class);
		} catch (IOException e) {
			e.printStackTrace();
			modelMap.put("false", false);
			modelMap.put("errMsg", e.toString());
			return modelMap;
		}

		if (null != shop && null != shopImg) {
			PersonInfo owner = (PersonInfo) request.getSession().getAttribute("user");
			// PersonInfo owner = new PersonInfo();
			// owner.setUserId(1);
			shop.setOwner(owner);
			ShopException se;
			try {
				se = shopService.addShop(shop, shopImg, shopImg.getOriginalFilename());
				if (se.getState() == ShopStateEnum.CHECK.getState()) {
					List<Shop> shopList = (List<Shop>) request.getSession().getAttribute("shopList");
					if (shopList == null && shopList.size() == 0) {
						shopList = new ArrayList<Shop>();
					}
					shopList.add(se.getShop());
					request.getSession().setAttribute("shopList", shopList);
					modelMap.put("success", true);
				} else {
					modelMap.put("false", false);
					modelMap.put("errMsg", "wrong");
				}

			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
		return modelMap;
	}

}
