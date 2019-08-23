package com.bxx.util;

public class BvoOrderManage {
	private String OrderNumber;
	private Double QTY;
	private String Sku;
	private Double TotalPrice;
	private String TrackNumber;
	private String State;
	private String RcverName;
	private String RcvAddr;
	private String RcverTel;
	private String RcverZip;

	public BvoOrderManage(String orderNumber, Double qTY, String sku, Double totalPrice, String trackNumber,
			String state, String rcverName, String rcvAddr, String rcverTel, String rcverZip) {
		super();
		OrderNumber = orderNumber;
		QTY = qTY;
		Sku = sku;
		TotalPrice = totalPrice;
		TrackNumber = trackNumber;
		State = state;
		RcverName = rcverName;
		RcvAddr = rcvAddr;
		RcverTel = rcverTel;
		RcverZip = rcverZip;
	}

	public String getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}

	public Double getQTY() {
		return QTY;
	}

	public void setQTY(Double qTY) {
		QTY = qTY;
	}

	public String getSku() {
		return Sku;
	}

	public void setSku(String sku) {
		Sku = sku;
	}

	public Double getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		TotalPrice = totalPrice;
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

	public String getRcverName() {
		return RcverName;
	}

	public void setRcverName(String rcverName) {
		RcverName = rcverName;
	}

	public String getRcvAddr() {
		return RcvAddr;
	}

	public void setRcvAddr(String rcvAddr) {
		RcvAddr = rcvAddr;
	}

	public String getRcverTel() {
		return RcverTel;
	}

	public void setRcverTel(String rcverTel) {
		RcverTel = rcverTel;
	}

	public String getRcverZip() {
		return RcverZip;
	}

	public void setRcverZip(String rcverZip) {
		RcverZip = rcverZip;
	}

	@Override
	public String toString() {
		String str = "";
		if (this.getOrderNumber() != null) {
			str += String.format("and OrderNumber = '%s' ", this.getOrderNumber());
		}
		if (this.getQTY() != null) {
			str += String.format("and QTY = '%f' ", this.getQTY());
		}
		if (this.getSku() != null) {
			str += String.format("and Sku = '%s' ", this.getSku());
		}
		if (this.getTotalPrice() != null) {
			str += String.format("and TotalPrice = %f ", this.getTotalPrice());
		}
		if (this.getTrackNumber() != null) {
			str += String.format("and TrackNumber = '%s' ", this.getTrackNumber());
		}
		if (this.getState() != null) {
			str += String.format("and State = '%s' ", this.getState());
		}
		if (this.getRcverName() != null) {
			str += String.format("and RcverName = '%s' ", this.getRcverName());
		}
		if (this.getRcvAddr() != null) {
			str += String.format("and RcvAddr = '%s' ", this.getRcvAddr());
		}
		if (this.getRcverTel() != null) {
			str += String.format("and RcverTel = %s ", this.getRcverTel());
		}
		if (this.getRcverZip() != null) {
			str += String.format("and RcverZip = '%s' ", this.getRcverZip());
		}
		if (str.equals(""))
			return str;
		return str.substring(4);
	}
}
