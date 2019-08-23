package com.bxx.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bxx.util.JdbcTool;
import com.bxx.util.EWallet;
import com.bxx.util.DBOp;
import com.bxx.util.EWalletDBOp;

public class main {
	public static void main(String[] args) {
		EWallet ew = new EWallet("983272314@qq.com", "CF", "12345678", 500.0);
		EWallet ew1 = new EWallet("123456789@qq.com", "CF", "12345678", 500.0);
		EWallet ew2 = new EWallet("987654321@qq.com", "CF", "12345678", 500.0);
		EWallet ew3 = new EWallet("000000000@qq.com", "CF", "12345678", 500.0);
		EWallet ew4 = new EWallet("111111111@qq.com", "CF", "12345678", 500.0);

		DBOp op = new EWalletDBOp();//////////
		// op.insert(ew);
		// op.insert(ew1);
		// op.insert(ew2);
		// op.insert(ew3);

		// op.delete(ew);
		//
		// op.update(ew4, ew3);

		EWallet ew5 = new EWallet(null, "CF", null, null);
		EWallet ew6 = new EWallet(null, null, null, null);
		ArrayList<Object> arr = op.select(ew6); 
		for (Object item : arr) {
			EWallet ee = (EWallet) item;
			System.out.println(ee.toString());
		}

		System.out.println("success");
	}
}
