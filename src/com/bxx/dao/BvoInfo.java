package com.bxx.dao;

public class BvoInfo {
	private String SellerID;
	private String Tel;
	private String EMail;
	private String SellerName;

	public BvoInfo(String sellerID, String tel, String eMail, String sellerName) {
		super();
		SellerID = sellerID;
		Tel = tel;
		EMail = eMail;
		SellerName = sellerName;
	}

	public String getSellerID() {
		return SellerID;
	}

	public void setSellerID(String sellerID) {
		SellerID = sellerID;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public String getEMail() {
		return EMail;
	}

	public void setEMail(String eMail) {
		EMail = eMail;
	}

	public String getSellerName() {
		return SellerName;
	}

	public void setSellerName(String sellerName) {
		SellerName = sellerName;
	}

	@Override
	public String toString() {
		String str = "";
		if (this.getSellerID() != null) {
			str += String.format("and SellerID = '%s' ", this.getSellerID());
		}
		if (this.getTel() != null) {
			str += String.format("and Tel = '%s' ", this.getTel());
		}
		if (this.getEMail() != null) {
			str += String.format("and EMail = '%s' ", this.getEMail());
		}
		if (this.getSellerName() != null) {
			str += String.format("and SellerName = '%s' ", this.getSellerName());
		}
		if (str.equals(""))
			return str;
		return str.substring(4);
	}
}
