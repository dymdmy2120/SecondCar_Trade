package cn.zlpc.po;

import tool.mastery.annotation.PrimaryKeyAnnotation;
import tool.mastery.annotation.TableAnnotation;

@TableAnnotation(name = "t_card")
public class Card {
	private Integer c_id;
	private String card_id;
	private String address;
	private String c_owner;
	private String c_type;

	@PrimaryKeyAnnotation(primaryKey = "c_id")
	public Integer getC_id() {
		return c_id;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	public String getCard_id() {
		return this.card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getC_owner() {
		return c_owner;
	}

	public void setC_owner(String c_owner) {
		this.c_owner = c_owner;
	}

	public String getC_type() {
		return c_type;
	}

	public void setC_type(String c_type) {
		this.c_type = c_type;
	}

}