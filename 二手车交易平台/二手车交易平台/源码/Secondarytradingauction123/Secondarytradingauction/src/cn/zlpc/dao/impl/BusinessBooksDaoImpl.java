package cn.zlpc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import tool.mastery.db.DBUtil;
import tool.mastery.exception.DBException;
import cn.zlpc.dao.MultiTableDao;
import cn.zlpc.vo.BusinessBooks;
import cn.zlpc.vo.Page;

public class BusinessBooksDaoImpl extends MultiTableDao{
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs =null;
	@Override
	public List<Object> listVo(Page page, String condition, String value)
			throws DBException {
		List<Object> result = new ArrayList<Object>();
		String sql = "select * ,count(*) counts from (select b.bidTime, v.v_id,v.plateNo,v.source, b.bidSpri,up.state,up.price,u.tname"
						+" from t_user u,t_vehicle v,t_userpart up,t_bid b" 
						+" where u.u_id = up.u_id and v.v_id = up.v_id and up.v_id = b.v_id and up.price != 0 and b.bidEndTime > '"+this.getLastMonthDay()+"' order by up.state desc) as temp group by temp.v_id;";
		con = DBUtil.getConnection();
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				BusinessBooks bbook = new BusinessBooks();
				bbook.setBidtime(rs.getDate("bidTime"));
				bbook.setV_id(rs.getInt("v_id"));
				bbook.setPlateNo(rs.getString("plateNo"));
				bbook.setSource(rs.getString("source"));
				bbook.setBspri(rs.getString("bidSpri"));
				bbook.setState((rs.getInt("state") == 2) ? "卖出":"未卖出");
				bbook.setPrice(rs.getString("price"));
				bbook.setTname(rs.getString("tname"));
				bbook.setCounts(rs.getInt("counts"));
				result.add(bbook);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pst, con);
		}
		return result;
	}
	private String getLastMonthDay(){
		String strlastMonthDay = null;
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);//得到前一天
		calendar.add(Calendar.MONTH, -1);//得到前一个月
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int date = calendar.get(Calendar.DATE);
		strlastMonthDay = year+"-"+month+"-"+date;
		return strlastMonthDay;
	}
	public static void main(String[] args) throws DBException{
		BusinessBooksDaoImpl dbDao = new BusinessBooksDaoImpl();
		List<Object> result = dbDao.listVo(new Page(), null, null);
		for(int i=0;i<result.size();i++){
			System.out.println(result.get(i));
		}
	}
}
