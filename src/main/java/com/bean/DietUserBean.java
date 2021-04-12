package com.bean;

public class DietUserBean {

	int userid;
	int dietid;
	String diettype;
	String dietcontent;
	String agegroup;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getDietid() {
		return dietid;
	}

	public void setDietid(int dietid) {
		this.dietid = dietid;
	}

	public String getDiettype() {
		return diettype;
	}

	public void setDiettype(String diettype) {
		this.diettype = diettype;
	}

	public String getDietcontent() {
		return dietcontent;
	}

	public void setDietcontent(String dietcontent) {
		this.dietcontent = dietcontent;
	}

	public String getAgegroup() {
		return agegroup;
	}

	public void setAgegroup(String agegroup) {
		this.agegroup = agegroup;
	}

}
