package tool.mastery.core;

import java.lang.reflect.Field;

public class BeanUtil {
	
	public static boolean isNumber(Class<?> entityClass , String name) {
		String className  = null;
		// 取得这个参数在Bean中的数据类开
		try {
			Field field = entityClass.getDeclaredField(name);
			Class<?> cls  = field.getType();
			//System.out.println(cls);
			className = cls.getSimpleName().toLowerCase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return className.indexOf("int") == 0
				|| className.indexOf("integer") == 0
				|| className.indexOf("float") == 0
				|| className.indexOf("double") == 0
				|| className.indexOf("nember") == 0
				|| className.indexOf("numeric") == 0;
	}
}
