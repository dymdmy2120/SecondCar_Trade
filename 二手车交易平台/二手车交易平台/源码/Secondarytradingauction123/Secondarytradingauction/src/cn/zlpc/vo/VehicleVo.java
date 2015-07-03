package cn.zlpc.vo;

import java.util.Date;

import cn.zlpc.po.Vehicle;

public class VehicleVo extends Vehicle{
	
	private Integer v_id;
	private String plateNo;
	private String note;
	private String loc;
	private String vname;
	private Date regTime;
	private String pledge;
	private String version;
	private Integer gear;
	private String vframe;
	private String motor;
	private String gearBox;
	private String output;
	private String mairSac;
	private String sairSac;
	private String tel;
	private String source;
	
	private int attentionCounts;
	private String strfBroke;
	private String strfTransfer;
	private String strfDisass;
	private String strfAgain;
	private String strfBRule;
	private String strfMort;
	public int getAttentionCounts() {
		return attentionCounts;
	}

	public void setAttentionCounts(int attentionCounts) {
		this.attentionCounts = attentionCounts;
	}

	public String getfBroke() {
		return strfBroke;
	}

	public void setfBroke(String strfBroke) {
		this.strfBroke = strfBroke;
	}

	public String getStrfBroke() {
		return strfBroke;
	}

	public void setStrfBroke(String strfBroke) {
		this.strfBroke = strfBroke;
	}

	public String getStrfTransfer() {
		return strfTransfer;
	}

	public void setStrfTransfer(String strfTransfer) {
		this.strfTransfer = strfTransfer;
	}

	public String getStrfDisass() {
		return strfDisass;
	}

	public void setStrfDisass(String strfDisass) {
		this.strfDisass = strfDisass;
	}

	public String getStrfAgain() {
		return strfAgain;
	}

	public void setStrfAgain(String strfAgain) {
		this.strfAgain = strfAgain;
	}

	public String getStrfBRule() {
		return strfBRule;
	}

	public void setStrfBRule(String strfBRule) {
		this.strfBRule = strfBRule;
	}

	public String getStrfMort() {
		return strfMort;
	}

	public void setStrfMort(String strfMort) {
		this.strfMort = strfMort;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
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

	public String getPledge() {
		return pledge;
	}

	public void setPledge(String pledge) {
		this.pledge = pledge;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Integer getGear() {
		return gear;
	}

	public void setGear(Integer gear) {
		this.gear = gear;
	}

	public String getVframe() {
		return vframe;
	}

	public void setVframe(String vframe) {
		this.vframe = vframe;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getGearBox() {
		return gearBox;
	}

	public void setGearBox(String gearBox) {
		this.gearBox = gearBox;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getMairSac() {
		return mairSac;
	}

	public void setMairSac(String mairSac) {
		this.mairSac = mairSac;
	}

	public String getSairSac() {
		return sairSac;
	}

	public void setSairSac(String sairSac) {
		this.sairSac = sairSac;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
}
