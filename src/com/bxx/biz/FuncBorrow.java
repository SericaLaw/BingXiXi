package com.bxx.biz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.bxx.common.Message;
import com.bxx.common.OrderMessage;
import com.bxx.common.StateName;
import com.bxx.dao.*;
import com.bxx.biz.FuncIndex;

public class FuncBorrow {
	public static void main(String[] args) {
		// for(Message mess:cancelled()) {
		// System.out.println(mess.toString());
		// }

		// boolean succ = add_borrower_information("5", "cf", "1", "1");
		// boolean succ = add_store_information("store001", "market01", "111", "ddd");
		// boolean succ = modify_push_information("12345");
		// boolean succ = modify_wishlist_information("12345");
		// boolean succ = check_wallet_ifafford(499.9, "123456789@qq.com");
		// boolean succ = add_payment_information("123456", 555, "zip", "tel", "name",
		// "addr");

		boolean succ = deposit("12345", 100.5);
		// boolean succ = changePassword("123", "12345");
		 System.out.println(succ);

		// for(Message mess:record()) {
		// System.out.println(mess.toString());
		// }

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
		bom.setState(StateName.AwaitingShipment);
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
		bom.setState(StateName.Shiped);
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
		bom.setState(StateName.Completed);
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
		bom.setState(StateName.Cancelled);
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

		try {
			Double balance = ((EWallet) arr.get(0)).getBalance();
			if (totalMoney > balance)
				return false;
			else
				return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean add_payment_information(String orderNumber, Integer QTY, String RcverZip, String RcverTel,
			String RcverName, String RcvAddr) {
		BvoOrderManage bom = new BvoOrderManage(), newBom = new BvoOrderManage();
		DBOp op = new BvoOrderManageDBOp();

		bom.setOrderNumber(orderNumber);
		ArrayList<Object> arr = op.select(bom);
		try {
			newBom = (BvoOrderManage) arr.get(0);

			newBom.setQTY(QTY);
			newBom.setRcverZip(RcverZip);
			newBom.setRcverTel(RcverTel);
			newBom.setRcverName(RcverName);
			newBom.setRcvAddr(RcvAddr);
			newBom.setState(StateName.AwaitingShipment);

			return op.update(bom, newBom);
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean deposit(String password, double money) // 若password正确，且余额充足，返回true
	{
		String eWalletEMail = "mail";

		EWallet ew = new EWallet();
		ew.setEmail(eWalletEMail);
		DBOp op = new EWalletDBOp();
		ArrayList<Object> arr = op.select(ew);
		try {
			ew = (EWallet) arr.get(0);
			String pwd = ew.getPassword();
			if (pwd.equals(password)) {
				Double balance = ew.getBalance();
				if (balance >= money) {
					EWallet newEw = new EWallet(ew.getEmail(), ew.getAccountName(), ew.getPassword(), ew.getBalance());
					newEw.setBalance(balance - money);
					op.update(ew, newEw);
					
					Date date = new Date();
					SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddhhmmss");
					String transnumber = ft.format(date).toString();
					Transcation trans = new Transcation(transnumber, StateName.Withdrew, StateName.WaitingCheck, date, ew.getEmail(), balance-money);
					DBOp opt = new TranscationDBOp();
					opt.insert(trans);
					
					return true;
				} else
					return false;
			} else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static ArrayList<Message> record() // 返回钱包流水的Transaction Number、Available Money、Create Time、State
	{
		String eWalletEMail = "mail";

		Transcation tran = new Transcation();
		DBOp op = new TranscationDBOp();
		tran.setEWalletEMail(eWalletEMail);
		ArrayList<Object> arr = op.select(tran);
		ArrayList<Message> res = new ArrayList<Message>();
		for (Object obj : arr) {
			Message mess = new Message();
			Transcation trans = (Transcation) obj;

			mess.setId(trans.getTranscationNumber());
			mess.setPrice(trans.getBalance());
			mess.setTime(trans.getTime_Date());
			mess.setState(trans.getState());

			res.add(mess);
		}
		return res;
	}

	public static boolean changePassword(String oldPassword, String newPassword) // 修改密码，若旧密码正确，则返回true
	{
		String eWalletEMail = "mail";

		EWallet ew = new EWallet();
		ew.setEmail(eWalletEMail);
		DBOp op = new EWalletDBOp();
		ArrayList<Object> arr = op.select(ew);
		try {
			ew = (EWallet) arr.get(0);
			String pwd = ew.getPassword();
			if (pwd.equals(oldPassword)) {
				EWallet newEw = new EWallet(ew.getEmail(), ew.getAccountName(), ew.getPassword(), ew.getBalance());
				newEw.setPassword(newPassword);
				op.update(ew, newEw);
				return true;

			} else
				return false;
		} catch (Exception e) {
			return false;
		}
	}



public static ArrayList<OrderMessage> request_order_list(String opera) {
	ArrayList<OrderMessage> ordermessage = new ArrayList<OrderMessage>();
	ArrayList<Object> array_bvo_om = new ArrayList<Object>();
	DBOp op = new BvoOrderManageDBOp();
	BvoOrderManage bvo_om = new BvoOrderManage();
	OrderMessage ordermess = new OrderMessage();
	BrandGoods bg = new BrandGoods();

	switch (opera) {
	case StateName.AwaitingShipment:// 传输等待shiped状态对应的：Title Price QTY Sku OrderNo Total
		bvo_om.setState(StateName.AwaitingShipment);
		array_bvo_om = op.select(bvo_om);

		for (Object obj : array_bvo_om) {
			String sku = (((BrandGoods) obj).getSku());
			bg.setSku(sku);
			Object temp = new Object();
			temp = op.select(bg);
			ordermess.setOrderName(((BrandGoods) temp).getBrandName());
			ordermess.setPrice(((BrandGoods) temp).getPrice());
			ordermess.setQTY(((BvoOrderManage) obj).getQTY());
			ordermess.setSku(((BvoOrderManage) obj).getSku());
			ordermess.setTotalPrice(((BvoOrderManage) obj).getTotalPrice());
			ordermess.setOrderNumber(((BvoOrderManage) obj).getOrderNumber());

			ordermessage.add(ordermess);
		}
		break;
	case StateName.Shiped:// 传输已经shiped状态对应的：Title Price QTY Sku Total OrderNo TrackingNo
		bvo_om.setState(StateName.Shiped);
		array_bvo_om = op.select(bvo_om);

		for (Object obj : array_bvo_om) {
			String sku = (((BrandGoods) obj).getSku());
			bg.setSku(sku);
			Object temp = new Object();
			temp = op.select(bg);
			ordermess.setOrderName(((BrandGoods) temp).getBrandName());
			ordermess.setPrice(((BrandGoods) temp).getPrice());
			ordermess.setQTY(((BvoOrderManage) obj).getQTY());
			ordermess.setSku(((BvoOrderManage) obj).getSku());
			ordermess.setTotalPrice(((BvoOrderManage) obj).getTotalPrice());
			ordermess.setOrderNumber(((BvoOrderManage) obj).getOrderNumber());
			ordermess.setTrackNumber(((BvoOrderManage) obj).getTrackNumber());

			ordermessage.add(ordermess);
		}
		break;
	case StateName.Completed:// 传输已经完成订单状态对应的：Title Price QTY Sku Total OrderNo TrackingNo
		bvo_om.setState(StateName.Completed);
		array_bvo_om = op.select(bvo_om);

		for (Object obj : array_bvo_om) {
			String sku = (((BrandGoods) obj).getSku());
			bg.setSku(sku);
			Object temp = new Object();
			temp = op.select(bg);
			ordermess.setOrderName(((BrandGoods) temp).getBrandName());
			ordermess.setPrice(((BrandGoods) temp).getPrice());
			ordermess.setQTY(((BvoOrderManage) obj).getQTY());
			ordermess.setSku(((BvoOrderManage) obj).getSku());
			ordermess.setTotalPrice(((BvoOrderManage) obj).getTotalPrice());
			ordermess.setOrderNumber(((BvoOrderManage) obj).getOrderNumber());
			ordermess.setTrackNumber(((BvoOrderManage) obj).getTrackNumber());

			ordermessage.add(ordermess);
		}
		break;
	case StateName.Cancelled:// 传输取消订单状态对应的：Title Price QTY Sku Total OrderNo
		bvo_om.setState(StateName.Cancelled);
		array_bvo_om = op.select(bvo_om);

		for (Object obj : array_bvo_om) {
			String sku = (((BrandGoods) obj).getSku());
			bg.setSku(sku);
			Object temp = new Object();
			temp = op.select(bg);
			ordermess.setOrderName(((BrandGoods) temp).getBrandName());
			ordermess.setPrice(((BrandGoods) temp).getPrice());
			ordermess.setQTY(((BvoOrderManage) obj).getQTY());
			ordermess.setSku(((BvoOrderManage) obj).getSku());
			ordermess.setTotalPrice(((BvoOrderManage) obj).getTotalPrice());
			ordermess.setOrderNumber(((BvoOrderManage) obj).getOrderNumber());

			ordermessage.add(ordermess);
		}
		break;

	}
	return ordermessage;
}

}
