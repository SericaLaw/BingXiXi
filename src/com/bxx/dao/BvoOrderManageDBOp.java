package com.bxx.dao;

import java.util.ArrayList;

import com.bxx.dao.BvoOrderManage;
import com.bxx.dao.JdbcTool;

import java.sql.*;

public class BvoOrderManageDBOp extends DBOp {
	@Override
	public boolean insert(Object obj) {
		BvoOrderManage bom = (BvoOrderManage) obj;
		String sqlstmt = String.format(
				"insert into BvoOrderManage values ('%s', %d, '%s', %f, '%s', '%s', '%s', '%s', '%s', '%s')",
				bom.getOrderNumber(), bom.getQTY(), bom.getSku(), bom.getTotalPrice(), bom.getTrackNumber(),
				bom.getState(), bom.getRcverName(), bom.getRcvAddr(), bom.getRcverTel(), bom.getRcverZip());
		// System.out.println(sqlstmt);
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public boolean delete(Object obj) {
		BvoOrderManage bom = (BvoOrderManage) obj;
		String sqlstmt = String.format("delete from BvoOrderManage where %s", bom.toString());
		// System.out.println(sqlstmt);
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public boolean update(Object oldObj, Object newObj) {
		BvoOrderManage oldEw = (BvoOrderManage) oldObj, newEw = (BvoOrderManage) newObj;
		String sqlstmt = String.format("update BvoOrderManage set %s where %s", newEw.toString().replaceAll("and", ","),
				oldEw.toString());
		// System.out.println(sqlstmt);
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public ArrayList<Object> select(Object obj) {
		BvoOrderManage bom = (BvoOrderManage) obj;
		String sqlstmt;
		if (bom.toString() == "")
			sqlstmt = "select * from BvoOrderManage";
		else
			sqlstmt = String.format("select * from BvoOrderManage where %s", bom.toString());
		// System.out.println(sqlstmt);
		ResultSet rs = JdbcTool.executeSqlByQuery(sqlstmt);
		ArrayList<Object> arr = new ArrayList<Object>();
		try {
			while (rs.next()) {
				BvoOrderManage boma = new BvoOrderManage(rs.getString(1), rs.getInt(2), rs.getString(3),
						rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10));
				arr.add(boma);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
}
