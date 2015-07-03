package cn.zlpc.vo;

import java.util.Date;

public class AuctionTimeSetting {
	
	private Integer v_id;
	private String plateNo;
	private String vname;
	private Integer bid_id;
	private Integer stopAuction;
	private Date bidTime;
	private Date bidEndTime;
	private Integer plusPri;//竞拍加价
	private Integer bidSpri;//竞拍底价
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public Integer getStopAuction() {
		return stopAuction;
	}
	public void setStopAuction(Integer stopAuction) {
		this.stopAuction = stopAuction;
	}
	
	
	public Integer getBid_id() {
		return bid_id;
	}
	public void setBid_id(Integer bid_id) {
		this.bid_id = bid_id;
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
	public Integer getPlusPri() {
		return plusPri;
	}
	public void setPlusPri(Integer plusPri) {
		this.plusPri = plusPri;
	}
	public Integer getBidSpri() {
		return bidSpri;
	}
	public void setBidSpri(Integer bidSpri) {
		this.bidSpri = bidSpri;
	}
	
	

}
