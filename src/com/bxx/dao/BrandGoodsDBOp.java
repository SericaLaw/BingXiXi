package com.bxx.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BrandGoodsDBOp extends DBOp {
	@Override
	public boolean insert(Object obj) {
		BrandGoods bg = (BrandGoods) obj;
		String sqlstmt = String.format(
				"insert into BrandGoods values ('%s', %f, %f, %f, %f, '%s', '%s', '%s', '%s', %f, '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
				bg.getSku(), bg.getWeight(), bg.getLength(), bg.getWidth(), bg.getHeight(), bg.getTitle(), bg.getUpc(),
				bg.getEna(), bg.getModel(), bg.getPrice(), bg.geteBayDescription(), bg.getAmazonDescription(),
				bg.getWarranty(), bg.getState(), bg.getBrandName(), bg.getCategory(), bg.getPicUrl());
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public boolean delete(Object obj) {
		BrandGoods bg = (BrandGoods) obj;
		String sqlstmt = String.format("delete from BrandGoods where %s", bg.toString());
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public boolean update(Object oldObj, Object newObj) {
		BrandGoods oldEw = (BrandGoods) oldObj, newEw = (BrandGoods) newObj;
		String sqlstmt = String.format("update BrandGoods set %s where %s", newEw.toString().replaceAll(" and", ","),
				oldEw.toString());
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public ArrayList<Object> select(Object obj) {
		BrandGoods bg = (BrandGoods) obj;
		String sqlstmt;
		if (bg.toString() == "")
			sqlstmt = "select * from BrandGoods";
		else
			sqlstmt = String.format("select * from BrandGoods where %s", bg.toString());
		// System.out.println(sqlstmt);
		ResultSet rs = JdbcTool.executeSqlByQuery(sqlstmt);
		ArrayList<Object> arr = new ArrayList<Object>();
		try {
			while (rs.next()) {
				BrandGoods brandgoods = new BrandGoods(rs.getString(1), rs.getDouble(2), rs.getDouble(3),
						rs.getDouble(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getDouble(10), rs.getString(11), rs.getString(12), rs.getString(13),
						rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17));
				arr.add(brandgoods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
}
