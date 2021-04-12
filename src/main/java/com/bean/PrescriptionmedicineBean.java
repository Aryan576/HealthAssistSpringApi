package com.bean;

public class PrescriptionmedicineBean  extends PrescriptionBean{

	int prescriptionmedicineid;
	int prescriptionid;
	int medicineid;
	String frequency;
	String duration;
	String instructions;
	
	
	public int getPrescriptionmedicineid() {
		return prescriptionmedicineid;
	}
	public void setPrescriptionmedicineid(int prescriptionmedicineid) {
		this.prescriptionmedicineid = prescriptionmedicineid;
	}
	public int getPrescriptionid() {
		return prescriptionid;
	}
	public void setPrescriptionid(int prescriptionid) {
		this.prescriptionid = prescriptionid;
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
