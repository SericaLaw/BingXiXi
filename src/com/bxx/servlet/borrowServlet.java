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
	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)		 * @api {post} /SignUp/
	 * @apiName borrowServlet
	 * @apiParam {json} request body example:
	 * {
	 * 	"email": xxx@xxx.com,
	 *  "account": accountName,
	 *  "password": pwd
	 * } 
	 * bvoInfo
	 * {  
	 *   SellerID:xx
	 *   tel:xx
	 *   email:xx
	 *   SellerName:xxx
	 * }
	 * storeInfo
	 * {
	 * 	StoreName:XX
	 *  MarketPlaceID:xx
	 *  SellerID:xx
	 *  MWS:xx
	 * }
	 * dropship{
	 * push:1
	 * }
	 * addtoWishlist{
	 * list:1
	 * }
	 * bvo-orderPayment{
	 * QTY
	 * RcverZip
	 * RcverTel
	 * RcverName
	 * RcvAddr
	 * walletEmail
	 * total
	 * }
	 *  
	 * @apiSuccess {json} response body example
	 * {
	 * "result": true
	 * }
	 * 
	 * 
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
		String email=null,account=null,password=null;
		boolean succ=true;
		switch (type)
		{
			case "/signUp":
				email = obj.get("email").toString();
				account = obj.get("account").toString();
				password = obj.get("password").toString();
				succ = FuncBorrow.signUpFunc(email, account, password);
				obj.clear();
				obj.fluentPut("result", succ);
				out.append(obj.toString());
				out.flush();
				out.close();
				break;
			case "/deposit":
				password=obj.getString("password");
				double money=obj.getDoubleValue("deposit");
				succ=FuncBorrow.deposit(password,money);
				obj.clear();
				obj.fluentPut("result", succ);
				out.append(obj.toString());
				out.flush();
				out.close();
				break;
			case "/record":
				result=FuncBorrow.record();
				out.append(JSON.toJSONString(result));
				out.flush();
				out.close();
				break;
			case "/changePassword":
				String newPassword=obj.getString("newPassword");
				String oldPassword=obj.getString("oldPassword");
				succ=FuncBorrow.changePassword(oldPassword,newPassword);
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
			case "/bvo-myInfo":
				//添加卖方信息
				//System.out.println(obj.size());
				System.out.println(obj);
			    email = obj.get("email").toString();
				String SellerName = obj.get("SellerName").toString();
				String SellerID = obj.get("SellerID").toString();
				String tel = obj.get("tel").toString();
			    /*System.out.println(email);
			    System.out.println(SellerName);
			    System.out.println(SellerID);
			    System.out.println(tel);
			    */
			    boolean confirm1=FuncBorrow.add_borrower_information( SellerID,tel,email,SellerName);
				obj.clear();
				obj.fluentPut("result", confirm1);
				out.append(obj.toString());
				out.flush();
				out.close();
				break;
				
			case "/bvo-shopAdd"://添加店铺信息
				System.out.println(obj.size());
				System.out.println(obj);
				String StoreName = obj.get("StoreName").toString(), 
				MarketPlaceID = obj.get("MarketPlaceID").toString(),
				SellerID_store = obj.get("SellerID").toString(),
				MWS = obj.get("MWS").toString();
				boolean confirm2=FuncBorrow.add_store_information(StoreName,MarketPlaceID,SellerID_store,MWS);
				obj.clear();
				obj.fluentPut("result", confirm2);
				out.append(obj.toString());
				out.flush();
				out.close();
				break;
			case "/dropship"://推送获得主键
				System.out.println(obj);
				String push_sku = obj.get("sku").toString();
				boolean confirm3=FuncBorrow.modify_push_information(push_sku);
				obj.clear();
				obj.fluentPut("result", confirm3);
				out.append(obj.toString());
				out.flush();
				out.close();
				break;
			case "/wishlist"://加入心愿单(心愿单状态修改)
				System.out.println(obj);
				String list_sku = obj.get("sku").toString();
				boolean confirm4=FuncBorrow.modify_wishlist_information(list_sku);
				obj.clear();
				obj.fluentPut("result", confirm4);
				out.append(obj.toString());
				out.flush();
				out.close();
				break;
			case "/bvo-wishlist"://对心愿单删除(删除数据)
				
				System.out.println(obj);
				break;
			case "/bvo-orderPayment"://判断余额是否够，然后再添加信息
				System.out.println(obj);
				/*String QTY = obj.get("QTY").toString(), 
						RcverZip = obj.get("RcverZip").toString(),
						RcverTel = obj.get("RcverTel").toString(),
						RcverName= obj.get(" RcverName").toString(),
						RcvAddr = obj.get("RcvAddr").toString(); */
				 
			case "/walletpay"://传totalnumber和钱包email
				String QTY = obj.get("QTY").toString(), 
				RcverZip = obj.get("RcverZip").toString(),
				RcverTel = obj.get("RcverTel").toString(),
				RcverName= obj.get(" RcverName").toString(),
				RcvAddr = obj.get("RcvAddr").toString(); 
				Double trackNumber = obj.getDouble("trackNumber"); 
				String walletEmail=obj.get("walletEmail").toString();
				boolean isafford=FuncBorrow.check_wallet_ifafford(trackNumber,walletEmail);
				if(isafford) {
					boolean confirm5=FuncBorrow.add_payment_information(QTY,RcverZip,RcverTel,RcverName,RcvAddr);
				}
				obj.fluentPut("isafford", isafford);
				out.append(obj.toString());
				out.flush();
				out.close();
				break;
			default:
				break;
		}
	}

}
