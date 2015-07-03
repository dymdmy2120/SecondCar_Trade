/**
 * 
 */
package cn.zlpc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import tool.mastery.db.DBUtil;
import tool.mastery.exception.DBException;
import cn.zlpc.dao.MultiTableDao;
import cn.zlpc.util.VoConvertObj;
import cn.zlpc.vo.AuctionTimeSetting;
import cn.zlpc.vo.Page;
import cn.zlpc.vo.StartContest;

/**
 * @author ASUS
 * 
 */
public class AuctionTimeSettingDaoImpl extends MultiTableDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.zlpc.dao.MultiTableDao#listVo(cn.zlpc.vo.Page, java.lang.String)
	 */
	@Override
	public List<Object> listVo(Page page, String condition, String value)
			throws DBException {
		VoConvertObj vo = new VoConvertObj();
		String sql = "select bid_id,t_vehicle.v_id,bidTime,bidEndTime,plusPri," +
				"bidSpri,stopAuction,vname,plateNo from t_vehicle left join t_bid on" +
				" t_vehicle.v_id=t_bid.v_id where t_vehicle.v_id in " +
				"(select t_vehicle.v_id from t_vehicle where t_vehicle.v_id not in " +
				"(select v.v_id from t_vehicle v , t_userpart up " +
				"where v.v_id=up.v_id and up.state=2) ) and t_vehicle.v_id not in (select v_id from t_bid where beginAuction=1) order by bid_id desc";
		sql = this.getSql(sql, StartContest.class, page, condition, value);
		System.out.println(sql);
		Connection conn = DBUtil.getConnection();
		PreparedStatement preparedStatment = DBUtil.getPstmt(conn, sql);
		ResultSet rs = DBUtil.getRs(preparedStatment);
		List<Object> list = vo.convertVoObj(AuctionTimeSetting.class, rs);
		DBUtil.closeDatabase(rs, preparedStatment);
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DBException("连接关闭异常!");
		}
		return list;
	}

}
