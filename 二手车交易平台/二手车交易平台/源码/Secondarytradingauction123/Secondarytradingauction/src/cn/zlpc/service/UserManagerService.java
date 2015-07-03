package cn.zlpc.service;

import java.util.ArrayList;
import java.util.List;

import tool.mastery.exception.DBException;

import cn.zlpc.dao.BaseDao;
import cn.zlpc.dao.impl.ContestApplyDaoImpl;
import cn.zlpc.exception.ErrorException;
import cn.zlpc.po.User;

public class UserManagerService {

	private String voName;

	public UserManagerService(String voName) {
		this.voName = voName;
	}

	/**
	 * 用户删除的Service
	 * 
	 * @param ids
	 * @return
	 * @throws ErrorException
	 */
	public boolean delete(String[] ids, String state) throws ErrorException {
		boolean flag = false;
		try {
			if (voName.equalsIgnoreCase("UserDelete")) {
				BaseDao baseDao = new BaseDao();
				List<Object> id = new ArrayList<Object>();
				for (int i = 0; i < ids.length; i++) {
					id.add(ids[i]);
				}
				flag = baseDao.delete(User.class, id);
			} else {
				ContestApplyDaoImpl caDao = new ContestApplyDaoImpl();
				for (int i = 0; i < ids.length; i++) {
					String[] condition = ids[i].split(",");
					// 对是否批准进行处理
					caDao.processBid(condition[0],
							Integer.parseInt(condition[1]), state);
				}
			}
		} catch (DBException e) {
			throw new ErrorException(e.getMessage());
		}

		return flag;
	}
}
