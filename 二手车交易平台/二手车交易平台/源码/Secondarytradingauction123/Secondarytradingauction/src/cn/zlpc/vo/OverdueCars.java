package cn.zlpc.vo;

import java.util.Date;

public class OverdueCars{
	private Integer v_id;
	private String plateNo;
	private Integer attCou;
	private String vname;
	private String isSuccess;
	private Date bidTime;
	private Integer partCou;

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

	public Integer getAttCou() {
		 return this.attCou;
	}

	public void setAttCou(Integer attCou) {
		this.attCou = attCou;
	}

	public String getVname() {
		 return this.vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getIsSuccess() {
		 return this.isSuccess;
	}

	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Date getBidTime() {
		 return this.bidTime;
	}

	public void setBidTime(Date bidTime) {
		this.bidTime = bidTime;
	}

	public Integer getPartCou() {
		 return this.partCou;
	}

	public void setPartCou(Integer partCou) {
		this.partCou = partCou;
	}

}