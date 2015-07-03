package cn.zlpc.po;

import tool.mastery.annotation.PrimaryKeyAnnotation;
import tool.mastery.annotation.TableAnnotation;

@TableAnnotation(name="t_sourceimg")
public class SourceImg {
	
	private Integer simg_id;
	private String simg_name;
	private String simg_path;
	
	@PrimaryKeyAnnotation(primaryKey="simg_id")
	public Integer getSimg_id() {
		return simg_id;
	}
	public void setSimg_id(Integer simg_id) {
		this.simg_id = simg_id;
	}
	public String getSimg_name() {
		return simg_name;
	}
	public void setSimg_name(String simg_name) {
		this.simg_name = simg_name;
	}
	public String getSimg_path() {
		return simg_path;
	}
	public void setSimg_path(String simg_path) {
		this.simg_path = simg_path;
	}
	
}
