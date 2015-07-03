package cn.zlpc.po;

import tool.mastery.annotation.PrimaryKeyAnnotation;
import tool.mastery.annotation.TableAnnotation;


@TableAnnotation(name = "t_admin")
public class Admin{
	private String admin;
	private String pasword;
	
	@PrimaryKeyAnnotation(primaryKey="admin")
	public String getAdmin() {
		 return this.admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getPasword() {
		 return this.pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

}