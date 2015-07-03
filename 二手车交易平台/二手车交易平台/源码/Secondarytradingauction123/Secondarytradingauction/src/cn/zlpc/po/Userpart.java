package cn.zlpc.po;

import java.util.Date;

import tool.mastery.annotation.PrimaryKeyAnnotation;
import tool.mastery.annotation.TableAnnotation;

@TableAnnotation(name = "t_userpart")
public class Userpart {
	private String u_id;
	private Integer v_id;
	private String pledge;
	private String price;
	private Integer state;
	private Date currentTime;
	private Integer attention;

	@PrimaryKeyAnnotation(primaryKey = "u_id")
	public String getU_id() {
		return this.u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	@PrimaryKeyAnnotation(primaryKey = "v_id")
	public Integer getV_id() {
		return this.v_id;
	}

	public void setV_id(Integer v_id) {
		this.v_id = v_id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCurrentTime() {
		return this.currentTime;
	}

	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}

	public Integer getAttention() {
		return attention;
	}

	public void setAttention(Integer attention) {
		this.attention = attention;
	}

	public String getPledge() {
		return pledge;
	}

	public void setPledge(String pledge) {
		this.pledge = pledge;
	}

	
}