package com.bxx.biz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.bxx.dao.*;
import com.bxx.common.CashMessage;
import com.bxx.common.GoodsMessage;

import com.bxx.common.OrderMessage;
import com.bxx.common.StateName;
import com.bxx.dao.*;

public class FuncBrand {
	public static void main(String[] args) {
		// boolean succ = addCompanyFunc("������", "name", "introduction", "type", "url");
		// boolean succ = checkCashFunc("123@qq.com", 600.0, "1234567");
		// boolean succ = addGoods("12345", 1.1, 2.2, 3.3, 4.4, null, null, null, null,
		// null, null, null, null, null, null, null, null);
		// boolean succ = deleteGoods("1234");
		// boolean succ = delivery("123");
		// boolean succ = cancelOrder("1234");
		// boolean succ = SoldOut("2222");

		// boolean succ = updateGoods("55", "name", "category", "pic");
		// ArrayList<CashMessage> succ=displayCashFunc("mail");
		// ArrayList<GoodsMessage> succ=searchGoods("55");
		// ArrayList<GoodsMessage> succ=requestList("Cancelled");
		// for (CashMessage mess : displayCashFunc("mail")) {
		// System.out.println(mess.toString());
		// }

		// System.out.println("=== " + succ + " ===");
		// System.out.println("success");
	}

	// ����һ����˾��Ϣ

	public static Boolean addCompanyFunc(String chineseName, String englishName, String introduction, String type,
										 String url) {
		DBOp op = new BrandInfoDBOp();
		BrandInfo binfo = new BrandInfo(chineseName, introduction, type, url);
		if (chineseName == null || chineseName == "" || introduction == null || introduction == "" || type == null
				|| type == "" || url == null || url == "")
			return false;
		else if (!op.insert(binfo))
			return false;
		return true;
	}

	// ���֣���������Ƿ���ȷ�����ֵĽ���Ƿ���ȷ
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

	// ������ˮ
	public static ArrayList<CashMessage> displayCashFunc(String email) {
		ArrayList<Object> orders = new ArrayList<Object>();
		ArrayList<CashMessage> result = new ArrayList<CashMessage>();

		DBOp op = new TranscationDBOp();
		Transcation tran = new Transcation(null, null, null, null, email, null);
		orders = op.select(tran);

		for (Object obj : orders) {
			CashMessage cashmess = new CashMessage(null, null, null, null);
			cashmess.setOrderNumber(((Transcation) obj).getTranscationNumber());
			cashmess.setCash(((Transcation) obj).getBalance());
			cashmess.setState(((Transcation) obj).getState());
			cashmess.setTime(((Transcation) obj).getTime_Date());

			if(cashmess.getOrderNumber()==null||cashmess.getCash()==null||
			cashmess.getState()==null||cashmess.getTime()==null)
				continue;
			result.add(cashmess);
		}

		return result;
	}

	// ͨ����Ʒ���������Ʒ��Ϣ
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
			GoodsMessage goodsmess = new GoodsMessage();
			goodsmess.setTitle(((BrandGoods) obj).getTitle());
			goodsmess.setCategory(((BrandGoods) obj).getCategory());
			goodsmess.setState(((BrandGoods) obj).getState());
			goodsmess.setPicUrl(((BrandGoods) obj).getPicUrl());

			if(goodsmess.getTitle()==null)
				continue;
			goods.add(goodsmess);
		}
		return goods;
	}

	// ����һ����Ʒ
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

	// ������Ʒsku��ɾ����Ʒ
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

	// ���ݶ�����Ž��з���
	public static Boolean delivery(String orderNumber) {
		DBOp op = new BrandOrderDBOp();
		BrandOrder bo = new BrandOrder(orderNumber, null, null, null, null, null, null);
		BrandOrder deliver = new BrandOrder(null, null, null, null, null, StateName.Shiped, null);
		if (!op.update(bo, deliver))
			return false;
		return true;
	}

	// ���ݶ�����Ž���ȡ������
	public static Boolean cancelOrder(String orderNumber) {
		DBOp op = new BrandOrderDBOp();
		BrandOrder bo = new BrandOrder(orderNumber, null, null, null, null, null, null);
		BrandOrder cancel = new BrandOrder(null, null, null, null, null, StateName.Cancelled, null);
		if (!op.update(bo, cancel))
			return false;

		return true;
	}

	// ��Ʒ���
	public static Boolean PutinStorage(String sku) {
		BrandGoods bg = new BrandGoods();
		bg.setSku(sku);
		BrandGoods newbg = new BrandGoods();
		newbg.setState(StateName.InStorage);

		DBOp op = new BrandGoodsDBOp();
		if (sku == null || sku == "")
			return false;
		if (!op.update(bg, newbg))
			return false;

		return true;
	}

	// ��Ʒ�ϼ�
	public static Boolean PutWay(String sku) {
		BrandGoods bg = new BrandGoods();
		bg.setSku(sku);
		BrandGoods newbg = new BrandGoods();
		newbg.setState(StateName.PutWay);

		DBOp op = new BrandGoodsDBOp();
		if (sku == null || sku == "")
			return false;
		if (!op.update(bg, newbg))
			return false;

		return true;
	}

	// ��Ʒ�¼�
	public static Boolean SoldOut(String sku) {
		BrandGoods bg = new BrandGoods();
		bg.setSku(sku);
		BrandGoods newbg = new BrandGoods();
		newbg.setState(StateName.WaitingPutWay);

		DBOp op = new BrandGoodsDBOp();
		if (sku == null || sku == "")
			return false;
		if (!op.update(bg, newbg))
			return false;

		return true;
	}

	// Ʒ���̶�������
	public static ArrayList<GoodsMessage> requestList(String type) {
		ArrayList<Object> goods = new ArrayList<Object>();
		ArrayList<GoodsMessage> goodsmessage = new ArrayList<GoodsMessage>();
		DBOp op = new BrandOrderDBOp();
		BrandOrder bo = new BrandOrder();
		BrandGoods bg = new BrandGoods();
		DBOp opp = new BrandGoodsDBOp();
		GoodsMessage goodsmess = new GoodsMessage();
		switch (type) {
			case StateName.Cancelled:// ������ȡ������Ʒ�б�
				bo.setState(StateName.Cancelled);
				goods = op.select(bo);

				for (Object obj : goods) {
					String sku = (((BrandOrder) obj).getSku());
					bg.setSku(sku);
					try {
						bg = (BrandGoods) (opp.select(bg)).get(0);
					}catch(Exception e){
						continue;
					}
					goodsmess.setTitle(bg.getTitle());
					goodsmess.setPrice(bg.getPrice());
					goodsmess.setQTY(((BrandOrder) obj).getQTY());
					goodsmess.setSku(((BrandOrder) obj).getSku());
					goodsmess.setOrderNumber(((BrandOrder) obj).getOrderNumber());
					goodsmess.setTime(((BrandOrder) obj).getTime_Date());

					System.out.println(goodsmess.toString());
					if(goodsmess.getTitle()==null||goodsmess.getPrice()==null||goodsmess.getQTY()==null||
					goodsmess.getSku()==null||goodsmess.getOrderNumber()==null||goodsmess.getTime()==null)
						continue;
					goodsmessage.add(goodsmess);
				}
				break;
			case StateName.Completed: // ��������ɵ���Ʒ�б�
				bo.setState(StateName.Completed);
				goods = op.select(bo);
				for (Object obj : goods) {
					String sku = (((BrandOrder) obj).getSku());
					bg.setSku(sku);
					try {
						bg = (BrandGoods) (opp.select(bg)).get(0);
					}catch(Exception e){
						continue;
					}
					goodsmess.setTitle(bg.getTitle());
					goodsmess.setPrice(bg.getPrice());
					goodsmess.setQTY(((BrandOrder) obj).getQTY());
					goodsmess.setSku(((BrandOrder) obj).getSku());
					goodsmess.setOrderNumber(((BrandOrder) obj).getOrderNumber());
					goodsmess.setTime((java.sql.Date) ((BrandOrder) obj).getTime_Date());
					goodsmess.setTrackNumber(((BrandOrder) obj).getTrackNumber());

					System.out.println(goodsmess.toString());
					if(goodsmess.getTitle()==null||goodsmess.getPrice()==null||goodsmess.getQTY()==null||
							goodsmess.getSku()==null||goodsmess.getOrderNumber()==null||
							goodsmess.getTime()==null||goodsmess.getTrackNumber()==null)
						continue;
					goodsmessage.add(goodsmess);
				}
				break;
			case StateName.Shiped: // �����ѷ�������Ʒ�б�
				bo.setState(StateName.Shiped);
				goods = op.select(bo);
				for (Object obj : goods) {
					String sku = (((BrandOrder) obj).getSku());
					bg.setSku(sku);
					try {
						bg = (BrandGoods) (opp.select(bg)).get(0);
					}catch(Exception e){
						continue;
					}
					goodsmess.setTitle(bg.getTitle());
					goodsmess.setPrice(bg.getPrice());
					goodsmess.setQTY(((BrandOrder) obj).getQTY());
					goodsmess.setSku(((BrandOrder) obj).getSku());
					goodsmess.setOrderNumber(((BrandOrder) obj).getOrderNumber());
					goodsmess.setTime((java.sql.Date) ((BrandOrder) obj).getTime_Date());
					goodsmess.setTrackNumber(((BrandOrder) obj).getTrackNumber());

					System.out.println(goodsmess.toString());
					if(goodsmess.getTitle()==null||goodsmess.getPrice()==null||goodsmess.getQTY()==null||
							goodsmess.getSku()==null||goodsmess.getOrderNumber()==null||
							goodsmess.getTime()==null||goodsmess.getTrackNumber()==null)
						continue;
					goodsmessage.add(goodsmess);
				}
				break;
			case StateName.AwaitingShipment: // �������������Ʒ�б�
				bo.setState(StateName.AwaitingShipment);
				goods = op.select(bo);
				for (Object obj : goods) {
					String sku = (((BrandOrder) obj).getSku());
					bg.setSku(sku);
					try {
						bg = (BrandGoods) (opp.select(bg)).get(0);
					}catch(Exception e){
						continue;
					}
					goodsmess.setTitle(bg.getTitle());
					goodsmess.setPrice(bg.getPrice());
					goodsmess.setQTY(((BrandOrder) obj).getQTY());
					goodsmess.setSku(((BrandOrder) obj).getSku());
					goodsmess.setOrderNumber(((BrandOrder) obj).getOrderNumber());
					goodsmess.setTime((java.sql.Date) ((BrandOrder) obj).getTime_Date());
					System.out.println(goodsmess.toString());
					if(goodsmess.getTitle()==null||goodsmess.getPrice()==null||goodsmess.getQTY()==null||
							goodsmess.getSku()==null||goodsmess.getOrderNumber()==null||
							goodsmess.getTime()==null)
						continue;
					goodsmessage.add(goodsmess);
				}
				break;
		}

		return goodsmessage;
	}

	// �޸���Ʒ��Ϣ
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
}