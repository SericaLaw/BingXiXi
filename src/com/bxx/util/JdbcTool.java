package com.bxx.util;

import java.sql.*;

public class JdbcTool {
	static final String databasePath = "jdbc:Access:///C:/Users/Surface/Documents/GitHub/BingXiXi/db.accdb";
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

	/**
	 * 执行sql 增删改 不包括查询
	 */
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

	/**
	 * 执行sql 查询 返回结果为 ResultSet 结果集
	 */
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
