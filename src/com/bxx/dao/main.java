//package com.bxx.dao;
//
//import java.util.Date;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//
//public class main {
//	public static void main(String[] args) {
//		BrandGoods ew = new BrandGoods("123", 1.1, 2.2, 3.3, 4.4, "1", "1", "11", "111", 5.5, "1", "2", "3", "4", "5",
//				"6");
//		BrandGoods ew1 = new BrandGoods("222", 1.1, 2.2, 3.3, 4.4, "2", "2", "22", "222", 5.5, "1", "2", "3", "4", "5",
//				"6");
//		BrandGoods ew2 = new BrandGoods("333", 1.1, 2.2, 3.3, 4.4, "3", "3", "33", "333", 5.5, "1", "2", "3", "4", "5",
//				"6");
//
//		DBOp op = new BrandGoodsDBOp();//////////
//
//		// op.insert(ew);
//		// op.insert(ew1);
//		// op.insert(ew2);
//		// op.insert(ew3);
//
//		// op.delete(ew);
//		// op.delete(ew1);
//		//
//		// op.update(ew1, ew);
//		//
//		BrandGoods ew6 = new BrandGoods(null, null, null, null, null, null, null, null, null, null, null, null, null,
//				null, null, null);
//		ArrayList<Object> arr = op.select(ew6);
//		for (Object item : arr) {
//			BrandGoods ee = (BrandGoods) item;
//			System.out.println(ee.toString());
//		}
//
//		System.out.println("success");
//	}
//}
