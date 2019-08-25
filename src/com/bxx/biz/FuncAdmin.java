package com.bxx.biz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.bxx.common.Message;
import com.bxx.common.StateName;
import com.bxx.dao.DBOp;
import com.bxx.dao.Transcation;
import com.bxx.dao.TranscationDBOp;

public class FuncAdmin {
	public static void main(String[] args) throws ParseException {
//		for(Message mess:depositDisplay()) {
//			System.out.println(mess.toString());
//		}
		String str = "2019/8/24 10:53:03";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = sdf.parse(str);
		
		boolean succ = check("mail", date, true);
		System.out.println("=== "+succ+" ===");
		System.out.println("succ");
	}

	public static ArrayList<Message> depositDisplay() //请求提现数据的账户名、业务类型、金额、申请时间、状态
	{
		ArrayList<Object> orders = new ArrayList<Object>();
		ArrayList<Message> result = new ArrayList<Message>();

		DBOp op = new TranscationDBOp();
		Transcation tran = new Transcation(null, null, StateName.WaitingCheck, null, null, null);
		orders = op.select(tran);

		for (Object obj : orders) {
			Message mess = new Message();
			Transcation trans = (Transcation)obj;
			
			mess.setName(trans.getEWalletEMail());
			mess.setType(trans.getType());
			mess.setPrice(trans.getBalance());
			mess.setTime(trans.getTime_Date());
			mess.setState(trans.getState());

			result.add(mess);
		}

		return result;
	}

	public static boolean check(String username, Date time, boolean result) //将对应用户、对应时间的流水状态改成已审核
	{
		DBOp op = new TranscationDBOp();
		Transcation tran = new Transcation(null, null, null, time, username, null);
		String state;
		if(result)
			state = StateName.Checked_Passed;
		else
			state = StateName.Checked_Not_Passed;
		Transcation newTran = new Transcation(null, null, state, null, null, null);
		return op.update(tran, newTran);
	}

}
