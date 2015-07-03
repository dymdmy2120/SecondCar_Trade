package cn.zlpc.po;

import java.util.Date;

import tool.mastery.annotation.PrimaryKeyAnnotation;
import tool.mastery.annotation.TableAnnotation;

@TableAnnotation(name = "t_bid")
public class Bid {
	private Integer bid_id;
	private Date bidTime;
	private Integer bidSpri;
	private Integer plusPri;
	private Date bidEndTime;
	private Integer beginAuction;
	private Integer stopAuction;
	private Integer v_id;

	@PrimaryKeyAnnotation(primaryKey = "bid_id")
	public Integer getBid_id() {
		return this.bid_id;
	}

	public void setBid_id(Integer bid_id) {
		this.bid_id = bid_id;
	}

	public Date getBidTime() {
		return this.bidTime;
	}

	public void setBidTime(Date bidTime) {
		this.bidTime = bidTime;
	}

	public Integer getBidSpri() {
		return bidSpri;
	}

	public void setBidSpri(Integer bidSpri) {
		this.bidSpri = bidSpri;
	}

	public Integer getPlusPri() {
		return this.plusPri;
	}

	public void setPlusPri(Integer plusPri) {
		this.plusPri = plusPri;
	}

	public Date getBidEndTime() {
		return this.bidEndTime;
	}

	public void setBidEndTime(Date bidEndTime) {
		this.bidEndTime = bidEndTime;
	}
	
	public Integer getBeginAuction() {
		return beginAuction;
	}

	public void setBeginAuction(Integer beginAuction) {
		this.beginAuction = beginAuction;
	}

	public Integer getStopAuction() {
		return stopAuction;
	}

	public void setStopAuction(Integer stopAuction) {
		this.stopAuction = stopAuction;
	}

	public Integer getV_id() {
		return v_id;
	}

	public void setV_id(Integer v_id) {
		this.v_id = v_id;
	}
	

}