package com.bxx.util;

import com.bxx.util.JdbcTool;
import com.bxx.util.EWallet;

public class SignupDBOp extends DBOp {
	@Override
	public void insert(Object obj) {
		EWallet ew = (EWallet) obj;
		String sqlstmt = String.format("insert into EWallet values ('%s', '%s', '%s', %f, '%s')", ew.getEmail(),
				ew.getAccountName(), ew.getPassword(), ew.getBalance(), ew.getTranscationNumber());
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
	public Object select(Object obj) {
		EWallet ew = (EWallet) obj;
		String sqlstmt = "select ... from EWallet ...";

		JdbcTool.executeSqlByQuery(sqlstmt);

		return null;
	}
}
