package com.bxx.common;

import java.util.Date;

public class CashMessage {
<<<<<<< HEAD
	private String orderNumber; //������ˮ��
	private Double cash;        //���
	private Date time;
	private String State;       //��֧�������������ѷ���������ɣ���ȡ��
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
	public CashMessage(String orderNumber, Double cash, Date time, String state) {
=======
	private String orderNumber; // ������ˮ��
	private Double cash; // ���
	private Date time;
	private String State; // ��֧�������������ѷ���������ɣ���ȡ��

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
>>>>>>> a355ee5b68084ce9cfa340d6fdb9b74d190d9cb6
		super();
		this.orderNumber = orderNumber;
		this.cash = cash;
		this.time = time;
		State = state;
	}
<<<<<<< HEAD
	public void setTime(Date time) {
		this.time = time;
	}
	public String getState() {
		return State;
	}
=======

	public void setTime(Date time) {
		this.time = time;
	}

	public String getState() {
		return State;
	}

>>>>>>> a355ee5b68084ce9cfa340d6fdb9b74d190d9cb6
	public void setState(String state) {
		State = state;
	}
}
