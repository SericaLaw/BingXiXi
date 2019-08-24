package com.bxx.biz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.bxx.dao.*;
import com.bxx.common.CashMessage;
import com.bxx.common.GoodsMessage;

public class FuncBrand {
	public static Boolean addCompanyFunc(String chineseName, String englishName, String introduction, String type,
			String url) {
		DBOp op = new BrandInfoDBOp();
		BrandInfo binfo = new BrandInfo(chineseName, introduction, type, url);
		if (chineseName == null || chineseName == "" || introduction == null || introduction == "" || type == null
				|| type == "" || url == null || url == "")
			return false;
		else if (!op.insert(binfo))
			return false;

		return false;
	}

	// 提现，检查密码是否正确，提现的金额是否正确
	public static Boolean checkCashFunc(String email, Double cash, String password) {
		DBOp op = new EWalletDBOp();
		DBOp opt = new TranscationDBOp();
		EWallet ew = new EWallet(email, null, null, null);
		ArrayList<Object> ewallet = new ArrayList<Object>();
		ewallet = op.select(ew);
		if (password != ewallet.get(2))
			return false;
		else if (cash.compareTo((Double) ewallet.get(3)) > 0)
			return false;
		Double balance = (Double) ewallet.get(3) - cash;
		EWallet newew = new EWallet(null, null, null, balance);

		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddhhmmss");
		String transnumber = ft.format(date).toString();

<<<<<<< HEAD
//		public static boolean addGoods(String sku, Double weight,Double width, Double height, Double length, String title, String upc,
//				String ena, String model, Double price, String eBayDescription, String amazonDescription, Date warranty,
//				String state, String brandName, String category,String picUrl) {
//			// TODO Auto-generated method stub
//			//增加一件商品
//			DBOp op=new BrandGoodsDBOp();
//			BrandGoods bg=new BrandGoods(sku, weight, width, height, title, length, upc,
//					ena, model, price, eBayDescription, amazonDescription, warranty,
//				  state, brandName, category, picUrl);
//			if(sku==null||sku=="")//主键
//				return false;
//	        if(!op.insert(bg))//插入失败
//	        	return false;
//	        return true;
//		}
=======
		Transcation trans = new Transcation(transnumber, "withdrew", "waiting check", date, email, balance);
>>>>>>> bd849962597a842be5f45527a98d8d25beb15084

		if (!op.update(ew, newew))
			return false;
		if (!opt.insert(trans))
			return false;

		return false;
	}

	// 提现流水
	public static ArrayList<CashMessage> displayCashFunc(String email) {
		ArrayList<Object> orders = new ArrayList<Object>();
		ArrayList<CashMessage> result = new ArrayList<CashMessage>();

		DBOp op = new TranscationDBOp();
		Transcation tran = new Transcation(null, null, null, null, email, null);
		orders = op.select(tran);

		for (Object obj : orders) {
			CashMessage cashmess = new CashMessage(null, null, null, null);
			// Transcation transcation=new Transcation();
			cashmess.setOrderNumber(((Transcation)obj).getTranscationNumber());
			cashmess.setCash(((Transcation)obj).getBalance());
			cashmess.setState(((Transcation)obj).getState());
			cashmess.setTime(((Transcation)obj).getTime_Date());

			result.add(cashmess);
		}

<<<<<<< HEAD
//		public static int updateState(String name) {
//
//		}
=======
		return result;
	}

	// 通过商品标题查找商品信息
	public static ArrayList<GoodsMessage> searchGoods(String name) {
		DBOp op = new BrandGoodsDBOp();
		ArrayList<GoodsMessage> goods = new ArrayList<GoodsMessage>();
		ArrayList<Object> obj_goods = new ArrayList<Object>();
		BrandGoods bg = new BrandGoods();
		bg.setBrandName(name);

		if (name == null || name == "")
			return null;
		obj_goods = op.select(bg);

		for (Object obj : obj_goods) {
			GoodsMessage goodsmess = new GoodsMessage(null, null, null, null);
			goodsmess.setTitle(((BrandGoods)obj).getBrandName());
			goodsmess.setCategory(((BrandGoods)obj).getCategory());
			goodsmess.setState(((BrandGoods)obj).getState());
			goodsmess.setPicUrl(((BrandGoods)obj).getPicUrl());
			goods.add(goodsmess);
		}
		return goods;
	}

	// 增加一件商品
	public static Boolean addGoods(String sku, Double weight, Double width, Double height, Double length, String title,
			String upc, String ena, String model, Double price, String eBayDescription, String amazonDescription,
			String warranty, String state, String brandName, String category, String picUrl) {
		DBOp op = new BrandGoodsDBOp();
		BrandGoods bg = new BrandGoods(sku, weight, width, height, length, title, upc, ena, model, price,
				eBayDescription, amazonDescription, warranty, state, brandName, category, picUrl);
		if (sku == null || sku == "")
			return false;
		if (!op.insert(bg))
			return false;
		return true;
	}

	// 根据商品sku码删除商品
	public static Boolean deleteGoods(String sku) {
		BrandGoods bg = new BrandGoods();
		bg.setSku(sku);
		DBOp op = new BrandGoodsDBOp();
		if (sku == null || sku == "")
			return false;
		if (!op.delete(bg))
			return false;

		return true;
	}

	// 根据订单编号进行发货
	public static Boolean delivery(String orderNumber) {
		DBOp op = new BrandOrderDBOp();
		BrandOrder bo = new BrandOrder(orderNumber, null, null, null, null, null, null);
		BrandOrder deliver = new BrandOrder(null, null, null, null, null, "Shipped", null);
		if (!op.update(bo, deliver))
			return false;

		return true;
	}

	// 根据订单编号进行取消订单
	public static Boolean cancelOrder(String orderNumber) {
		DBOp op = new BrandOrderDBOp();
		BrandOrder bo = new BrandOrder(orderNumber, null, null, null, null, null, null);
		BrandOrder cancel = new BrandOrder(null, null, null, null, null, "cancelled", null);
		if (!op.update(bo, cancel))
			return false;

		return true;
	}

	// 商品入仓
	public static Boolean PutinStorage(String sku) {
		BrandGoods bg = new BrandGoods();
		bg.setSku(sku);
		BrandGoods newbg = new BrandGoods();
		bg.setState("InStorage");

		DBOp op = new BrandGoodsDBOp();
		if (sku == null || sku == "")
			return false;
		if (!op.update(bg, newbg))
			return false;

		return true;
	}

	// 商品上架
	public static Boolean PutWay(String sku) {
		BrandGoods bg = new BrandGoods();
		bg.setSku(sku);
		BrandGoods newbg = new BrandGoods();
		bg.setState("PutWay");

		DBOp op = new BrandGoodsDBOp();
		if (sku == null || sku == "")
			return false;
		if (!op.update(bg, newbg))
			return false;

		return true;
	}

	// 商品下架
	public static Boolean SoldOut(String sku) {
		BrandGoods bg = new BrandGoods();
		bg.setSku(sku);
		BrandGoods newbg = new BrandGoods();
		bg.setState("StoreOut");

		DBOp op = new BrandGoodsDBOp();
		if (sku == null || sku == "")
			return false;
		if (!op.update(bg, newbg))
			return false;

		return true;
	}
>>>>>>> bd849962597a842be5f45527a98d8d25beb15084
}
