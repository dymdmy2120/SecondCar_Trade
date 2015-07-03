package tool.mastery.dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import tool.mastery.annotation.AnnotationUtil;
import tool.mastery.annotation.Util;
import tool.mastery.db.DBUtil;
import tool.mastery.exception.DBException;

public class Dao {

	public Dao() {
	}

	/**
	 * 统一的保存方法
	 * 
	 * @param entity
	 * @return
	 * @throws DBException
	 */
	public boolean save(Object entity) throws DBException {
		Connection conn = DBUtil.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		boolean flag = false;

		AnnotationUtil annotationUtil = new AnnotationUtil();
		// 获取表名
		String tableName = annotationUtil.getAnnotationTableName(entity
				.getClass());
		// 获取主键名
		String primaryKeyName = annotationUtil.getPrimaryKey(entity.getClass());
		// 获取实体类存放的属性名和值
		Map<String, Object> beanMap = annotationUtil.getBeanInfo(entity);

		try {
			stmt = conn.createStatement();
			/**
			 * select * from tablename where 1=0的意义 此语句的作用是:
			 * 打开此记录集,但并不从记录集中读取任何记录 直观点说就是,为保护记录集数据,仅做打开,是只做插入记录时用到
			 */
			rs = stmt.executeQuery("select * from " + tableName + " where 1=0");
			// ResultSetMetaData对象是描述表的结构(字段名,字段类型,可容纳的长度)
			ResultSetMetaData rsmd = rs.getMetaData();
			// 获得表中一共有几个字段
			int columnCount = rsmd.getColumnCount();
			// 组装字段
			StringBuffer columnBuffer = new StringBuffer("insert into "
					+ tableName + "(");
			StringBuffer valueBuffer = new StringBuffer(" values(");

			for (int i = 1; i <= columnCount; i++) {
				// 获取列名
				String columnName = rsmd.getColumnName(i).toLowerCase();
				// 获取此字段的类型
				String columnType = rsmd.getColumnTypeName(i).toLowerCase();
				// 获取此字段的值
				Object columnValue = beanMap.get(columnName);
				// 如果不是自动增长的字段,并且是主键
				if (!rsmd.isAutoIncrement(i)
						&& columnName.equals(primaryKeyName)) {

					// 如果是最后一个字段
					if (i == columnCount) {
						columnBuffer.append(columnName + ")");
						if (isNumberType(columnType)) {
							valueBuffer.append(columnValue + ")");
						} else {
							valueBuffer.append("'" + columnValue + "')");
						}
					} else {
						columnBuffer.append(columnName + ",");
						if (isNumberType(columnType)) {
							valueBuffer.append(columnValue + ",");
						} else {
							valueBuffer.append("'" + columnValue + "',");
						}
					}
				}
				// 如果不是自动增长的字段,并且不是主键
				if (!rsmd.isAutoIncrement(i)
						&& !columnName.equals(primaryKeyName)) {

					if (i == columnCount) {
						// 将字段插入到SQL语句中的"insert into tableName("之后
						columnBuffer.append(columnName + ")");
						// 如果插入的值为数值
						if (isNumberType(columnType)) {
							if (columnType.indexOf("date") == 0) {
								columnValue = new Util()
										.transferDateToString((java.util.Date) columnValue);
							}
							valueBuffer.append(columnValue + ")");
			;			} else {
							// 如果插入的值为空
							if (columnValue == null) {
								valueBuffer.append(columnValue + ")");
							} else {
								if (columnType.indexOf("date") == 0) {
									columnValue = new Util()
											.transferDateToString((java.util.Date) columnValue);
								}
								// 如果插入的值不为空
								valueBuffer.append("'" + columnValue + "')");
							}
						}
					} else {
						// 将字段插入到SQL语句中的"insert into tableName("之后
						columnBuffer.append(columnName + ",");
						// 如果插入的值为数值
						if (isNumberType(columnType)) {
							valueBuffer.append(columnValue + ",");
						} else {
							if (columnValue == null) {
								valueBuffer.append(columnValue + ",");
							} else {
								if (columnType.indexOf("date") == 0) {
									columnValue = new Util()
											.transferDateToString((java.util.Date) columnValue);
								}
								valueBuffer.append("'" + columnValue + "',");
							}
						}
					}
				}
			}
			String insertSql = columnBuffer.toString() + valueBuffer.toString();
			// TODO
			System.out.println(insertSql);
			// 用于记录执行sql返回的次数
			int sum = 0;
			sum = stmt.executeUpdate(insertSql);
			if (sum > 0) {
				flag = true;
				// System.out.println("保存成功");
			} else {
				// System.out.println("保存失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("保存失败");
		} finally {
			DBUtil.close();
		}

		return flag;
	}

	/**
	 * 统一的修改方法
	 * 
	 * @param entity
	 * @return
	 * @throws DBException
	 */
	public boolean update(Object entity) throws DBException {
		Connection conn = DBUtil.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		// 用于记录执行sql返回的次数
		boolean flag = false;

		AnnotationUtil annotationUtil = new AnnotationUtil();
		// 获取表名
		String tableName = annotationUtil.getAnnotationTableName(entity
				.getClass());
		// 获取主键名
		String primaryKeyName = annotationUtil.getPrimaryKey(entity.getClass());
		// 获取实体类存放的属性名和值
		Map<String, Object> beanMap = annotationUtil.getBeanInfo(entity);

		try {
			stmt = conn.createStatement();
			/**
			 * select * from tablename where 1=0的意义 此语句的作用是:
			 * 打开此记录集,但并不从记录集中读取任何记录 直观点说就是,为保护记录集数据,仅做打开,是只做插入记录时用到
			 */
			rs = stmt.executeQuery("select * from " + tableName + " where 1=0");
			// ResultSetMetaData对象是描述表的结构(字段名,字段类型,可容纳的长度)
			ResultSetMetaData rsmd = rs.getMetaData();
			// 获得表中一共有几个字段
			int columnCount = rsmd.getColumnCount();

			StringBuffer valueBuffer = new StringBuffer("update " + tableName
					+ " set ");
			String whereCondition = null;

			for (int i = 1; i <= columnCount; i++) {
				String columnName = rsmd.getColumnName(i).toLowerCase();
				String columnType = rsmd.getColumnTypeName(i).toLowerCase();
				Object columnValue = beanMap.get(columnName);
				if (primaryKeyName.equalsIgnoreCase(columnName)) {
					// 当主键为数字的类型时
					if (isNumberType(columnType)) {
						whereCondition = " where " + columnName + "="
								+ columnValue;
					} else {
						whereCondition = " where " + columnName + "='"
								+ columnValue + "'";
					}
				} else {
					if (columnValue != null) {
						// 若为最后一个
						if (i == columnCount) {
							// 若为数字
							if (isNumberType(columnType)) {
								valueBuffer.append(columnName + "="
										+ columnValue);
							} else {
								if (columnType.indexOf("date") == 0) {
									columnValue = new Util()
											.transferDateToString((java.util.Date) columnValue);
								}
								valueBuffer.append(columnName + "='"
										+ columnValue + "'");
							}
						} else {
							if (isNumberType(columnType)) {
								valueBuffer.append(columnName + "="
										+ columnValue + ",");
							} else {
								if (columnType.indexOf("date") == 0) {
									columnValue = new Util()
											.transferDateToString((java.util.Date) columnValue);
								}
								valueBuffer.append(columnName + "='"
										+ columnValue + "',");
							}
						}
					}
				}
			}
			// 获取最后一个逗号到总长度的大小
			int quoteApartLength = valueBuffer.length()
					- valueBuffer.toString().lastIndexOf(",");
			if (quoteApartLength == 1) {
				valueBuffer.deleteCharAt(valueBuffer.toString()
						.lastIndexOf(","));
			}
			String sql = valueBuffer.toString() + whereCondition;
			// TODO
			System.out.println(sql);
			int sum = 0;
			if (whereCondition != null) {
				sum = stmt.executeUpdate(sql);
			} else {
				throw new DBException("更新的主键为空!");
			}
			if (sum > 0) {
				flag = true;
				// System.out.println("更新成功");
			} else {
				// System.out.println("更新失败");
			}
		} catch (SQLException e) {
			throw new DBException("更新失败!");
		} finally {
			DBUtil.close();
		}
		return flag;
	}

	/**
	 * 根据主键id，和实体类 删除一个实体对象
	 * 
	 * @param entityClass
	 * @param id
	 * @return
	 * @throws DBException
	 */
	public boolean delete(Class<?> entityClass, Object id) throws DBException {

		Connection conn = DBUtil.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		boolean flag = false;

		AnnotationUtil annotationUtil = new AnnotationUtil();
		// 获取表名
		String tableName = annotationUtil.getAnnotationTableName(entityClass);
		// 获取主键名
		String primaryKeyName = annotationUtil.getPrimaryKey(entityClass);

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from " + tableName + " where 1=0");

			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			String valueBuffer = new String("delete from " + tableName);
			String whereCondition = null;
			/**
			 * 此处用于判断实体的存在性 若存在则SQL语句组装完成，将where条件中的id补入
			 */
			for (int i = 1; i <= columnCount; i++) {
				String columnName = rsmd.getColumnName(i);
				String columnType = rsmd.getColumnTypeName(i).toLowerCase();
				if (primaryKeyName.equalsIgnoreCase(columnName)) {
					if (isNumberType(columnType)) {
						whereCondition = " where " + primaryKeyName + "=" + id;
					} else {
						whereCondition = " where " + primaryKeyName + "='" + id
								+ "'";
					}
				}
			}
			String sql = valueBuffer.toString() + whereCondition;
			// TODO
			System.out.println(sql);
			// 用于记录执行sql返回的次数
			int sum = 0;
			if (whereCondition != null) {
				sum = stmt.executeUpdate(sql);
			} else {
				throw new DBException("删除的主键为空!");
			}
			if (sum > 0) {
				flag = true;
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("删除失败");
		} finally {

			DBUtil.close();
		}

		return flag;
	}

	private boolean isNumberType(String columnType) {
		return columnType.indexOf("int") == 0
				|| columnType.indexOf("integer") == 0
				|| columnType.indexOf("float") == 0
				|| columnType.indexOf("double") == 0
				|| columnType.indexOf("nember") == 0
				|| columnType.indexOf("numeric") == 0;
	}

	/**
	 * 根据sql语句遍历实体
	 * 
	 * @param sql
	 * @param entityClass
	 * @return
	 * @throws DBException
	 */
	public List<Object> list(String sql, Class<?> entityClass)
			throws DBException {
		Connection conn = DBUtil.getConnection();
		List<Object> list = new ArrayList<Object>();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			// 获取结果集
			rs = stmt.executeQuery(sql);
			// 检索此ResultSetMetaData对象的列编号、类型和属性
			ResultSetMetaData rsmd = rs.getMetaData();
			// 获取所有列
			int columnCount = rsmd.getColumnCount();
			// 封装好的类型信息
			Map<String, PropertyDescriptor> beanMap = new AnnotationUtil()
					.getBeanInfo(entityClass);
			while (rs.next()) {
				Object entity = entityClass.newInstance();

				for (int i = 1; i <= columnCount; i++) {
					// 获取列名
					String columnName = rsmd.getColumnName(i).toLowerCase();
					// 获取列的值
					Object columnValue = rs.getObject(columnName);
					// 获得属性描述对象
					PropertyDescriptor pd = beanMap.get(columnName);
					// 属性数据类型Integer,String,Float,Double(名称)
					String fieldType = pd.getPropertyType().getName();
					// 获取set方法
					Method writerMethod = pd.getWriteMethod();
					if (columnValue != null) {
						// 获取调用set方法的值
						Object args = new Util().typeConvert(columnValue,
								fieldType);
						// 动态调用实体类的set方法，将值保存到实体类对象中
						writerMethod.invoke(entity, args);
					}
				}
				list.add(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("查询失败");
		}
		return list;
	}

	/**
	 * 根据主键id和实体类 加载一个实体对象
	 * 
	 * @throws DBException
	 */
	public Object get(Class<?> entityClass, Object id) throws DBException {
		Object entity = null;
		if (id != null) {
			AnnotationUtil annotationUtil = new AnnotationUtil();
			// 获取表名
			String tableName = annotationUtil
					.getAnnotationTableName(entityClass);
			// 获取主键名
			String primaryKeyName = annotationUtil.getPrimaryKey(entityClass);

			String sql = null;
			Map<String, PropertyDescriptor> beanMap = null;
			try {
				beanMap = annotationUtil.getBeanInfo(entityClass);
			} catch (IntrospectionException e1) {
				throw new DBException("查询失败");
			}
			// 获取主键的数据类型
			String typeName = beanMap.get(primaryKeyName).getPropertyType()
					.getSimpleName().toLowerCase();
			// 若为字符类型
			if (typeName.equals("string")) {
				sql = "select * from " + tableName + " where " + primaryKeyName
						+ "='" + id + "'";
			} else {
				sql = "select * from " + tableName + " where " + primaryKeyName
						+ "=" + id;
			}
			System.out.println(sql);
			List<Object> list = this.list(sql, entityClass);
			if (list != null && list.size() > 0) {
				entity = list.get(0);
			}
		}
		return entity;
	}
}