package com.bxx.common;

import java.util.Date;

public class Message {
	private String name; // 标题，名字
	private String type;// 类别
	private String picture;// 图片
	private String sku;// sku
	private String id;// 订单编号
	private Integer number;// 数量
	private Date time;// 时间
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
