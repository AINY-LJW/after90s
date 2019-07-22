/**============================================================
 * 包： com.after90s.common.constant
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月19日       LJW        
 * ============================================================*/

package com.after90s.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * <p>TODO 数字格式化工具类</p>
 *
 * @author LJW
 * @version 2019年7月19日
 */

public class NumberFormatUtil {


	private static final int DEF_DIV_SCALE = 10;
	/**
	 * LJW
	 * ThreadLocal用于保存某个线程共享变量：对于同一个static ThreadLocal，不同线程只能从中get，set，remove自己的变量，而不会影响其他线程的变量。
	 */
	private static ThreadLocal<DecimalFormat> df = new ThreadLocal<DecimalFormat>(){
		protected DecimalFormat initialValue() {
			return new DecimalFormat();
		};
	};
	/**
	 * 保留两位小数  转字符串
	 * 
	 * @param dou
	 * @return String
	 */
	public static String formatNumbertwo(Double dou){
		if(dou==null){
			return "";
		}
		DecimalFormat df = new DecimalFormat("#.00");
		
		return df.format(dou);
		
	}
	/**
	 * 数据格式化
	 * 
	 * @param value
	 * @param decimal     小数位数
	 * @param thoundsMark 是否千分位
	 * @param precision   精度
	 * @return String
	 */
	public static String formatNumberString(double value, int decimal,
			boolean thoundsMark,int precision) {
		df.get().setMaximumFractionDigits(precision);
		df.get().setGroupingUsed(false);
		if (thoundsMark) {
			df.get().setGroupingSize(3);
			df.get().setGroupingUsed(true);
		}
		if (decimal >= 0) {
			df.get().setMaximumFractionDigits(decimal);
			df.get().setMinimumFractionDigits(decimal);
		}
		return df.get().format(value);
	}


		/**
		 * 添加精确的加法运算
		 * @param v1
		 * @param v2
		 * @return double
		 */
		public static double add(double v1, double v2) {
			BigDecimal b1 = new BigDecimal(Double.toString(v1));
			BigDecimal b2 = new BigDecimal(Double.toString(v2));
			return b1.add(b2).doubleValue();
		}

		/**
		 * 提供精确的减法运算
		 * @param v1 被减数
		 * @param v2 减数
		 * @return 两个参数的差
		 */
		public static double sub(double v1, double v2) {
			BigDecimal b1 = new BigDecimal(Double.toString(v1));
			BigDecimal b2 = new BigDecimal(Double.toString(v2));
			return b1.subtract(b2).doubleValue();
		}

		/**
		 * 提供精确的乘法运算。
		 * @param v1 被乘数
		 * @param v2 乘数
		 * @return 两个参数的积
		 */
		public static double mul(double v1, double v2) {
			BigDecimal b1 = new BigDecimal(Double.toString(v1));
			BigDecimal b2 = new BigDecimal(Double.toString(v2));
			return b1.multiply(b2).doubleValue();
		}

		/**
		 * 
		 * 提供（相对）精确的除法运算,当发生除不尽的情况时,精确到
		 * 小数点以后10位,以后的数字四舍五入。
		 * @param v1 被除数
		 * @param v2 除数
		 * @return 两个参数的商
		 */
		public static double div(double v1, double v2) {
			return div(v1, v2, DEF_DIV_SCALE);
		}

		/**
		 * 提供（相对）精确的除法运算。当发生除不尽的情况时,由scale参数指
		 * 定精度,以后的数字四舍五入。
		 * @param v1 被除数
		 * @param v2 除数
		 * @param scale 表示表示需要精确到小数点以后几位。
		 * @return 两个参数的商
		 */
		public static double div(double v1, double v2, int scale) {
			if (scale == 0) {
				throw new IllegalArgumentException(
				"The scale must be a positive integer or zero");
			}
			BigDecimal b1 = new BigDecimal(Double.toString(v1));
			BigDecimal b2 = new BigDecimal(Double.toString(v2));
			return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
		}

		/**
		 * 提供精确的小数位四舍五入处理。
		 * @param v 需要四舍五入的数字
		 * @param scale 小数点后保留几位
		 * @return 四舍五入后的结果
		 */
		public static double round(double v, int scale) {
			if (scale == 0) {
				throw new IllegalArgumentException(
				"The scale must be a positive integer or zero");
			}
			BigDecimal b = new BigDecimal(Double.toString(v));
			BigDecimal one = new BigDecimal("1");
			return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		
		/**
		 * 
		 * 格式化浮点型数值，可设置保留的小数位.<br>
		 * @author ranfeng
		 * @param v
		 * @param scale
		 * @return  String
		 */
		public static String formatDouble(double v,int scale){
			if (scale < 0) {
				throw new IllegalArgumentException(
				"The scale must be a positive integer or zero");
			}
			String formatStr = v < 1 ? "0." : "#.";
			for(int i = 0 ; i < scale ; i++){
				formatStr = formatStr.concat("0");
			}
			DecimalFormat df = new DecimalFormat(formatStr);
			return df.format(v);
		}
		/**
		 * 
		 * 格式化金额，带千分符并保留两位小数.<br>
		 * @author ranfeng
		 * @return  String
		 */
		public static String formatMoney(double money){
			DecimalFormat df =new DecimalFormat("#,##0.00");
			return df.format(money);
		}



}
