package com.paul.logisticsmanagementsystem.util;

/**
 * 无网点系统-生成流水的key(表名)
 * 
 * @author 吴健辉
 * @date 2017-6-6
 */
public enum GenerateWaterKeyEnums {

	/*** ===========================流水号生成规则===================================== */

	// waterArgs
	// [0] = 流水代码
	// [1] = 流水长度
	// 20171108 01 0000000001
	// yyyymmdd + 流水代码 + 流水号 = 流水长度


	// 渠道交易流水表的流水号
	ORDERS("orders", new String[] { "02", "20" }),;


	/*** ===========================序列号生成规则===================================== */
	// waterArgs
	// [0] = 序列号最大长度
	// 例如
	// 当前序列号：99
	// 最大长度：3
	// 获取的序列号为：1
	// 最大长度是指 超过这个长度，序列值从1开始从新累计

	private String tableName;
	private String[] waterArgs;

	GenerateWaterKeyEnums(String tableName, String[] waterArgs) {
		this.tableName = tableName;
		this.waterArgs = waterArgs;
	}

	public String getTableName() {
		return tableName;
	}

	// 根据code获取msg
	public String[] getWaterArgs() {
		return waterArgs;
	}

	public static String[] getWaterArgsByTableName(String code) {
		for (GenerateWaterKeyEnums c : values()) {
			if (c.getTableName().equals(code)) {
				return c.getWaterArgs();
			}
		}
		return new String[] { "0", "20" };
	}
}
