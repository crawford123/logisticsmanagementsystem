package com.paul.logisticsmanagementsystem.util;


import org.apache.commons.lang.StringUtils;

import java.text.*;
import java.util.*;

/**
 * Created by ivan on 17/2/22.
 */
public class DateUtils extends org.apache.commons.lang.time.DateFormatUtils {

	/**
	 * yyyyMMdd
	 */
	public static final String format1 = "yyyyMMdd";

	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String format2 = "yyyy-MM-dd HH:mm:ss";

	public static final String formatWithoutSecond = "yyyy-MM-dd HH:mm";

	public static final String formatDateTimePage = "dd-MM-yyyy HH:mm:ss";
	/**
	 * yyyyMMddHHmmss
	 */
	public static final String format3 = "yyyyMMddHHmmss";

	/**
	 * yyyy-MM-dd HH:mm
	 */
	public static final String format4 = "yyyy-MM-dd HH:mm";

	/**
	 * yyMMdd
	 */
	public static final String yyMMdd = "yyMMdd";

	/**
	 * HHmmss
	 */
	public static final String HHmmss = "HHmmss";

	/**
	 * 日期-中文格式
	 */
	public static final String formatCN = "yyyy年MM月dd日";

	/**
	 * 日期-英文格式
	 */
	public static final String formatEN = "dd MM yyyy";

	/**
	 * 日期-巴文格式
	 */
	public static final String formatUR = "dd-MM-yyyy";

	/**
	 * 日期-中文格式
	 */
	public static final String timeCN = "HH时mm分ss秒";

	/**
	 * 日期-英文格式
	 */
	public static final String timeEN = "HH:mm:ss";

	/**
	 * 日期-巴文格式
	 */
	public static final String timeUR = "HH:mm:ss";

	public static final String formatURTime = "dd-MM-yyyy HH:mm:ss";

	/**
	 * 1毫秒
	 */
	public static final Long MS = 1L;
	/**
	 * 1秒
	 */
	public static final Long SECOND = 1000 * MS;
	/**
	 * 1分钟
	 */
	public static final Long MINUTE = 60 * SECOND;
	/**
	 * 1小时
	 */
	public static final Long HOUR = 60 * MINUTE;
	/**
	 * 1天
	 */
	public static final Long DAY = 24 * HOUR;
	/**
	 * 1年(闰年)
	 */
	public static final Long YEAR_LEAP = 366 * DAY;
	/**
	 * 1年(平年)
	 */
	public static final Long YEAR_AVERAGE = 365 * DAY;
	/**
	 * 1年(默认为平年)
	 */
	public static final Long YEAR = 1 * YEAR_AVERAGE;

	/**
	 * 巴方日期格式dd-MM-yyyy转换成数据库格式
	 * 
	 * @param date
	 * @return
	 */
	public static String formatPageDateToSystem(String date) {

		SimpleDateFormat sdfFormatUR = new SimpleDateFormat(formatUR);
		SimpleDateFormat sdfFormatPage = new SimpleDateFormat(format1);
		String pageDate = null;
		try {
			pageDate = sdfFormatPage.format(sdfFormatUR.parse(date));
		} catch (ParseException e) {
			return null;
		}
		return pageDate;
	}


	/**
	 * 根据语言标志格式化日期
	 * 
	 * @param date
	 *            日期
	 * @param dateFormat
	 *            参数date日期的格式
	 * @param language
	 *            语言类型 0 中文 1 英文 2 巴文 默认英文 3 数据库存储日期类型 4页面日期时间类型
	 * @author 吴健辉
	 * @date 2017-8-7
	 */
	public static String formatDateByLanguage(String date, String dateFormat, String language) {
		if (StringUtils.isBlank(date)) {
			return "";
		}
		// 日期格式
		String format = "";

		// 语音环境
		Locale locale = null;

		switch (language) {
		case "0":// 中文
			format = formatCN;
			break;
		case "1":// 英文
			format = formatEN;
			break;
		case "2":// 巴文
			format = formatUR;
			break;
		case "3":// format1系统格式
			format = format1;
			break;
		case "4":// formatDateTimePage页面时间格式
			format = formatDateTimePage;
			break;
		default:// 默认英文
			format = formatEN;
			locale = Locale.ENGLISH;
			break;
		}
		String formatDate = "";
		try {
			// 格式化日期
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			SimpleDateFormat toFormat;
			if (null != locale) {
				toFormat = new SimpleDateFormat(format, locale);
			} else {
				toFormat = new SimpleDateFormat(format);
			}

			formatDate = toFormat.format(sdf.parse(date));
		} catch (ParseException e) {
			LogCvt.error(e.getMessage(), e);
			formatDate = date;
		}
		return formatDate;
	}


	/**
	 * 根据语言标志格式化时间
	 * 
	 * @param time
	 *            时间
	 * @param timeFormat
	 *            参数time时间的格式
	 * @param language
	 *            语言类型 0 中文 1 英文 2 巴文 默认英文 3 数据库存储时间类型
	 * @author 吴健辉
	 * @date 2017-8-7
	 */
	public static String formatTimeByLanguage(String time, String timeFormat, String language) {

		// 日期格式
		String format = "";

		// 语音环境
		Locale locale = null;

		switch (language) {
		case "0":// 中文
			format = timeCN;
			break;
		case "2":// 巴文
			format = timeUR;
			break;
		case "3":// 数据库存储时间类型
			format = HHmmss;
			break;
		default:// 默认英文
			format = timeEN;
			locale = Locale.ENGLISH;
			break;
		}

		String formatTime = "";
		try {
			// 格式化日期
			SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
			SimpleDateFormat toFormat;
			if (null != locale) {
				toFormat = new SimpleDateFormat(format, locale);
			} else {
				toFormat = new SimpleDateFormat(format);
			}
			formatTime = toFormat.format(sdf.parse(time));
		} catch (ParseException e) {
			LogCvt.error(e.getMessage(), e);
			formatTime = time;
		}

		return formatTime;
	}

	public static String getCurDate(long cur_millis, String strformat) {
		return format(cur_millis, strformat);
	}

	public static String getDate() {
		String d = new SimpleDateFormat(format2).format(Calendar.getInstance().getTime());
		return d;
	}

	// 获取前一天的日期
	public static String getPreDate() {
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.DAY_OF_MONTH, -1);
		String d = new SimpleDateFormat(format1).format(instance.getTime());
		return d;
	}

	// 获取前N天的日期
	public static String getPreDate(int preN) {
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.DAY_OF_MONTH, -preN);
		String d = new SimpleDateFormat(format1).format(instance.getTime());
		return d;
	}

	// 获取目标日期的前N天的日期
	public static String getPreDate(String date, String dateFormat, int preN) {
		DateFormat df = new SimpleDateFormat(dateFormat);
		Calendar instance = Calendar.getInstance();
		try {
			instance.setTime(df.parse(date));
		} catch (ParseException e) {
			return getPreDate(preN);
		}
		instance.add(Calendar.DAY_OF_MONTH, -preN);
		String d = new SimpleDateFormat(format1).format(instance.getTime());
		return d;
	}

	public static String getDateFormat4() {
		String d = new SimpleDateFormat(format4).format(Calendar.getInstance().getTime());
		return d;
	}

	public static String getDateFormatURTime(Date date) {
		String d = new SimpleDateFormat(formatURTime).format(date);
		return d;
	}

	public static String getCurYYYMMDD() {
		return getCurYYYMMDD(null);
	}
	
	public static String getCurYYYMMDD(String pattern) {
		if(StringUtils.isBlank(pattern)){
			pattern = format1;
		}
		String d = new SimpleDateFormat(pattern).format(Calendar.getInstance().getTime());
		return d;
	}

	public static String getCurHHMMSS() {
		String d = new SimpleDateFormat(HHmmss).format(Calendar.getInstance().getTime());
		return d;
	}

	/**
	 * 比较日期是否超过一个月 下午3:54:34
	 */
	public static int compareDate(String date1, String date2, String format) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		long d1 = sdf.parse(date1).getTime();
		long d2 = sdf.parse(date2).getTime();
		if (d1 < d2)
			return -1;
		if (d1 == d2) {
			return 0;
		}
		return 1;
	}

	/**
	 * 日期的月份。和日份。不能是日历上没有的日期 验证输入日期格式 Validate input date format
	 * 
	 * @param date
	 */
	public static String dateIsR(String date) {
		int year = Integer.parseInt(date.substring(0, 4));
		int mon = Integer.parseInt(date.substring(4, 6));
		int day = Integer.parseInt(date.substring(6, 8));
		String M2 = "28";
		if (year % 4 == 0) {
			M2 = "29";
		}
		String[] Mday = new String[] { "31", M2, "31", "30", "31", "30", "31", "31", "30", "31", "30", "31" };
		if (mon > 12 || mon == 0) {
			return "输入时间月份有误";

		}
		int tDay = Integer.parseInt(Mday[(mon - 1)]);
		if (day > tDay || day == 0) {
			return "输入时间日期有误";
		}
		return "";

	}

	/**
	 * 修改日期
	 * 
	 * @param baseDate
	 *            基础日期
	 * @param field
	 *            修改日期字段 -年,月,日
	 * @param amount
	 *            数量
	 * @return
	 */
	public static String dateModify(String baseDate, int field, int amount) {
		StringBuffer sb = new StringBuffer();

		SimpleDateFormat sdf = new SimpleDateFormat(format1); // 将字符串格式化
		Date dt = sdf.parse(baseDate, new ParsePosition(0)); // 由格式化后的字符串产生一个Date对象

		Calendar c = Calendar.getInstance(); // 初始化一个Calendar
		c.setTime(dt); // 设置基准日期
		c.add(field, amount); // 你要加减的日期
		Date dt1 = c.getTime(); // 从Calendar对象获得基准日期增减后的日期
		sb = sdf.format(dt1, sb, new FieldPosition(0)); // 得到结果字符串

		return sb.toString();
	}

	/**
	 * Created by froad - glh 返回 date1 是否大于 date2
	 * 
	 * @param dfs
	 *            例如 "yyyyMMdd HHmmss"
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean dateCompare(String dfs, String date1, String date2) {
		DateFormat df = new SimpleDateFormat(dfs);
		// 获取Calendar实例
		Calendar currentTime = Calendar.getInstance();
		Calendar compareTime = Calendar.getInstance();
		try {
			// 把字符串转成日期类型
			currentTime.setTime(df.parse(date1));
			compareTime.setTime(df.parse(date2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 利用Calendar的方法比较大小
		return currentTime.compareTo(compareTime) > 0;
	}

	/**
	 * @@author Cen
	 * @param dfs
	 *            时间日期格式 如"yyyyMMdd HHmmss"
	 * @param date1
	 * @param date2
	 * @param unit
	 *            计算结果返回的单位，默认为毫秒
	 * @return date1 - date2
	 */
	public static long dateDifferent(String dfs, String date1, String date2, Long unit) {
		DateFormat df = new SimpleDateFormat(dfs);
		// 获取Calendar实例
		Calendar currentTime = Calendar.getInstance();
		Calendar compareTime = Calendar.getInstance();
		try {
			// 把字符串转成日期类型
			currentTime.setTime(df.parse(date1));
			compareTime.setTime(df.parse(date2));

			Long l1 = currentTime.getTime().getTime();
			Long l2 = compareTime.getTime().getTime();

			Double result = l1.doubleValue() - l2.doubleValue();
			if (unit == null || unit.longValue() - 0L == 0) {
				unit = MS;
			}
			result = result / unit.doubleValue();
			return result.longValue();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0L;
	}

	/**
	 * 时间字符串转化为时间类
	 * 
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Date parseDate(String dateStr, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date d = null;
		try {
			d = sdf.parse(dateStr);
		} catch (ParseException e) {
			d = new Date();
		}
		return d;
	}

	// 转为dd-MM-yyyy HH:ss
	public static String formatURTimeStr(String date, String dateFormat, String time, String timeFormat,
			boolean withSecond) {
		StringBuffer sTime = new StringBuffer();
		String dateStr = DateUtils.formatDateByLanguage(date, dateFormat, "2");
		String timeStr = DateUtils.formatTimeByLanguage(time, timeFormat, "2");
		sTime.append(dateStr).append(" ");
		if (withSecond) {
			sTime.append(timeStr);
		} else {
			timeStr = timeStr.substring(0, timeStr.lastIndexOf(":"));
			sTime.append(timeStr);
		}
		return sTime.toString();

	}

	// yyMM -> MM-yyyy
	public static String formatBillMonth(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
		SimpleDateFormat toFormat = new SimpleDateFormat("MM-yyyy");
		String format = null;
		try {
			format = toFormat.format(sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return format;

	}

	// -> dd-MM-yyyy
	public static String formateURDate(String date, String originalFormat) {

		SimpleDateFormat from = new SimpleDateFormat(originalFormat);
		SimpleDateFormat to = new SimpleDateFormat(formatUR);
		String result = "";
		try {
			Date tmpDate = from.parse(date);
			result = to.format(tmpDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return result;

	}
	// 转为 yyyyMMdd
		public static String format1Date(String date, String originalFormat) {

			SimpleDateFormat from = new SimpleDateFormat(originalFormat);
			SimpleDateFormat to = new SimpleDateFormat(format1);
			String result = "";
			try {
				Date tmpDate = from.parse(date);
				result = to.format(tmpDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			return result;

		}

	/**
	 * 通过时间秒毫秒数判断两个时间的间隔
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 * @throws ParseException
	 */
	public static int differentDays(String date1, String date1Format, String date2, String date2Format)
			throws ParseException {

		SimpleDateFormat sdf1 = new SimpleDateFormat(date1Format);
		SimpleDateFormat sdf2 = new SimpleDateFormat(date2Format);

		long t1 = sdf1.parse(date1).getTime();
		long t2 = sdf2.parse(date2).getTime();

		int days = (int) ((t2 - t1) / (1000 * 3600 * 24));
		return days;
	}

	/**
	 * 获取目标日期是周几
	 * 
	 * @author Cen
	 * @param dateStr
	 *            时间字符串
	 * @param pattern
	 *            时间字符串的格式
	 * @return 当前日期是星期几
	 */
	public static String getWeekOfDate(String dateStr, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			Date dt = sdf.parse(dateStr);
			return getWeekOfDate(dt);
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * 获取目标日期是周几
	 * 
	 * @author Cen
	 * @param dt
	 * @return
	 */
	public static String getWeekOfDate(Date dt) {
		String[] weekDays = { "Sun", "Mon", "Tues", "Wed", "Thurs", "Fri", "Sat" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

	/***
	 * 获取2个日期之间的所有日期
	 * @param startDate
	 * @param endDate
	 * @param pattern
	 * @return
	 */
	public static List<String> getEveryDay(String startDate, String endDate, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		List<String> dates = new ArrayList<String>();

		try {
			Date start = sdf.parse(startDate);
			Date end = sdf.parse(endDate);
			Calendar gregorianCalendar = new GregorianCalendar();
			gregorianCalendar.setTime(start);
			dates.add(startDate);
			while (gregorianCalendar.getTime().compareTo(end) < 0) {
				// 加1天
				gregorianCalendar.add(Calendar.DAY_OF_MONTH, 1);
				Date theDate = gregorianCalendar.getTime();
				dates.add(sdf.format(theDate));
			}
			return dates;
		} catch (ParseException e) {
			LogCvt.error(e.getMessage(),e);
			return dates;
		}
	}

	public static void main(String[] args) throws Exception {
		// System.out.println(formateURDate("20170908", "yyyyMMdd"));

		System.out.println(getCurYYYMMDD());

	}

}
