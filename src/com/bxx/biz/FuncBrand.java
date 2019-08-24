package com.bxx.biz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.bxx.dao.*;
import com.bxx.common.CashMessage;
import com.bxx.common.GoodsMessage;
<<<<<<< HEAD
import com.bxx.common.OrderMessage;
import com.bxx.common.StateName;
import com.bxx.dao.*;

public class FuncBrand {
	public static void main(String[] args) {
		// boolean succ = addCompanyFunc("‰∏≠ÊñáÂêç", "name", "introduction", "type", "url");
		// boolean succ = checkCashFunc("123@qq.com", 600.0, "1234567");
		// boolean succ = addGoods("12345", 1.1, 2.2, 3.3, 4.4, null, null, null, null,
		// null, null, null, null, null, null, null, null);
		// boolean succ = deleteGoods("1234");
		// boolean succ = delivery("123");
		// boolean succ = cancelOrder("1234");
		// boolean succ = SoldOut("2222");
		
		//boolean succ = updateGoods("55", "name", "category", "pic");
		//ArrayList<CashMessage> succ=displayCashFunc("mail");
		//ArrayList<GoodsMessage> succ=searchGoods("55");
		//ArrayList<GoodsMessage> succ=requestList("Cancelled");
		ArrayList<GoodsMessage> succ=request_order_list()
		// for (CashMessage mess : displayCashFunc("mail")) {
		// System.out.println(mess.toString());
		// }

		System.out.println("=== " + succ + " ===");
		System.out.println("success");
	}

	// Â¢ûÂä†‰∏Ä‰∏™ÂÖ¨Âè∏‰ø°ÊÅØ

	public static Boolean addCompanyFunc(String chineseName, String englishName, String introduction, String type,
			String url) {
=======

public class FuncBrand {
	public static Boolean addCompanyFunc(String chineseName, String englishName, String introduction, String type,
										 String url) {
>>>>>>> 10d52231888148ee62b1b12cf40db519b73c9728
		DBOp op = new BrandInfoDBOp();
		BrandInfo binfo = new BrandInfo(chineseName, introduction, type, url);
		if (chineseName == null || chineseName == "" || introduction == null || introduction == "" || type == null
				|| type == "" || url == null || url == "")
			return false;
		else if (!op.insert(binfo))
			return false;

<<<<<<< HEAD
		return true;
	}

	// ÊèêÁé∞ÔºåÊ£ÄÊü•ÂØÜÁ†ÅÊòØÂê¶Ê≠£Á°ÆÔºåÊèêÁé∞ÁöÑÈáëÈ¢ùÊòØÂê¶Ê≠£Á°Æ
	public static Boolean checkCashFunc(String email, Double cash, String password) {
		EWallet ew = new EWallet();
		ew.setEmail(email);
		DBOp op = new EWalletDBOp();
		ArrayList<Object> arr = op.select(ew);
		try {
			ew = (EWallet) arr.get(0);
			String pwd = ew.getPassword();
			if (pwd.equals(password)) {
				Double balance = ew.getBalance();
				if (balance >= cash) {
					EWallet newEw = new EWallet(ew.getEmail(), ew.getAccountName(), ew.getPassword(), ew.getBalance());
					newEw.setBalance(balance - cash);
					op.update(ew, newEw);

					Date date = new Date();
					SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddhhmmss");
					String transnumber = ft.format(date).toString();
					Transcation trans = new Transcation(transnumber, StateName.Withdrew, StateName.WaitingCheck, date,
							ew.getEmail(), balance - cash);
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

	// ÊèêÁé∞ÊµÅÊ∞¥
=======
		return false;
	}

	// Ã·œ÷£¨ºÏ≤È√‹¬Î «∑Ò’˝»∑£¨Ã·œ÷µƒΩ∂Ó «∑Ò’˝»∑
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

		Transcation trans = new Transcation(transnumber, "withdrew", "waiting check", date, email, balance);

		if (!op.update(ew, newew))
			return false;
		if (!opt.insert(trans))
			return false;

		return false;
	}

	// Ã·œ÷¡˜ÀÆ
>>>>>>> 10d52231888148ee62b1b12cf40db519b73c9728
	public static ArrayList<CashMessage> displayCashFunc(String email) {
		ArrayList<Object> orders = new ArrayList<Object>();
		ArrayList<CashMessage> result = new ArrayList<CashMessage>();

		DBOp op = new TranscationDBOp();
		Transcation tran = new Transcation(null, null, null, null, email, null);
		orders = op.select(tran);

		for (Object obj : orders) {
			CashMessage cashmess = new CashMessage(null, null, null, null);
<<<<<<< HEAD
			cashmess.setOrderNumber(((Transcation) obj).getTranscationNumber());
			cashmess.setCash(((Transcation) obj).getBalance());
			cashmess.setState(((Transcation) obj).getState());
			cashmess.setTime(((Transcation) obj).getTime_Date());
=======
			// Transcation transcation=new Transcation();
			cashmess.setOrderNumber(((Transcation)obj).getTranscationNumber());
			cashmess.setCash(((Transcation)obj).getBalance());
			cashmess.setState(((Transcation)obj).getState());
			cashmess.setTime(((Transcation)obj).getTime_Date());
>>>>>>> 10d52231888148ee62b1b12cf40db519b73c9728

			result.add(cashmess);
		}

		return result;
	}

<<<<<<< HEAD
	// ÈÄöËøáÂïÜÂìÅÊ†áÈ¢òÊü•ÊâæÂïÜÂìÅ‰ø°ÊÅØ
=======
	// Õ®π˝…Ã∆∑±ÍÃ‚≤È’“…Ã∆∑–≈œ¢
>>>>>>> 10d52231888148ee62b1b12cf40db519b73c9728
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
<<<<<<< HEAD
			GoodsMessage goodsmess = new GoodsMessage();
			goodsmess.setTitle(((BrandGoods) obj).getTitle());
			goodsmess.setCategory(((BrandGoods) obj).getCategory());
			goodsmess.setState(((BrandGoods) obj).getState());
			goodsmess.setPicUrl(((BrandGoods) obj).getPicUrl());
=======
			GoodsMessage goodsmess = new GoodsMessage(null, null, null, null);
			goodsmess.setTitle(((BrandGoods)obj).getBrandName());
			goodsmess.setCategory(((BrandGoods)obj).getCategory());
			goodsmess.setState(((BrandGoods)obj).getState());
			goodsmess.setPicUrl(((BrandGoods)obj).getPicUrl());
>>>>>>> 10d52231888148ee62b1b12cf40db519b73c9728
			goods.add(goodsmess);
		}
		return goods;
	}

<<<<<<< HEAD
	// Â¢ûÂä†‰∏Ä‰ª∂ÂïÜÂìÅ
	public static Boolean addGoods(String sku, Double weight, Double width, Double height, Double length, String title,
			String upc, String ena, String model, Double price, String eBayDescription, String amazonDescription,
			String warranty, String state, String brandName, String category, String picUrl) {
=======
	// ‘ˆº”“ªº˛…Ã∆∑
	public static Boolean addGoods(String sku, Double weight, Double width, Double height, Double length, String title,
								   String upc, String ena, String model, Double price, String eBayDescription, String amazonDescription,
								   String warranty, String state, String brandName, String category, String picUrl) {
>>>>>>> 10d52231888148ee62b1b12cf40db519b73c9728
		DBOp op = new BrandGoodsDBOp();
		BrandGoods bg = new BrandGoods(sku, weight, width, height, length, title, upc, ena, model, price,
				eBayDescription, amazonDescription, warranty, state, brandName, category, picUrl);
		if (sku == null || sku == "")
			return false;
		if (!op.insert(bg))
			return false;
		return true;
	}

<<<<<<< HEAD
	// Ê†πÊçÆÂïÜÂìÅskuÁ†ÅÂà†Èô§ÂïÜÂìÅ
=======
	// ∏˘æ›…Ã∆∑sku¬Î…æ≥˝…Ã∆∑
>>>>>>> 10d52231888148ee62b1b12cf40db519b73c9728
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

<<<<<<< HEAD
	// Ê†πÊçÆËÆ¢ÂçïÁºñÂè∑ËøõË°åÂèëË¥ß
	public static Boolean delivery(String orderNumber) {
		DBOp op = new BrandOrderDBOp();
		BrandOrder bo = new BrandOrder(orderNumber, null, null, null, null, null, null);
		BrandOrder deliver = new BrandOrder(null, null, null, null, null, StateName.Shiped, null);
		if (!op.update(bo, deliver))
			return false;
		return true;
	}

	// Ê†πÊçÆËÆ¢ÂçïÁºñÂè∑ËøõË°åÂèñÊ∂àËÆ¢Âçï
	public static Boolean cancelOrder(String orderNumber) {
		DBOp op = new BrandOrderDBOp();
		BrandOrder bo = new BrandOrder(orderNumber, null, null, null, null, null, null);
		BrandOrder cancel = new BrandOrder(null, null, null, null, null, StateName.Cancelled, null);
=======
	// ∏˘æ›∂©µ•±‡∫≈Ω¯––∑¢ªı
	public static Boolean delivery(String orderNumber) {
		DBOp op = new BrandOrderDBOp();
		BrandOrder bo = new BrandOrder(orderNumber, null, null, null, null, null, null);
		BrandOrder deliver = new BrandOrder(null, null, null, null, null, "Shipped", null);
		if (!op.update(bo, deliver))
			return false;

		return true;
	}

	// ∏˘æ›∂©µ•±‡∫≈Ω¯––»°œ˚∂©µ•
	public static Boolean cancelOrder(String orderNumber) {
		DBOp op = new BrandOrderDBOp();
		BrandOrder bo = new BrandOrder(orderNumber, null, null, null, null, null, null);
		BrandOrder cancel = new BrandOrder(null, null, null, null, null, "cancelled", null);
>>>>>>> 10d52231888148ee62b1b12cf40db519b73c9728
		if (!op.update(bo, cancel))
			return false;

		return true;
	}

<<<<<<< HEAD
	// ÂïÜÂìÅÂÖ•‰ªì
=======
	// …Ã∆∑»Î≤÷
>>>>>>> 10d52231888148ee62b1b12cf40db519b73c9728
	public static Boolean PutinStorage(String sku) {
		BrandGoods bg = new BrandGoods();
		bg.setSku(sku);
		BrandGoods newbg = new BrandGoods();
<<<<<<< HEAD
		newbg.setState(StateName.InStorage);
=======
		bg.setState("InStorage");
>>>>>>> 10d52231888148ee62b1b12cf40db519b73c9728

		DBOp op = new BrandGoodsDBOp();
		if (sku == null || sku == "")
			return false;
		if (!op.update(bg, newbg))
			return false;

		return true;
	}

<<<<<<< HEAD
	// ÂïÜÂìÅ‰∏äÊû∂
=======
	// …Ã∆∑…œº‹
>>>>>>> 10d52231888148ee62b1b12cf40db519b73c9728
	public static Boolean PutWay(String sku) {
		BrandGoods bg = new BrandGoods();
		bg.setSku(sku);
		BrandGoods newbg = new BrandGoods();
<<<<<<< HEAD
		newbg.setState(StateName.PutWay);
=======
		bg.setState("PutWay");
>>>>>>> 10d52231888148ee62b1b12cf40db519b73c9728

		DBOp op = new BrandGoodsDBOp();
		if (sku == null || sku == "")
			return false;
		if (!op.update(bg, newbg))
			return false;

		return true;
	}

<<<<<<< HEAD
	// ÂïÜÂìÅ‰∏ãÊû∂
=======
	// …Ã∆∑œ¬º‹
>>>>>>> 10d52231888148ee62b1b12cf40db519b73c9728
	public static Boolean SoldOut(String sku) {
		BrandGoods bg = new BrandGoods();
		bg.setSku(sku);
		BrandGoods newbg = new BrandGoods();
<<<<<<< HEAD
		newbg.setState(StateName.WaitingPutWay);
=======
		bg.setState("StoreOut");
>>>>>>> 10d52231888148ee62b1b12cf40db519b73c9728

		DBOp op = new BrandGoodsDBOp();
		if (sku == null || sku == "")
			return false;
		if (!op.update(bg, newbg))
			return false;

		return true;
	}
<<<<<<< HEAD

	//ÂìÅÁâåÂïÜËÆ¢ÂçïÊêúÁ¥¢
	public static ArrayList<GoodsMessage> requestList(String type) {
		ArrayList<Object> goods = new ArrayList<Object>();
		ArrayList<GoodsMessage> goodsmessage = new ArrayList<GoodsMessage>();
		DBOp op = new BrandOrderDBOp();
		BrandOrder bo = new BrandOrder();
		BrandGoods bg = new BrandGoods();
		GoodsMessage goodsmess = new GoodsMessage();
		switch (type) {
		case StateName.Cancelled:// ËØ∑Ê±ÇÂ∑≤ÂèñÊ∂àÁöÑÂïÜÂìÅÂàóË°®
			bo.setState(StateName.Cancelled);
			goods = op.select(bo);

			for (Object obj : goods) {
				String sku = (((BrandOrder) obj).getSku());
				bg.setSku(sku);
				goodsmess.setTitle(bg.getBrandName());
				goodsmess.setPrice(bg.getPrice());
				goodsmess.setQTY(((BrandOrder) obj).getQTY());
				goodsmess.setSku(((BrandOrder) obj).getSku());
				goodsmess.setOrderNumber(((BrandOrder) obj).getOrderNumber());
				goodsmessage.add(goodsmess);
			}
			break;
		case StateName.Completed: // ËØ∑Ê±ÇÂ∑≤ÂÆåÊàêÁöÑÂïÜÂìÅÂàóË°®
			bo.setState(StateName.Completed);
			goods = op.select(bo);
			for (Object obj : goods) {
				String sku = (((BrandOrder) obj).getSku());
				bg.setSku(sku);
				goodsmess.setTitle(bg.getBrandName());
				goodsmess.setPrice(bg.getPrice());
				goodsmess.setQTY(((BrandOrder) obj).getQTY());
				goodsmess.setSku(((BrandOrder) obj).getSku());
				goodsmess.setOrderNumber(((BrandOrder) obj).getOrderNumber());
				goodsmess.setTime((java.sql.Date) ((BrandOrder) obj).getTime_Date());
				goodsmess.setTrackNumber(((BrandOrder) obj).getTrackNumber());

				goodsmessage.add(goodsmess);
			}
			break;
		case StateName.Shiped: // ËØ∑Ê±ÇÂ∑≤ÂèëË¥ßÁöÑÂïÜÂìÅÂàóË°®
			bo.setState(StateName.Shiped);
			goods = op.select(bo);
			for (Object obj : goods) {
				String sku = (((BrandOrder) obj).getSku());
				bg.setSku(sku);
				goodsmess.setTitle(bg.getBrandName());
				goodsmess.setPrice(bg.getPrice());
				goodsmess.setQTY(((BrandOrder) obj).getQTY());
				goodsmess.setSku(((BrandOrder) obj).getSku());
				goodsmess.setOrderNumber(((BrandOrder) obj).getOrderNumber());
				goodsmess.setTime((java.sql.Date) ((BrandOrder) obj).getTime_Date());
				goodsmess.setTrackNumber(((BrandOrder) obj).getTrackNumber());
				goodsmessage.add(goodsmess);
			}
			break;
		case StateName.AwaitingShipment: // ËØ∑Ê±ÇÂæÖÂèëË¥ßÁöÑÂïÜÂìÅÂàóË°®
			bo.setState(StateName.AwaitingShipment);
			goods = op.select(bo);
			for (Object obj : goods) {
				String sku = (((BrandOrder) obj).getSku());
				bg.setSku(sku);
				goodsmess.setTitle(bg.getBrandName());
				goodsmess.setPrice(bg.getPrice());
				goodsmess.setQTY(((BrandOrder) obj).getQTY());
				goodsmess.setSku(((BrandOrder) obj).getSku());
				goodsmess.setOrderNumber(((BrandOrder) obj).getOrderNumber());
				goodsmess.setTime((java.sql.Date) ((BrandOrder) obj).getTime_Date());
				goodsmessage.add(goodsmess);
			}
			break;
		}

		return goodsmessage;
	}

	// ‰øÆÊîπÂïÜÂìÅ‰ø°ÊÅØ
	public static boolean updateGoods(String oldtitle, String title, String category, String picUrl) {
		DBOp op = new BrandGoodsDBOp();
		BrandGoods bg = new BrandGoods();
		bg.setTitle(oldtitle);
		BrandGoods newbg = new BrandGoods();
		newbg.setTitle(title);
		newbg.setCategory(category);
		newbg.setPicUrl(picUrl);
		if (!op.update(bg, newbg))
			return false;
		return true;
	}
=======
}
>>>>>>> 10d52231888148ee62b1b12cf40db519b73c9728
