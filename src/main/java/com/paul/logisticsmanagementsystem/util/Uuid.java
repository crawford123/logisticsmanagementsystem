package com.paul.logisticsmanagementsystem.util;

import org.apache.commons.lang.math.RandomUtils;

import java.io.RandomAccessFile;
import java.util.UUID;

public class Uuid {
	 //获取其极UUID
	 public static String getUuid(){
	    UUID uuid = UUID.randomUUID();
	     String a = uuid.toString();
	     a = a.toUpperCase();
	     a = a.replaceAll("-", "");
	     return a;
	 }
	public static String getOrderIdByUUId() {
		int machineId = 1;//最大支持1-9个集群机器部署
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if(hashCodeV < 0) {//有可能是负数
			hashCodeV = - hashCodeV;
		}
		// 0 代表前面补充0
		// 4 代表长度为4
		// d 代表参数为正数型
		return machineId + String.format("%015d", hashCodeV);
	}


	public static String generateSequenceID() throws  Exception {
		 String dateTime=DateUtils.getCurYYYMMDD();
		 String  uuid=UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
		 String ranEight=String.format("%08d",new RandomUtils().nextInt(99999999));
		return  dateTime+uuid+ranEight;
	}

	public static String getOrderNo(){
		String dateTime=DateUtils.getCurYYYMMDD();
		StringBuffer orderNo = new StringBuffer().append(dateTime).append(getOrderIdByUUId());
		return  orderNo.toString();
	}

	 public static void main(String[] args) throws  Exception{
	 //System.out.println(getUuid());
	 // System.out.println(getOrderIdByUUId());
	 //System.out.println("现在的时间："+DateUtils.getCurYYYMMDD());
		 //System.out.println("现在的时间："+generateSequenceID());
		 System.out.println(getOrderNo());
	 }


}
