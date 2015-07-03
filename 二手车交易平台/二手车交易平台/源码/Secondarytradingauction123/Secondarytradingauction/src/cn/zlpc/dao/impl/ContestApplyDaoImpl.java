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
import cn.zlpc.vo.ContestApply;
import cn.zlpc.vo.Page;

/**
 * 竞拍申请的Dao
 * @author mastery
 * @Time 2014-10-23 上午9:30:28
 * 
 */
public class ContestApplyDaoImpl extends MultiTableDao {

	@Override
	public List<Object> listVo(Page page, String condition, String value)
			throws DBException {
		List<Object> list = new ArrayList<Object>();
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT u.u_id , u.tname,u.r_rank , v.vname , up.v_id , b.bidSpri , b.plusPri , v.plateNo FROM t_user u , t_vehicle v , t_userpart up , t_bid b WHERE u.u_id=up.u_id AND v.v_id=b.v_id AND up.v_id=b.v_id and up.state=0 ";
		sql = this.getSql(sql, ContestApply.class, page, condition, value);
		System.out.println(sql);
		PreparedStatement pstmt = DBUtil.getPstmt(conn, sql);
		ResultSet rs = DBUtil.getRs(pstmt);
		try {
			while(rs.next()) {
				ContestApply contestApply = new ContestApply();
				contestApply.setU_id(rs.getString(1));
				contestApply.setTname(rs.getString(2));
				String rank = rs.getInt(3) == 0 ? "普通会员" : "VIP";
				contestApply.setRank(rank);
				contestApply.setVname(rs.getString(4));
				contestApply.setV_id(rs.getInt(5));
				contestApply.setBidSpri(rs.getInt(6));
				contestApply.setPlusPri(rs.getInt(7));
				contestApply.setPlateNo(rs.getString(8));
				list.add(contestApply);
			}
			DBUtil.closeDatabase(rs, pstmt);
			DBUtil.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
		return list;
	}
	
	/**
	 * 对批准或者不批准做出相应的判断
	 * @param u_id
	 * @param v_id
	 * @param state	当状态为1时证明批准，为0时不批准
	 * @return
	 * @throws DBException
	 */
	public boolean processBid(String u_id , int v_id , String state) throws DBException {
		boolean flag = false;
		System.out.println(v_id);
		Connection conn = DBUtil.getConnection();
		String sql = "";
		if(state.equalsIgnoreCase("1")) {
			sql = "update t_userpart set state=1 where u_id=? and v_id=? ";
		}else {
			sql = "delete from t_userpart where u_id=? and v_id=? ";
		}
		
		PreparedStatement pstmt = DBUtil.getPstmt(conn, sql);
		try {
			pstmt.setString(1, u_id);
			pstmt.setInt(2, v_id);
			
			int sum = pstmt.executeUpdate();
			if(sum > 0 ) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
		return flag;
	}
}
