package cn.zlpc.util;

import java.util.Calendar;

public class GetMoth {
	public static String getMoth(){
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		String strT = year+"Y"+month;
		return strT;
	}
}
