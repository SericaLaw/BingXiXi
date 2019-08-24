package com.bxx.dao;

public class BrandInfo {
	private String BrandName;
	private String COIntro;
	private String Type;
	private String CertiAddr;

	public BrandInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BrandInfo(String brandName, String cOIntro, String type, String certiAddr) {
		super();
		BrandName = brandName;
		COIntro = cOIntro;
		Type = type;
		CertiAddr = certiAddr;
	}

	public String getBrandName() {
		return BrandName;
	}

	public void setBrandName(String brandName) {
		BrandName = brandName;
	}

	public String getCOIntro() {
		return COIntro;
	}

	public void setCOIntro(String cOIntro) {
		COIntro = cOIntro;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getCertiAddr() {
		return CertiAddr;
	}

	public void setCertiAddr(String certiAddr) {
		CertiAddr = certiAddr;
	}

	@Override
	public String toString() {
		String str = "";
		if (this.getBrandName() != null) {
			str += String.format("and BrandName = '%s' ", this.getBrandName());
		}
		if (this.getCOIntro() != null) {
			str += String.format("and COIntro = '%s' ", this.getCOIntro());
		}
		if (this.getType() != null) {
			str += String.format("and Type = '%s' ", this.getType());
		}
		if (this.getCertiAddr() != null) {
			str += String.format("and CertiAddr = '%s' ", this.getCertiAddr());
		}

		if (str.equals(""))
			return str;
		return str.substring(4);
	}
}
