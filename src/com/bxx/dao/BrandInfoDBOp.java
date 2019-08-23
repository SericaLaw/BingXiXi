package com.bxx.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BrandInfoDBOp extends DBOp {

	@Override
	public boolean insert(Object obj) {
		BrandInfo info = (BrandInfo) obj;
		String sqlstmt = String.format("insert into BrandInfo values ('%s', '%s', '%s', '%s')", info.getBrandName(),
				info.getCOIntro(), info.getType(), info.getCertiAddr());
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public boolean delete(Object obj) {
		BrandInfo info = (BrandInfo) obj;
		String sqlstmt = String.format("delete from BrandInfo where %s", info.toString());
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public boolean update(Object oldObj, Object newObj) {
		BrandInfo oldEw = (BrandInfo) oldObj, newEw = (BrandInfo) newObj;
		String sqlstmt = String.format("update BrandInfo set %s where %s", newEw.toString().replaceAll(" and", ","),
				oldEw.toString());
		// System.out.println(sqlstmt);
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public ArrayList<Object> select(Object obj) {
		BrandInfo info = (BrandInfo) obj;
		String sqlstmt;
		if (info.toString() == "")
			sqlstmt = "select * from BrandInfo";
		else
			sqlstmt = String.format("select * from BrandInfo where %s", info.toString());
		// System.out.println(sqlstmt);
		ResultSet rs = JdbcTool.executeSqlByQuery(sqlstmt);
		ArrayList<Object> arr = new ArrayList<Object>();
		try {
			while (rs.next()) {
				BrandInfo brandinfo = new BrandInfo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				arr.add(brandinfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

}
