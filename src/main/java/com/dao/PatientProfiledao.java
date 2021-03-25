package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.bean.PatientProfileBean;

@Repository
public class PatientProfiledao {

	@Autowired
	JdbcTemplate stmt;

	public void addpatientprofile(PatientProfileBean bean) {
		// TODO Auto-generated method stub

		stmt.update(
				"insert into patientprofile (patientname,gender,phoneno,email,age,profilepic,cityid,pincode,userid) values(?,?,?,?,?,?,?,?,?)",
				bean.getPatientname(), bean.getGender(), bean.getPhoneno(), bean.getEmail(), bean.getAge(),
				bean.getProfilePic(), bean.getCityid(), bean.getPincode(),bean.getUserid());

	}

	public List<PatientProfileBean> listprofile() {
		// TODO Auto-generated method stub

		List<PatientProfileBean> bean = stmt.query("select *,city.cityname from patientprofile as p join city using(cityid) where p.cityid = cityid",
				BeanPropertyRowMapper.newInstance(PatientProfileBean.class));
		return bean;
	}

	public PatientProfileBean deletepatientprofile(int patientid) {
		// TODO Auto-generated method stub
		PatientProfileBean bean = null;

		bean = getPatientProfileById(patientid);
		if (bean != null) {
			stmt.update("delete from patientprofile where patientid=?", patientid);
		}

		return bean;
	}

	public PatientProfileBean getPatientProfileById(int userid) {
		// TODO Auto-generated method stub

		PatientProfileBean bean = null;
		try {
			bean = stmt.queryForObject("select * from patientprofile where userid=? ", new Object[] { userid },
					BeanPropertyRowMapper.newInstance(PatientProfileBean.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return bean;

	}

	public void updatepatientprofile(PatientProfileBean bean) {
		// TODO Auto-generated method stub
		stmt.update(
				"update patientprofile set patientname=?,gender=?,phoneno=?,email=?,age=?,profilePic=?,cityid=?,pincode=? where patientid=? ",
				bean.getPatientname(), bean.getGender(), bean.getPhoneno(), bean.getEmail(), bean.getAge(),
				bean.getProfilePic(), bean.getCityid(),  bean.getPincode(), bean.getPatientid());

		

	}

	public PatientProfileBean getPatientById(int userid) {
		PatientProfileBean bean = null;
        try {
        	System.out.println("this is patient profile userid "+userid);
            bean = stmt.queryForObject("select *,city.cityname from patientprofile as p join city using(cityid) where p.cityid = cityid and userid=?", new Object[]{userid},
                    BeanPropertyRowMapper.newInstance(PatientProfileBean.class));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("getpatientprofile.....?????");
        }
        return bean;
	}

	public List<PatientProfileBean> listUserPatient(int userid) {
		// TODO Auto-generated method stub
		 java.util.List<PatientProfileBean> userPatientBean = stmt.query("select pp.*,up.userid from patientprofile as pp,users as up where pp.userid = up.userid and pp.isdeleted =0  and up.userid= ?", new Object[]{userid}, BeanPropertyRowMapper.newInstance(PatientProfileBean.class));
	     return userPatientBean;
	}

}
