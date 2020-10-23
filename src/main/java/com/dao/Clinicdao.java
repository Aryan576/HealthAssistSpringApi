package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ClinicBean;

@Repository
public class Clinicdao {
	@Autowired
	JdbcTemplate stmt;

	public void adddoctor(ClinicBean clinicBean) {
		// TODO Auto-generated method stub

		stmt.update(
				"insert clinic (clinicname,opentiming,closetiming,address,phoneno,rating,about,lat,log,cityId, stateId,pincode) values(?,?,?,?,?,?,?,?,?,?,?,?) ",
				clinicBean.getClinicname(), clinicBean.getOpentiming(), clinicBean.getClosetiming(),
				clinicBean.getAddress(), clinicBean.getPhoneno(), clinicBean.getRating(), clinicBean.getAbout(),
				clinicBean.getLat(), clinicBean.getLog(), clinicBean.getCityId(), clinicBean.getStateId(),
				clinicBean.getPincode());

	}

}
