package com.bxx.biz;

import java.util.ArrayList;

import com.bxx.dao.*;
import com.bxx.biz.*;

public class FuncBrand {
	//增加一个公司信息
		public static boolean addCompanyFunc(String chineseName, String englishName, String introduction, String type,
				String url) {
			// TODO Auto-generated method stub
			DBOp op=new BrandInfoDBOp();
			BrandInfo binfo=new BrandInfo(chineseName,introduction,type,url);
			if(chineseName==null||chineseName==""||introduction==null||introduction==""||type==null||type==""||url==null||url=="")
				return false;
			else if(!op.insert(binfo))
				return false;
			
			return false;
		}

		//提现，检查密码是否正确，提现的金额是否正确
		public static boolean checkCashFunc(String email, Double cash, String password) {
			// TODO Auto-generated method stub
			DBOp op=new  EWalletDBOp();
			EWallet ew=new EWallet(email,null,null,null);
			ArrayList<Object> ewallet=new ArrayList<Object>();
			ewallet=op.select(ew);
			if(password!=ewallet.get(2))
				return false;//密码错误
			else if(cash.compareTo((Double) ewallet.get(3))>0 )
				return false;//余额不足
			Double balance=(Double)ewallet.get(3)-cash;
			EWallet newew=new EWallet(null,null,null,balance);
			if(!op.update(ew, newew))
				return false;
			
			return false;
		}
	    
		//提现流水
		public static ArrayList<Object> displayCashFunc(String email) {
			// TODO Auto-generated method stub	
			ArrayList<Object> orders = new ArrayList<Object>();
			DBOp op=new TranscationDBOp();
			Transcation tran=new Transcation(null,"withdrow",null,null,email);
			orders=op.select(tran);
			
			return orders;
		}

		public static ArrayList<Object> searchGoods(String name) {
			// TODO Auto-generated method stub
			//通过商品标题查找商品信息
			DBOp op=new BrandGoodsDBOp();
			ArrayList<Object> goods=new ArrayList<Object>();
			BrandGoods bg=new BrandGoods(null,null,null,null,null,null,null,null,null,null,null,null,null,null,name,null,null);
			if(name==null||name=="")
				return null;
			goods=op.select(bg);
			return goods;
		}

		public static boolean addGoods(String sku, Double weight,Double width, Double height, Double length, String title, String upc,
				String ena, String model, Double price, String eBayDescription, String amazonDescription, Date warranty,
				String state, String brandName, String category,String picUrl) {
			// TODO Auto-generated method stub
			//增加一件商品
			DBOp op=new BrandGoodsDBOp();
			BrandGoods bg=new BrandGoods(sku, weight, width, height, title, length, upc,
					ena, model, price, eBayDescription, amazonDescription, warranty,
				  state, brandName, category, picUrl);
			if(sku==null||sku=="")//主键
				return false;
	        if(!op.insert(bg))//插入失败
	        	return false;
	        return true;
		}

		public static boolean deleteGoods(String sku) {
			// TODO Auto-generated method stub
			//根据商品标题删除商品
			BrandGoods bg=new BrandGoods(sku,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
			DBOp op=new BrandGoodsDBOp();
			if(sku==null||sku=="")
				return false;
			if(!op.delete(bg))
				return false;
			
			return true;
		}

		public static boolean delivery(String orderNumber) {
			// TODO Auto-generated method stub
			//根据订单编号进行发货
			DBOp op=new BrandOrderDBOp();
			BrandOrder bo=new BrandOrder(orderNumber,null,null,null,null,null,null);
			BrandOrder deliver=new BrandOrder(null,null,null,null,null,"Shipped",null);
			if(!op.update(bo, deliver))
				return false;
			
			return true;
		}

		public static boolean cancelOrder(String orderNumber) {
			// TODO Auto-generated method stub
			//根据订单编号进行取消订单
			DBOp op=new BrandOrderDBOp();
			BrandOrder bo=new BrandOrder(orderNumber,null,null,null,null,null,null);
			BrandOrder cancel=new BrandOrder(null,null,null,null,null,"cancelled",null);
			if(!op.update(bo, cancel))
				return false;
			
			return true;
		}

		//商品入仓
		public static boolean PutinStorage(String sku) {
			// TODO Auto-generated method stub
			//更新商品状态  返回入仓or上架or下架状态 用不同的int值表示？
			
			BrandGoods bg=new BrandGoods(sku,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
			BrandGoods newbg=new BrandGoods(null,null,null,null,null,null,null,null,null,null,null,null,null,"InStorage",null,null,null);

			DBOp op=new BrandGoodsDBOp();
			if(sku==null||sku=="")
				return false;
			if(!op.update(bg, newbg))
				return false;
			
			return true;
		}
		
		//商品上架
		public static boolean PutWay(String sku) {
			// TODO Auto-generated method stub
			//更新商品状态  返回入仓or上架or下架状态 用不同的int值表示？
			
			BrandGoods bg=new BrandGoods(sku,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
			BrandGoods newbg=new BrandGoods(null,null,null,null,null,null,null,null,null,null,null,null,null,"PutWay",null,null,null);

			DBOp op=new BrandGoodsDBOp();
			if(sku==null||sku=="")
				return false;
			if(!op.update(bg, newbg))
				return false;
			
			return true;
		}
		
		//商品下架
		public static boolean SoldOut(String sku) {
			// TODO Auto-generated method stub
			//更新商品状态  返回入仓or上架or下架状态 用不同的int值表示？
			
			BrandGoods bg=new BrandGoods(sku,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
			BrandGoods newbg=new BrandGoods(null,null,null,null,null,null,null,null,null,null,null,null,null,"StoreOut",null,null,null);

			DBOp op=new BrandGoodsDBOp();
			if(sku==null||sku=="")
				return false;
			if(!op.update(bg, newbg))
				return false;
			
			return true;
		}

		public static int updateState(String name) {

		}
}
