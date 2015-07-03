package cn.zlpc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import tool.mastery.annotation.AnnotationUtil;
import tool.mastery.db.DBUtil;
import tool.mastery.exception.DBException;
import cn.zlpc.dao.MultiTableDao;
import cn.zlpc.util.VoConvertObj;
import cn.zlpc.vo.Page;
import cn.zlpc.vo.StartContest;

public class StartContestDaoImpl extends MultiTableDao {
	@Override
	public List<Object> listVo(Page page, String condition, String value)
			throws DBException {
		VoConvertObj vo = new VoConvertObj();
		String sql = "SELECT DISTINCT beginAuction,plusPri,bidSpri,vname," +
				"v_id,plateNo,stopAuction,bidTime,bidEndTime," +
				"bid_id FROM (SELECT beginAuction," +
				"plusPri,bidSpri,vname,getv.v_id,plateNo," +
				"stopAuction,bidTime,bidEndTime,bid_id," +
				"state FROM (SELECT v.v_id v_id , v.plateNo plateNo," +
				"b.stopAuction stopAuction , " +
				"b.beginAuction beginAuction ," +
				" b.bidSpri bidSpri ,b.plusPri " +
				"plusPri , v.vname vname , " +
				"b.bid_id bid_id , b.bidTime bidTime ," +
				" b.bidEndTime bidEndTime  FROM t_vehicle " +
				"v, t_bid b where v.v_id=b.v_id) " +
				"getv LEFT JOIN t_userpart up ON getv." +
				"v_id=up.v_id ) child WHERE child.v_id IN " +
				"(SELECT child.v_id FROM t_userpart" +
				" WHERE child.state IS NULL) OR" +
				" child.v_id IN (SELECT child.v_id " +
				"FROM t_userpart WHERE child.state <>2) AND stopAuction!=1";
		sql = this.getSql(sql, StartContest.class, page, condition, value);
	/*	if(sql.indexOf("limit") >= 0) {
			String frontSql = sql.substring(0 , sql.indexOf("limit") - 1);
			String afterSql = sql.substring(sql.indexOf("limit") -1 , sql.length());
			sql = frontSql + " GROUP BY t_vehicle.v_id ORDER BY bidTime " + afterSql;
		}else {
			sql += " GROUP BY t_vehicle.v_id ORDER BY bidTime ";
		}*/
		System.out.println(sql);
		Connection conn = DBUtil.getConnection();
		PreparedStatement preparedStatment = DBUtil.getPstmt(conn, sql);
		ResultSet rs = DBUtil.getRs(preparedStatment);
		List<Object> list = vo.convertVoObj(StartContest.class, rs);
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

	public Boolean update(Object entity) throws DBException {
		boolean flag = false;
		PreparedStatement preparedStatment = null;
		try {
			AnnotationUtil annotationUtil = new AnnotationUtil();
			Map<String, Object> beanMap = annotationUtil.getBeanInfo(entity);
			// 获取表名
			String tableName = annotationUtil.getAnnotationTableName(entity
					.getClass());
			String v_id = (String) beanMap.get("v_id");
			Integer beginAuction = (Integer) beanMap.get("beginauction");
			Integer stopAuction = (Integer) beanMap.get("stopauction");
			System.out.println(beginAuction + " map");
			String sql = null;
			if (stopAuction != null) {
				sql = "update " + tableName + " set stopAuction=" + stopAuction
						+ " where v_id='" + v_id + "'";
			}
			if (beginAuction != null) {
				sql = "update " + tableName + " set beginAuction="
						+ beginAuction + " where v_id='" + v_id + "'";
			}
			System.out.println(sql);
			Connection conn = DBUtil.getConnection();
			preparedStatment = DBUtil.getPstmt(conn, sql);
			int rows = preparedStatment.executeUpdate();
			if (rows > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("更新异常!");
		} finally {
			DBUtil.close(preparedStatment);
			DBUtil.close();
		}
		return flag;
	}
}
