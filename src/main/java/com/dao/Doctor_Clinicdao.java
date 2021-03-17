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

	public List<Doctor_ClinicBean> listDoctCLinic(int userid) {
		// TODO Auto-generated method stub
		 List<Doctor_ClinicBean> doctClinicBean = stmt.query("select dc.*,dp.userid,cli.clinicname,u.firstname from doctorclinic as dc,clinic cli,doctorprofile as dp,users as u where dp.userid = dc.doctorid and cli.clinicid = dc.clinicid and u.userid = dp.userid and dc.isdeleted =0 and u.userid=?",new Object[] {userid},BeanPropertyRowMapper.newInstance(Doctor_ClinicBean.class));
			return doctClinicBean;
		
	}

}
