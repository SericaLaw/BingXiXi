package com.bxx.biz;

import java.util.ArrayList;

import com.bxx.dao.BrandGoods;
import com.bxx.dao.BrandOrder;

public class FuncBrand {
	public static boolean addCompanyFunc(String chineseName, String englishName, String introduction, String type,
			String url) {
		// TODO Auto-generated method stub
		System.out.println("此处需要数据库增操作");
		//增加一个公司信息
		return false;
	}

	public static boolean checkCashFunc(String email, String cash, String password) {
		// TODO Auto-generated method stub
		System.out.println("此处需要数据库查与改操作");
		//提现，检查密码是否正确，提现的金额是否正确
		return false;
	}

	public static ArrayList<BrandOrder> displayCashFunc(String email) {
		// TODO Auto-generated method stub
		System.out.println("此处需要数据库查操作");
		//提现流水
		ArrayList<BrandOrder> orders = new ArrayList<BrandOrder>();
		return orders;
	}

	public static BrandGoods searchGoods(String name) {
		// TODO Auto-generated method stub
		//通过商品标题查找商品信息
		return null;
	}

	public static boolean addGoods(String sku, String weight, String height, String length, String title, String upc,
			String ena, String model, String price, String eBayDescription, String amazonDescription, String warranty,
			String state, String brandName, String category) {
		// TODO Auto-generated method stub
		//增加一件商品
		return false;
	}

	public static boolean deleteGoods(String name) {
		// TODO Auto-generated method stub
		//根据商品标题删除商品
		return false;
	}

	public static boolean delivery(String trackNumber) {
		// TODO Auto-generated method stub
		//根据订单编号进行发货
		return false;
	}

	public static boolean cancelOrder(String trackNumber) {
		// TODO Auto-generated method stub
		//根据订单编号进行取消订单
		return false;
	}

	public static int updateState(String name) {
		// TODO Auto-generated method stub
		//更新商品状态  返回入仓or上架or下架状态 用不同的int值表示？
		return 0;
	}
}
