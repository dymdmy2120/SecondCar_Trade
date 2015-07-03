package cn.zlpc.po;

import java.util.Date;

import tool.mastery.annotation.PrimaryKeyAnnotation;
import tool.mastery.annotation.TableAnnotation;

@TableAnnotation(name="t_notice")
public class Notice {
	private Integer n_id;
	private String content;
	private String title;
	private Date n_time = new Date();

	@PrimaryKeyAnnotation(primaryKey="n_id")
	public Integer getN_id() {
		 return this.n_id;
	}

	public void setN_id(Integer n_id) {
		this.n_id = n_id;
	}

	public String getContent() {
		 return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		 return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getN_time() {
		 return this.n_time;
	}

	public void setN_time(Date n_time) {
		this.n_time = n_time;
	}

}