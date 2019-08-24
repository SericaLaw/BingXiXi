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
import com.bxx.common.Message;

/**
 * Servlet implementation class borrowServlet
 */
public class borrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public borrowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
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
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		PrintWriter out=response.getWriter();
		JSONObject obj = JSON.parseObject(request.getReader().readLine());
		System.out.println(obj);
		String type=parseRequestURI(request);
		ArrayList<Message> result;
		switch (type)
		{
			case "/signUp":
				String email = obj.get("email").toString(), 
				account = obj.get("account").toString(),
				password = obj.get("password").toString();
				boolean succ = FuncBorrow.signUpFunc(email, account, password);
				obj.clear();
				obj.fluentPut("result", succ);
				out.append(obj.toString());
				out.flush();
				out.close();
				break;
			case "/awaitingShipment":
				result=FuncBorrow.awaitingShipment(); 
				out.append(JSON.toJSONString(result));
				out.flush();
				out.close();
				break;
			case "/shiped":
				result=FuncBorrow.shiped(); 
				out.append(JSON.toJSONString(result));
				out.flush();
				out.close();
				break;
			case "/completed":
				result=FuncBorrow.completed(); 
				out.append(JSON.toJSONString(result));
				out.flush();
				out.close();
				break;
			case "/cancelled":
				result=FuncBorrow.cancelled(); 
				out.append(JSON.toJSONString(result));
				out.flush();
				out.close();
				break;
			default:
				break;
		}
	}

}
