package com.bxx.biz;

import java.util.ArrayList;

import com.bxx.dao.BrandGoods;
import com.bxx.dao.BrandOrder;

public class FuncBrand {
	public static boolean addCompanyFunc(String chineseName, String englishName, String introduction, String type,
			String url) {
		// TODO Auto-generated method stub
		System.out.println("�˴���Ҫ���ݿ�������");
		//����һ����˾��Ϣ
		return false;
	}

	public static boolean checkCashFunc(String email, String cash, String password) {
		// TODO Auto-generated method stub
		System.out.println("�˴���Ҫ���ݿ����Ĳ���");
		//���֣���������Ƿ���ȷ�����ֵĽ���Ƿ���ȷ
		return false;
	}

	public static ArrayList<BrandOrder> displayCashFunc(String email) {
		// TODO Auto-generated method stub
		System.out.println("�˴���Ҫ���ݿ�����");
		//������ˮ
		ArrayList<BrandOrder> orders = new ArrayList<BrandOrder>();
		return orders;
	}

	public static BrandGoods searchGoods(String name) {
		// TODO Auto-generated method stub
		//ͨ����Ʒ���������Ʒ��Ϣ
		return null;
	}

	public static boolean addGoods(String sku, String weight, String height, String length, String title, String upc,
			String ena, String model, String price, String eBayDescription, String amazonDescription, String warranty,
			String state, String brandName, String category) {
		// TODO Auto-generated method stub
		//����һ����Ʒ
		return false;
	}

	public static boolean deleteGoods(String name) {
		// TODO Auto-generated method stub
		//������Ʒ����ɾ����Ʒ
		return false;
	}

	public static boolean delivery(String trackNumber) {
		// TODO Auto-generated method stub
		//���ݶ�����Ž��з���
		return false;
	}

	public static boolean cancelOrder(String trackNumber) {
		// TODO Auto-generated method stub
		//���ݶ�����Ž���ȡ������
		return false;
	}

	public static int updateState(String name) {
		// TODO Auto-generated method stub
		//������Ʒ״̬  �������or�ϼ�or�¼�״̬ �ò�ͬ��intֵ��ʾ��
		return 0;
	}
}
