package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.CityBean;

@Repository
public class Citydao {
	@Autowired
	JdbcTemplate stmt;

	public void addcity(CityBean bean) {
		// TODO Auto-generated method stub

		stmt.update("insert into city(cityname,stateid) values(?,?)", bean.getCityname(), bean.getStateid());

	}

	public List<CityBean> getCity() {
		// TODO Auto-generated method stub
		List<CityBean> bean = stmt.query("select * from city", BeanPropertyRowMapper.newInstance(CityBean.class));
		return bean;
	}
}
