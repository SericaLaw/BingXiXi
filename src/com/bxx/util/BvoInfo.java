package com.bxx.util;

public class BvoInfo {
	private String Email;
	private String AccountName;
	private String Password;
	private Double Balance;
	private String TranscationNumber;

	public BvoInfo(String email, String accountName, String password, Double balance, String transcationNumber) {
		super();
		Email = email;
		AccountName = accountName;
		Password = password;
		Balance = balance;
		TranscationNumber = transcationNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAccountName() {
		return AccountName;
	}

	public void setAccountName(String accountName) {
		AccountName = accountName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Double getBalance() {
		return Balance;
	}

	public void setBalance(Double balance) {
		Balance = balance;
	}

	public String getTranscationNumber() {
		return TranscationNumber;
	}

	public void setTranscationNumber(String transcationNumber) {
		TranscationNumber = transcationNumber;
	}

	@Override
	public String toString() {
		String str = "";
		if (this.getEmail() != null) {
			str += String.format("and Email = '%s' ", this.getEmail());
		}
		if (this.getAccountName() != null) {
			str += String.format("and AccountName = '%s' ", this.getAccountName());
		}
		if (this.getPassword() != null) {
			str += String.format("and Password = '%s' ", this.getPassword());
		}
		if (this.getBalance() != null) {
			str += String.format("and Balance = %f ", this.getBalance());
		}
		if (this.getTranscationNumber() != null) {
			str += String.format("and TranscationNumber = '%s' ", this.getTranscationNumber());
		}
		if(str.equals(""))
			return str;
		return str.substring(4);
	}
}
