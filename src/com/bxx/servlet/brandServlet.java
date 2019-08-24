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
import com.bxx.biz.FuncBrand;
import com.bxx.biz.FuncSet;
import com.bxx.dao.BrandGoods;
import com.bxx.dao.BrandOrder;

public class brandServlet extends HttpServlet {
	
	private String parseRequestURI(HttpServletRequest request) {
		/**
		 * ��������·������ȡ�������·��
		 * �硾http://localhost/MySpringMVC/testServlet��--> ��/testServlet��
		 */
		String path = request.getContextPath();
		String requestUri = request.getRequestURI();
		String lasturl = requestUri.replaceFirst(path, "");
		lasturl = lasturl.substring(0, lasturl.lastIndexOf("."));
		return lasturl;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		System.out.println("����BrandServlet��Post����");
		
		JSONObject obj = JSON.parseObject(req.getReader().readLine());
		//System.out.println(obj);
		
		req.setCharacterEncoding("UTF-8");
		resp.setHeader("content-type","text/html;charset=UTF-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET,POST");
		PrintWriter out=resp.getWriter();
		
		String type = this.parseRequestURI(req);
		System.out.println(type);
		switch(type) {
		case "/register":        //ע�ṫ˾
			this.register(obj);
			break;
		case "/addCompany":      //����һ����˾��Ϣ
			this.addCompany(obj);
			break;
		case "/checkCash":       //����
			this.checkCash(obj);
		case "/displayCash":     //������ˮ
			this.displayCash(obj);
			break;
		case "/searchGoods":     //������Ʒ���������Ʒ
			this.searchGoods(obj);
			break;
		case "/addGoods":        //������Ʒ
			this.addGoods(obj);
			break;
		case "/deleteGoods":     //ɾ����Ʒ
			this.deleteGoods(obj);
			break;
		case "/updateGoods":     //�޸���Ʒ��Ϣ
			this.updateGoods(obj);
			break;
		case "/updateState":     //������Ʒ״̬  ���+�ϼ�+�¼�
			this.updateState(obj);
			break;
		case "/delivery":        //����
			this.delivery(obj);
			break;
		case "/cancelOrder":     //ȡ������ 
			this.cancelOrder(obj);
			break;
		default:
			System.out.println("Not yet!");
		}
		
		out.append(obj.toString());
		out.flush();
		out.close();	
	}
	
	
	private int updateState(JSONObject obj) {
		// TODO Auto-generated method stub
		String name = obj.get("goodsName").toString();
		int state = FuncBrand.updateState(name);
		return state;
	}

	private boolean cancelOrder(JSONObject obj) {
		// TODO Auto-generated method stub
		String trackNumber = obj.get("trackNumber").toString();
		boolean succ = FuncBrand.cancelOrder(trackNumber);
		return succ;
	}

	private boolean delivery(JSONObject obj) {
		// TODO Auto-generated method stub
		String trackNumber = obj.get("trackNumber").toString();
		boolean succ = FuncBrand.delivery(trackNumber);
		return succ;
	}

	private void updateGoods(JSONObject obj) {
		// TODO Auto-generated method stub
		//FuncBrand.updateGoods();
	}

	private boolean deleteGoods(JSONObject obj) {
		// TODO Auto-generated method stub
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
		boolean succ = FuncSet.signUpFunc(email, account, password);
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
		// TODO Auto-generated method stub
		String cash = obj.get("cash").toString(),
				email = obj.get("email").toString(),
				password = obj.get("password").toString();
				
		System.out.println(obj);
		//email��ô��ȡ��
		boolean succ = FuncBrand.checkCashFunc(email, cash, password);
		System.out.println(succ);
		obj.clear();
		obj.fluentPut("result", succ);
		return succ;
	}
	
	private ArrayList<BrandOrder> displayCash(JSONObject obj) {
		// TODO Auto-generated method stub
		
		String email = obj.get("email").toString();
				
		System.out.println(obj);
		//email��ô��ȡ��
		ArrayList<BrandOrder>orders = FuncBrand.displayCashFunc(email);
		
		obj.clear();
		return orders;
	}
	
	private BrandGoods searchGoods(JSONObject obj) {
		// TODO Auto-generated method stub
		String name = obj.get("goodsName").toString();
		BrandGoods goods = FuncBrand.searchGoods(name);
		return goods;
	}	
	
	private boolean addGoods(JSONObject obj) {
		// TODO Auto-generated method stub
		String sku = obj.get("sku").toString(),
				weight = obj.get("weight").toString(),
				width = obj.get("width").toString(),
				height = obj.get("height").toString(),
				length = obj.get("length").toString(),
				title = obj.get("title").toString(),
				upc = obj.get("upc").toString(),
				ena = obj.get("ena").toString(),
				model = obj.get("model").toString(),
				price = obj.get("sprice").toString(),
				eBayDescription = obj.get("eBayDescription").toString(),
				amazonDescription = obj.get("amazonDescription").toString(),
				warranty = obj.get("warranty").toString(),
				state = obj.get("state").toString(),
				brandName = obj.get("brandName").toString(),
				category = obj.get("category").toString();
		boolean succ = FuncBrand.addGoods(sku, weight, height, length, title, upc, 
				ena, model, price, eBayDescription, amazonDescription,
				warranty, state, brandName, category);
		System.out.println(succ);
		obj.clear();
		obj.fluentPut("result", succ);
		return succ;
	}
}
