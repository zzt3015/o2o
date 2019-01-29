package com.zt.o2o.service.Impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zt.o2o.dao.ShopMapper;
import com.zt.o2o.dto.ShopException;
import com.zt.o2o.entity.Shop;
import com.zt.o2o.enums.ShopStateEnum;
import com.zt.o2o.service.ShopService;
import com.zt.o2o.util.FileUtil;
import com.zt.o2o.util.ImageUtil;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopMapper shopDao;

	@Transactional
	public ShopException addShop(Shop shop, MultipartFile file, String fileName) throws RuntimeException {
		if (null == shop) {
			return new ShopException(ShopStateEnum.NULL_SHOP_INFO);
		}
		try {
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			int num = shopDao.insertShop(shop);
			if (num < 0) {
				return new ShopException(ShopStateEnum.INNER_ERROR);
			} else {
				try {
					if (file != null) {
						addShopImg(shop, file, fileName);
					}
				} catch (Exception e) {
					throw new RuntimeException(e.getMessage());
				}
				int number = shopDao.updateShop(shop);
				if (number < 0) {
					throw new RuntimeException();
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("shopError" + e.getMessage());
		}
		return new ShopException(ShopStateEnum.CHECK, shop);
	}

	private void addShopImg(Shop shop, MultipartFile file, String fileName) {

		String dest = FileUtil.getShopImagePath(shop.getShopId());
		String pathUrl = ImageUtil.generateThumbnail(file, dest, fileName);
		shop.setShopImg(pathUrl);
	}

	public Shop queryShop(int shopId) {
		Shop shop = shopDao.queryByShopId(shopId);
		return shop;
	}

	public ShopException modifyShop(Shop shop, MultipartFile file, String fileName) throws RuntimeException {

		if (shop == null || file.getOriginalFilename() == null || fileName == null) {
			return new ShopException(ShopStateEnum.NULL_SHOP_INFO);
		} else {

			try {
				if (file != null) {
					Shop shopMsg = shopDao.queryByShopId(shop.getShopId());
					String shopImgUrl = shopMsg.getShopImg();
					if (shopImgUrl != null) {
						FileUtil.deleteShopImg(shopImgUrl);
					}
					addShopImg(shop, file, fileName);
				}

				
				shop.setLastEditTime(new Date());
				int countNUm = shopDao.updateShop(shop);
				if (countNUm < 0) {
					return new ShopException(ShopStateEnum.NULL_SHOP_INFO);
				} else {
					shop = shopDao.queryByShopId(shop.getShopId());
					return new ShopException(ShopStateEnum.SUCCESS, shop);
				}
			} catch (Exception e) {
				throw new RuntimeException();
			}

		}

	}

	public ShopException getShopList(Shop shopCondition, int pageIndex, int pageSize) {

		// List<Shop> shopList = new ArrayList<Shop>();
		List<Shop> shopList = shopDao.queryCondition(shopCondition, pageIndex, pageSize);
		ShopException se = new ShopException();

		if (shopList != null) {
			se.setShopList(shopList);
		} else {
			se.setState(ShopStateEnum.INNER_ERROR.getState());
		}
		return se;
	}

}
