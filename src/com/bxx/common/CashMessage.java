package com.bxx.common;

import java.util.Date;

public class CashMessage {
	private String orderNumber; // 交易流水号
	private Double cash; // 余额
	private Date time;
	private String State; // 待支付，待发货，已发货，已完成，已取消

	public CashMessage() {
		super();
	}

	public CashMessage(String orderNumber, Double cash, Date time, String state) {
		super();
		this.orderNumber = orderNumber;
		this.cash = cash;
		this.time = time;
		State = state;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Double getCash() {
		return cash;
	}

	public void setCash(Double cash) {
		this.cash = cash;
	}

	public Date getTime() {
		return time;
	}

	public CashMessage(String orderNumber, double cash, Date time, String state) {
		super();
		this.orderNumber = orderNumber;
		this.cash = cash;
		this.time = time;
		State = state;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}
}