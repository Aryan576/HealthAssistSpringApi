package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.Doctor_ClinicBean;

@Repository
public class Doctor_Clinicdao {

	@Autowired
	JdbcTemplate stmt;

	public void addDoctorClinic(Doctor_ClinicBean bean) {
		// TODO Auto-generated method stub
		stmt.update(
				"insert into doctorclinic (doctorid,clinicid,mon,tue,wed,thru,fri,sat,sun,threshold) values(?,?,?,?,?,?,?,?,?,?)",
				bean.getDoctorid(), bean.getClinicid(), bean.getMon(), bean.getTue(), bean.getWed(), bean.getThru(),
				bean.getFri(), bean.getSat(), bean.getSun(), bean.getThreshold());
	}

}
