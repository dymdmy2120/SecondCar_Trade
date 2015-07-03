package cn.zlpc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tool.mastery.db.DBUtil;
import tool.mastery.exception.DBException;
import cn.zlpc.dao.MultiTableDao;
import cn.zlpc.vo.Page;
import cn.zlpc.vo.SucInfor;

public class SucInforDaoImpl extends MultiTableDao {
	public Connection conn = null;
	public PreparedStatement psmt = null;
	public ResultSet rs = null;

	public SucInforDaoImpl() {
	}

	@Override
	public List<Object> listVo(Page page, String condition, String value)
			throws DBException {
		conn = DBUtil.getConnection();
		List<Object> listSuinfor = new ArrayList<Object>();
		String sql = "select * from t_vehicle v ,t_user u, t_userpart p where v.v_id = p.v_id and p.u_id = u.u_id and p.state=2";
		sql = this.getSql(sql, SucInfor.class, page, condition, value);
		/*// 当page对象不为空时
		if (page != null) {
			firstIndex = page.getFirstIndex();
			maxResult = page.getMaxSize();
			if(maxResult == 0) {
				maxResult = 20;
			}
			// 当接收到的参数不为空时
			if (condition != null) {
				sql = "select * from t_vehicle v ,t_user u, t_userpart p where v.v_id = p.v_id and p.u_id = u.u_id and "
						+ condition;
				if (BeanUtil.isNumber(SucInfor.class, condition)) {
					sql += " =" + value;
				}else {
					sql += " ='" + value + "'";
				}
				sql += " limit " + firstIndex + ","
						+ maxResult;

			} else {
				sql = "select * from t_vehicle v ,t_user u, t_userpart p where v.v_id = p.v_id and p.u_id = u.u_id  limit "
						+ firstIndex + "," + maxResult;
			}
			System.out.println(sql);

		} else {
			// 查询出所有的记录
			sql = "select * from t_vehicle v ,t_user u, t_userpart p where v.v_id = p.v_id and p.u_id = u.u_id ";
		}*/
		System.out.println(sql);
		try {
			this.psmt = conn.prepareStatement(sql);
			rs = this.psmt.executeQuery();
			while (rs.next()) {
				SucInfor suinfor = new SucInfor();
				suinfor.setV_id(rs.getInt("v_id"));
				suinfor.setPlateNo(rs.getString("plateNo"));
				suinfor.setPrice(rs.getInt("price"));
				suinfor.setTname(rs.getString("tname"));
				suinfor.setVname(rs.getString("vname"));
				suinfor.setTel(rs.getString("tel"));
				listSuinfor.add(suinfor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("您错了！");
		}

		return listSuinfor;
	}
}
