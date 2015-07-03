package cn.zlpc.vo;

/**
 * 修改了此vo，添加了u_id，修改了rank和deadline的数据类型
 * @author mastery
 * @Time 2014-10-22 下午4:15:28
 * 
 */
public class ContestApply{
	private String u_id;
	private String tname;
	private String rank;
	private String vname;
	private Integer v_id;
	private String plateNo;
	private Integer bidSpri;
	private Integer plusPri;

	
	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getTname() {
		 return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getRank() {
		 return this.rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getVname() {
		 return this.vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public Integer getV_id() {
		 return this.v_id;
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