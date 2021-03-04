package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.bean.PathologyBean;

@RestController
public class Pathologydao {
	@Autowired
	JdbcTemplate stmt;

	public void addPathology(PathologyBean bean) {
		// TODO Auto-generated method stub

		stmt.update(
				"insert into pathology (pathologyname,timing,address,phoneno,rating,about,lat,log,cityid,pincode,specialization) values(?,?,?,?,?,?,?,?,?,?,?)",
				bean.getPathologyname(), bean.getTiming(), bean.getAddress(), bean.getPhoneno(), bean.getRating(),
				bean.getAbout(), bean.getLat(), bean.getLog(), bean.getCityid(), bean.getPincode(),
				bean.getSpecialization());

	}

	public List<PathologyBean> listPathology() {
		// TODO Auto-generated method stub

		List<PathologyBean> bean = stmt.query("select *,city.cityname from pathology as p join city using(cityid) where p.cityid = cityid and isdeleted = 0",
				BeanPropertyRowMapper.newInstance(PathologyBean.class));
		return bean;
	}

	public PathologyBean deletepathology(int pathologyid) {
		// TODO Auto-generated method stub
		PathologyBean bean = null;
		bean = getPathologyById(pathologyid);
		if (bean != null) {
			stmt.update("update pathology set isdeleted = 1 where pathologyid=?", pathologyid);
		}
		return bean;
	}

	public PathologyBean getPathologyById(int pathologyid) {

		PathologyBean bean = null;
		try {
			bean = stmt.queryForObject("select * from pathology where pathologyid=?", new Object[] { pathologyid },
					BeanPropertyRowMapper.newInstance(PathologyBean.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return bean;

	}

	public PathologyBean updatePathology(PathologyBean bean) {
		stmt.update(
				"update pathology set pathologyname=?,timing=?,address=?,phoneno=?,rating=?,about=?,lat=?,log=?,cityid=?,pincode=?,specialization=? where pathologyid=? ",
				bean.getPathologyname(), bean.getTiming(), bean.getAddress(), bean.getPhoneno(), bean.getRating(),
				bean.getAbout(), bean.getLat(), bean.getLog(), bean.getCityid(), bean.getPincode(),
				bean.getSpecialization(), bean.getPathologyid());
		return bean;
	}

}
