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

	public void addCities(CityBean citiesBean) {
		// TODO Auto-generated method stub
		stmt.update("insert into city(cityname,stateid) values(?,?)", citiesBean.getCityname(),
				citiesBean.getStateid());
	}

	public List<CityBean> listCities() {
		// TODO Auto-generated method stub
		java.util.List<CityBean> citiesBean = stmt.query(
				"select *,states.statename from city as s join states using(stateid) where s.stateid = stateid and s.isdeleted=0",
				BeanPropertyRowMapper.newInstance(CityBean.class));
		return citiesBean;
	}

	public void deleteCities(int cityId) {
		// TODO Auto-generated method stub
		stmt.update("update city set isdeleted = 1 where cityid = ?", cityId);
	}

	public void updateCities(CityBean cityBean) {
		// TODO Auto-generated method stub
		stmt.update("update city set cityname=?,stateid=? where cityid=?", cityBean.getCityname(),
				cityBean.getStateid(), cityBean.getCityid());
	}

	public CityBean getCityById(int cityid) {
		// TODO Auto-generated method stub
		CityBean bean = null;
		try {
			bean = stmt.queryForObject(
					"select *,states.statename from city as s join states using(stateid) where s.stateid = stateid and cityid=?",
					new Object[] { cityid }, BeanPropertyRowMapper.newInstance(CityBean.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bean;
	}
}
