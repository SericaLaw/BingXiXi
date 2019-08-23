package com.bxx.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BrandOrderDBOp extends DBOp {

	@Override
	public boolean insert(Object obj) {
		BrandOrder bo = (BrandOrder) obj;
		String sqlstmt = String.format("insert into BrandOrder values ('%s', %d, '%s', '%s', '%s', '%s', '%s')",
				bo.getOrderNumber(), bo.getQTY(), bo.getSku(), bo.getTime(), bo.getTrackNumber(), bo.getState(),
				bo.getBvoStore());
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public boolean delete(Object obj) {
		BrandOrder bo = (BrandOrder) obj;
		String sqlstmt = String.format("delete from BrandOrder where %s", bo.toString());
		System.out.println(sqlstmt);
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public boolean update(Object oldObj, Object newObj) {
		BrandOrder oldEw = (BrandOrder) oldObj, newEw = (BrandOrder) newObj;
		String sqlstmt = String.format("update BrandOrder set %s where %s", newEw.toString().replaceAll("and", ","),
				oldEw.toString());
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public ArrayList<Object> select(Object obj) {
		BrandOrder bo = (BrandOrder) obj;
		String sqlstmt;
		if (bo.toString() == "")
			sqlstmt = "select * from BrandOrder";
		else
			sqlstmt = String.format("select * from BrandOrder where %s", bo.toString());
		// System.out.println(sqlstmt);
		ResultSet rs = JdbcTool.executeSqlByQuery(sqlstmt);
		ArrayList<Object> arr = new ArrayList<Object>();
		try {
			while (rs.next()) {
				BrandOrder brandorder = new BrandOrder(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDate(4),
						rs.getString(5), rs.getString(6), rs.getString(7));
				arr.add(brandorder);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

}
