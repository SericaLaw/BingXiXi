package com.bxx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bxx.biz.FuncBorrow;
import com.bxx.biz.FuncBrand;

import com.bxx.common.Message;
import com.bxx.common.CashMessage;
import com.bxx.common.GoodsMessage;

import com.bxx.dao.BrandGoods;
import com.bxx.dao.BrandOrder;


public class brandServlet extends HttpServlet {

	private String parseRequestURI(HttpServletRequest request) {
		/**
		 * 解析请求路径，获取到请求的路径
		 * 如【http://localhost/MySpringMVC/testServlet】--> 【/testServlet】
		 */
		String path = request.getContextPath();
		String requestUri = request.getRequestURI();
		String lasturl = requestUri.replaceFirst(path, "");
		lasturl = lasturl.substring(0, lasturl.lastIndexOf("."));
		return lasturl;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)		 * @api {post} /SignUp/
	 * @apiName brandServlet
	 * @apiParam {json} request body example:
	 * {
	 * 	"email": xxx@xxx.com,
	 *  "account": accountName,
	 *  "password": pwd
	 * } 
	 *
	 * @apiSuccess {json} response body example
	 * {
	 * "result": true
	 * }
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("这是BrandServlet的Post请求");

		JSONObject obj = JSON.parseObject(req.getReader().readLine());
		//System.out.println(obj);

		req.setCharacterEncoding("UTF-8");
		resp.setHeader("content-type","text/html;charset=UTF-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET,POST");
		PrintWriter out=resp.getWriter();
		
//		ArrayList<Message> result;
		String type = this.parseRequestURI(req);
		System.out.println(type);
		switch(type) {
		case "/register":        //注册公司
			this.register(obj);
			break;
		case "/addCompany":      //增加一个公司信息
			this.addCompany(obj);
			break;
		case "/checkCash":       //提现
			this.checkCash(obj);
		case "/displayCash":     //提现流水
			this.displayCash(obj);
			break;
		case "/searchGoods":     //根据商品标题查找商品
			this.searchGoods(obj);
			break;
		case "/addGoods":        //增加商品
			this.addGoods(obj);
			break;
		case "/deleteGoods":     //删除商品
			this.deleteGoods(obj);
			break;
		case "/updateGoods":     //修改商品信息
			this.updateGoods(obj);
			break;
		case "/PutinStorage":    //入仓
			this.PutinStorage(obj);
			break;
		case "/putWay":          //上架 
			this.putWay(obj);
			break;
		case "/soldOut":         //下架
			this.soldOut(obj);
			break;
		case "/delivery":        //发货
			this.delivery(obj);
			break;
		case "/cancelOrder":     //取消订单 
			this.cancelOrder(obj);
			break;
		default:
			System.out.println("Not yet!");
		}
		
		out.append(JSON.toJSONString(obj));
		out.flush();
		out.close();
	}
	
	
	private boolean soldOut(JSONObject obj) {
		// TODO Auto-generated method stub
		String sku = obj.get("sku").toString();
		boolean succ = FuncBrand.SoldOut(sku);
		return succ;
	}

	private boolean putWay(JSONObject obj) {
		// TODO Auto-generated method stub
		String sku = obj.get("sku").toString();
		boolean succ = FuncBrand.PutWay(sku);
		return succ;
	}

	private boolean PutinStorage(JSONObject obj) {
		// TODO Auto-generated method stub
		String sku = obj.get("sku").toString();
		boolean succ = FuncBrand.PutinStorage(sku);
		return succ;
	}


		String type = this.parseRequestURI(req);
		System.out.println(type);
		switch(type) {
			case "/register":        //注册公司
				this.register(obj);
				break;
			case "/addCompany":      //增加一个公司信息
				this.addCompany(obj);
				break;
			case "/checkCash":       //提现
				this.checkCash(obj);
//			case "/displayCash":     //提现流水
//				this.displayCash(obj);
//				break;
//			case "/searchGoods":     //根据商品标题查找商品
//				this.searchGoods(obj);
//				break;
//			case "/addGoods":        //增加商品
//				this.addGoods(obj);
//				break;
//			case "/deleteGoods":     //删除商品
//				this.deleteGoods(obj);
//				break;
			case "/updateGoods":     //修改商品信息
				this.updateGoods(obj);
				break;
//			case "/updateState":     //更新商品状态  入仓+上架+下架
//				this.updateState(obj);
//				break;
			case "/delivery":        //发货
				this.delivery(obj);
				break;
			case "/cancelOrder":     //取消订单
				this.cancelOrder(obj);
				break;
			default:
				System.out.println("Not yet!");
		}

		out.append(obj.toString());
		out.flush();
		out.close();
	}

//
//	private int updateState(JSONObject obj) {
//		String name = obj.get("goodsName").toString();
//		int state = FuncBrand.updateState(name);
//		return state;
//	}
>>>>>>> a355ee5b68084ce9cfa340d6fdb9b74d190d9cb6

	private boolean cancelOrder(JSONObject obj) {
		String trackNumber = obj.get("trackNumber").toString();
		boolean succ = FuncBrand.cancelOrder(trackNumber);
		return succ;
	}

	private boolean delivery(JSONObject obj) {
		String trackNumber = obj.get("trackNumber").toString();
		boolean succ = FuncBrand.delivery(trackNumber);
		return succ;
	}

	private void updateGoods(JSONObject obj) {
		//FuncBrand.updateGoods();
	}

	private boolean deleteGoods(JSONObject obj) {
		String name = obj.get("goodsName").toString();
		boolean succ = FuncBrand.deleteGoods(name);
		System.out.println(succ);
		obj.clear();
		obj.fluentPut("result", succ);
		return succ;
	}

	private Boolean register(JSONObject obj) {
		String email = obj.get("email").toString(),
				account = obj.get("account").toString(),
				password = obj.get("password").toString();
		System.out.println(obj);
		boolean succ = FuncBorrow.signUpFunc(email, account, password);
		System.out.println(succ);
		obj.clear();
		obj.fluentPut("result", succ);
		return succ;
	}

	private Boolean addCompany(JSONObject obj) {
		String chineseName = obj.get("chineseName").toString(),
				englishName = obj.get("englishName").toString(),
				introduction = obj.get("introduction").toString(),
				type = obj.get("type").toString(),
				url = obj.getString("url").toString();
		System.out.println(obj);
		boolean succ = FuncBrand.addCompanyFunc(chineseName, englishName, introduction, type, url);
		System.out.println(succ);
		obj.clear();
		obj.fluentPut("result", succ);
		return succ;
	}

	private Boolean checkCash(JSONObject obj) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		Double cash = obj.getDouble("cash");
		String	email = obj.get("email").toString(),
				password = obj.get("password").toString();		
				
=======
		Double cash = Double.parseDouble(obj.get("cash").toString());
		String email = obj.get("email").toString(),
				password = obj.get("password").toString();

>>>>>>> a355ee5b68084ce9cfa340d6fdb9b74d190d9cb6
		System.out.println(obj);
		//email怎么获取？
		boolean succ = FuncBrand.checkCashFunc(email, cash, password);
		System.out.println(succ);
		obj.clear();
		obj.fluentPut("result", succ);
		return succ;
	}
<<<<<<< HEAD
	

	private ArrayList<CashMessage> displayCash(JSONObject obj) {
		// TODO Auto-generated method stub
		String email = obj.get("email").toString();
		
		System.out.println(obj);
		//email怎么获取？
		ArrayList<CashMessage>orders = FuncBrand.displayCashFunc(email);
		
		obj.clear();
		return orders;
	}

	private ArrayList<GoodsMessage> searchGoods(JSONObject obj) {
		// TODO Auto-generated method stub
		String name = obj.get("goodsName").toString();
		ArrayList<GoodsMessage> goods = FuncBrand.searchGoods(name);
		return goods;
	}
	
	private boolean addGoods(JSONObject obj) {
		String sku = obj.get("sku").toString(),
				upc = obj.get("upc").toString(),
				ena = obj.get("ena").toString(),
				model = obj.get("model").toString(),
				eBayDescription = obj.get("eBayDescription").toString(),
				amazonDescription = obj.get("amazonDescription").toString(),
				warranty = obj.get("warranty").toString(),
				state = obj.get("state").toString(),
				brandName = obj.get("brandName").toString(),
				category = obj.get("category").toString(),
				title = obj.get("title").toString(),
				picUrl = obj.get("picUrl").toString();
		Double weight = obj.getDoubleValue("weight"),
				width = obj.getDoubleValue("width"),
				height = obj.getDoubleValue("height"),
				length = obj.getDoubleValue("length"),
				price = obj.getDoubleValue("price");
		boolean succ = FuncBrand.addGoods(sku, weight, width, height, length, title, upc, 
				ena, model, price, eBayDescription, amazonDescription,
				warranty, state, brandName, category, picUrl);
		System.out.println(succ);
		obj.clear();
		obj.fluentPut("result", succ);
		return succ;
	}
}
=======

//	private ArrayList<Object> displayCash(JSONObject obj) {
//		// TODO ???
//
//		String email = obj.get("email").toString();
//
//		System.out.println(obj);
//		//email怎么获取？
//		ArrayList<Object>orders = FuncBrand.displayCashFunc(email);
//
//		obj.clear();
//		return orders;
//	}
//
//	private BrandGoods searchGoods(JSONObject obj) {
//		// ???
//		String name = obj.get("goodsName").toString();
//		BrandGoods goods = FuncBrand.searchGoods(name);
//		return goods;
//	}
//
//	private boolean addGoods(JSONObject obj) {
//		String sku = obj.get("sku").toString(),
//				weight = obj.get("weight").toString(),
//				width = obj.get("width").toString(),
//				height = obj.get("height").toString(),
//				length = obj.get("length").toString(),
//				title = obj.get("title").toString(),
//				upc = obj.get("upc").toString(),
//				ena = obj.get("ena").toString(),
//				model = obj.get("model").toString(),
//				price = obj.get("sprice").toString(),
//				eBayDescription = obj.get("eBayDescription").toString(),
//				amazonDescription = obj.get("amazonDescription").toString(),
//				warranty = obj.get("warranty").toString(),
//				state = obj.get("state").toString(),
//				brandName = obj.get("brandName").toString(),
//				category = obj.get("category").toString();
//		boolean succ = FuncBrand.addGoods(sku, weight, height, length, title, upc,
//				ena, model, price, eBayDescription, amazonDescription,
//				warranty, state, brandName, category);
//		System.out.println(succ);
//		obj.clear();
//		obj.fluentPut("result", succ);
//		return succ;
//	}
}
>>>>>>> a355ee5b68084ce9cfa340d6fdb9b74d190d9cb6
