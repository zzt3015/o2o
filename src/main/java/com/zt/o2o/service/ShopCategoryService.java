package com.zt.o2o.service;



import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.zt.o2o.entity.ShopCategory;


public interface ShopCategoryService {
	/**
	 * 鏌ヨ鎸囧畾鏌愪釜搴楅摵涓嬬殑鎵�鏈夊晢鍝佺被鍒俊鎭�
	 * 
	 * @param long shopId
	 * @return List<ProductCategory>
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	List<ShopCategory> getFirstLevelShopCategoryList() throws IOException;

	/**
	 * 
	 * @param parentId
	 * @return
	 * @throws IOException
	 */
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategory) throws IOException;

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	List<ShopCategory> getAllSecondLevelShopCategory() throws IOException;

	/**
	 * 
	 * @param shopCategory
	 * @return
	 */
	ShopCategory getShopCategoryById(Long shopCategoryId);

    
	
	
}
