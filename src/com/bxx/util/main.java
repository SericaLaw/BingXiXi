package com.bxx.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bxx.util.JdbcTool;
import com.bxx.util.EWallet;
import com.bxx.util.DBOp;
import com.bxx.util.SignupDBOp;

public class main {
	public static void main(String[] args) {
		EWallet ew = new EWallet("983272314@qq.com", "CF", "12345678", 500.0, "01");
		EWallet ew1 = new EWallet("123456789@qq.com", "CF", "12345678", 500.0, "01");
		EWallet ew2 = new EWallet("987654321@qq.com", "CF", "12345678", 500.0, "01");
		EWallet ew3 = new EWallet("000000000@qq.com", "CF", "12345678", 500.0, "01");
		EWallet ew4 = new EWallet("111111111@qq.com", "CF", "12345678", 500.0, "01");

		DBOp op = new SignupDBOp();//////////
//		op.insert(ew);
//		op.insert(ew1);
//		op.insert(ew2);
//		op.insert(ew3);
		
//		op.delete(ew);
//		
		op.update(ew3, ew4);
		
		System.out.println("success");
	}
}
