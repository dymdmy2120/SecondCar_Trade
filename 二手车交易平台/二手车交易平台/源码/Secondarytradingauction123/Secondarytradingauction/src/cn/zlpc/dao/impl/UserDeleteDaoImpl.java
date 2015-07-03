package cn.zlpc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tool.mastery.annotation.Util;
import tool.mastery.db.DBUtil;
import tool.mastery.exception.DBException;
import cn.zlpc.dao.MultiTableDao;
import cn.zlpc.vo.Page;
import cn.zlpc.vo.UserDelete;

public class UserDeleteDaoImpl extends MultiTableDao {

	@Override
	public List<Object> listVo(Page page, String condition, String value)
			throws DBException {
		List<Object> list = new ArrayList<Object>();
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT u_id , tname , r_rank , vipTime , paytime , tel , email from t_user";

		sql = this.getSql(sql, UserDelete.class, page, condition, value);
		System.out.println(sql);
		PreparedStatement pstmt = DBUtil.getPstmt(conn, sql);
		ResultSet rs = DBUtil.getRs(pstmt);
		try {
			while (rs.next()) {
				UserDelete userDelete = new UserDelete();
				userDelete.setU_id(rs.getString(1));
				userDelete.setTname(rs.getString(2));
				String rank = rs.getInt(3) == 0 ? "普通会员" : "VIP";
				userDelete.setRank(rank);
				String vipTime = rs.getInt(4) == 0 ? "" : rs.getInt(4) + "个月";
				userDelete.setDeadline(vipTime);
				//System.out.println(rs.getObject(5));
				userDelete.setPaytime(new Util().transferStringToDate(String
						.valueOf(rs.getObject(5))));
				userDelete.setTel(rs.getString(6));
				userDelete.setEmail(rs.getString(7));
				// 此处计算关注次数
				String sql3 = "select count(*) from t_userpart where u_id=? and attention=1";
				PreparedStatement pstmt3 = DBUtil.getPstmt(conn, sql3);
				pstmt3.setString(1, rs.getString(1));
				ResultSet rs3 = DBUtil.getRs(pstmt3);
				while (rs3.next()) {
					userDelete.setAttCou(rs3.getInt(1));
				}
				// 这是获得竞拍成功次数
				String sql1 = "select count(*) from t_userpart where u_id=? and state=2";
				PreparedStatement pstmt1 = DBUtil.getPstmt(conn, sql1);
				pstmt1.setString(1, rs.getString(1));
				ResultSet rs1 = DBUtil.getRs(pstmt1);
				while (rs1.next()) {
					userDelete.setSucesCou(rs1.getInt(1));
				}

				// 这是获得参与竞拍次数
				String sql2 = "select count(*) from t_userpart where u_id=? and state in (1,2) and price != 0";
				PreparedStatement pstmt2 = DBUtil.getPstmt(conn, sql2);
				pstmt2.setString(1, rs.getString(1));
				ResultSet rs2 = DBUtil.getRs(pstmt2);
				while (rs2.next()) {
					userDelete.setPartCou(rs2.getInt(1));
				}
				list.add(userDelete);
				DBUtil.closeDatabase(rs1, pstmt1);
				DBUtil.closeDatabase(rs2, pstmt2);
				DBUtil.closeDatabase(rs3, pstmt3);
			}
			DBUtil.closeDatabase(rs, pstmt);
			DBUtil.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
		return list;
	}
}
