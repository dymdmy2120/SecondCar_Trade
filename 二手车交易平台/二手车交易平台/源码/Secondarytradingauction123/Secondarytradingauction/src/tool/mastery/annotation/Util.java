package tool.mastery.annotation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	/**
	 * 字符替换
	 * 
	 * @param str
	 * @return
	 */
	public String replaceChar(String str) {
		String rstr = str;
		rstr = replaceChar(rstr, "'", "‘", "’");
		return rstr;
	}

	/**
	 * 双字符替换，如括号，引号等 该方法不对外公开，仅供内部调用
	 * 
	 * @param str
	 * @param oldStr
	 * @param newStr1
	 * @param newStr2
	 * @return
	 */
	private String replaceChar(String str, String oldStr, String newStr1,
			String newStr2) {
		String rstr = str;
		if (rstr != null) {
			// 获取符号的下标
			int quoteIndex = rstr.indexOf(oldStr);
			while (quoteIndex > -1) {
				rstr = rstr.replaceFirst(oldStr, newStr1);
				rstr = rstr.replaceFirst(oldStr, newStr2);
				quoteIndex = rstr.indexOf(oldStr);
			}
		}
		return rstr;
	}

	/**
	 * 字符转换成日期类型
	 * 
	 * @param source
	 * @return
	 */
	public Date transferStringToDate(String source) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(source);
		} catch (ParseException e) {
			String stringData = String.valueOf(source);
			try {
				stringData = stringData.substring(0, stringData.lastIndexOf("."));
			} catch (Exception e1) {
				return date;
			}
			this.transferStringToDate(stringData.trim());
			//e.printStackTrace();
		}
		return date;
	}

	/**
	 * 日期转换成字符类型
	 * 
	 * @param date
	 * @return
	 */
	public String transferDateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String convertData = null;
		convertData = sdf.format(date);
		return convertData;
	}

	/**
	 * 获得调用set方法需要传的值 source要转换的值 据要封装到实体类属性中的字段值 fieldType属性的类型（数据类型）
	 * 
	 * @param source
	 * @param fieldType
	 * @return
	 */
	public Object typeConvert(Object source, String fieldType) {
		Object args = new Object();
		String lowerFieldType = fieldType.trim().toLowerCase();

		if (lowerFieldType.indexOf("string") >= 0) {
			args = source;
		} else if (lowerFieldType.indexOf("int") >= 0
				|| lowerFieldType.indexOf("integer") >= 0) {
			args = new Integer(source.toString());
		} else if (lowerFieldType.indexOf("double") >= 0) {
			args = new Double(source.toString());
		} else if (lowerFieldType.indexOf("float") >= 0) {
			args = new Float(source.toString());
		} else if (lowerFieldType.indexOf("long") >= 0) {
			args = new Long(source.toString());
		} else if (lowerFieldType.indexOf("date") >= 0) {
			//String stringData = String.valueOf(source);
			//stringData = stringData.substring(0, stringData.lastIndexOf("."));
			args = this.transferStringToDate(String.valueOf(source));
		}
		return args;
	}

}
