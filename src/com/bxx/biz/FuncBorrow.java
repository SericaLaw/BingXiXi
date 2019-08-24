package com.bxx.biz;

import java.util.ArrayList;

import com.bxx.common.Message;
import com.bxx.dao.*;
import com.bxx.biz.FuncIndex;

public class FuncBorrow {
	public static void main(String[] args) {
		// for(Message mess:cancelled()) {
		// System.out.println(mess.toString());
		// }

		// boolean succ = add_borrower_information("3", "cf", "1", "1");
		// boolean succ = add_store_information("store001", "market01", "111", "ddd");
		// boolean succ = modify_push_information("12345");
		boolean succ = modify_wishlist_information("12345");

		System.out.println(succ);

		System.out.println("===== success =====");
	}

	public static boolean signUpFunc(String email, String account, String password) {
		EWallet ew = new EWallet(email, account, password, null);
		DBOp op = new EWalletDBOp();
		return op.insert(ew);
	}

	public static ArrayList<Message> awaitingShipment() // 请求待运输的
	{
		DBOp op = new BvoOrderManageDBOp();
		BvoOrderManage bom = new BvoOrderManage();
		bom.setState("Awaiting Shipment");
		ArrayList<Object> arr = op.select(bom);
		ArrayList<Message> res = new ArrayList<Message>();
		for (Object obj : arr) {
			Message mess = new Message();
			BvoOrderManage bo = (BvoOrderManage) obj;
			BrandGoods bg = FuncIndex.getBrandGoodsBySku(bo.getSku());
			mess.setName(bg.getBrandName());
			mess.setPrice(bg.getPrice());
			mess.setSku(bo.getSku());
			mess.setId(bo.getOrderNumber());
			mess.setNumber(bo.getQTY());
			res.add(mess);
		}
		return res;
	}

	public static ArrayList<Message> shiped() // 请求已送达的商品
	{
		DBOp op = new BvoOrderManageDBOp();
		BvoOrderManage bom = new BvoOrderManage();
		bom.setState("Shiped");
		ArrayList<Object> arr = op.select(bom);
		ArrayList<Message> res = new ArrayList<Message>();
		for (Object obj : arr) {
			Message mess = new Message();
			BvoOrderManage bo = (BvoOrderManage) obj;
			BrandGoods bg = FuncIndex.getBrandGoodsBySku(bo.getSku());
			mess.setName(bg.getBrandName());
			mess.setPrice(bg.getPrice());
			mess.setSku(bo.getSku());
			mess.setId(bo.getOrderNumber());
			mess.setNumber(bo.getQTY());
			res.add(mess);
		}
		return res;
	}

	public static ArrayList<Message> completed() // 请求已完成交易的商品
	{
		DBOp op = new BvoOrderManageDBOp();
		BvoOrderManage bom = new BvoOrderManage();
		bom.setState("Completed");
		ArrayList<Object> arr = op.select(bom);
		ArrayList<Message> res = new ArrayList<Message>();
		for (Object obj : arr) {
			Message mess = new Message();
			BvoOrderManage bo = (BvoOrderManage) obj;
			BrandGoods bg = FuncIndex.getBrandGoodsBySku(bo.getSku());
			mess.setName(bg.getBrandName());
			mess.setPrice(bg.getPrice());
			mess.setSku(bo.getSku());
			mess.setId(bo.getOrderNumber());
			mess.setNumber(bo.getQTY());
			res.add(mess);
		}
		return res;
	}

	public static ArrayList<Message> cancelled() // 请求品牌商商品标题、分类、主图、状态
	{
		DBOp op = new BvoOrderManageDBOp();
		BvoOrderManage bom = new BvoOrderManage();
		bom.setState("Cancelled");
		ArrayList<Object> arr = op.select(bom);
		ArrayList<Message> res = new ArrayList<Message>();
		for (Object obj : arr) {
			Message mess = new Message();
			BvoOrderManage bo = (BvoOrderManage) obj;
			BrandGoods bg = FuncIndex.getBrandGoodsBySku(bo.getSku());
			mess.setName(bg.getBrandName());
			mess.setPrice(bg.getPrice());
			mess.setSku(bo.getSku());
			mess.setId(bo.getOrderNumber());
			mess.setNumber(bo.getQTY());
			res.add(mess);
		}
		return res;
	}

	public static boolean add_borrower_information(String SellerID, String tel, String email, String SellerName) {
		BvoInfo bg = new BvoInfo(SellerID, tel, email, SellerName);
		DBOp op = new BvoInfoDBOp();
		if (SellerID == null || SellerID == "" || tel == null || tel == "" || email == null || email == ""
				|| SellerName == null || SellerName == "")
			return false;
		else if (!op.insert(bg))
			return false;

		return true;
	}

	public static boolean add_store_information(String StoreName, String MarketPlaceID, String SellerID_store,
			String MWS) {
		StoreInfo sinfo = new StoreInfo(StoreName, null, SellerID_store, MarketPlaceID, MWS);
		DBOp op = new StoreInfoDBOp();
		if (StoreName == null || StoreName == "" || SellerID_store == null || SellerID_store == ""
				|| MarketPlaceID == null || MarketPlaceID == "" || MWS == null || MWS == "")
			return false;
		else if (!op.insert(sinfo))
			return false;

		return true;
	}

	public static boolean modify_push_information(String push_sku) {
		BvoGoods newbg = new BvoGoods(null, null, true, null);
		DBOp op = new BvoGoodsDBOp();
		BvoGoods oldbg = new BvoGoods(push_sku, null, null, null);
		if (op.select(oldbg).isEmpty())
			return false;
		if (!op.update(oldbg, newbg))
			return false;

		return true;
	}

	public static boolean modify_wishlist_information(String wish_sku) {
		BvoGoods newbg = new BvoGoods(null, null, null, true);
		DBOp op = new BvoGoodsDBOp();
		BvoGoods oldbg = new BvoGoods(wish_sku, null, null, null);
		if (op.select(oldbg).isEmpty())
			return false;
		if (!op.update(oldbg, newbg))
			return false;

		return true;
	}

	public static boolean check_wallet_ifafford(Double totalMoney, String walletEmail) {
		DBOp op = new EWalletDBOp();
		EWallet ew = new EWallet();
		ew.setEmail(walletEmail);
		ArrayList<Object> arr = op.select(ew);
		Double balance = ((EWallet) arr.get(0)).getBalance();
		if (totalMoney > balance)
			return false;
		else
			return true;
	}

	public static boolean add_payment_information(String orderNumber, Integer QTY, String RcverZip, String RcverTel,
			String RcverName, String RcvAddr) {
		BvoOrderManage bom = new BvoOrderManage(), newBom = new BvoOrderManage();
		DBOp op = new BvoOrderManageDBOp();
		
		bom.setOrderNumber(orderNumber);
		ArrayList<Object> arr = op.select(bom);
		newBom = (BvoOrderManage)arr.get(0);
		
		newBom.setQTY(QTY);
		newBom.setRcverZip(RcverZip);
		newBom.setRcverTel(RcverTel);
		newBom.setRcverName(RcverName);
		newBom.setRcvAddr(RcvAddr);
		newBom.setState("Awaiting Shipment");
		
		return op.update(bom, newBom);
	}

	public static boolean deposit(String password, double money) //若password正确，且余额充足，返回true
	{
		return true;
	}

	public static ArrayList<Message> record() // 返回钱包流水的Transaction Number、Available Money、Create Time、State
	{
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean changePassword(String oldPassword, String newPassword)  //修改密码，若旧密码正确，则返回true
	{
		// TODO Auto-generated method stub
		return false;
	}

}
