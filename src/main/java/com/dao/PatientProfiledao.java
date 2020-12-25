package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.PathologyBean;
import com.bean.PatientProfileBean;

@Repository
public class PatientProfiledao {

	@Autowired
	JdbcTemplate stmt;

	public void addpatientprofile(PatientProfileBean bean) {
		// TODO Auto-generated method stub

		stmt.update(
				"insert into patientprofile (patientname,gender,phoneno,email,age,profilepic,cityid,stateid,pincode) values(?,?,?,?,?,?,?,?,?)",
				bean.getPatientname(), bean.getGender(), bean.getPhoneno(), bean.getEmail(), bean.getAge(),
				bean.getProfilePic(), bean.getCityid(), bean.getStateid(), bean.getPincode());

	}

	public List<PatientProfileBean> listprofile() {
		// TODO Auto-generated method stub

		List<PatientProfileBean> bean = stmt.query("select * from patientprofile",
				BeanPropertyRowMapper.newInstance(PatientProfileBean.class));
		return bean;
	}

	public PatientProfileBean deletepatientprofile(int patientid) {
		// TODO Auto-generated method stub
		PatientProfileBean bean = null;

		bean = getPatientProfileById(patientid);
		if (bean != null) {
			stmt.update("delete from patientprofile where patientid=?", patientid);
		}

		return bean;
	}

	private PatientProfileBean getPatientProfileById(int patientid) {
		// TODO Auto-generated method stub

		PatientProfileBean bean = null;
		try {
			bean = stmt.queryForObject("select * from patientprofile where patientid=?", new Object[] { patientid },
					BeanPropertyRowMapper.newInstance(PatientProfileBean.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return bean;

	}

	public void updatepatientprofile(PatientProfileBean bean) {
		// TODO Auto-generated method stub
		stmt.update(
				"update patientprofile set patientname=?,gender=?,phoneno=?,email=?,age=?,profilePic=?,cityid=?,stateid =?,pincode=? where patientid=? ",
				bean.getPatientname(), bean.getGender(), bean.getPhoneno(), bean.getEmail(), bean.getAge(),
				bean.getProfilePic(), bean.getCityid(), bean.getStateid(), bean.getPincode(), bean.getPatientid());

		

	}

}
