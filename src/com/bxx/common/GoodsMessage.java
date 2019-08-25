package com.bxx.common;

import java.util.Date;

public class GoodsMessage {
	private String Title;
	private String Category;
	private String PicUrl;
	private String State;

	private String Sku;
	private Double Price;
	private Integer QTY;
	private String OrderNumber;
	private String TrackNumber;
	private Date Time;

	public String getSku() {
		return Sku;
	}

	public void setSku(String sku) {
		Sku = sku;
	}

	public GoodsMessage(String title, String category, String picUrl, String state, String sku, Double price,
			Integer qTY, String orderNumber, String trackNumber, Date time) {
		super();
		Title = title;
		Category = category;
		PicUrl = picUrl;
		State = state;
		Sku = sku;
		Price = price;
		QTY = qTY;
		OrderNumber = orderNumber;
		TrackNumber = trackNumber;
		Time = time;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public Integer getQTY() {
		return QTY;
	}

	public void setQTY(Integer qTY) {
		QTY = qTY;
	}

	public String getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}

	public String getTrackNumber() {
		return TrackNumber;
	}

	public void setTrackNumber(String trackNumber) {
		TrackNumber = trackNumber;
	}

	public Date getTime() {
		return Time;
	}

	public void setTime(Date time) {
		Time = time;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public GoodsMessage() {
		super();
	}

	@Override
	public String toString() {
		return "GoodsMessage [Title=" + Title + ", Category=" + Category + ", PicUrl=" + PicUrl + ", State=" + State
				+ ", Sku=" + Sku + ", Price=" + Price + ", QTY=" + QTY + ", OrderNumber=" + OrderNumber
				+ ", TrackNumber=" + TrackNumber + ", Time=" + Time + "]";
	}
}

