package cn.zlpc.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import tool.mastery.core.ClassUtil;
import tool.mastery.core.ConvertUtil;

/**
 * 上传文件的表单封装
 * 
 * @author Administrator
 * 
 */
public class WebUtils {
	
	public static List<FileItem> list =null;

	public static List<Object> request2Bean(HttpServletRequest request,
			String viewName) throws UnsupportedEncodingException {
		
		List<Object> beans = new ArrayList<Object>();
		Object bean = null;

		DiskFileItemFactory fac = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fac);
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(request);
			list = items;
			bean =  ClassUtil.getBeanByClassName(viewName);
		} catch (FileUploadException e1) {
			 new RuntimeException("上传表单解析出错");
			e1.printStackTrace();
		}
		String folderName = findNo(items);
		Iterator<FileItem> iter = items.iterator(); // 得到所有的属性项

		
			while (iter.hasNext()) {
				FileItem item = iter.next();
				
				if (item.isFormField()) { // 是普通的文本
				
					String name = item.getFieldName();
					String value = item.getString().toString();
					try {
						setValue(bean, name, value);
					} catch (Exception e) {
						new RuntimeException("上传表单解析出错");
						e.printStackTrace();
					}
				}
			}
		beans.add(bean);
		return beans;
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
	public static void setValue(Object bean, String paramName, String value)
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

	/**
	 * 得到车牌号 作为文件夹名称
	 * 
	 * @param iter
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String findNo(List<FileItem> items)
			throws UnsupportedEncodingException {
		Iterator<FileItem> iter = items.iterator(); // 得到所有的属性项
		String temp = null;
		while (iter.hasNext()) {
			FileItem item = iter.next();
			if (item.isFormField() && item.getFieldName().equals("v_id")) {
				temp = item.getString();
			}
		}
		
		return temp;
	}
}
