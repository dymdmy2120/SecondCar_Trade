package cn.zlpc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tool.mastery.db.DBUtil;
import tool.mastery.exception.DBException;
import cn.zlpc.dao.BaseDao;
import cn.zlpc.dao.MultiTableDao;
import cn.zlpc.exception.ErrorException;
import cn.zlpc.po.Vehicle;
import cn.zlpc.vo.Page;
import cn.zlpc.vo.RegistrationVehicle;
import cn.zlpc.vo.VehicleVo;

public class VehicleVoDaoImpl extends MultiTableDao{
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs =null;
	@Override
	public List<Object> listVo(Page page, String condition, String value)
			throws DBException {
		List<Object> result = new ArrayList<Object>();
		String sql="select v.v_id,v.plateNo,v.note,v.loc,v.vname,v.regTime,v.v_version,v.gear,v.vframe,v.motor,v.gearBox,v.output,v.output,v.mairSac,v.sairSac,"
				 +"v.fbroke,v.ftransfer,v.fdisass,v.fagain,v.fbrule,v.fmort,v.tel,v.source,v.pledge, count(*) as counts"
				 +" from t_vehicle v,t_userpart up "
				 +"where v.v_id=up.v_id and up.attention = 1";
		String finalSql = this.getSql(sql, RegistrationVehicle.class, page, condition, value);
		System.out.println(finalSql);
		
		con = DBUtil.getConnection();
		try {
			pst = con.prepareStatement(finalSql);
			rs = pst.executeQuery();
			while(rs.next()){
				VehicleVo ve = new VehicleVo();
				ve.setV_id(rs.getInt("v_id"));
				ve.setPlateNo(rs.getString("plateNo"));
				ve.setNote(rs.getString("note"));
				ve.setLoc(rs.getString("loc"));
				ve.setVname(rs.getString("vname"));
				ve.setRegTime(rs.getDate("regTime"));
				ve.setPledge(rs.getString("pledge"));
				ve.setVersion(rs.getString("v_version"));
				ve.setGear(rs.getInt("gear"));
				ve.setVframe(rs.getString("vframe"));
				ve.setMotor(rs.getString("motor"));
				ve.setGearBox(rs.getString("gearBox"));
				ve.setOutput(rs.getString("output"));
				ve.setMairSac(rs.getString("mairSac"));
				ve.setStrfBroke((rs.getInt("fbroke")==1 ? "是" : "否"));
				ve.setStrfTransfer((rs.getInt("ftransfer")==1 ? "是" : "否"));
				ve.setStrfDisass((rs.getInt("fdisass")==1 ? "是" : "否"));
				ve.setStrfAgain((rs.getInt("fagain")==1 ? "是" : "否"));
				ve.setStrfBRule((rs.getInt("fbRule")==1 ? "是" : "否"));
				ve.setStrfMort((rs.getInt("fmort")==1 ? "是" : "否"));
				ve.setTel(rs.getString("tel"));
				ve.setSource(rs.getString("source"));
				ve.setAttentionCounts(rs.getInt("counts"));
				result.add(ve);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pst, con);
		}
			
		return result;
	}
	
	/**
	 * 获得自动增长的最大的id加1
	 * @return
	 * @throws ErrorException
	 */
	public Integer getNewVid() throws ErrorException {
		BaseDao baseDao = new BaseDao();
		Integer v_id = 0;
		try {
			List<Object> list = baseDao.queryForSingle(Vehicle.class, 0, 0, null, null, null, false);
			if(list.size() != 0) {
				v_id = ((Vehicle)list.get(0)).getV_id() + 1;
			}
		} catch (DBException e) {
			throw new ErrorException(e.getMessage());
		}
		return v_id;
	}
}
