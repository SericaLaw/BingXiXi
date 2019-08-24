package com.bxx.dao;

public class BvoGoods {
	private String Sku;
	private Integer Inventory;
	private Boolean IfDropShip;
	private Boolean IfWishList;

	public BvoGoods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BvoGoods(String sku, Integer inventory, Boolean ifDropShip, Boolean ifWishList) {
		super();
		Sku = sku;
		Inventory = inventory;
		IfDropShip = ifDropShip;
		IfWishList = ifWishList;
	}

	public String getSku() {
		return Sku;
	}

	public void setSku(String sku) {
		Sku = sku;
	}

	public Integer getInventory() {
		return Inventory;
	}

	public void setInventory(Integer inventory) {
		Inventory = inventory;
	}

	public Boolean getIfDropShip() {
		return IfDropShip;
	}

	public void setIfDropShip(Boolean ifDropShip) {
		IfDropShip = ifDropShip;
	}

	public Boolean getIfWishList() {
		return IfWishList;
	}

	public void setIfWishList(Boolean ifWishList) {
		IfWishList = ifWishList;
	}

	@Override
	public String toString() {
		String str = "";
		if (this.getSku() != null) {
			str += String.format("and Sku = '%s' ", this.getSku());
		}
		if (this.getInventory() != null) {
			str += String.format("and Inventory = %d ", this.getInventory());
		}
		if (this.getIfDropShip() != null) {
			str += String.format("and IfDropShip = %b ", this.getIfDropShip());
		}
		if (this.getIfWishList() != null) {
			str += String.format("and IfWishList = %b ", this.getIfWishList());
		}
		if (str.equals(""))
			return str;
		return str.substring(4);
	}
}
