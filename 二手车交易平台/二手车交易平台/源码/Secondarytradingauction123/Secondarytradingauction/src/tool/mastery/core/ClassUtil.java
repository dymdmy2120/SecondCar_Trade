package tool.mastery.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import tool.mastery.exception.InnerException;

/**
 * 工具类，通过类名加载字节码或者对象
 * 
 * @author Administrator
 * 
 */
public class ClassUtil {
	public static String BASE_PACKAGE_NAME ;
	private static String PO_PACKAGE_NAME;
	private static String VO_PACKAGE_NAME;

	static {
		InputStream is = ClassUtil.class.getClassLoader().getResourceAsStream(
				"class.properties");

		Properties prop = new Properties();
		try {
			prop.load(is);
			BASE_PACKAGE_NAME = prop.getProperty("BasePackageName") ;
			PO_PACKAGE_NAME = BASE_PACKAGE_NAME + ".po.";
			VO_PACKAGE_NAME = BASE_PACKAGE_NAME + ".vo.";
		} catch (IOException e) {
			throw new InnerException(
					"配置参数错误！请检查您的参数是否配置正确！请在class.properties中配置BasePackageName属性参数！");
		}
	}

	/**
	 * 通过类名加载对应的字节码
	 * 
	 * @param className
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static Class<?> getClassByName(String className)
			throws ClassNotFoundException {
		Class<?> clazz = null;
		try {
			clazz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			throw e;
		}
		return clazz;
	}

	/**
	 * 通过类名加载对应po的字节码
	 * 
	 * @param className
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static Class<?> getPoClassByName(String className)
			throws ClassNotFoundException {
		return getClassByName(PO_PACKAGE_NAME + className);
	}

	/**
	 * 通过类名加载对应vo的字节码
	 * 
	 * @param className
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static Class<?> getVoClassByName(String className)
			throws ClassNotFoundException {
		return getClassByName(VO_PACKAGE_NAME + className);
	}

	/**
	 * 通过类名加载对应的对象
	 * 
	 * @param className
	 * @return
	 * @throws Exception
	 */
	public static Object getObjectByName(String className) throws Exception {
		Class<?> clazz = getClassByName(className);
		Object bean = null;
		try {
			bean = clazz.newInstance();
		} catch (Exception e) {
			throw e;
		}
		return bean;
	}

	/**
	 * 通过类名加载对应po的对象
	 * 
	 * @param className
	 * @return
	 * @throws Exception
	 */
	public static Object getPoByName(String className) throws Exception {
		
		return getObjectByName(PO_PACKAGE_NAME + className);
	}

	/**
	 * 通过类名加载对应vo的对象
	 * 
	 * @param className
	 * @return
	 * @throws Exception
	 */
	public static Object getVoByName(String className) throws Exception {
		return getObjectByName(VO_PACKAGE_NAME + className);
	}

	/**
	 * 通过类名判断得到po包下或者vo包下对应的对象
	 * 
	 * @param className
	 * @return
	 */
	public static Object getBeanByClassName(String className)
			throws InnerException {
		Object bean = null;
		try {
			bean = ClassUtil.getVoByName(className);
		} catch (Exception e) {
			try {
				bean = ClassUtil.getPoByName(className);
			} catch (Exception e1) {
				throw new InnerException("未在vo包下或者po包下找到此类！请检查该类是否存在！该类的名称为"
						+ className);
			}

		}
		return bean;
	}

	/**
	 * 通过类名判断得到po包下或者vo包下对应的对象
	 * 
	 * @param className
	 * @return
	 */
	public static Class<?> getClassByClassName(String className)
			throws InnerException {
		Class<?> cls = null;
		try {
			cls = ClassUtil.getVoClassByName(className);
		} catch (Exception e) {
			try {
				cls = ClassUtil.getPoClassByName(className);
			} catch (Exception e1) {
				throw new InnerException("未在vo包下或者po包下找到此类！请检查该类是否存在！该类的名称为"
						+ className);
			}

		}
		return cls;
	}
	
}
