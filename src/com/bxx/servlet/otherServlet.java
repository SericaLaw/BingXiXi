package com.bxx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Servlet implementation class otherServlet
 */
public class otherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
     * @see HttpServlet#HttpServlet()
     */
    public otherServlet() {
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
		switch (type)
		{
			case "1.other":
				break;
			case "2.other":
				break;
			case "3.other":
				break;
			default:
				break;
		}
	}

}
