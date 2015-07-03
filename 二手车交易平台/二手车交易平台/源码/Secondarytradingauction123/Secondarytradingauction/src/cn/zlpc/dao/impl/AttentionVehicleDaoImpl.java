package cn.zlpc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tool.mastery.db.DBUtil;
import tool.mastery.exception.DBException;
import cn.zlpc.dao.MultiTableDao;
import cn.zlpc.util.ImageUtil;
import cn.zlpc.vo.AttentionVehicle;
import cn.zlpc.vo.Page;

/**
 * 会员中心，我的车辆模块Dao层；
 * @author Administrator
 *
 */
public class AttentionVehicleDaoImpl extends MultiTableDao{
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs =null;
	@Override
	public List<Object> listVo(Page page, String condition, String value)
			throws DBException {
		// TODO Auto-generated method stub
	//	System.out.println("key:"+condition+" value:"+value);
		List<Object> result = new ArrayList<Object>();
		String sql = "select v.v_id,v.plateNo, v.vname,v.regTime,v.pledge,b.bidSpri,v.source,b.bidTime,b.bidEndTime,v_source from t_user u,t_vehicle v,t_userpart  up,t_bid b where u.u_id = up.u_id and v.v_id = up.v_id and v.v_id = b.v_id and up.attention = 1";
		String finalSql = this.getSql(sql, AttentionVehicle.class, page, condition, value);
		System.out.println(finalSql);
		con = DBUtil.getConnection();
		try {
			pst = con.prepareStatement(finalSql);
			rs = pst.executeQuery();
			while(rs.next()){
				AttentionVehicle av = new AttentionVehicle();
				av.setV_id(rs.getInt("v_id"));
				av.setPlateNo(rs.getString("plateNo"));
				av.setVname(rs.getString("vname"));
				av.setFristregist(rs.getDate("regTime"));
				av.setMargin(rs.getString("pledge"));
				av.setDownprice(rs.getString("bidSpri"));
				av.setVehiclesource(rs.getString("source"));
				av.setV_source(rs.getString("v_source"));
				av.setState(this.getState(rs.getDate("bidTime"), rs.getDate("bidEndTime")));
				List<String> imageList = ImageUtil.getImage(ImageUtil.GET_PATH + rs.getInt("v_id")
						+ "\\", ImageUtil.SHOW_PATH + rs.getString("v_id")
						+ "/");
				if(imageList.size() != 0) {
					av.setImagePath(imageList.get(0));
				}else {
					av.setImagePath("img/nophoto.jpg");
				}
				result.add(av);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pst, con);
		}
		return result;
	}
	
	private String getState(Date startTime,Date endTime){
		String state = "未知";
		long nowDate = new java.util.Date().getTime();
		if(startTime.getTime()>nowDate){
			state = "未开始拍卖";
		}else{
			if(endTime.getTime()<nowDate){
				state = "拍卖已结束";
			}else{
				state = "正在拍卖中";
			}
		}
		return state;
	}
	

}
