package com.yjg.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;


/**
 * 日期操作工具类
 * 
 * @author YJG
 * 
 */
public class DateUtil {
	/**
	 * 默认日期格式：yyyy-MM-dd
	 */
	public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

	/**
	 * 默认时间格式：yyyy-MM-dd HH:mm
	 */
	public static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd HH:mm";

	/**
	 * 默认时间戳格式，到毫秒 yyyy-MM-dd HH:mm:ss SSS
	 */
	public static final String DEFAULT_DATEDETAIL_PATTERN = "yyyy-MM-dd HH:mm:ss SSS";

	public static final String YEAR_APRIL_DAY_BRANCHSECONDS = "yyyyMMddHHmmss";

	public static final String CURRENT_TIME_MILLIS = "yyyyMMddHHmmssSSS";

	/**
	 * 1天折算成毫秒数
	 */
	public static final long MILLIS_A_DAY = 24 * 3600 * 1000;

	private static HashMap<String,Object> parsers = new HashMap<>();

	private static SimpleDateFormat getDateParser(String pattern) {
		Object parser = parsers.get(pattern);
		if (parser == null) {
			parser = new SimpleDateFormat(pattern);
			parsers.put(pattern, parser);
		}
		return (SimpleDateFormat) parser;
	}

	/**
	 * 取得当前系统日期
	 * 
	 * @return
	 */
	public static java.util.Date currentDate() {
		return new java.util.Date();
	}

	/**
	 * 取得系统当前日期，返回默认日期格式的字符串。
	 * 
	 * @param strFormat
	 * @return
	 */
	public static String nowDate(String strFormat) {
		java.util.Date date = new java.util.Date();
		return getDateParser(strFormat).format(date);
	}

	/**
	 * 取得当前系统时间戳
	 * 
	 * @return
	 */
	public static Timestamp currentTimestamp() {
		return new Timestamp(new Date().getTime());
	}

	/**
	 * 取得时间戳
	 * 
	 * @return
	 */
	public static Timestamp getTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	/**
	 * 将日期字符串转换为java.util.Date对象
	 * 
	 * @param dateString
	 * @param pattern
	 *            日期格式
	 * @return
	 * @throws Exception
	 */
	public static java.util.Date toDate(String dateString, String pattern) throws Exception {
		return getDateParser(pattern).parse(dateString);
	}

	/**
	 * 将日期字符串转换为java.util.Date对象，使用默认日期格式
	 * 
	 * @param dateString
	 * @return
	 * @throws Exception
	 */
	public static java.util.Date toDate(String dateString) throws Exception {
		return getDateParser(DEFAULT_DATE_PATTERN).parse(dateString);
	}

	/**
	 * 将时间字符串转换为java.util.Date对象
	 * 
	 * @param dateString
	 * @return
	 * @throws Exception
	 */
	public static java.util.Date toDateTime(String dateString) throws Exception {
		return getDateParser(DEFAULT_DATETIME_PATTERN).parse(dateString);
	}

	/**
	 * 获取年月日时分秒yyyyMMddHHmmss
	 * 
	 * @return
	 */
	public static String toDateTimeStr() {
		SimpleDateFormat sdf = new SimpleDateFormat(YEAR_APRIL_DAY_BRANCHSECONDS);
		return sdf.format(System.currentTimeMillis());
	}

	/**
	 * 根据格式返回string格式日期
	 * 
	 * @param dateFormat
	 * @return
	 */
	public static String toDateTimeStr(String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(System.currentTimeMillis());
	}

	/**
	 * 将java.util.Date对象转换为字符串
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String toDateString(java.util.Date date, String pattern) {
		if (date == null) {
			return null;
		} else {
			return getDateParser(pattern).format(date);
		}
	}

	/**
	 * 将java.util.Date对象转换为字符串，使用默认日期格式
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String toDateString(java.util.Date date) {
		if (date == null) {
			return null;
		} else {
			return getDateParser(DEFAULT_DATE_PATTERN).format(date);
		}
	}

	/**
	 * 将java.util.Date对象转换为时间字符串，使用默认日期格式
	 * 
	 * @param date
	 * @return
	 */
	public static String toDateTimeString(java.util.Date date) {
		if (date == null) {
			return null;
		} else {
			return getDateParser(DEFAULT_DATETIME_PATTERN).format(date);
		}
	}
	
	/**
	 * 根据时间变量返回时间字符串
	 * 
	 * @return 返回时间字符串
	 * @param pattern
	 *            时间字符串样式
	 * @param date
	 *            时间变量
	 * @author huangxin
	 */
	public static String dateToString(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		try {
			SimpleDateFormat sfDate = new SimpleDateFormat(pattern);
			sfDate.setLenient(false);
			return sfDate.format(date);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 日期相减
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date diffDate(java.util.Date date, int day) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) - ((long) day) * MILLIS_A_DAY);
		return c.getTime();
	}

	/**
	 * 返回毫秒
	 * 
	 * @param date
	 *            日期
	 * @return 返回毫秒
	 * @author doumingjun create 2007-04-07
	 */
	public static long getMillis(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * 日期相加
	 * 
	 * @param date
	 *            日期
	 * @param day
	 *            天数
	 * @return 返回相加后的日期
	 * @author doumingjun create 2007-04-07
	 */
	public static java.util.Date addDate(java.util.Date date, int day) {
		java.util.Calendar c = java.util.Calendar.getInstance();

		c.setTimeInMillis(getMillis(date) + ((long) day) * MILLIS_A_DAY);
		return c.getTime();
	}

	public static java.util.Date addDays(java.util.Date date, float day) {
		java.util.Calendar c = java.util.Calendar.getInstance();

		c.setTimeInMillis(getMillis(date) + ((long) (day * MILLIS_A_DAY)));
		return c.getTime();
	}

	/**
	 * 根据季度获得相应的月份
	 * 
	 * @param quarters
	 *            季度
	 * 
	 * @return 返回相应的月份
	 */
	public static String getMonth(String quarters) {
		String month;
		int m = Integer.parseInt(quarters);
		m = m * 3 - 2;
		if (m > 0 && m < 10) {
			month = "0" + String.valueOf(m);
		} else {
			month = String.valueOf(m);
		}
		return month;
	}

	/**
	 * 根据月份获得相应的季度
	 * 
	 * @param month
	 *            月份
	 * 
	 * @return 返回相应的季度
	 */
	public static String getQuarters(String month) {
		String quarters;
		int m = Integer.parseInt(month);
		m = (m + 2) / 3;
		quarters = String.valueOf(m);
		return quarters;
	}

	/**
	 * 根据月份获得相应的季度
	 * 
	 * @param month
	 *            月份
	 * 
	 * @return 返回相应的季度
	 */
	public static int getQuarters(int month) {
		return (month + 2) / 3;
	}

	/**
	 * 取上月最后一天
	 * 
	 * @return
	 */
	public static Date getLastDayOfLastMonth() {
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.DATE, 1); // 本月第一天
		calendar.add(Calendar.DATE, -1);// 上月最后一天
		return calendar.getTime();
	}

	/**
	 * 取上月第一天
	 * 
	 * @return
	 */
	public static Date getFristDayOfLastMonth() {
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.DATE, 1); // 本月第一天
		calendar.add(Calendar.MONTH, -1);// 上月第一天
		return calendar.getTime();
	}

	/**
	 * 取今天0时0分0秒
	 * 
	 * @return
	 */
	public static Date getTodayFristTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 取今天0时0分0秒
	 * 
	 * @return
	 */
	public static String getTodayFristTimeStr() {
		return DateUtil.toDateString(getTodayFristTime(), DateUtil.DEFAULT_DATETIME_PATTERN);
	}

	/**
	 * 取当前时间之前N天的时间
	 * 
	 * @return
	 */
	public static String getCurrentBefore(int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - day);
		return DateUtil.toDateString(calendar.getTime(), DateUtil.DEFAULT_DATETIME_PATTERN);
	}

	/**
	 * 取当前时间之前N小时的时间
	 * 
	 * @return
	 */
	public static String getCurrentBeforeHour(int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - hour);
		return DateUtil.toDateString(calendar.getTime(), DateUtil.DEFAULT_DATETIME_PATTERN);
	}

	/**
	 * 取当前时间之前N分钟的时间
	 * 
	 * @return
	 */
	public static String getCurrentBeforeMinute(int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) - minute);
		return DateUtil.toDateString(calendar.getTime(), DateUtil.DEFAULT_DATETIME_PATTERN);
	}

	/**
	 * @param date1
	 *            需要比较的时间 不能为空(null),需要正确的日期格式 "yyyy-MM-dd"
	 * @param date2
	 *            被比较的时间 不能为空(null)
	 * @return
	 */
	public static int compareDate(Date date1, Date date2) {
		int n = 0;
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		try {
			c1.setTime(date1);
			c2.setTime(date2);
		} catch (Exception e) {

		}
		while (!c1.after(c2)) { // 循环对比，直到相等，n 就是所要的结果
			n++;
			c1.add(Calendar.DATE, 1);
		}
		n = n - 1;
		return n;
	}
	public  static String strDate(){
		return nowDate(DEFAULT_DATETIME_PATTERN);
	}
}