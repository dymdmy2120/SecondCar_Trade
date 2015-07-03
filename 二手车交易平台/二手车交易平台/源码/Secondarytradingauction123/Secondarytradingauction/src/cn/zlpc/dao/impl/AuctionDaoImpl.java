package cn.zlpc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tool.mastery.annotation.Util;
import tool.mastery.db.DBUtil;
import tool.mastery.exception.DBException;
import cn.zlpc.dao.MultiTableDao;
import cn.zlpc.util.ImageUtil;
import cn.zlpc.vo.CurrContest;
import cn.zlpc.vo.Page;

/**
 * 拍卖的Dao类
 * 
 * @author antsmarth
 * 
 */
public class AuctionDaoImpl extends MultiTableDao {
	private static Connection conn = DBUtil.getConnection();
	private static Util util = new Util();
	
	/**
	 * 以车牌号查询车辆信息；(即当前竞拍车辆)
	 * 
	 * @param v_id
	 * @return
	 * @throws DBException
	 */
	public CurrContest getCurrContest(int v_id, String u_id)
			throws DBException {

		CurrContest entity = null;
		try {
			entity = new CurrContest();
			Statement stm = conn.createStatement();
			String sql = "select t_vehicle.v_id,t_vehicle.plateNo,vname,regTime,source,bidSpri,plusPri,bidTime,bidEndTime,beginAuction,stopAuction,v_source from t_vehicle ,t_bid,t_userpart where t_vehicle.v_id=t_bid.v_id and t_vehicle.v_id=t_userpart.v_id and t_vehicle.v_id ='"
					+ v_id + "' and u_id='" + u_id + "' and state =1";
			// System.out.println(sql);
			ResultSet rs = stm.executeQuery(sql);
			entity.ConvertResultSet(rs, entity);
			if (entity.getV_id() == null || entity.getV_id().equals("")) {

			} else {
				entity.setAttCou(getAttCount(v_id));
				entity.setPeCou(getPeCount(v_id));
			}
		} catch (SQLException e) {

		}
		return entity;
	}

	/**
	 * 以用户ID来查询，根据不同的标志位来查询该用户登记或者关注的车辆；
	 * 
	 * @param u_id
	 * @param stateFlag
	 * @param condition
	 * @return
	 * @throws DBException
	 */
	public List<CurrContest> getAuctionVehicle(String u_id, int stateFlag,
			String condition) throws DBException {
		String sql = "select t_vehicle.v_id,t_vehicle.plateNo,vname,regTime,source,bidTime,bidEndTime,bidSpri,plusPri,beginAuction,stopAuction,v_source from t_vehicle,t_userpart,t_bid where t_vehicle.v_id=t_bid.v_id and t_vehicle.v_id=t_userpart.v_id and u_id='"
				+ u_id + "'";
		if (condition.equals("state"))
			sql = sql + " and state=" + stateFlag;
		else if (condition.equals("attention")) {
			sql = sql + " and attention= 1";
		}
		List<CurrContest> auctionVehicleList = new ArrayList<CurrContest>();
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				CurrContest aucVeh = new CurrContest();
				aucVeh.setV_id(rs.getInt("v_id"));
				aucVeh.setPlateNo(rs.getString("plateNo"));
				aucVeh.setVname(rs.getString("vname"));
				aucVeh.setRegTime(rs.getDate("regTime"));
				aucVeh.setBidSpri(rs.getInt("bidSpri"));
				aucVeh.setPlusPri(rs.getInt("plusPri"));
				aucVeh.setBidTime(util.transferStringToDate(String.valueOf(rs.getObject("bidTime"))));
				aucVeh.setBidEndTime(util.transferStringToDate(String.valueOf(rs.getObject("bidEndTime"))));
				aucVeh.setBeginAuction(rs.getInt("beginAuction"));
				aucVeh.setStopAuction(rs.getInt("stopAuction"));
				aucVeh.setSource(rs.getString("source"));
				aucVeh.setV_source(rs.getString("v_source"));
				aucVeh.setAttCou(getAttCount(rs.getInt("v_id")));
				aucVeh.setPeCou(getPeCount(rs.getInt("v_id")));
				
				List<String> imageList = ImageUtil.getImage(ImageUtil.GET_PATH + rs.getString("v_id")
						+ "\\", ImageUtil.SHOW_PATH + rs.getString("v_id")
						+ "/");
				if(imageList.size() != 0) {
					aucVeh.setImagePath(imageList.get(0));
				}else {
					aucVeh.setImagePath("img/nophoto.jpg");
				}
				
				auctionVehicleList.add(aucVeh);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return auctionVehicleList;
	}

	/**
	 * 以车牌号查询车辆的关注人数
	 * 
	 * @param v_id
	 * @return
	 */
	public int getAttCount(int v_id) {
		int attCou = 0;
		try {
			String sql = "select count(*) as count from t_userpart where v_id="
					+ v_id + " and attention = 1";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				attCou = rs.getInt("count");
			}
		} catch (SQLException e) {

		}
		return attCou;
	}

	/**
	 * 以车辆编号来查询登记车辆的人数
	 * 
	 * @param v_id
	 * @return
	 */
	public int getPeCount(int v_id) {
		int PeCou = 0;
		try {
			String sql = "select count(*) as count from t_userpart where v_id="
					+ v_id + " and state = 1";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				PeCou = rs.getInt("count");
			}
		} catch (SQLException e) {

		}
		return PeCou;
	}

	public Boolean saveForAuction(String u_id, int v_id, String price) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String updatesql = "update t_userpart set price ='" + price
				+ "', state=2, currentTime='" + format.format(new Date())
				+ "' where u_id='" + u_id + "' and v_id=" + v_id + "";
		System.out.println(updatesql);
		try {
			PreparedStatement pstm = conn.prepareStatement(updatesql,
					Statement.RETURN_GENERATED_KEYS);
			conn.setAutoCommit(false);
			int saveFlag = pstm.executeUpdate(updatesql);
			conn.commit();

			if (saveFlag == 0) {
				return false;
			} else {
				deleteForAuctionPart(v_id);
				updateForBidFlag(v_id);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void updateForBidFlag(int v_id) {
		String updateSql = "update  t_bid set beginAuction = 0 ,stopAuction = 1 where  v_id=" + v_id;
		try {
			PreparedStatement pstm = conn.prepareStatement(updateSql,
					Statement.RETURN_GENERATED_KEYS);
			conn.setAutoCommit(false);
			pstm.executeUpdate(updateSql);
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteForAuctionPart(int v_id) {
		String deleteSql = "delete from t_userpart where state = 1 and v_id="
				+ v_id ;
		try {
			PreparedStatement pstm = conn.prepareStatement(deleteSql,
					Statement.RETURN_GENERATED_KEYS);
			conn.setAutoCommit(false);
			pstm.executeUpdate(deleteSql);
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Object> listVo(Page page, String condition, String value)
			throws DBException {
		// TODO Auto-generated method stub
		return null;
	}
}
