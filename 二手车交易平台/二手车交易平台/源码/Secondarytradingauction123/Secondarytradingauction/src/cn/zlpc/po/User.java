package cn.zlpc.po;

import java.util.Date;

import tool.mastery.annotation.PrimaryKeyAnnotation;
import tool.mastery.annotation.TableAnnotation;

@TableAnnotation(name = "t_user")
public class User {

	private String u_id;
	private String u_name;
	private String psword;
	private String email;
	private String tel;
	private Integer r_rank;
	private Date vipTime;
	private Date paytime;
	private String reIntro;
	private String cardID;
	private String tname;
	private String u_address;

	@PrimaryKeyAnnotation(primaryKey = "u_id")
	public String getU_id() {
		return this.u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getU_address() {
		return u_address;
	}

	public void setU_address(String u_address) {
		this.u_address = u_address;
	}

	public String getU_name() {
		return this.u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getPsword() {
		return this.psword;
	}

	public void setPsword(String psword) {
		this.psword = psword;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getR_rank() {
		return r_rank;
	}

	public void setR_rank(Integer r_rank) {
		this.r_rank = r_rank;
	}


	public Date getVipTime() {
		return vipTime;
	}

	public void setVipTime(Date vipTime) {
		this.vipTime = vipTime;
	}

	public Date getPaytime() {
		return this.paytime;
	}

	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}

	public String getReIntro() {
		return this.reIntro;
	}

	public void setReIntro(String reIntro) {
		this.reIntro = reIntro;
	}

	public String getCardID() {
		return this.cardID;
	}

	public void setCardID(String cardID) {
		this.cardID = cardID;
	}

}