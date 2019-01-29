package com.zt.o2o.enums;


public enum ShopStateEnum {

	CHECK(0, "�����"), OFFLINE(-1, "�Ƿ�����"), SUCCESS(1, "�����ɹ�"), PASS(2, "ͨ����֤"), INNER_ERROR(
			-1001, "����ʧ��"), NULL_SHOPID(-1002, "ShopIdΪ��"), NULL_SHOP_INFO(
			-1003, "�����˿յ���Ϣ");

	private int state;

	private String stateInfo;

	private ShopStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public static ShopStateEnum stateOf(int index) {
		for (ShopStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}
}