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
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setHeader("content-type","text/html;charset=UTF-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET,POST");
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
		JSONObject obj = JSON.parseObject(req.getReader().readLine());
		System.out.println(obj);
		String type = this.parseRequestURI(req);
		switch(type) {
		case "brand-wallerAcountRegister":
			this.register(obj);
			break;
		case "brand-orderlist":
			break;
		
		}
			
		
		
		

	
	}
}
