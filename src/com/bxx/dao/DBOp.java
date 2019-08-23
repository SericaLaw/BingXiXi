package com.bxx.dao;

import java.util.ArrayList;

public abstract class DBOp {
	public abstract boolean insert(Object obj);

	public abstract boolean delete(Object obj);

	public abstract boolean update(Object oldObj, Object newObj);

	public abstract ArrayList<Object> select(Object obj);
}
