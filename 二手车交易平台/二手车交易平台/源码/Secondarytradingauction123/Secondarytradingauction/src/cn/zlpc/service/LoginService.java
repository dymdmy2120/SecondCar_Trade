package cn.zlpc.service;

import cn.zlpc.dao.LoginDao;
import cn.zlpc.po.Admin;
import cn.zlpc.po.User;
import cn.zlpc.util.MD5Util;
import cn.zlpc.util.TransCode;

public class LoginService {
	// LoginService负责处理用户登入、忘记密码、回答密保等业务逻辑操作。
	private String operate;
	private User user;
	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LoginService(String operate, User user) {
		this.operate = operate;
		this.user = user;
	}
	
	public LoginService(String operate,Admin admin){
		this.operate = operate;
		this.admin = admin;
	}

	public Admin getAdminResult(){
		Admin admin1 = null;
		admin1 = adminlogin();
		return admin1;
		
	}
	public User getUserResult(){
		User user = null;
		if (operate.equals("login")) {
			user = login();
		} else if (operate.equals("forgetPws")) {
			user = forgetPw();
		} else if(operate.equals("enrol")){
			user = enrol();
		}else if(operate.equals("findBack")){
			user = alterPasword();
		}else if(operate.equals("answer")){
			user = anwser();
		}
		return user;
	}

	private User login(){
		User user = null;
		
		LoginDao loginDao = new LoginDao();
		user = loginDao.Validate(this.user.getU_id(), this.user.getPsword());
		
		return user;
	}
	
	/**
	 *@Author linhao007
	 *@Decration 用于后台管理登入
	 * @return
	 */
	private Admin adminlogin(){
		Admin admin2 = null;
		
		LoginDao loginDao = new LoginDao();
		admin2 = loginDao.adminValidate(this.admin.getAdmin(), this.admin.getPasword());
		return admin2;
	}
	
	
	
	private User enrol() {
		User user = null;
		
		LoginDao loginDao = new LoginDao();
		boolean result = loginDao.enrol(this.user);
		if(result){
			user = this.user;
		}
		
		return user;
	}

	private User forgetPw(){
		User user = null;
		
		LoginDao loginDao = new LoginDao();
		user = loginDao.Validate(this.user.getU_id());
		return user;
	}
	
	private User anwser(){
		User user = null;
		
		LoginDao loginDao = new LoginDao();
		User temp = loginDao.Validate(this.user.getU_id());
		
		String tel = TransCode.transcoding(this.user.getTel());
		String reIntor = TransCode.transcoding(this.user.getReIntro());
		String md5reIntor = MD5Util.EncoderByMd5(reIntor);
		if(tel.equals(temp.getTel()) && md5reIntor.equals(temp.getReIntro())){
			user = temp;
		}
		
		return user;
	}

	private User alterPasword(){
		User user = null;
		
		LoginDao loginDao = new LoginDao();
		boolean result = loginDao.alterPasword(this.user.getU_id(), this.user.getPsword());
		if(result){
			user = this.user;
		}
		
		return user;
	}
	
}
