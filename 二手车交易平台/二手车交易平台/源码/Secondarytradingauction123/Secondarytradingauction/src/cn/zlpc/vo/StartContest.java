package cn.zlpc.vo;


public class StartContest{
	private Integer bid_id;
	private Integer v_id;
	private String plateNo;
	private Integer attCou;
	private String vname;
	private Integer bidSpri;
	private Integer plusPri;
	private Integer applyCou;
    private Integer beginAuction;
    private Integer stopAuction;
    private String bidTime;
    private String bidEndTime;
    private Integer allowCou;
	public Integer getAllowCou() {
		return allowCou;
	}

	public void setAllowCou(Integer allowCou) {
		this.allowCou = allowCou;
	}

	public String getBidTime() {
		return bidTime;
	}

	public void setBidTime(String bidTime) {
		this.bidTime = bidTime;
	}

	public String getBidEndTime() {
		return bidEndTime;
	}

	public void setBidEndTime(String bidEndTime) {
		this.bidEndTime = bidEndTime;
	}

	public Integer getStopAuction() {
		return stopAuction;
	}

	public void setStopAuction(Integer stopAuction) {
		this.stopAuction = stopAuction;
	}

	public Integer getBeginAuction() {
		return beginAuction;
	}

	public void setBeginAuction(Integer beginAuction) {
		this.beginAuction = beginAuction;
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

	public Integer getApplyCou() {
		 return this.applyCou;
	}

	public void setApplyCou(Integer applyCou) {
		this.applyCou = applyCou;
	}
	public Integer getBid_id() {
		return bid_id;
	}

	public void setBid_id(Integer bid_id) {
		this.bid_id = bid_id;
	}

}