package com.bxx.util;

import com.bxx.util.JdbcTool;
import java.util.ArrayList;
import com.bxx.util.BvoInfo;
import java.sql.*;

public class BvoInfoDBOp extends DBOp {
	@Override
	public boolean insert(Object obj) {
		BvoInfo bi = (BvoInfo) obj;
		String sqlstmt = String.format("insert into BvoInfo values ('%s', '%s', '%s', '%s')", bi.getSellerID(),
				bi.getTel(), bi.getEMail(), bi.getSellerName());
		// System.out.println(sqlstmt);
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public boolean delete(Object obj) {
		BvoInfo bi = (BvoInfo) obj;
		String sqlstmt = String.format("delete from BvoInfo where %s", bi.toString());
		// System.out.println(sqlstmt);
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public boolean update(Object oldObj, Object newObj) {
		BvoInfo oldEw = (BvoInfo) oldObj, newEw = (BvoInfo) newObj;
		String sqlstmt = String.format("update BvoInfo set %s where %s", newEw.toString().replaceAll("and", ","),
				oldEw.toString());
		// System.out.println(sqlstmt);
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public ArrayList<Object> select(Object obj) {
		BvoInfo bi = (BvoInfo) obj;
		String sqlstmt;
		if (bi.toString() == "")
			sqlstmt = "select * from BvoInfo";
		else
			sqlstmt = String.format("select * from BvoInfo where %s", bi.toString());
		// System.out.println(sqlstmt);
		ResultSet rs = JdbcTool.executeSqlByQuery(sqlstmt);
		ArrayList<Object> arr = new ArrayList<Object>();
		try {
			while (rs.next()) {
				BvoInfo binfo = new BvoInfo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				arr.add(binfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
}
