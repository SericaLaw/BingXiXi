package com.bxx.util;

public class StoreInfo {
	private String StoreName;
	private String StoreUrl;
	private String SellerID;
	private String MarketID;
	private String MWS;

	public StoreInfo(String storeName, String storeUrl, String sellerID, String marketID, String mWS) {
		super();
		StoreName = storeName;
		StoreUrl = storeUrl;
		SellerID = sellerID;
		MarketID = marketID;
		MWS = mWS;
	}

	public String getStoreName() {
		return StoreName;
	}

	public void setStoreName(String storeName) {
		StoreName = storeName;
	}

	public String getStoreUrl() {
		return StoreUrl;
	}

	public void setStoreUrl(String storeUrl) {
		StoreUrl = storeUrl;
	}

	public String getSellerID() {
		return SellerID;
	}

	public void setSellerID(String sellerID) {
		SellerID = sellerID;
	}

	public String getMarketID() {
		return MarketID;
	}

	public void setMarketID(String marketID) {
		MarketID = marketID;
	}

	public String getMWS() {
		return MWS;
	}

	public void setMWS(String mWS) {
		MWS = mWS;
	}

	@Override
	public String toString() {
		String str = "";
		if (this.getStoreName() != null) {
			str += String.format("and StoreName = '%s' ", this.getStoreName());
		}
		if (this.getStoreUrl() != null) {
			str += String.format("and StoreUrl = '%s' ", this.getStoreUrl());
		}
		if (this.getSellerID() != null) {
			str += String.format("and SellerID = '%s' ", this.getSellerID());
		}
		if (this.getMarketID() != null) {
			str += String.format("and MarketID = %s ", this.getMarketID());
		}
		if (this.getMWS() != null) {
			str += String.format("and MWS = '%s' ", this.getMWS());
		}
		if (str.equals(""))
			return str;
		return str.substring(4);
	}
}
