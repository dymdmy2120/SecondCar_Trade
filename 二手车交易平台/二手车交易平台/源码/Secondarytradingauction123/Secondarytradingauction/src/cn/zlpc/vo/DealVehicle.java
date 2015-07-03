package cn.zlpc.vo;

import java.util.Date;

/**
 * 会员中心，成交车辆信息；
 * 
 * @author 没名堂
 */
public class DealVehicle {
	private Integer v_id;
	private String plateNo;
	// 车辆简介
	private String downprice;// 竞拍底价
	private String vname;
	private String margin;// 保证金
	private Date fristregist;// 初次登记时间
	private String header;
	// 车辆简介
	private String source;// 车辆来源
	private String servicefee;// 服务费
	private String myprice;// 我的出价
	private String imagePath;
	private String v_source;
	

	public String getV_source() {
		return v_source;
	}

	public void setV_source(String v_source) {
		this.v_source = v_source;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getDownprice() {
		return downprice;
	}

	public void setDownprice(String downprice) {
		this.downprice = downprice;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getMargin() {
		return margin;
	}

	public void setMargin(String margin) {
		this.margin = margin;
	}

	public Date getFristregist() {
		return fristregist;
	}

	public void setFristregist(Date fristregist) {
		this.fristregist = fristregist;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getServicefee() {
		return servicefee;
	}

	public void setServicefee(String servicefee) {
		this.servicefee = servicefee;
	}

	public String getMyprice() {
		return myprice;
	}

	public void setMyprice(String myprice) {
		this.myprice = myprice;
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

}
