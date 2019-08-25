package com.bxx.dao;

import java.sql.*;

public class JdbcTool {
	static final String databasePath = "jdbc:Access:///F:\\BingXiXi\\BingXiXi\\db.accdb";
	public static Connection conn;

	static {
		try {
			Class.forName("com.hxtt.sql.access.AccessDriver").newInstance();
			conn = DriverManager.getConnection(databasePath);
		} catch (Exception e) {
			System.out.println("exception when connecting to database");
			e.printStackTrace();
		}
	}


	public static boolean executeSql(String sql) {
		try {
			Statement st = (Statement) conn.createStatement();
			st.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public static ResultSet executeSqlByQuery(String querysql) {
		ResultSet rs = null;
		try {
			Statement st = (Statement) conn.createStatement();
			rs = (ResultSet) st.executeQuery(querysql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}