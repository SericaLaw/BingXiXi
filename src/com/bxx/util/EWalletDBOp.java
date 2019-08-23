package com.bxx.util;

import com.bxx.util.JdbcTool;
import java.util.ArrayList;
import com.bxx.util.EWallet;
import java.sql.*;

public class EWalletDBOp extends DBOp {
	@Override
	public void insert(Object obj) {
		EWallet ew = (EWallet) obj;
		String sqlstmt = String.format("insert into EWallet values ('%s', '%s', '%s', %f)", ew.getEmail(),
				ew.getAccountName(), ew.getPassword(), ew.getBalance());
		// System.out.println(sqlstmt);
		JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public void delete(Object obj) {
		EWallet ew = (EWallet) obj;
		String sqlstmt = String.format("delete from EWallet where %s", ew.toString());
		// System.out.println(sqlstmt);
		JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public void update(Object oldObj, Object newObj) {
		EWallet oldEw = (EWallet) oldObj, newEw = (EWallet) newObj;
		String sqlstmt = String.format("update EWallet set %s where %s", newEw.toString().replaceAll("and", ","),
				oldEw.toString());
		// System.out.println(sqlstmt);
		JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public ArrayList<Object> select(Object obj) {
		EWallet ew = (EWallet) obj;
		String sqlstmt;
		if (ew.toString() == "")
			sqlstmt = "select * from EWallet";
		else
			sqlstmt = String.format("select * from EWallet where %s", ew.toString());
		// System.out.println(sqlstmt);
		ResultSet rs = JdbcTool.executeSqlByQuery(sqlstmt);
		ArrayList<Object> arr = new ArrayList<Object>();
		try {
			while (rs.next()) {
				EWallet ewallet = new EWallet(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
				arr.add(ewallet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
}
