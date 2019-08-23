package com.bxx.util;

import com.bxx.util.JdbcTool;
import java.util.ArrayList;

import com.bxx.util.StoreInfo;
import java.sql.*;

public class StoreInfoDBOp extends DBOp {
	@Override
	public boolean insert(Object obj) {
		StoreInfo si = (StoreInfo) obj;
		String sqlstmt = String.format("insert into StoreInfo values ('%s', '%s', '%s', '%s', '%s')", si.getStoreName(),
				si.getStoreUrl(), si.getSellerID(), si.getMarketID(), si.getMWS());
		// System.out.println(sqlstmt);
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public boolean delete(Object obj) {
		StoreInfo si = (StoreInfo) obj;
		String sqlstmt = String.format("delete from StoreInfo where %s", si.toString());
		// System.out.println(sqlstmt);
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public boolean update(Object oldObj, Object newObj) {
		StoreInfo oldEw = (StoreInfo) oldObj, newEw = (StoreInfo) newObj;
		String sqlstmt = String.format("update StoreInfo set %s where %s", newEw.toString().replaceAll("and", ","),
				oldEw.toString());
		// System.out.println(sqlstmt);
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public ArrayList<Object> select(Object obj) {
		StoreInfo si = (StoreInfo) obj;
		String sqlstmt;
		if (si.toString() == "")
			sqlstmt = "select * from StoreInfo";
		else
			sqlstmt = String.format("select * from StoreInfo where %s", si.toString());
		// System.out.println(sqlstmt);
		ResultSet rs = JdbcTool.executeSqlByQuery(sqlstmt);
		ArrayList<Object> arr = new ArrayList<Object>();
		try {
			while (rs.next()) {
				StoreInfo sinfo = new StoreInfo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				arr.add(sinfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
}
