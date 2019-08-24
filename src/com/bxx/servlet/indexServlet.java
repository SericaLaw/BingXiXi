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
import com.bxx.biz.FuncIndex;
import com.bxx.common.Message;

/**
 * Servlet implementation class indexServlet
 */
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	private String parseRequestURI(HttpServletRequest request) {
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
		System.out.println("borrowPost");
		request.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		PrintWriter out=response.getWriter();
		JSONObject obj = JSON.parseObject(request.getReader().readLine());
		System.out.println(obj);
		String type=parseRequestURI(request);
		System.out.println(type);
		ArrayList<Message> result=null;
		switch (type)
		{
			case "/brandPicture":
				result=FuncIndex.BrandProductPicture(); //����Ʒ������Ʒ���⡢���ࡢ��ͼ��״̬
				break;
			case "/brandOrderManage":
				result=FuncIndex.BrandWaitingOrder();//����Ʒ�������д�֧����Ʒ���⡢�۸�������sku��������š���������ʱ��
				break;
			case "/borrowProductView":
				result=FuncIndex.BorrowProduct(); //�����������ƷͼƬ���۸�����
				break;
			case "/borrowWishList":
				result=FuncIndex.WishList();//�����������Ը��ͼƬ���۸�sku
				break;
			case "/borrowOrderManage":
				result=FuncIndex.BorrowWaitingOrder();//����Ʒ�������д�֧����Ʒ���⡢�۸�������sku��������š���������ʱ��
				break;
			default:
				break;
		}
		
//		for(Message mess:result) {
//			System.out.println(mess.toString());
//		}
		
		out.append(JSON.toJSONString(result));
		out.flush();
		out.close();
	}

}
