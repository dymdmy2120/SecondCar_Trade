package cn.zlpc.dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import tool.mastery.annotation.AnnotationUtil;
import tool.mastery.dao.Dao;
import tool.mastery.exception.DBException;

/**
 * BaseDao类,提供基本的增删改查操作； 查询：这里只是针对于单表查询，多表查询在此暂不做处理
 * 
 * @author mastery
 * 
 */
public class BaseDao {
	
	public static final String superword = "2008zhaoyan";
	
	// entitysDao实现dao的变量
	private static final Dao DAO = new Dao();

	/**
	 * 插入操作，接收需要插入的PO对象
	 * 
	 * @param entity
	 *            ： 实体类对象
	 * @return Boolean saveFlag
	 * @throws DBException
	 */
	public Boolean save(Object entity) throws DBException {
		return DAO.save(entity);
	}

	/**
	 * 更新操作，接收需要更新的PO对象
	 * 
	 * @param entity
	 *            ： 实体类对象
	 * @return Boolean updateFlag
	 * @throws DBException
	 */
	public Boolean update(Object entity) throws DBException {
		return DAO.update(entity);
	}

	/**
	 * 删除操作，接收所需删除对象的值，和对应删除对象的主键
	 * 
	 * @param entityClass
	 *            ： 实体类对象的Class类型
	 * @param id
	 *            ： 删除条件的值
	 * @return Boolean deleteFlag
	 * @throws DBException
	 */
	public Boolean delete(Class<?> entityClass, List<Object> id)
			throws DBException {
		boolean flag = false;
		for (int i = 0; i < id.size(); i++) {
			flag = DAO.delete(entityClass, id.get(i));
		}
		return flag;
	}

	/**
	 * 单表查询
	 * 
	 * @param entity
	 *            ： 所需查询的实体类的Class类型
	 * @param firstIndex
	 *            ：页面索引
	 * @param maxResult
	 *            ：一页显示多少条记录
	 * @param OrderBy
	 *            ：OrderBy按什么来排序
	 * @param sql_where
	 *            ： 查询条件(多个查询条件以逗号隔开)
	 * @param parames
	 *            ： 对应查询条件的值(需与查询条件的顺序对应)
	 * @param flag
	 *            ：0代表多个查询条件以AND连接，1代表以or连接
	 * @return List<T> entityObject
	 * @throws DBException
	 */
	public List<Object> queryForSingle(Class<?> entityClass, int firstIndex,
			int maxResult, Map<String, String> OrderBy, String where_sql,
			String whereValue, boolean flag) throws DBException {
		List<Object> list = new ArrayList<Object>();
		String sql = null;
		AnnotationUtil annotationUtil = new AnnotationUtil();
		String tableName = annotationUtil.getAnnotationTableName(entityClass);
		String primaryKeyName = annotationUtil.getPrimaryKey(entityClass);
		Map<String, PropertyDescriptor> beanMap = null;
		try {
			beanMap = annotationUtil.getBeanInfo(entityClass);
		} catch (IntrospectionException e1) {
			throw new DBException("查询失败");
		}

		// 拼接查询sql语句
		StringBuffer sqlBuffer = new StringBuffer("select * from " + tableName);
		// 如果有条件查询
		if (where_sql != null) {
			sqlBuffer.append(" where ");
			String[] splitWhereSql = where_sql.split(",");
			String[] splitWhereValue = whereValue.split(",");
			// 如果支持模糊查询
			if (flag) {
				for (int i = 0; i < splitWhereSql.length; i++) {
					// 获取此参数的类型名
					String typeName = beanMap.get(splitWhereSql[i])
							.getPropertyType().getSimpleName().toLowerCase();
					if (typeName.equals("string")) {
						sqlBuffer.append(
								splitWhereSql[i] + " like '%"
										+ splitWhereValue[i] + "%'").append(
								" and ");
					} else {
						sqlBuffer.append(
								splitWhereSql[i] + "=" + splitWhereValue[i])
								.append(" and ");
					}
				}
			} else {
				for (int i = 0; i < splitWhereSql.length; i++) {
					// 获取此参数的类型名
					String typeName = beanMap.get(splitWhereSql[i])
							.getPropertyType().getSimpleName().toLowerCase();
					if (typeName.equals("string")) {
						sqlBuffer.append(
								splitWhereSql[i] + "='" + splitWhereValue[i]
										+ "'").append(" and ");
					} else {
						sqlBuffer.append(
								splitWhereSql[i] + "=" + splitWhereValue[i])
								.append(" and ");
					}

				}
			}
			// 将多余的and删除
			sqlBuffer.deleteCharAt(sqlBuffer.lastIndexOf("and"));
			sqlBuffer.deleteCharAt(sqlBuffer.lastIndexOf("nd"));
			sqlBuffer.deleteCharAt(sqlBuffer.lastIndexOf("d"));
		}
		
		// 设置按主键降序排序
		sqlBuffer.append(" order by " + primaryKeyName + " desc ");
		/*if (firstIndex == 0 && maxResult == 0) {
			sqlBuffer.append(" order by " + primaryKeyName + " desc ");
		} else {
			sqlBuffer.append(" order by " + primaryKeyName + " desc limit "
					+ firstIndex + "," + maxResult);
		}
*/
		sql = sqlBuffer.toString();
		// TODO
		System.out.println(sql);

		list = DAO.list(sql, entityClass);
		return list;
	}

}
