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
import cn.zlpc.vo.PrTaNotice;

public class PrTaNoticeDaoImpl extends MultiTableDao {

	@Override
	public List<Object> listVo(Page page, String condition, String value)
			throws DBException {
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList<Object>();
		Connection conn = DBUtil.getConnection();
		String sql = null;
		if (condition == null) {
			//sql = "select b.v_id,vname,bidTime,bidSpri,pledge,regTime,source,bidEndTime,plateNo from t_vehicle b left join t_bid a on a.v_id=b.v_id WHERE b.v_id NOT IN (SELECT v_id FROM t_userpart WHERE state=2)";
			sql = "SELECT t_bid.v_id,vname,bidTime,bidSpri,pledge,regTime,source,bidEndTime,plateNo,v_source,stopAuction FROM t_vehicle LEFT JOIN t_bid ON t_vehicle.v_id=t_bid.v_id  ORDER BY bid_id DESC";
		} else {
			sql = "select b.v_id,vname,bidTime,bidSpri,pledge,regTime,source,bidEndTime,plateNo,v_source from t_bid a,t_vehicle b where a.v_id=b.v_id AND b.v_id NOT IN (SELECT v_id FROM t_userpart WHERE state=2)  order by bidTime desc";
		}
		PreparedStatement pstmt = DBUtil.getPstmt(conn, sql);
		ResultSet rs = DBUtil.getRs(pstmt);
		try {
			Util util = new Util();
			while (rs.next()) {
					PrTaNotice prTaNotice = new PrTaNotice();
					prTaNotice.setV_id(rs.getInt(1));
					prTaNotice.setVname(rs.getString(2));
					prTaNotice.setBidTime(util.transferStringToDate(String
							.valueOf(rs.getObject(3))));
					prTaNotice.setBidSpri(rs.getInt(4));
					prTaNotice.setPledge(rs.getString(5));
					prTaNotice.setRegTime(rs.getDate(6));
					prTaNotice.setSource(rs.getString(7));
					prTaNotice.setBidEndTime(util.transferStringToDate(String
							.valueOf(rs.getObject(8))));
					prTaNotice.setPlateNo(rs.getString(9));
					// 得到总关注人数
					String sql1 = "select count(*) from t_userpart where v_id =? and attention=1";
					PreparedStatement pstmt1 = DBUtil.getPstmt(conn, sql1);
					pstmt1.setInt(1, prTaNotice.getV_id());
					ResultSet rs1 = DBUtil.getRs(pstmt1);
					while (rs1.next()) {
						prTaNotice.setAttCout(rs1.getInt(1));
					}
					prTaNotice.setV_source(rs.getString(10));
					if(condition == null) {
						prTaNotice.setStopAuction(rs.getInt(11));
					}
					list.add(prTaNotice);
			}
			DBUtil.closeDatabase(rs, pstmt);
			DBUtil.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
		if(condition == null) {
			for(int i = 0 ; i < list.size() ; i ++ ) {
				PrTaNotice prTaNotice = (PrTaNotice)list.get(i);
				//如果已经竞拍成功，则将其放置到最后
				if(prTaNotice.getStopAuction() != null && prTaNotice.getStopAuction() == 1) {
					list.remove(prTaNotice);
					list.add(prTaNotice);
				}
				
			}
		}
		return list;
	}

}
