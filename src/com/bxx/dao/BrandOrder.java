package com.bxx.dao;

import java.util.Date;
import java.text.SimpleDateFormat;

public class BrandOrder {
	private String OrderNumber;
	private Integer QTY;
	private String Sku;
	private Date Time;
	private String TrackNumber;
	private String State;
	private String BvoStore;

	public BrandOrder(String orderNumber, Integer qTY, String sku, Date time, String trackNumber, String state,
			String bvoStore) {
		super();
		OrderNumber = orderNumber;
		QTY = qTY;
		Sku = sku;
		Time = time;
		TrackNumber = trackNumber;
		State = state;
		BvoStore = bvoStore;
	}

	public String getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}

	public Integer getQTY() {
		return QTY;
	}

	public void setQTY(Integer qTY) {
		QTY = qTY;
	}

	public String getSku() {
		return Sku;
	}

	public void setSku(String sku) {
		Sku = sku;
	}

	public String getTime() {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if (Time == null)
			return null;
		return ft.format(Time).toString();
	}

	public void setTime(Date time) {
		Time = time;
	}

	public String getTrackNumber() {
		return TrackNumber;
	}

	public void setTrackNumber(String trackNumber) {
		TrackNumber = trackNumber;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getBvoStore() {
		return BvoStore;
	}

	public void setBvoStore(String bvoStore) {
		BvoStore = bvoStore;
	}

	@Override
	public String toString() {
		String str = "";
		if (this.getOrderNumber() != null) {
			str += String.format("and OrderNumber = '%s' ", this.getOrderNumber());
		}
		if (this.getQTY() != null) {
			str += String.format("and QTY = %d ", this.getQTY());
		}
		if (this.getSku() != null) {
			str += String.format("and Sku = '%s' ", this.getSku());
		}
		if (this.getTime() != null) {
			str += String.format("and Time = '%s' ", this.getTime());
		}
		if (this.getTrackNumber() != null) {
			str += String.format("and TrackNumber = '%s' ", this.getTrackNumber());
		}
		if (this.getState() != null) {
			str += String.format("and State = '%s' ", this.getState());
		}
		if (this.getBvoStore() != null) {
			str += String.format("and BvoStore = '%s' ", this.getBvoStore());
		}

		if (str.equals(""))
			return str;
		return str.substring(4);
	}

}
