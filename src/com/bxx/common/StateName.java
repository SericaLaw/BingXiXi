package com.bxx.common;

public class StateName {
	public static final String AwaitingPayment = "AwaitingPayment";//��֧��
	public static final String AwaitingShipment = "AwaitingShipment";//������
	public static final String Shiped = "Shiped";//������
	public static final String Completed = "Completed";//�����
	public static final String Cancelled = "Cancelled";//��ȡ��
	
	public static final String WaitingInStorage = "WaitingInStorage";//�����
	public static final String InStorage = "InStorage";//��֣��У�
	public static final String WaitingPutWay = "WaitingPutWay";//���ϼ�
	public static final String PutWay = "PutWay";//�ϼ���
	
	public static final String Withdrew = "Withdrew";//����
	public static final String Recharge = "Recharge";//��ֵ
	public static final String Input = "Input";//����
	public static final String Output = "Output";//֧��
	
	public static final String WaitingCheck = "WaitingCheck";//�����
	public static final String Checked_Not_Passed = "Checked:0";//����ˣ�δͨ��
	public static final String Checked_Passed = "Checked:1";//����ˣ���ͨ��
}
