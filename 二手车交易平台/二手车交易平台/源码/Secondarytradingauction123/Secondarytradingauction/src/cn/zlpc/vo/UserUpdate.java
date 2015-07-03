package cn.zlpc.vo;

/**
 * 用户修改密码的vo
 * @author mastery
 * @Time 2014-10-24 下午8:02:19
 * 
 */
public class UserUpdate {
	private String u_id;
	private String oldPassword;
	private String newPassword;
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}