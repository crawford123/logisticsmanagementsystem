package com.paul.logisticsmanagementsystem.util;

import java.text.MessageFormat;

public enum RedisKeyEnum {
	
	/**
	 * 保存在redis的交易流水总记录数
	 */
	TRANS_RECORDS_CONUT("bbcore:trans:records:count:account_{0}"),
	
	/**
	 * 保存在redis的交易流水记录key
	 */
	TRANS_RECORDS("bbcore:trans:records:mobile_{0}"),
	
	/**
	 * 保存在redis的交易流水记录的当前记录数位置key
	 */
	TRANS_RECORDS_INDEX("bbcore:trans:records:index:tran_no_{0}"),
	
	/**
	 * OTP业务系统的Key
	 * {0}为渠道 Channel id
	 */
	OTP_PREFIX("{0}:mobile:otp:{1}"),
	
	/**
	 * OTP支付的Key
	 * {0} 手机号
	 * {1}otp value
	 */
	OTP_PAY_PREFIX("otp:payment:{0}：{1}"),
	
	/**
	 * LOCK业务系统的Key
	 * {0}为渠道 Channel id
	 */
	CHANNEL_ACCOUNT_LOCK_KEY("{0}:lock_account_{1}"),
	
	
	//APP端
	/**
	 * app accessToken key
	 */
	APP_ACCESSTOKEN_PREFIX("app:accesstoken:mobileacct:{0}"),
	/**
	 * app refreshToken key
	 */
	APP_REFRESHTOKEN_JTI_PREFIX("app:refreshtokenjti:mobileacct:{0}"),
	
	/**
	 * 保存在redis的交易流水记录key
	 */
	APP_TRANS_RECORDS("app:trans:records:account_{0}"),
	
	/**
	 * 保存在redis的交易流水记录key
	 */
	WEB_CUST_TRANS_RECORDS("web:customer:trans:records:account_{0}"),
	
	
	//Batch processing(批量处理)
	BATCH_STATUS_CHECK("batch:status_check:file"),	
	/**
	 *保存代理端交易tokenId的key
	 */
	AGENT_TRANS_TOKENID("agent:trans:tokenid:agentUserId:{0}"),
	
	/**
	 * 保存所有的市
	 * */
	F_LOCATION_ALL_CITY_LIST("branchless:location:all:city:list"),
	//{0}channel
	//{1}mobile account
	MOBILE_ACCT_QR_CODE_KEY("branchless:{0}:{1}:qrcode"),
	
	/**
	 * OTP PAYMENT结果
	 */
	//{0}mobile acct no
	OTP_PAYMENT_RESULT("branchless:otp:payment:{0}"),
	
	/**
	 * 流水号序号
	 */
	SEQUENCE_NO("sequence:{0}:{1}"),
	
	/**
	 * 电子账户收款信息读取标记0:代理点编号,1:代理点下所有人的手机号（有5个人，就5个key）,2：交易流水号
	 * value： 0-未读,1-已读
	 * 写入场景：交易成功，目前只用于代理电子账户二维码收款成功
	 * 删除场景: 1,代理点下某个手机号登录，点击查看某个二维码收款详情，删除对应key的redis记录
	 * 		   2,代理点下某个手机号登录后，清空改手机号对应的所有redis记录
	 */
	ACCOUNT_RECEIVE_READ_FLAG("branchless:readFlag:{0}:{1}:{2}"),
	;	
	
	private String code;
	
	RedisKeyEnum(String code){
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}

	/**
	 * 格式化Redis Key
	 * @author 吴健辉
	 * @date 2017-7-21
	 */
	public static String format(RedisKeyEnum e,Object...objects){
		String redis = MessageFormat.format(e.getCode(),objects);
		LogCvt.debug("redis key:"+redis);
		return redis;
	}
}
