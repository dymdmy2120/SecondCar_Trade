package tool.mastery.core;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;

import tool.mastery.exception.InnerException;

public class CollectionFormUtil {

	/**
	 * 封装request的参数对象
	 * 
	 * @param request
	 * @param action
	 * @return
	 * @throws InnerException
	 */
	public static List<Object> parseRequest(HttpServletRequest request,
			String action) throws InnerException {
		List<Object> list = new ArrayList<Object>();
		if (action.equals("import")) {
		} else {
			// 获得对应的bean对象
			list = createBeanFromParam(request, action);
		}
		return list;

	}

	// 封装高级搜索VO对象
	public static Object parseObjectRequest(HttpServletRequest request,
			String viewName) throws InnerException {
		// 获得对应的bean对象
		Object bean = createBeanFromParam(request, viewName).get(0);
		return bean;
	}

	/**
	 * 从前台接收的表单后生成对应的bean对象
	 * 
	 * @param request
	 * @param viewName
	 * @return
	 */
	private static List<Object> createBeanFromParam(HttpServletRequest request,
			String viewName) {
		List<Object> objList = null;
		Object bean = ClassUtil.getBeanByClassName(viewName);
		Enumeration<?> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String paramName = (String) enu.nextElement();
			try {
				String[] beanValues = request.getParameterValues(paramName
						.toString());
				if (beanValues.length == 1) {

					String value = request.getParameter(paramName.toString());
					try {
						setValue(bean, paramName, value);
					} catch (NoSuchMethodException e) {
						continue;
					}
				} else {
					try {
						// 添充Bean值
						PropertyUtils.setProperty(bean, paramName.toString(),
								beanValues);
					} catch (IllegalArgumentException e) {
						objList = new ArrayList<Object>();
						// 如果此处遇到IllegalArgumentException异常则就是得到的值为1个对象的多个主键值
						for (int i = 0; i < beanValues.length; i++) {
							Object obj = ClassUtil.getBeanByClassName(viewName);
							try {
								setValue(obj, paramName, beanValues[i]);
							} catch (NoSuchMethodException e1) {
								continue;
							}
							objList.add(obj);
						}
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				// throw new InnerException("");
			}
		}
		if (objList == null) {
			objList = new ArrayList<Object>();
			objList.add(bean);
		}
		return objList;
	}

	/**
	 * 给bean对象赋值
	 * 
	 * @param bean
	 * @param paramName
	 * @param value
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	private static void setValue(Object bean, String paramName, String value)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		// 取得这个参数在Bean中的数据类开
		Class<?> cls = PropertyUtils
				.getPropertyType(bean, paramName.toString());
		// 把相应的数据转换成对应的数据类型
		Object beanValue = ConvertUtil.convert(value, cls);
		// 添充Bean值
		PropertyUtils.setProperty(bean, paramName.toString(), beanValue);
	}

}
