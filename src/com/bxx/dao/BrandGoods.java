package com.bxx.dao;

public class BrandGoods {
	private String Sku;
	private Double Weight;
	private Double Width;
	private Double Height;
	private Double Length;
	private String Title;
	private String Upc;
	private String Ena;
	private String Model;
	private Double Price;
	private String eBayDescription;
	private String AmazonDescription;
	private String Warranty;
	private String State;
	private String BrandName;
	private String Category;

	public BrandGoods(String sku, Double weight, Double width, Double height, Double length, String title, String upc,
			String ena, String model, Double price, String eBayDescription, String amazonDescription, String warranty,
			String state, String brandName, String category) {
		super();
		Sku = sku;
		Weight = weight;
		Width = width;
		Height = height;
		Length = length;
		Title = title;
		Upc = upc;
		Ena = ena;
		Model = model;
		Price = price;
		this.eBayDescription = eBayDescription;
		AmazonDescription = amazonDescription;
		Warranty = warranty;
		State = state;
		BrandName = brandName;
		Category = category;
	}

	public String getSku() {
		return Sku;
	}

	public void setSku(String sku) {
		Sku = sku;
	}

	public Double getWeight() {
		return Weight;
	}

	public void setWeight(Double weight) {
		Weight = weight;
	}

	public Double getWidth() {
		return Width;
	}

	public void setWidth(Double width) {
		Width = width;
	}

	public Double getHeight() {
		return Height;
	}

	public void setHeight(Double height) {
		Height = height;
	}

	public Double getLength() {
		return Length;
	}

	public void setLength(Double length) {
		Length = length;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getUpc() {
		return Upc;
	}

	public void setUpc(String upc) {
		Upc = upc;
	}

	public String getEna() {
		return Ena;
	}

	public void setEna(String ena) {
		Ena = ena;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public String geteBayDescription() {
		return eBayDescription;
	}

	public void seteBayDescription(String eBayDescription) {
		this.eBayDescription = eBayDescription;
	}

	public String getAmazonDescription() {
		return AmazonDescription;
	}

	public void setAmazonDescription(String amazonDescription) {
		AmazonDescription = amazonDescription;
	}

	public String getWarranty() {
		return Warranty;
	}

	public void setWarranty(String warranty) {
		Warranty = warranty;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getBrandName() {
		return BrandName;
	}

	public void setBrandName(String brandName) {
		BrandName = brandName;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String toString() {
		String str = "";
		if (this.getSku() != null) {
			str += String.format("and Sku = '%s' ", this.getSku());
		}
		if (this.getWeight() != null) {
			str += String.format("and Weight = %f ", this.getWeight());
		}
		if (this.getLength() != null) {
			str += String.format("and Length = %f ", this.getLength());
		}
		if (this.getWidth() != null) {
			str += String.format("and Width = %f ", this.getWidth());
		}
		if (this.getHeight() != null) {
			str += String.format("and Height = %f ", this.getHeight());
		}
		if (this.getTitle() != null) {
			str += String.format("and Title = '%s' ", this.getTitle());
		}
		if (this.getUpc() != null) {
			str += String.format("and Upc = '%s' ", this.getUpc());
		}
		if (this.getEna() != null) {
			str += String.format("and Ena = '%s' ", this.getEna());
		}
		if (this.getModel() != null) {
			str += String.format("and Model = '%s' ", this.getModel());
		}
		if (this.getPrice() != null) {
			str += String.format("and Price = %f ", this.getPrice());
		}
		if (this.geteBayDescription() != null) {
			str += String.format("and eBayDescription = '%s' ", this.geteBayDescription());
		}
		if (this.getAmazonDescription() != null) {
			str += String.format("and AmazonDescription = '%s' ", this.getAmazonDescription());
		}
		if (this.getWarranty() != null) {
			str += String.format("and Warranty = '%s' ", this.getWarranty());
		}
		if (this.getState() != null) {
			str += String.format("and State = '%s' ", this.getState());
		}
		if (this.getBrandName() != null) {
			str += String.format("and BrandName = '%s' ", this.getBrandName());
		}
		if (this.getCategory() != null) {
			str += String.format("and Category = '%s' ", this.getCategory());
		}
		if (str.equals(""))
			return str;
		return str.substring(4);
	}
}
