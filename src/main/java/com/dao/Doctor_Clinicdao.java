package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

	public List<Doctor_ClinicBean> listDoctCLinic() {
		// TODO Auto-generated method stub
		 List<Doctor_ClinicBean> doctClinicBean = stmt.query("select *,clinic.clinicname from doctorclinic as dc join clinic using(clinicid) where dc.clinicid = clinicid and dc.isdeleted = 0",BeanPropertyRowMapper.newInstance(Doctor_ClinicBean.class));
			return doctClinicBean;
		
	}

}
