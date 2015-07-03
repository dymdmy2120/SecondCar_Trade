package cn.zlpc.service;

import java.util.List;

import tool.mastery.dao.Dao;
import tool.mastery.exception.DBException;
import cn.zlpc.dao.BaseDao;
import cn.zlpc.exception.ErrorException;
import cn.zlpc.po.User;
import cn.zlpc.util.MD5Util;
import cn.zlpc.vo.UserUpdate;

public class UserService {

	public User execute(List<Object> beans , String operate) throws ErrorException{
		User retObj  = null;
		//如果是User对象则证明是用户资料修改
		Object bean = beans.get(0);
		if(bean instanceof User) {
			User user = (User)bean;
			SingleService service = new SingleService(beans);
			try {
				boolean flag = service.execute(operate);
				if(flag) {
					retObj = (User)new Dao().get(User.class, user.getU_id());
				}
			} catch (Exception e) {
				throw new ErrorException(e.getMessage() + "用户资料修改失败！");
			}
		}else {
			UserUpdate uu = (UserUpdate)bean;
			uu.setOldPassword(MD5Util.EncoderByMd5(uu.getOldPassword()));
			BaseDao baseDao = new BaseDao();
			try {
				//查询此用户的密码是否正确
				List<Object> list = baseDao.queryForSingle(User.class, 0, 0, null, "u_id,psword", uu.getU_id() + "," + uu.getOldPassword(), false);
				//若查询出此用户！则证明输入正确
				if(list.size() != 0) {
					User user = new User();
					user.setU_id(uu.getU_id());
					user.setPsword(MD5Util.EncoderByMd5(uu.getNewPassword()));
					baseDao.update(user);
				}
			} catch (DBException e) {
				throw new ErrorException(e.getMessage() + "用户密码修改失败！");
			}
		}
		
		return retObj;
	}
}
