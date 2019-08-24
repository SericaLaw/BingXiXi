package com.bxx.biz;

import java.util.ArrayList;

import com.bxx.dao.*;

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
		//增加一个公司信息
		return false;
	}

	public static boolean checkFunc(String email, String cash, String password) {
		// TODO Auto-generated method stub
		System.out.println("此处需要数据库查与改操作");
		//提现，检查密码是否正确，提现的金额是否正确
		return false;
	}

	public static ArrayList<BrandOrder> displayFunc(String email) {
		// TODO Auto-generated method stub
		System.out.println("此处需要数据库查操作");
		//提现流水
		ArrayList<BrandOrder> orders = new ArrayList<BrandOrder>();
		return orders;
	}
}
