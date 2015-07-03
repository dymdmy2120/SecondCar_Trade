package cn.zlpc.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

import tool.mastery.annotation.AnnotationUtil;
import tool.mastery.dao.Dao;
import tool.mastery.exception.DBException;
import cn.zlpc.dao.BaseDao;
import cn.zlpc.exception.ErrorException;

/**
 * 用于当是单个po时的Service，处理单个po的操作
 * 
 * @author mastery
 * 
 */
public class SingleService {

	private List<Object> beans;
	private BaseDao baseDao;

	public SingleService(List<Object> beans) {
		baseDao = new BaseDao();
		this.beans = beans;
	}

	public boolean execute(String operate) throws ErrorException {
		boolean flag = false;
		try {
			// 若操纵是添加
			if (operate.equalsIgnoreCase("add")) {
				flag = add();
			} else if (operate.equalsIgnoreCase("update")) {
				// 若操纵是修改
				for (int i = 0; i < beans.size(); i++) {
					flag = baseDao.update(beans.get(i));
				}
			} else if (operate.equalsIgnoreCase("delete")) {
				// 若操纵是修改
				AnnotationUtil au = new AnnotationUtil();
				List<Object> id = new ArrayList<Object>();
				// 获取该po的主键名
				String primaryKeyName = au.getPrimaryKey(beans.get(0)
						.getClass());
				Class<?> entityClass = beans.get(0).getClass();
				for (int i = 0; i < beans.size(); i++) {
					// 获取该主键名对应的值后添加到集合中
					Object primarykeyValue = null;
					try {
						primarykeyValue = PropertyUtils.getProperty(
								beans.get(i), primaryKeyName);
						id.add(primarykeyValue);
					} catch (Exception e) {
						throw new ErrorException("数据删除异常！");
					}
				}
				// 调用dao层的删除方法
				flag = baseDao.delete(entityClass, id);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new ErrorException(e.getMessage());
		}
		return flag;

	}

	private boolean add() throws DBException {
		boolean flag = false;
		for (int i = 0; i < beans.size(); i++) {
			Object bean = beans.get(i);

			String primaryKeyName = new AnnotationUtil().getPrimaryKey(bean
					.getClass());
			Object obj = null;
			try {
				// 判断表中是否存在此条数据
				obj = new Dao().get(bean.getClass(),
						PropertyUtils.getProperty(bean, primaryKeyName));
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (obj != null) {
				throw new ErrorException("错误!存在相同的数据,不能做插入!");
			}
			flag = baseDao.save(bean);
		}
		return flag;
	}

}
