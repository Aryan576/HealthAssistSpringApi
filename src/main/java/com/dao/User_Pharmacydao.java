package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.User_PharmacyBean;

@Repository
public class User_Pharmacydao {
	@Autowired
	JdbcTemplate stmt;

	public void adduserpharmacy(User_PharmacyBean bean) {
		// TODO Auto-generated method stub

		stmt.update("insert into userpharmacy (userid,pharmacyid) values(?,?)", bean.getUserid(), bean.getPharmacyid());

	}

	public List<User_PharmacyBean> listuser() {
		// TODO Auto-generated method stub
		List<User_PharmacyBean> bean = stmt.query("select * from userpharmacy",
				BeanPropertyRowMapper.newInstance(User_PharmacyBean.class));
		return bean;
	}
}
