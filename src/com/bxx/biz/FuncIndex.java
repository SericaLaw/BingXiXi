package com.bxx.biz;

import java.util.ArrayList;
import com.bxx.common.Message;
import com.bxx.dao.*;

public class FuncIndex {
	// public static void main(String[] args) {
	// for(Message mess:BorrowWaitingOrder()) {
	// System.out.println(mess.toString());
	// }
	// System.out.println("===== success =====");
	// }

	public static BrandGoods getBrandGoodsBySku(String sku) {
		BrandGoods bg = new BrandGoods();
		bg.setSku(sku);
		DBOp op = new BrandGoodsDBOp();
		ArrayList<Object> arr = op.select(bg);
		return (BrandGoods) arr.get(0);
	}

	public static ArrayList<Message> BrandProductPicture() // ����Ʒ������Ʒ���⡢���ࡢ��ͼ��״̬
	{
		DBOp op = new BrandGoodsDBOp();
		BrandGoods bg = new BrandGoods();
		ArrayList<Object> arr = op.select(bg);
		ArrayList<Message> res = new ArrayList<Message>();
		for (Object obj : arr) {
			Message mess = new Message();
			// System.out.println("!!!\n"+mess.toString()+"???\n");
			BrandGoods bgs = (BrandGoods) obj;

			if (bgs.getTitle() == null || bgs.getCategory() == null || bgs.getPicUrl() == null
					|| bgs.getState() == null)
				continue;
			mess.setName(bgs.getTitle());
			mess.setType(bgs.getCategory());
			mess.setPicture(bgs.getPicUrl());
			mess.setState(bgs.getState());

			res.add(mess);
		}
		return res;
	}

	public static ArrayList<Message> BrandWaitingOrder()// ����Ʒ�������д�֧����Ʒ���⡢�۸�������sku��������š���������ʱ��
	{
		DBOp op = new BrandOrderDBOp();
		BrandOrder bom = new BrandOrder();
		bom.setState("��֧��");
		ArrayList<Object> arr = op.select(bom);
		ArrayList<Message> res = new ArrayList<Message>();
		for (Object obj : arr) {
			Message mess = new Message();
			BrandOrder bo = (BrandOrder) obj;
			BrandGoods bg = getBrandGoodsBySku(bo.getSku());

			if (bg.getBrandName() == null || bg.getPrice() == null || bo.getSku() == null || bo.getOrderNumber() == null
					|| bo.getQTY() == null || bo.getTime_Date() == null)
				continue;
			mess.setName(bg.getBrandName());
			mess.setPrice(bg.getPrice());
			mess.setSku(bo.getSku());
			mess.setId(bo.getOrderNumber());
			mess.setNumber(bo.getQTY());
			mess.setTime(bo.getTime_Date());

			res.add(mess);
		}
		return res;
	}

	public static ArrayList<Message> BorrowProduct() // �����������ƷͼƬ���۸�����
	{
		DBOp op = new BvoGoodsDBOp();
		BvoGoods bg = new BvoGoods();
		ArrayList<Object> arr = op.select(bg);
		ArrayList<Message> res = new ArrayList<Message>();
		for (Object obj : arr) {
			Message mess = new Message();
			BvoGoods bgs = (BvoGoods) obj;
			BrandGoods brg = getBrandGoodsBySku(bgs.getSku());

			if (brg.getBrandName() == null || brg.getPrice() == null || brg.getPicUrl() == null)
				continue;
			mess.setName(brg.getBrandName());
			mess.setPicture(brg.getPicUrl());
			mess.setPrice(brg.getPrice());
			res.add(mess);
		}
		return res;
	}

	public static ArrayList<Message> WishList() // �����������Ը��ͼƬ���۸�sku
	{
		DBOp op = new BvoGoodsDBOp();
		BvoGoods bg = new BvoGoods();
		bg.setIfWishList(true);
		ArrayList<Object> arr = op.select(bg);
		ArrayList<Message> res = new ArrayList<Message>();
		for (Object obj : arr) {
			Message mess = new Message();
			BvoGoods bgs = (BvoGoods) obj;
			BrandGoods brg = getBrandGoodsBySku(bgs.getSku());

			if (brg.getBrandName() == null || brg.getPicUrl() == null || brg.getPrice() == null || brg.getSku() == null)
				continue;
			mess.setName(brg.getBrandName());
			mess.setPicture(brg.getPicUrl());
			mess.setPrice(brg.getPrice());
			mess.setSku(brg.getSku());

			res.add(mess);
		}
		return res;
	}

	public static ArrayList<Message> BorrowWaitingOrder()// ������������д�֧����Ʒ���⡢�۸�������sku���������
	{
		DBOp op = new BvoOrderManageDBOp();
		BvoOrderManage bom = new BvoOrderManage();
		bom.setState("Awaiting Payment");
		ArrayList<Object> arr = op.select(bom);
		ArrayList<Message> res = new ArrayList<Message>();
		for (Object obj : arr) {
			Message mess = new Message();
			BvoOrderManage bo = (BvoOrderManage) obj;
			BrandGoods bg = getBrandGoodsBySku(bo.getSku());

			if (bg.getBrandName() == null || bg.getPrice() == null || bo.getSku() == null || bo.getOrderNumber() == null
					|| bo.getQTY() == null)
				continue;
			mess.setName(bg.getBrandName());
			mess.setPrice(bg.getPrice());
			mess.setSku(bo.getSku());
			mess.setId(bo.getOrderNumber());
			mess.setNumber(bo.getQTY());

			res.add(mess);
		}
		return res;
	}
}
