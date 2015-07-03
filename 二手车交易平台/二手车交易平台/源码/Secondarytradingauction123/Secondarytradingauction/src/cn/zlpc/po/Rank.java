package cn.zlpc.po;

import tool.mastery.annotation.PrimaryKeyAnnotation;
import tool.mastery.annotation.TableAnnotation;


@TableAnnotation(name = "t_rank")
public class Rank{
	private Integer r_rank;
	private String r_range;
	private Integer r_cmsion;

	@PrimaryKeyAnnotation(primaryKey="r_rank")
	public Integer getR_rank() {
		 return this.r_rank;
	}

	public void setR_rank(Integer r_rank) {
		this.r_rank = r_rank;
	}

	public String getR_range() {
		 return this.r_range;
	}

	public void setR_range(String r_range) {
		this.r_range = r_range;
	}

	public Integer getR_cmsion() {
		 return this.r_cmsion;
	}

	public void setR_cmsion(Integer r_cmsion) {
		this.r_cmsion = r_cmsion;
	}

}