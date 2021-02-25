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

	public void addDoctor(DoctorProfileBean db) {
		
	
	
		
	}

	public List<DoctorProfileBean> listdoctor() {
		List<DoctorProfileBean> DoctorBean = stmt.query("select * from doctorprofile as d join users using(userid) where userid = d.userid",BeanPropertyRowMapper.newInstance(DoctorProfileBean.class));
		// TODO Auto-generated method stub
		return DoctorBean;
	}
	
	
}
