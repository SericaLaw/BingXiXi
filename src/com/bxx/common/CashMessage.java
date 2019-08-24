package com.bxx.common;

import java.util.Date;

public class CashMessage {
	private String orderNumber; // 交易流水号
	private Double cash; // 余额
	private Date time;
	private String state; // 待支付，待发货，已发货，已完成，已取消

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

	public CashMessage(String orderNumber, Double cash, Date time, String state) {
		super();
		this.orderNumber = orderNumber;
		this.cash = cash;
		this.time = time;
		this.state = state;
	}

	public Date getTime() {
		return time;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setTime(Date date) {
		this.time = date;
	}

	public String getState() {
		return state;
	}

	@Override
	public String toString() {
		return "CashMessage [orderNumber=" + orderNumber + ", cash=" + cash + ", time=" + time + ", state=" + state
				+ "]";
	}
}