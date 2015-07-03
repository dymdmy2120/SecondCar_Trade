package tool.mastery.core;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 数据转换工具类
 * 
 * @author Administrator
 * 
 */
public class ConvertUtil {

	/**
	 * 将value更改成clazz对应的类型
	 * 
	 * @param value
	 * @param clazz
	 * @return
	 */
	public static Object convert(String value, Class<?> clazz) {
		Object retVal = null;
		if (clazz == null) {
			return retVal;
		}
		String clazzName = clazz.getSimpleName();
		if (clazzName.equalsIgnoreCase("int")
				|| clazzName.equalsIgnoreCase("integer")) {
			retVal = Integer.parseInt(value);
		} else if (clazzName.equalsIgnoreCase("float")) {
			retVal = Float.parseFloat(value);
		} else if (clazzName.equalsIgnoreCase("double")) {
			retVal = Double.parseDouble(value);
		} else if (clazzName.equalsIgnoreCase("date")) {
			retVal = getDate(value);
		} else {
			//对字符进行转码,如果不是中文则转换成中文
			if(!CharacterUtil.isChinese(value)) {
				retVal = CharacterUtil.transcoding(value);
			}else {
				retVal = value;
			}
		}
		return retVal;
	}

	public static Date getDate(String value) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date d = null;
		try {
			d = sim.parse(value);
		} catch (ParseException e) {
			sim = new SimpleDateFormat("yyyy/MM/dd");
			try {
				d = sim.parse(value);
			} catch (ParseException e1) {
				sim = new SimpleDateFormat("yyyy-MM-dd");
				try {
					d = sim.parse(value);
				} catch (ParseException e2) {
					return d;
				}
			}
		}
		return d;
	}

	public static String getFormalDate(Date date) {
		if(date == null) {
			return null;
		}
		DateFormat sim = new SimpleDateFormat("yyyy-MM-dd  HH:mm ");
		String d = sim.format(date);
		return d;
	}

	public static Date stringToDate(String str) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = null;
		try {
			// Fri Feb 24 00:00:00 CST 2012
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 2012-02-24
		// date = java.sql.Date.valueOf(str);

		return date;
	}
}
