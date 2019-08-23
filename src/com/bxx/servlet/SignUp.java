package com.bxx.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.bxx.biz.FuncSet;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @api {post} /SignUp/
	 * @apiName SignUp
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		PrintWriter out=response.getWriter();
		// The settings of response
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}*/
		JSONObject obj = JSON.parseObject(request.getReader().readLine());
		System.out.println(obj);
		String email = obj.get("email").toString(), 
				account = obj.get("account").toString(),
				password = obj.get("password").toString();
		
		
		boolean succ = FuncSet.signUpFunc(email, account, password);
		
		
		obj.clear();
		obj.fluentPut("result", succ);
		out.append(obj.toString());
		out.flush();
		out.close();
	}

}
