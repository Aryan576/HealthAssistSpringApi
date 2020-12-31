package com.bean;

import java.util.Date;

public class BookAppointmentBean {

	int appointmentid;

	int patientid;
	int doctorid;
	int statusid;
	Date app_create_date;
	String comment;
	int clinicid;
	String reference;
	String complain;

	Date appointMentDate;
	String appointMentTime;
	
	
	public int getAppointmentid() {
		return appointmentid;
	}
	public void setAppointmentid(int appointmentid) {
		this.appointmentid = appointmentid;
	}
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public int getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}
	public int getStatusid() {
		return statusid;
	}
	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}
	public Date getApp_create_date() {
		return app_create_date;
	}
	public void setApp_create_date(Date app_create_date) {
		this.app_create_date = app_create_date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getClinicid() {
		return clinicid;
	}
	public void setClinicid(int clinicid) {
		this.clinicid = clinicid;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getComplain() {
		return complain;
	}
	public void setComplain(String complain) {
		this.complain = complain;
	}
	public Date getAppointMentDate() {
		return appointMentDate;
	}
	public void setAppointMentDate(Date appointMentDate) {
		this.appointMentDate = appointMentDate;
	}
	public String getAppointMentTime() {
		return appointMentTime;
	}
	public void setAppointMentTime(String appointMentTime) {
		this.appointMentTime = appointMentTime;
	}

	

}