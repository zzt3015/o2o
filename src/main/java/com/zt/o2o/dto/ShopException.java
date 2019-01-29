package com.zt.o2o.dto;

import java.util.List;

import com.zt.o2o.entity.Shop;
import com.zt.o2o.enums.ShopStateEnum;

public class ShopException {

	private int state;

	private String stateInfo;

	// ��������
	private int count;

	// ������shop����ɾ�ĵ��̵�ʱ���ã�
	private Shop shop;

	// ��ȡ��shop�б�(��ѯ�����б��ʱ����)
	private List<Shop> shopList;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public List<Shop> getShopList() {
		return shopList;
	}

	public void setShopList(List<Shop> shopList) {
		this.shopList = shopList;
	}

	public ShopException() {

	}

	public ShopException(ShopStateEnum stateEnum) {

		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	public ShopException(ShopStateEnum stateEnum, List<Shop> shopList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shopList = shopList;
	}

	public ShopException(ShopStateEnum stateEnum,Shop shop) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shop = shop;
	}

}
