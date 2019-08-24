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

import com.bxx.common.CashMessage;
import com.bxx.common.GoodsMessage;
import com.bxx.common.StateName;

public class brandServlet extends HttpServlet {

	private String parseRequestURI(HttpServletRequest request) {
		/**
		 * 解析请求路径，获取到请求的路径 如【http://localhost/MySpringMVC/testServlet】--> 【/testServlet】
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
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)
	 *      * @api {post} /SignUp/
	 * @apiName brandServlet
	 * @apiParam {json} request body example: { "email": xxx@xxx.com, "account":
	 *           accountName, "password": pwd }
	 *
	 * @apiSuccess {json} response body example { "result": true }
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("这是BrandServlet的Post请求");

		JSONObject obj = JSON.parseObject(req.getReader().readLine());
		// System.out.println(obj);

		req.setCharacterEncoding("UTF-8");
		resp.setHeader("content-type", "text/html;charset=UTF-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET,POST");

		PrintWriter out = resp.getWriter();
		ArrayList<GoodsMessage> result = new ArrayList<GoodsMessage>();
		boolean succ = false;
		String type = this.parseRequestURI(req);
		// System.out.println(type);
		switch (type) {
		case "/register": // 注册公司
			succ = this.register(obj);
			out.append(JSON.toJSONString(succ));
			break;
		case "/addCompany": // 增加一个公司信息
			succ = this.addCompany(obj);
			break;
		case "/checkCash": // 提现
			succ = this.checkCash(obj);
			out.append(JSON.toJSONString(succ));
			break;
		case "/displayCash": // 提现流水
			ArrayList<CashMessage> cash = this.displayCash(obj);
			out.append(JSON.toJSONString(cash));
			break;
		case "/searchGoods": // 根据商品标题查找商品
			result = this.searchGoods(obj);
			out.append(JSON.toJSONString(result));
			break;
		case "/addGoods": // 增加商品
			succ = this.addGoods(obj);
			out.append(JSON.toJSONString(succ));
			break;
		case "/deleteGoods": // 删除商品
			succ = this.deleteGoods(obj);
			out.append(JSON.toJSONString(succ));
			break;
		case "/updateGoods": // 修改商品信息
			succ = this.updateGoods(obj);
			out.append(JSON.toJSONString(succ));
			break;
		case "/PutinStorage": // 入仓
			succ = this.PutinStorage(obj);
			out.append(JSON.toJSONString(succ));
			break;
		case "/putWay": // 上架
			succ = this.putWay(obj);
			out.append(JSON.toJSONString(succ));
			break;
		case "/soldOut": // 下架
			succ = this.soldOut(obj);
			out.append(JSON.toJSONString(succ));
			break;
		case "/delivery": // 发货
			succ = this.delivery(obj);
			out.append(JSON.toJSONString(succ));
			break;
		case "/cancelOrder": // 取消订单
			succ = this.cancelOrder(obj);
			out.append(JSON.toJSONString(succ));
			break;
		case "/requestWaitingForDeliveryList": // 请求待发货的商品列表
			result = this.requestWaitingForDeliveryList(obj);
			out.append(JSON.toJSONString(result));
			break;
		case "/requesDeliveredList": // 请求已发货的商品列表
			result = this.requesDeliveredList(obj);
			out.append(JSON.toJSONString(result));
			break;
		case "/requestcompletedList": // 请求已完成的商品列表
			result = this.requestCompletedList(obj);
			out.append(JSON.toJSONString(result));
			break;
		case "/requestCanceledList": // 请求已取消的商品列表
			result = this.requestCanceledList(obj);
			out.append(JSON.toJSONString(result));
			break;
		default:
			System.out.println("Not yet!");
		}

		out.flush();
		out.close();
	}

	private ArrayList<GoodsMessage> requestCanceledList(JSONObject obj) {
		System.out.println("这是请求已取消商品列表");
		ArrayList<GoodsMessage> goods = FuncBrand.requestList(StateName.Cancelled);
		return goods;
	}

	private ArrayList<GoodsMessage> requestCompletedList(JSONObject obj) {
		System.out.println("这是请求已完成商品列表");
		ArrayList<GoodsMessage> goods = FuncBrand.requestList(StateName.Completed);
		return goods;
	}

	private ArrayList<GoodsMessage> requesDeliveredList(JSONObject obj) {
		System.out.println("这是请求已发货商品列表");
		ArrayList<GoodsMessage> goods = FuncBrand.requestList(StateName.Shiped);
		return goods;
	}

	private ArrayList<GoodsMessage> requestWaitingForDeliveryList(JSONObject obj) {
		System.out.println("这是请求待发货商品列表");
		ArrayList<GoodsMessage> goods = FuncBrand.requestList(StateName.AwaitingShipment);
		return goods;
	}

	private boolean soldOut(JSONObject obj) {
		System.out.println("这是下架");
		String sku = obj.get("sku").toString();
		boolean succ = FuncBrand.SoldOut(sku);
		return succ;
	}

	private boolean putWay(JSONObject obj) {
		System.out.println("这是上架");
		String sku = obj.get("sku").toString();
		boolean succ = FuncBrand.PutWay(sku);
		return succ;
	}

	private boolean PutinStorage(JSONObject obj) {
		System.out.println("这是入仓");
		String sku = obj.get("sku").toString();
		boolean succ = FuncBrand.PutinStorage(sku);
		return succ;
	}

	private boolean cancelOrder(JSONObject obj) {
		System.out.println("这是请求已取消商品列表");
		String trackNumber = obj.get("trackNumber").toString();
		boolean succ = FuncBrand.cancelOrder(trackNumber);
		return succ;
	}

	private boolean delivery(JSONObject obj) {
		System.out.println("这是取消订单");
		String trackNumber = obj.get("trackNumber").toString();
		boolean succ = FuncBrand.delivery(trackNumber);
		return succ;
	}

	private boolean updateGoods(JSONObject obj) {
		System.out.println("这是修改商品信息");
		String oldTitle = obj.getString("oldTitle"), title = obj.getString("title"), category = obj.getString("Category"),
				picUrl = obj.getString("PicUrl");
		boolean succ = FuncBrand.updateGoods(oldTitle, title, category, picUrl);
		return succ;
	}

	private boolean deleteGoods(JSONObject obj) {
		System.out.println("这是删除商品");
		String name = obj.get("goodsName").toString();
		boolean succ = FuncBrand.deleteGoods(name);
		System.out.println(succ);
		obj.clear();
		obj.fluentPut("result", succ);
		return succ;
	}

	private Boolean register(JSONObject obj) {
		System.out.println("这是注册");
		String email = obj.get("email").toString(), account = obj.get("account").toString(),
				password = obj.get("password").toString();
		System.out.println(obj);
		boolean succ = FuncBorrow.signUpFunc(email, account, password);
		System.out.println(succ);
		obj.clear();
		obj.fluentPut("result", succ);
		return succ;
	}

	private Boolean addCompany(JSONObject obj) {
		System.out.println("这是增加公司信息");
		String chineseName = obj.get("chineseName").toString(), englishName = obj.get("englishName").toString(),
				introduction = obj.get("introduction").toString(), type = obj.get("type").toString(),
				url = obj.getString("url").toString();
		System.out.println(obj);
		boolean succ = FuncBrand.addCompanyFunc(chineseName, englishName, introduction, type, url);
		System.out.println(succ);
		obj.clear();
		obj.fluentPut("result", succ);
		return succ;
	}

	private Boolean checkCash(JSONObject obj) {
		System.out.println("这是提现");
		Double cash = obj.getDouble("cash");
		String email = obj.get("email").toString(), password = obj.get("password").toString();

		boolean succ = FuncBrand.checkCashFunc(email, cash, password);
		System.out.println(succ);
		obj.clear();
		obj.fluentPut("result", succ);
		return succ;
	}

	private ArrayList<CashMessage> displayCash(JSONObject obj) {
		System.out.println("这是提现流水");
		String email = obj.get("semail").toString();
		System.out.println(obj);
		ArrayList<CashMessage> orders = FuncBrand.displayCashFunc(email);
		obj.clear();
		return orders;
	}

	private ArrayList<GoodsMessage> searchGoods(JSONObject obj) {
		System.out.println("这是通过商品标题查找商品");
		String name = obj.get("goodsName").toString();
		ArrayList<GoodsMessage> goods = FuncBrand.searchGoods(name);
		return goods;
	}

	private boolean addGoods(JSONObject obj) {
		System.out.println("这是增加商品");
		String sku = obj.get("sku").toString(), upc = obj.get("upc").toString(), ena = obj.get("ena").toString(),
				model = obj.get("model").toString(), eBayDescription = obj.get("eBayDescription").toString(),
				amazonDescription = obj.get("amazonDescription").toString(), warranty = obj.get("warranty").toString(),
				state = obj.get("state").toString(), brandName = obj.get("brandName").toString(),
				category = obj.get("category").toString(), title = obj.get("title").toString(),
				picUrl = obj.get("picUrl").toString();
		Double weight = obj.getDoubleValue("weight"), width = obj.getDoubleValue("width"),
				height = obj.getDoubleValue("height"), length = obj.getDoubleValue("length"),
				price = obj.getDoubleValue("price");
		boolean succ = FuncBrand.addGoods(sku, weight, width, height, length, title, upc, ena, model, price,
				eBayDescription, amazonDescription, warranty, state, brandName, category, picUrl);
		System.out.println(succ);
		obj.clear();
		obj.fluentPut("result", succ);
		return succ;
	}
}
