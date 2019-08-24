package com.bxx.common;

public class OrderMessage {
	private String OrderName; 
	private Integer QTY;
	private String Sku;
	private Double TotalPrice;
	private String TrackNumber;
	private String State;
	private String RcverName;
	private String RcvAddr;
	private String RcverTel;
	private String RcverZip;
	private Double Price;
	private String OrderNumber;
	
	
	public OrderMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderMessage(String orderName, Integer qTY, String sku, Double totalPrice, String trackNumber, String state,
			String rcverName, String rcvAddr, String rcverTel, String rcverZip, Double price, String orderNumber) {
		super();
		OrderName = orderName;
		QTY = qTY;
		Sku = sku;
		TotalPrice = totalPrice;
		TrackNumber = trackNumber;
		State = state;
		RcverName = rcverName;
		RcvAddr = rcvAddr;
		RcverTel = rcverTel;
		RcverZip = rcverZip;
		Price = price;
		OrderNumber = orderNumber;
	}

	public String getOrderName() {
		return OrderName;
	}

	public void setOrderName(String orderName) {
		OrderName = orderName;
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

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public String getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}

	@Override
	public String toString() {
		return "OrderMessage [OrderName=" + OrderName + ", QTY=" + QTY + ", Sku=" + Sku + ", TotalPrice=" + TotalPrice
				+ ", TrackNumber=" + TrackNumber + ", State=" + State + ", RcverName=" + RcverName + ", RcvAddr="
				+ RcvAddr + ", RcverTel=" + RcverTel + ", RcverZip=" + RcverZip + ", Price=" + Price + ", OrderNumber="
				+ OrderNumber + "]";
	}
}
