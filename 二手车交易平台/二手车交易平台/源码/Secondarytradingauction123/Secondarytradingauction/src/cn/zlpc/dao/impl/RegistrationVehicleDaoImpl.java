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
import cn.zlpc.vo.Page;
import cn.zlpc.vo.RegistrationVehicle;

public class RegistrationVehicleDaoImpl extends MultiTableDao{
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs =null;
	@Override
	public List<Object> listVo(Page page, String condition, String value)
			throws DBException {
		List<Object> result = new ArrayList<Object>();
		String sql = "select v.v_id,v.plateNo, v.vname,v.regTime,v.pledge,b.bidSpri,b.bidTime,b.bidEndTime,v_source from t_user u,t_vehicle v,t_userpart  up,t_bid b where u.u_id = up.u_id and v.v_id = up.v_id and v.v_id = b.v_id and up.state in (0,1)";
		String finalSql = this.getSql(sql, RegistrationVehicle.class, page, condition, value);
		con = DBUtil.getConnection();
		try {
			pst = con.prepareStatement(finalSql);
			rs = pst.executeQuery();
			while(rs.next()){
				RegistrationVehicle av = new RegistrationVehicle();
				av.setV_id(rs.getInt("v_id"));
				av.setPlateNo(rs.getString("plateNo"));
				av.setVname(rs.getString("vname"));
				av.setFristregist(rs.getDate("regTime"));
				av.setMargin(rs.getString("pledge"));
				av.setDownprice(rs.getString("bidSpri"));
				av.setBiddingtime(rs.getDate("bidTime"));
				av.setState(this.getState(rs.getDate("bidTime"), rs.getDate("bidEndTime")));
				av.setV_source(rs.getString("v_source"));
				List<String> imageList = ImageUtil.getImage(ImageUtil.GET_PATH + rs.getInt("v_id")
						+ "\\", ImageUtil.SHOW_PATH + rs.getInt("v_id")
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
		//System.out.println("daoSize:"+result.size());
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
