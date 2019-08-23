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
	 * ִ��sql ��ɾ�� ��������ѯ
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
	 * ִ��sql ��ѯ ���ؽ��Ϊ ResultSet �����
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
