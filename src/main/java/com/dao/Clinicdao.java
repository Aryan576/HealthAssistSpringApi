package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
				"insert into clinic (clinicname,timing,address,phoneno,rating,about,lat,log,cityid,stateid,pincode) values(?,?,?,?,?,?,?,?,?,?,?)",
				clinicBean.getClinicname(), clinicBean.getTiming(), clinicBean.getAddress(), clinicBean.getPhoneno(),
				clinicBean.getRating(), clinicBean.getAbout(), clinicBean.getLat(), clinicBean.getLog(),
				clinicBean.getCityid(), clinicBean.getStateid(), clinicBean.getPincode());

	}

	public List<ClinicBean> listclinic() {
		// TODO Auto-generated method stub

		List<ClinicBean> clinicBean = stmt.query("select * from clinic",
				BeanPropertyRowMapper.newInstance(ClinicBean.class));
		return clinicBean;
	}

	public ClinicBean deleteclinic(int clinicid) {
		// TODO Auto-generated method stub
		ClinicBean bean = null;
		bean = getClinicById(clinicid);
		if (bean != null) {
			stmt.update("delete from clinic where clinicid =?", clinicid);
		}
		return bean;
	}

	public ClinicBean getClinicById(int clinicid) {
		ClinicBean bean = null;
		try {
			bean = stmt.queryForObject("select * from clinic where clinicid=?", new Object[] { clinicid },
					BeanPropertyRowMapper.newInstance(ClinicBean.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bean;

	}

	public ClinicBean updateclinic(ClinicBean clinicBean) {
		// TODO Auto-generated method stub
		stmt.update(
				"update clinic set clinicname=?,timing=?,address=?,phoneno=?,rating=?,about=?,lat=?,log=?,cityid=?,stateid=?,pincode=? where clinicid=? ",
				clinicBean.getClinicname(), clinicBean.getTiming(), clinicBean.getAddress(), clinicBean.getPhoneno(),
				clinicBean.getRating(), clinicBean.getAbout(), clinicBean.getLat(), clinicBean.getLog(),
				clinicBean.getCityid(), clinicBean.getStateid(), clinicBean.getPincode(), clinicBean.getClinicid());
		return clinicBean;
	}

}
