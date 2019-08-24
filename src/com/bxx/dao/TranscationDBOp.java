package com.bxx.dao;

import java.util.ArrayList;

import com.bxx.dao.JdbcTool;
import com.bxx.dao.Transcation;

import java.sql.*;

public class TranscationDBOp extends DBOp {
	@Override
	public boolean insert(Object obj) {
		Transcation tran = (Transcation) obj;
		String sqlstmt = String.format("insert into Transcation values ('%s', '%s', '%s', '%s', '%s', %f)",
				tran.getTranscationNumber(), tran.getType(), tran.getState(), tran.getTime(), tran.getEWalletEMail(),
				tran.getBalance());
//		System.out.println(sqlstmt);
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public boolean delete(Object obj) {
		Transcation tran = (Transcation) obj;
		String sqlstmt = String.format("delete from Transcation where %s", tran.toString());
		// System.out.println(sqlstmt);
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public boolean update(Object oldObj, Object newObj) {
		Transcation oldEw = (Transcation) oldObj, newEw = (Transcation) newObj;
		String sqlstmt = String.format("update Transcation set %s where %s", newEw.toString().replaceAll("and", ","),
				oldEw.toString());
		// System.out.println(sqlstmt);
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public ArrayList<Object> select(Object obj) {
		Transcation tran = (Transcation) obj;
		String sqlstmt;
		if (tran.toString() == "")
			sqlstmt = "select * from Transcation";
		else
			sqlstmt = String.format("select * from Transcation where %s", tran.toString());
		// System.out.println(sqlstmt);
		ResultSet rs = JdbcTool.executeSqlByQuery(sqlstmt);
		ArrayList<Object> arr = new ArrayList<Object>();
		try {
			while (rs.next()) {
				Transcation trans = new Transcation(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4),
						rs.getString(5), rs.getDouble(6));
				arr.add(trans);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
}
