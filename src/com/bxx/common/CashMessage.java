package com.bxx.common;

import java.util.Date;

public class CashMessage {
	private String orderNumber; // ������ˮ��
	private Double cash; // ���
	private Date time;
	private String state; // ��֧�������������ѷ���������ɣ���ȡ��

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