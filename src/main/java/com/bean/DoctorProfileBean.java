package com.bean;

public class DoctorProfileBean extends UserBean {

	int doctorprofileid;
	int userid;
	String qualification;
	String specialization;
	int experience;
	String profilepic;
	String about;
	String registerationno;

	public int getDoctorprofileid() {
		return doctorprofileid;
	}

	public void setDoctorprofileid(int doctorprofileid) {
		this.doctorprofileid = doctorprofileid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getProfilepic() {
		return profilepic;
	}

	public void setProfilepic(String profilepic) {
		this.profilepic = profilepic;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getRegisterationno() {
		return registerationno;
	}

	public void setRegisterationno(String registerationno) {
		this.registerationno = registerationno;
	}

}
