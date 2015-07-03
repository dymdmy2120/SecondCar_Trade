package cn.zlpc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import tool.mastery.db.DBUtil;
import tool.mastery.exception.DBException;
import cn.zlpc.dao.BaseDao;
import cn.zlpc.po.Userpart;

public class UserPartDaoImpl {

	private BaseDao baseDao;

	public UserPartDaoImpl() {
		baseDao = new BaseDao();
	}

	public boolean insert(Object entity) throws DBException {
		boolean flag = false;
		if (entity == null) {
			throw new DBException("entity对象为空！");
		}
		Userpart up = (Userpart) entity;
		// 判断数据是否存在,若不等于0则证明存在
		List<Object> list = baseDao.queryForSingle(Userpart.class, 0, 0, null,
				"u_id,v_id", up.getU_id() + "," + up.getV_id(), false);
		String sql = null;
		System.out.println("attention"+up.getAttention());
		System.out.println("state"+up.getState());
		if (list.size() != 0) {
			Userpart retUp = (Userpart) list.get(0);
			// 如果是关注
			if (up.getAttention() != null) {
				// 如果两者相同
				if (String.valueOf(up.getAttention()).equalsIgnoreCase(
						String.valueOf(retUp.getAttention()))) {
					throw new DBException("关注失败！已经关注过该车辆");
				} else {
					sql = "update t_userpart set attention="
							+ up.getAttention() + " where u_id='"
							+ up.getU_id() + "' and v_id=" + up.getV_id();
				}
			} else {
				// 如果不是关注那就是登记
				if (retUp.getState() != null) {
					throw new DBException("登记失败！已经登记过该车辆");
				} else {
					sql = "update t_userpart set state=" + up.getState()
							+ " where u_id='" + up.getU_id() + "' and v_id="
							+ up.getV_id();
					;
				}
			}
		} else {
			// 如果数据不存在
			sql = "insert into t_userpart(u_id,v_id,state,attention) values('"
					+ up.getU_id() + "'," + up.getV_id() + ","
					+ up.getState() + "," + up.getAttention() + ")";
		}
		System.out.println(sql);
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, sql);
		try {
			int sum = pstmt.executeUpdate();

			if (sum > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DBException("错误！执行异常");
		}
		return flag;
	}
}
