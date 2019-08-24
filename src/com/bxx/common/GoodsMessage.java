package com.bxx.common;

public class GoodsMessage {
	private String Title;
	private String Category;
	private String PicUrl;
	private String State;

	public GoodsMessage() {
		super();
	}

	public GoodsMessage(String title, String category, String picUrl, String state) {
		super();
		Title = title;
		Category = category;
		PicUrl = picUrl;
		State = state;
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

}
