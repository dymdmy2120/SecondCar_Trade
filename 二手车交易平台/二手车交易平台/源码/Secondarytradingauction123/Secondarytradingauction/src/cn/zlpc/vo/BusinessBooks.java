package cn.zlpc.vo;

import java.util.Date;

public class BusinessBooks {
	private Date bidtime;
	private Integer v_id;
	private String plateNo;
	private String source;
	private String bspri;
	private String state;
	private String price;
	private String tname;
	private int counts;
	public Date getBidtime() {
		return bidtime;
	}
	public void setBidtime(Date bidtime) {
		this.bidtime = bidtime;
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
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getBspri() {
		return bspri;
	}
	public void setBspri(String bspri) {
		this.bspri = bspri;
	}
	@Override
	public String toString() {
		return "BusinessBooks [bidtime=" + bidtime + ", v_id=" + v_id
				+ ", source=" + source + ", bSpri=" + bspri + ", state="
				+ state + ", price=" + price + ", tname=" + tname + ", counts="
				+ counts + "]";
	}
}
