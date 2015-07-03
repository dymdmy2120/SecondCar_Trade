package cn.zlpc.service.support;

import tool.mastery.annotation.AnnotationUtil;
import tool.mastery.core.ClassUtil;

public class VoSupport {

	public static boolean isSinglePo(Object entity) {
		Class<?> entityClass = null;
		if (entity instanceof String) {
			String entityName = (String) entity;
			entityClass = ClassUtil.getClassByClassName(entityName);
		} else if (entity instanceof Class<?>) {
			entityClass = (Class<?>) entity;
		} else {
			entityClass = entity.getClass();
		}
		AnnotationUtil au = new AnnotationUtil();
		//获得类上的注解的表名，若表名存在则证明是po是属于单表的
		String tableName = au.getAnnotationTableName(entityClass);
		if (tableName != null) {
			return true;
		} else {
			return false;
		}
	}
}
