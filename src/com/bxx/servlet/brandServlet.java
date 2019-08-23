package com.bxx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bxx.biz.FuncSet;

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
	
	private Boolean add(JSONObject obj) {
		String chineseName = obj.get("chineseName").toString(),
				englishName = obj.get("englishName").toString(),
				introduction = obj.get("introduction").toString(),
				type = obj.get("type").toString(),
				url = obj.getString("url").toString();
		System.out.println(obj);
		boolean succ = FuncSet.addFunc(chineseName, englishName, introduction, type, url);
		System.out.println(succ);
		obj.clear();
		obj.fluentPut("result", succ);
		return succ;
	}
	
	private Boolean check(JSONObject obj) {
		// TODO Auto-generated method stub
		String cash = obj.get("cash").toString(),
				password = obj.get("password").toString();
				
		System.out.println(obj);
		boolean succ = FuncSet.checkFunc(cash, password);
		System.out.println(succ);
		obj.clear();
		obj.fluentPut("result", succ);
		return succ;
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
		System.out.println("这是BrandServlet的Post请求");
		
		JSONObject obj = JSON.parseObject(req.getReader().readLine());
		//System.out.println(obj);
		
		req.setCharacterEncoding("UTF-8");
		resp.setHeader("content-type","text/html;charset=UTF-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET,POST");

		String type = this.parseRequestURI(req);
		System.out.println(type);
		switch(type) {
		case "/register":    //注册公司
			this.register(obj);
			break;
		case "/add":         //增加一个公司信息
			this.add(obj);
			break;
		case "/check":     //提现
			this.check(obj);
			break;
		default:
			System.out.println("Not yet!");
		}
			
		
		
		

	
	}
	
}
