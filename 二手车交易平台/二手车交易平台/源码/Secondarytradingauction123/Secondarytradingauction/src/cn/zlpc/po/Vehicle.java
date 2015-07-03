package cn.zlpc.po;

import java.util.Date;

import tool.mastery.annotation.PrimaryKeyAnnotation;
import tool.mastery.annotation.TableAnnotation;

@TableAnnotation(name="t_vehicle")
public class Vehicle{
	private Integer v_id;
	private String plateNo;
	private String note;
	private String loc;
	private String vname;
	private Date regTime;
	private String pledge;
	private String v_version;
	private Integer gear;
	private String vframe;
	private String motor;
	private String gearBox;
	private String output;
	private String mairSac;
	private String sairSac;
	private Integer fbroke;
	private Integer ftransfer;
	private Integer fdisass;
	private Integer fagain;
	private Integer fbrule;
	private Integer fmort;
	private String tel;
	private String source;
	private String v_source;

	@PrimaryKeyAnnotation(primaryKey = "v_id")
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

	public String getV_version() {
		return v_version;
	}

	public void setV_version(String v_version) {
		this.v_version = v_version;
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

	public Integer getFbroke() {
		return fbroke;
	}

	public void setFbroke(Integer fbroke) {
		this.fbroke = fbroke;
	}

	public Integer getFtransfer() {
		return ftransfer;
	}

	public void setFtransfer(Integer ftransfer) {
		this.ftransfer = ftransfer;
	}

	public Integer getFdisass() {
		return fdisass;
	}

	public void setFdisass(Integer fdisass) {
		this.fdisass = fdisass;
	}

	public Integer getFagain() {
		return fagain;
	}

	public void setFagain(Integer fagain) {
		this.fagain = fagain;
	}

	public Integer getFbrule() {
		return fbrule;
	}

	public void setFbrule(Integer fbrule) {
		this.fbrule = fbrule;
	}

	public Integer getFmort() {
		return fmort;
	}

	public void setFmort(Integer fmort) {
		this.fmort = fmort;
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

	public String getV_source() {
		return v_source;
	}

	public void setV_source(String v_source) {
		this.v_source = v_source;
	}

}