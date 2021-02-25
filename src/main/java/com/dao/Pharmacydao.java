package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.PharmacyBean;

@Repository
public class Pharmacydao {
	@Autowired
	JdbcTemplate stmt;

	public void addpharmacy(PharmacyBean bean) {
		// TODO Auto-generated method stub
		stmt.update(
				"insert into pharmacy(pharmacyname,address,phone,rating,comment,lat,log,about,cityid,stateid,pincode,timing) values(?,?,?,?,?,?,?,?,?,?,?,?)",
				bean.getPharmacyname(), bean.getAddress(), bean.getPhone(), bean.getRating(), bean.getComment(),
				bean.getLat(), bean.getLog(), bean.getAbout(), bean.getCityId(), bean.getStateId(), bean.getPincode(),bean.getTiming());

	}

	public List<PharmacyBean> listpharmacy() {
		// TODO Auto-generated method stub
		List<PharmacyBean> bean = stmt.query("select *,city.cityname from pharmacy as p join city using(cityid) where p.cityid = cityid",
				BeanPropertyRowMapper.newInstance(PharmacyBean.class));
		return bean;
	}

	public PharmacyBean deletepharacy(int pharmacyid) {
		// TODO Auto-generated method stub
		PharmacyBean bean = null;
		bean = getPharmacyById(pharmacyid);
		if (bean != null) {
			stmt.update("delete from pharmacy where pharmacyid=?", pharmacyid);
		}
		return bean;
	}

	public PharmacyBean getPharmacyById(int pharmacyid) {
		PharmacyBean bean = null;
		try {
			bean=stmt.queryForObject("select * from pharmacy where pharmacyid=?", new Object[] { pharmacyid },
					BeanPropertyRowMapper.newInstance(PharmacyBean.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Role not  Found" + e.getMessage());
		}
		return bean;
	}

	public void updatepharmacy(PharmacyBean bean) {
		// TODO Auto-generated method stub
		stmt.update(
				"update pharmacy set pharmacyname=?,address=?,phone=?,rating=?,comment=?,lat=?,log=?,about=?,cityid=?,stateid=?,pincode=?,timing=? where pharmacyid=?",
				bean.getPharmacyname(), bean.getAddress(), bean.getPhone(), bean.getRating(), bean.getComment(),
				bean.getLat(), bean.getLog(), bean.getAbout(), bean.getCityId(), bean.getStateId(), bean.getPincode(),bean.getTiming(),
				bean.getPharmacyid());

	}
}
