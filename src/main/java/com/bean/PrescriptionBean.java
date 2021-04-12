package com.bean;

import java.sql.Date;

public class PrescriptionBean {
	
	int prescriptionid;
	int patientprofileid;
	int doctorprofileid;
	int appointmentid;
	String description;
	Date prescriptiondate;
	String generaladvice;
	String followupcomment;
	int medicineid;
	String frequency;
	String duration;
	String instructions;
	
	

	public int getPrescriptionid() {
		return prescriptionid;
	}

	public void setPrescriptionid(int prescriptionid) {
		this.prescriptionid = prescriptionid;
	}

	public int getPatientprofileid() {
		return patientprofileid;
	}

	public void setPatientprofileid(int patientprofileid) {
		this.patientprofileid = patientprofileid;
	}

	public int getDoctorprofileid() {
		return doctorprofileid;
	}

	public void setDoctorprofileid(int doctorprofileid) {
		this.doctorprofileid = doctorprofileid;
	}

	public int getAppointmentid() {
		return appointmentid;
	}

	public void setAppointmentid(int appointmentid) {
		this.appointmentid = appointmentid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPrescriptiondate() {
		return prescriptiondate;
	}

	public void setPrescriptiondate(Date prescriptiondate) {
		this.prescriptiondate = prescriptiondate;
	}

	public String getGeneraladvice() {
		return generaladvice;
	}

	public void setGeneraladvice(String generaladvice) {
		this.generaladvice = generaladvice;
	}

	public String getFollowupcomment() {
		return followupcomment;
	}

	public void setFollowupcomment(String followupcomment) {
		this.followupcomment = followupcomment;
	}

	public int getMedicineid() {
		return medicineid;
	}

	public void setMedicineid(int medicineid) {
		this.medicineid = medicineid;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
}
