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
		 * ��������·������ȡ�������·�� �硾http://localhost/MySpringMVC/testServlet��--> ��/testServlet��
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
		System.out.println("����BrandServlet��Post����");

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
		case "/register": // ע�ṫ˾
			succ = this.register(obj);
			out.append(JSON.toJSONString(succ));
			break;
		case "/addCompany": // ����һ����˾��Ϣ
			succ = this.addCompany(obj);
			break;
		case "/checkCash": // ����
			succ = this.checkCash(obj);
			out.append(JSON.toJSONString(succ));
			break;
		case "/displayCash": // ������ˮ
			ArrayList<CashMessage> cash = this.displayCash(obj);
			out.append(JSON.toJSONString(cash));
			break;
		case "/searchGoods": // ������Ʒ���������Ʒ
			result = this.searchGoods(obj);
			out.append(JSON.toJSONString(result));
			break;
		case "/addGoods": // ������Ʒ
			succ = this.addGoods(obj);
			out.append(JSON.toJSONString(succ));
			break;
		case "/deleteGoods": // ɾ����Ʒ
			succ = this.deleteGoods(obj);
			out.append(JSON.toJSONString(succ));
			break;
		case "/updateGoods": // �޸���Ʒ��Ϣ
			succ = this.updateGoods(obj);
			out.append(JSON.toJSONString(succ));
			break;
		case "/PutinStorage": // ���
			succ = this.PutinStorage(obj);
			out.append(JSON.toJSONString(succ));
			break;
		case "/putWay": // �ϼ�
			succ = this.putWay(obj);
			out.append(JSON.toJSONString(succ));
			break;
		case "/soldOut": // �¼�
			succ = this.soldOut(obj);
			out.append(JSON.toJSONString(succ));
			break;
		case "/delivery": // ����
			succ = this.delivery(obj);
			out.append(JSON.toJSONString(succ));
			break;
		case "/cancelOrder": // ȡ������
			succ = this.cancelOrder(obj);
			out.append(JSON.toJSONString(succ));
			break;
		case "/requestWaitingForDeliveryList": // �������������Ʒ�б�
			result = this.requestWaitingForDeliveryList(obj);
			out.append(JSON.toJSONString(result));
			break;
		case "/requesDeliveredList": // �����ѷ�������Ʒ�б�
			result = this.requesDeliveredList(obj);
			out.append(JSON.toJSONString(result));
			break;
		case "/requestcompletedList": // ��������ɵ���Ʒ�б�
			result = this.requestCompletedList(obj);
			out.append(JSON.toJSONString(result));
			break;
		case "/requestCanceledList": // ������ȡ������Ʒ�б�
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
		System.out.println("����������ȡ����Ʒ�б�");
		ArrayList<GoodsMessage> goods = FuncBrand.requestList(StateName.Cancelled);
		return goods;
	}

	private ArrayList<GoodsMessage> requestCompletedList(JSONObject obj) {
		System.out.println("���������������Ʒ�б�");
		ArrayList<GoodsMessage> goods = FuncBrand.requestList(StateName.Completed);
		return goods;
	}

	private ArrayList<GoodsMessage> requesDeliveredList(JSONObject obj) {
		System.out.println("���������ѷ�����Ʒ�б�");
		ArrayList<GoodsMessage> goods = FuncBrand.requestList(StateName.Shiped);
		return goods;
	}

	private ArrayList<GoodsMessage> requestWaitingForDeliveryList(JSONObject obj) {
		System.out.println("���������������Ʒ�б�");
		ArrayList<GoodsMessage> goods = FuncBrand.requestList(StateName.AwaitingShipment);
		return goods;
	}

	private boolean soldOut(JSONObject obj) {
		System.out.println("�����¼�");
		String sku = obj.get("sku").toString();
		boolean succ = FuncBrand.SoldOut(sku);
		return succ;
	}

	private boolean putWay(JSONObject obj) {
		System.out.println("�����ϼ�");
		String sku = obj.get("sku").toString();
		boolean succ = FuncBrand.PutWay(sku);
		return succ;
	}

	private boolean PutinStorage(JSONObject obj) {
		System.out.println("�������");
		String sku = obj.get("sku").toString();
		boolean succ = FuncBrand.PutinStorage(sku);
		return succ;
	}

	private boolean cancelOrder(JSONObject obj) {
		System.out.println("����������ȡ����Ʒ�б�");
		String trackNumber = obj.get("trackNumber").toString();
		boolean succ = FuncBrand.cancelOrder(trackNumber);
		return succ;
	}

	private boolean delivery(JSONObject obj) {
		System.out.println("����ȡ������");
		String trackNumber = obj.get("trackNumber").toString();
		boolean succ = FuncBrand.delivery(trackNumber);
		return succ;
	}

	private boolean updateGoods(JSONObject obj) {
		System.out.println("�����޸���Ʒ��Ϣ");
		String oldTitle = obj.getString("oldTitle"), title = obj.getString("title"), category = obj.getString("Category"),
				picUrl = obj.getString("PicUrl");
		boolean succ = FuncBrand.updateGoods(oldTitle, title, category, picUrl);
		return succ;
	}

	private boolean deleteGoods(JSONObject obj) {
		System.out.println("����ɾ����Ʒ");
		String name = obj.get("goodsName").toString();
		boolean succ = FuncBrand.deleteGoods(name);
		System.out.println(succ);
		obj.clear();
		obj.fluentPut("result", succ);
		return succ;
	}

	private Boolean register(JSONObject obj) {
		System.out.println("����ע��");
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
		System.out.println("�������ӹ�˾��Ϣ");
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
		System.out.println("��������");
		Double cash = obj.getDouble("cash");
		String email = obj.get("email").toString(), password = obj.get("password").toString();

		boolean succ = FuncBrand.checkCashFunc(email, cash, password);
		System.out.println(succ);
		obj.clear();
		obj.fluentPut("result", succ);
		return succ;
	}

	private ArrayList<CashMessage> displayCash(JSONObject obj) {
		System.out.println("����������ˮ");
		String email = obj.get("semail").toString();
		System.out.println(obj);
		ArrayList<CashMessage> orders = FuncBrand.displayCashFunc(email);
		obj.clear();
		return orders;
	}

	private ArrayList<GoodsMessage> searchGoods(JSONObject obj) {
		System.out.println("����ͨ����Ʒ���������Ʒ");
		String name = obj.get("goodsName").toString();
		ArrayList<GoodsMessage> goods = FuncBrand.searchGoods(name);
		return goods;
	}

	private boolean addGoods(JSONObject obj) {
		System.out.println("����������Ʒ");
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
