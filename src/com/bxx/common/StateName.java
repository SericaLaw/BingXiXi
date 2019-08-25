package com.bxx.common;

public class StateName {
	public static final String AwaitingPayment = "AwaitingPayment";//待支付
	public static final String AwaitingShipment = "AwaitingShipment";//待运输
	public static final String Shiped = "Shiped";//运输中
	public static final String Completed = "Completed";//已完成
	public static final String Cancelled = "Cancelled";//已取消
	
	public static final String WaitingInStorage = "WaitingInStorage";//待入仓
	public static final String InStorage = "InStorage";//入仓（中）
	public static final String WaitingPutWay = "WaitingPutWay";//待上架
	public static final String PutWay = "PutWay";//上架中
	
	public static final String Withdrew = "Withdrew";//提现
	public static final String Recharge = "Recharge";//充值
	public static final String Input = "Input";//收入
	public static final String Output = "Output";//支出
	
	public static final String WaitingCheck = "WaitingCheck";//待审核
	public static final String Checked_Not_Passed = "Checked:0";//已审核，未通过
	public static final String Checked_Passed = "Checked:1";//已审核，已通过
}
