package com.bxx.biz;

import com.bxx.dao.*;

public class FuncSet {
	public static boolean signUpFunc(String email, String account, String password) {
		EWallet ew = new EWallet(email, account, password, null);
		DBOp op = new EWalletDBOp();
		return op.insert(ew);
	}
	
	public static boolean addCompany(String name, String type, String description, String renzheng) {
		
		return false;
	}
}
