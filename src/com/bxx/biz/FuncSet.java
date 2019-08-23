package com.bxx.biz;

import com.bxx.util.*;

public class FuncSet {
	public static boolean signUpFunc(String email, String account, String password) {
		EWallet ew = new EWallet(email, account, password, null);
		DBOp op = new EWalletDBOp();
		return op.insert(ew);
	}

	public static boolean addFunc(String chineseName, String englishName, String introduction, String type,
			String url) {
		// TODO Auto-generated method stub
		System.out.println("此处需要数据库增操作");
		return false;
	}
}
