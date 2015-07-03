package cn.zlpc.dao;

import java.util.List;

import tool.mastery.core.BeanUtil;
import tool.mastery.exception.DBException;

import cn.zlpc.vo.Page;

public abstract class MultiTableDao {

	/**
	 * 通过传入分页对象和查询条件的值与具体实现中的sql语句填充后查询得到结果
	 * 
	 * @param page
	 *            分页对象
	 * @param condition
	 *            查询条件
	 * @param value
	 *            查询条件的值,
	 * @return
	 * @throws DBException
	 */
	public abstract List<Object> listVo(Page page, String condition,
			String value) throws DBException;

	protected String getSql(String initSql, Class<?> entityClass, Page page,
			String condition, String value) {
		String sql = initSql;
		if (condition != null) {
			// 若已经包含了where条件
			if (sql.indexOf("where") >= 0 || sql.indexOf("WHERE") >= 0) {
				sql += " and ";
			} else {
				sql += " where ";
			}
			//通过在sql语句中寻找真实的查询条件
			String truthCondition = "";
			String[] splitSql = sql.split(" ");
			for(int i = 0 ; i < splitSql.length ; i ++ ) {
				boolean flag = false;
				String[] splitAgainSql = splitSql[i].split(",");
				for(int j = 0 ; j < splitAgainSql.length ; j ++) {
					if(splitAgainSql[j].indexOf(condition) >= 0) {
						truthCondition = splitAgainSql[j];
						flag = true;
						break;
					}
				}
				if(flag) {
					break;
				}
			}
			if (BeanUtil.isNumber(entityClass, condition)) {
				sql += truthCondition + " =" + value;
			} else {
				sql += truthCondition + " ='" + value + "'";
			}
		}
		/*int firstIndex = page.getFirstIndex();
		int maxSize = page.getMaxSize();
		if (maxSize != 0) {
			sql += " limit " + firstIndex + "," + maxSize;
		}*/
		return sql;
	}
}
