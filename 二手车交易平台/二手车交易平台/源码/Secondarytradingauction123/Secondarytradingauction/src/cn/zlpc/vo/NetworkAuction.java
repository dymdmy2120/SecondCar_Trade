package cn.zlpc.vo;

import java.util.Date;

public class NetworkAuction {
	private Integer v_id;
	private String plateNo;
	private String vname;
	private Date regTime;
	private Date bidTime;
	private Date bidEndTime;
	private String attation;
	private String announcement;
	private String discount;// 默认为无
	private String pledge;
	private Integer plusPri;
	private Integer bSpri;
	private Date countdown;// 倒计时
	private Integer current_price;
private String v_source;
	

	public String getV_source() {
		return v_source;
	}

	public void setV_source(String v_source) {
		this.v_source = v_source;
	}

	public Integer getV_id() {
		return v_id;
	}

	public void setV_id(Integer v_id) {
		this.v_id = v_id;
	}

	public String getPlateNo() {
		return plateNo;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public Date getBidTime() {
		return bidTime;
	}

	public void setBidTime(Date bidTime) {
		this.bidTime = bidTime;
	}

	public Date getBidEndTime() {
		return bidEndTime;
	}

	public void setBidEndTime(Date bidEndTime) {
		this.bidEndTime = bidEndTime;
	}

	public String getAttation() {
		return attation;
	}

	public void setAttation(String attation) {
		this.attation = attation;
	}

	public String getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getPledge() {
		return pledge;
	}

	public void setPledge(String pledge) {
		this.pledge = pledge;
	}

	public Integer getPlusPri() {
		return plusPri;
	}

	public void setPlusPri(Integer plusPri) {
		this.plusPri = plusPri;
	}

	public Integer getbSpri() {
		return bSpri;
	}

	public void setbSpri(Integer bSpri) {
		this.bSpri = bSpri;
	}

	public Date getCountdown() {
		return countdown;
	}

	public void setCountdown(Date countdown) {
		this.countdown = countdown;
	}

	public Integer getCurrent_price() {
		return current_price;
	}

	public void setCurrent_price(Integer current_price) {
		this.current_price = current_price;
	}

}
