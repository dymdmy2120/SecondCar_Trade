package cn.zlpc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tool.mastery.db.DBUtil;
import cn.zlpc.po.Admin;
import cn.zlpc.po.User;
import cn.zlpc.util.MD5Util;
import cn.zlpc.util.TransCode;

public class LoginDao {
	
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs =null;
	
	public User Validate(String u_id){
		User user = null;
		con = DBUtil.getConnection();
		String strSql="select * from t_user where u_id='"+u_id+"'";
		try {
			pst=con.prepareStatement(strSql);
			rs = pst.executeQuery();
			if(rs.next()){
				user = new User();
				user.setU_id(rs.getString("u_id"));
				user.setTel(rs.getString("tel"));
				user.setReIntro(rs.getString("reIntro"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pst, con);
		}
		return user;
	}
	
	public User Validate(String u_id,String password){
		User user = null;
		con = DBUtil.getConnection();
		String pasword = MD5Util.EncoderByMd5(password);
		String sql="select * from t_user where u_id=? and psword=?";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, u_id);
			pst.setString(2, pasword);
			System.out.println(u_id);
			System.out.println(pasword);
			rs = pst.executeQuery();
			if(rs.next()){
				user = new User();
				user.setU_id(rs.getString("u_id"));
				user.setU_name(rs.getString("u_name"));
				user.setPsword(rs.getString("psword"));
				user.setEmail(rs.getString("email"));
				user.setTel(rs.getString("tel"));
				user.setR_rank(rs.getInt("r_rank"));
				user.setVipTime(rs.getDate("vipTime"));
				user.setPaytime(rs.getDate("paytime"));
				user.setReIntro(rs.getString("reIntro"));
				user.setCardID(rs.getString("cardID"));
				user.setTname(rs.getString("tname"));
				user.setU_address(rs.getString("u_address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pst, con);
		}
		return user;
	}
	
	/**
	 *@Author linhao007
	 *@Decration 用来后台管理登入sql语句查询
	 * @param admin
	 * @param pasword
	 * @return
	 */
	public Admin adminValidate(String u_id,String password){
		Admin  admin= null;
		con = DBUtil.getConnection();
//		String pasword = MD5Util.EncoderByMd5(password);
		String sql="select * from t_admin where admin=? and pasword=?";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, u_id);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()){
				admin = new Admin();
				admin.setAdmin(rs.getString("admin"));
				admin.setPasword(rs.getString("pasword"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pst, con);
		}
		return admin;
	}
	
	public boolean enrol(User user){
		boolean result = false;
		con = DBUtil.getConnection();
		String sql="insert into t_user(u_id,u_name,psword,email,tel,reIntro,cardID,tname,u_address) values (?,?,?,?,?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getU_id());
			String u_name = TransCode.transcoding(user.getU_name());
			System.out.println(u_name);
			pst.setString(2, u_name);
			String password = MD5Util.EncoderByMd5(user.getPsword());
			pst.setString(3, password);
			pst.setString(4, user.getEmail());
			pst.setString(5, user.getTel());
			String reIntro = TransCode.transcoding(user.getReIntro());
			String md5rintro = MD5Util.EncoderByMd5(reIntro);
			pst.setString(6, md5rintro);
			pst.setString(7, user.getCardID());
			String tname = TransCode.transcoding(user.getTname());
			System.out.println(tname);
			pst.setString(8,tname );
			String address = TransCode.transcoding(user.getU_address());
			System.out.println(address);
			pst.setString(9, address);
			pst.executeUpdate();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pst, con);
		}
		return result;
	}
	
	public boolean alterPasword(String u_id,String pasword){
		boolean result = false;
		con = DBUtil.getConnection();
		String password = MD5Util.EncoderByMd5(pasword);
		String sql = "update t_user set psword='"+password+"' where u_id ='"+u_id+"'";
		try {
			pst = con.prepareStatement(sql);
			System.out.println(pst);
			int a = pst.executeUpdate();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pst, con);
		}
		return result;
	}
	public static void main(String[] args){
		LoginDao loginDao = new LoginDao();
		System.out.println(loginDao.Validate("123445"));;
	}
}
