package com.paul.logisticsmanagementsystem.util;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 生成流水管理
 * 
 * @author 冯志
 * @date 2018-4-14
 */

public class GenerateWaterManager {


	@Autowired
	private JedisService jedisService; // 缓存

	static StringBuffer temString = new StringBuffer();

	private final static String MAX_SEQ = "9999";

	/**
	 * 生成流水号 读数据库存储过程
	 * 
	 * @author 冯志
	 * @date 2018-4-13
	 */

	/**
	 * 生成流水号 读Readis
	 *
	 * @author 冯志
	 * @date 2018-4-13
	 */
	public String generateWater(String tableName) {
		String transDate = DateUtils.getCurYYYMMDD();
		String key = RedisKeyEnum.format(RedisKeyEnum.SEQUENCE_NO, transDate, tableName);
		int timeout = 60 * 60 * 24 * 7;
		// 读取缓存
		Long seqNo = jedisService.getSequenceNumber(key, timeout);
		LogCvt.info("sequence number : " + seqNo);

		// 参数配置
		String[] waterArgs = GenerateWaterKeyEnums.getWaterArgsByTableName(tableName);

		// waterArgs
		// [0] = 流水代码
		// [1] = 流水长度
		// 判断流水长度 6位的日期+2位的流水代码
		String seqNoStr = seqNo + "";
		int seqNoLen = transDate.length() + waterArgs[0].length();
		int configLength = Integer.parseInt(waterArgs[1]);// 流水长度

		// 组装流水号
		StringBuffer transNo = new StringBuffer().append(transDate).append(waterArgs[0])// 流水代码
				.append(StringUtils.leftPad(seqNoStr, (configLength - seqNoLen), "0"));

		LogCvt.info("Result sequence no :" + transNo.toString());
		return transNo.toString();
	}

	public String getOrderWater() {
		LogCvt.info("执行step -> getOrderWater[生成订单流水号][]");
		return generateWater(GenerateWaterKeyEnums.ORDERS.getTableName());
	}


}
