package com.bxx.common;

import java.util.Date;

public class Message {
	private String name; // ���⣬����
	private String type;// ���
	private String picture;// ͼƬ
	private String sku;// sku
	private String id;// �������
	private Integer number;// ����
	private Date time;// ʱ��
	private String state;
	private Double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Message [name=" + name + ", type=" + type + ", picture=" + picture + ", sku=" + sku + ", id=" + id
				+ ", number=" + number + ", time=" + time + ", state=" + state + ", price=" + price + "]";
	}

}
