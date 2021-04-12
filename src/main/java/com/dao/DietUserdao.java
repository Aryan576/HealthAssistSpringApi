package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.DietUserBean;

@Repository
public class DietUserdao {
	
	@Autowired
	JdbcTemplate stmt;
	public void addDietUser(DietUserBean dietUserBean) {
		// TODO Auto-generated method stub
		stmt.update("insert into diet_user(dietid,userid) values(?,?)", dietUserBean.getDietid(),dietUserBean.getUserid());
	}

	public List<DietUserBean> listDietUser(int patientid) {
		// TODO Auto-generated method stub
		List<DietUserBean> dietUserBean = stmt.query("select du.*,d.*,pp.* from diet_user as du,patientprofile as pp,diet as d where du.userid = pp.patientid and du.dietid = d.dietid and pp.patientid = ?",
				new Object[] {patientid},BeanPropertyRowMapper.newInstance(DietUserBean.class));
		return dietUserBean;
	}

}
