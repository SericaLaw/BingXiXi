package com.bxx.util;

import java.util.ArrayList;

public abstract class DBOp {
	public abstract void insert(Object obj);
	public abstract void delete(Object obj);
	public abstract void update(Object oldObj, Object newObj);
	public abstract ArrayList<Object> select(Object obj);
}
