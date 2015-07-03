package cn.zlpc.vo;

import java.util.Date;

public class PrTaNotice {
	private Integer v_id;
	private String plateNo;//车辆编号
	private String vname;//车辆名称
	private Integer bidSpri;//底价
	private String pledge;//保证金
	private String source;//车源地
	private Date regTime;//初次登记时间
	private Date bidTime;//竞拍时间
	private Date bidEndTime;//竞价结束时间
	private Integer attCout;	//关注次数
	private String imageName;
	private Integer stopAuction;
	private String v_source;
	
	public Date getBidEndTime() {
		return bidEndTime;
	}
	public void setBidEndTime(Date bidEndTime) {
		this.bidEndTime = bidEndTime;
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

	public Integer getBidSpri() {
		return bidSpri;
	}
	public void setBidSpri(Integer bidSpri) {
		this.bidSpri = bidSpri;
	}
	public String getPledge() {
		return pledge;
	}
	public void setPledge(String pledge) {
		this.pledge = pledge;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
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
	public Integer getAttCout() {
		return attCout;
	}
	public void setAttCout(Integer attCout) {
		this.attCout = attCout;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public Integer getStopAuction() {
		return stopAuction;
	}
	public void setStopAuction(Integer stopAuction) {
		this.stopAuction = stopAuction;
	}
	public String getV_source() {
		return v_source;
	}
	public void setV_source(String v_source) {
		this.v_source = v_source;
	}

}
