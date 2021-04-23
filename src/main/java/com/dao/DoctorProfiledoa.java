package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.DoctorProfileBean;

@Repository
public class DoctorProfiledoa {

	@Autowired
	JdbcTemplate stmt;

	public List<DoctorProfileBean> listdoctor() {
		List<DoctorProfileBean> DoctorBean = stmt.query(
				"select * from doctorprofile as d join users using(userid) where userid = d.userid and d.isdeleted = 0",
				BeanPropertyRowMapper.newInstance(DoctorProfileBean.class));
		// TODO Auto-generated method stub
		return DoctorBean;
	}

	public DoctorProfileBean getDoctorById(int userid) {
		// TODO Auto-generated method stub
		DoctorProfileBean bean = null;
		try {
			bean = stmt.queryForObject(
					"select * from doctorprofile as d join users using(userid) where userid = d.userid and userid=?",
					new Object[] { userid }, BeanPropertyRowMapper.newInstance(DoctorProfileBean.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return bean;

	}

	public void addDoctor(DoctorProfileBean db) {
		// TODO Auto-generated method stub

	}

	public void updatedoctor(DoctorProfileBean bean) {
		// TODO Auto-generated method stub

		stmt.update(
				"update doctorprofile set qualification=?,specialization=?,experience=?,profilepic=?,about=?,registrationno=? where userid=?",
				bean.getQualification(), bean.getSpecialization(), bean.getExperience(), bean.getProfilepic(),
				bean.getAbout(), bean.getRegisterationno(), bean.getUserid());

		stmt.update(
				"update users set email = ?,password = ?,firstname = ?,lastname = ?,gender = ?,status=? where userid = ?",
				bean.getEmail(), bean.getPassword(), bean.getFirstname(), bean.getLastname(), bean.getGender(),
				bean.getStatus(), bean.getUserid());

	}

	public DoctorProfileBean deleteDoctor(int userid) {
		// TODO Auto-generated method stub
		DoctorProfileBean bean = null;
		bean = getDoctorById(userid);
		if (bean != null) {
			stmt.update("update doctorprofile set isdeleted = 1 where userid=?", userid);

		}

		return bean;
	}

	public List<DoctorProfileBean> kycDoctor() {
		// TODO Auto-generated method stub
		java.util.List<DoctorProfileBean> DoctorBean = stmt.query("select u.*,d.*,d.doctorprofileid as docProfileId from doctorprofile as d join users u using(userid) where userid = d.userid and d.isdeleted=0 and u.status=5", BeanPropertyRowMapper.newInstance(DoctorProfileBean.class));
		return DoctorBean;
	}

	public List<DoctorProfileBean> activeDoctor() {
		java.util.List<DoctorProfileBean> DoctorBean = stmt.query("select u.*,d.*,d.doctorprofileid as docProfileId from doctorprofile as d join users u using(userid) where userid = d.userid and d.isdeleted=0 and u.status=1", BeanPropertyRowMapper.newInstance(DoctorProfileBean.class));
		return DoctorBean;
	}

	public List<DoctorProfileBean> pendingDoctor() {
		java.util.List<DoctorProfileBean> DoctorBean = stmt.query("select u.*,d.*,d.doctorprofileid as docProfileId from doctorprofile as d join users u using(userid) where userid = d.userid and d.isdeleted=0 and u.status=2", BeanPropertyRowMapper.newInstance(DoctorProfileBean.class));
		return DoctorBean;
	}

	public List<DoctorProfileBean> pauseDoctor() {
		java.util.List<DoctorProfileBean> DoctorBean = stmt.query("select u.*,d.*,d.doctorprofileid as docProfileId from doctorprofile as d join users u using(userid) where userid = d.userid and d.isdeleted=0 and u.status=4", BeanPropertyRowMapper.newInstance(DoctorProfileBean.class));
		return DoctorBean;
	}
}
