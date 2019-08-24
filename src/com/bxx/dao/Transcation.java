package com.bxx.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transcation {
	private String TranscationNumber;
	private String Type;
	private String State;
	private Date Time;
	private String EWalletEMail;

	public Transcation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transcation(String transcationNumber, String type, String state, Date time, String eWalletEMail) {
		super();
		TranscationNumber = transcationNumber;
		Type = type;
		State = state;
		Time = time;
		EWalletEMail = eWalletEMail;
	}

	public String getTranscationNumber() {
		return TranscationNumber;
	}

	public void setTranscationNumber(String transcationNumber) {
		TranscationNumber = transcationNumber;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getTime() {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if(Time==null)
			return null;
		return ft.format(Time).toString();
	}

	public void setTime(Date time) {
		Time = time;
	}

	public String getEWalletEMail() {
		return EWalletEMail;
	}

	public void setEWalletEMail(String eWalletEMail) {
		EWalletEMail = eWalletEMail;
	}

	@Override
	public String toString() {
		String str = "";
		if (this.getTranscationNumber() != null) {
			str += String.format("and TranscationNumber = '%s' ", this.getTranscationNumber());
		}
		if (this.getType() != null) {
			str += String.format("and Type = '%s' ", this.getType());
		}
		if (this.getState() != null) {
			str += String.format("and State = '%s' ", this.getState());
		}
		if (this.getTime() != null) {
			str += String.format("and Time = '%s' ", this.getTime());
		}
		if (this.getEWalletEMail() != null) {
			str += String.format("and EWalletEMail = '%s' ", this.getEWalletEMail());
		}
		if (str.equals(""))
			return str;
		return str.substring(4);
	}
}
