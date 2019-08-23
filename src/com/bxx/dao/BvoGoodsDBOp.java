package com.bxx.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BvoGoodsDBOp extends DBOp {

	@Override
	public boolean insert(Object obj) {
		BvoGoods bovg = (BvoGoods) obj;
		String sqlstmt = String.format("insert into BvoGoods values ('%s', %d, %b, %b)", bovg.getSku(),
				bovg.getInventory(), bovg.getIfDropShip(), bovg.getIfWishList());
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public boolean delete(Object obj) {
		BvoGoods bovg = (BvoGoods) obj;
		String sqlstmt = String.format("delete from BvoGoods where %s", bovg.toString());
		// System.out.println(sqlstmt);
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public boolean update(Object oldObj, Object newObj) {
		BvoGoods oldEw = (BvoGoods) oldObj, newEw = (BvoGoods) newObj;
		String sqlstmt = String.format("update BvoGoods set %s where %s", newEw.toString().replaceAll("and", ","),
				oldEw.toString());
		return JdbcTool.executeSql(sqlstmt);
	}

	@Override
	public ArrayList<Object> select(Object obj) {
		BvoGoods bovg = (BvoGoods) obj;
		String sqlstmt;
		if (bovg.toString() == "")
			sqlstmt = "select * from BvoGoods";
		else
			sqlstmt = String.format("select * from BvoGoods where %s", bovg.toString());
		// System.out.println(sqlstmt);
		ResultSet rs = JdbcTool.executeSqlByQuery(sqlstmt);
		ArrayList<Object> arr = new ArrayList<Object>();
		try {
			while (rs.next()) {
				BvoGoods bovgoods = new BvoGoods(rs.getString(1), rs.getInt(2), rs.getBoolean(3), rs.getBoolean(4));
				arr.add(bovgoods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

}
