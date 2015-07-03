package cn.zlpc.vo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import cn.zlpc.util.ImageUtil;

import tool.mastery.annotation.Util;
import tool.mastery.exception.DBException;


public class CurrContest {
	private Integer v_id;
	private String plateNo;
	private Date regTime;
	private String vname;
	private String source;
	private Integer bidSpri;
	private Integer plusPri;
	private Date bidTime;
	private Date bidEndTime;
	private Integer beginAuction;
	private Integer stopAuction;
	private Integer peCou;
	private Integer attCou;
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

	//当前价
	private Integer hignprice;

	public Integer getBidSpri() {
		return bidSpri;
	}

	public void setBidSpri(Integer bidSpri) {
		this.bidSpri = bidSpri;
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

	public Integer getPeCou() {
		return this.peCou;
	}

	public void setPeCou(Integer peCou) {
		this.peCou = peCou;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public Integer getPlusPri() {
		return plusPri;
	}

	public void setPlusPri(Integer plusPri) {
		this.plusPri = plusPri;
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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Integer getHignprice() {
		return hignprice;
	}

	public void setHignprice(Integer hignprice) {
		this.hignprice = hignprice;
	}

	public void ConvertResultSet(ResultSet rs, CurrContest entity)
			throws DBException {
		try {
			Util util = new Util();
			while (rs.next()) {
				entity.setV_id(rs.getInt("v_id"));
				entity.setPlateNo(rs.getString("plateNo"));
				entity.setVname(rs.getString("vname"));
				entity.setRegTime(rs.getDate("regTime"));
				entity.setBidSpri(rs.getInt("bidSpri"));
				entity.setPlusPri(rs.getInt("plusPri"));
				entity.setV_source(rs.getString("v_source"));
				entity.setBidTime(util.transferStringToDate(String.valueOf(rs.getObject("bidTime"))));
				entity.setBidEndTime(util.transferStringToDate(String.valueOf(rs.getObject("bidEndTime"))));
				entity.setBeginAuction(rs.getInt("beginAuction"));
				entity.setStopAuction(rs.getInt("stopAuction"));
				entity.setSource(rs.getString("source"));
				List<String> imageList = ImageUtil.getImage(ImageUtil.GET_PATH + rs.getString("v_id")
						+ "\\", ImageUtil.SHOW_PATH + rs.getString("v_id")
						+ "/");
				if(imageList.size() != 0) {
					entity.setImagePath(imageList.get(0));
				}else {
					entity.setImagePath("img/nophoto.jpg");
				}
			}
		} catch (SQLException e) {
			throw new DBException("CurrContest类通过ResultSet转换错误！");
		}
	}

}