package cn.zlpc.vo;

import java.util.Date;



/**
 * 修改了此vo，添加了u_id，修改了rank和deadline的数据类型
 * @author mastery
 * @Time 2014-10-22 下午4:12:45
 * 
 */
public class UserDelete{
	private String u_id;
	private String tname;
	private String rank;
	private Integer sucesCou;
	private Integer partCou;
	private Integer attCou;
	private String tel;
	private String email;
	private String deadline;
	private Date paytime;

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getTname() {
		 return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}
	
	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Integer getSucesCou() {
		 return this.sucesCou;
	}

	public void setSucesCou(Integer sucesCou) {
		this.sucesCou = sucesCou;
	}

	public Integer getPartCou() {
		 return this.partCou;
	}

	public void setPartCou(Integer partCou) {
		this.partCou = partCou;
	}

	public Integer getAttCou() {
		 return this.attCou;
	}

	public void setAttCou(Integer attCou) {
		this.attCou = attCou;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public Date getPaytime() {
		 return this.paytime;
	}

	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}