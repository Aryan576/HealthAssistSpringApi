package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.BookAppointmentBean;

@Repository
public class BookAppointmentdao {

	@Autowired
	JdbcTemplate stmt;

	public void bookppointment(BookAppointmentBean bean) {
		// TODO Auto-generated method stub

		stmt.update(
				"insert into appointment (appointmentname,patientid,doctorid,statusid,appcreatedate,comment,clinicid,reference,complain,diagnosis,appointmentdate,appointmenttime) values(?,?,?,?,?,?,?,?,?,?,?,?)",
				bean.getAppointmentname(), bean.getPatientid(), bean.getDoctorid(), bean.getStatusid(),
				bean.getApp_create_date(), bean.getComment(), bean.getClinicid(), bean.getReference(),
				bean.getComplain(), bean.getDiagnosis(), bean.getAppointMentDate(), bean.getAppointMentTime());

	}

	public List<BookAppointmentBean> ListAppointment() {
		// TODO Auto-generated method stub
		List<BookAppointmentBean> bean = stmt.query("select * from appointment",
				BeanPropertyRowMapper.newInstance(BookAppointmentBean.class));
		return bean;
	}

	public BookAppointmentBean deleteappointment(int appointmentid) {
		// TODO Auto-generated method stub
		BookAppointmentBean bean = null;
		bean = getAppointmentById(appointmentid);
		if (bean != null) {
			stmt.update("delete from appointment where appointmentid=?", appointmentid);
		}

		return bean;
	}

	private BookAppointmentBean getAppointmentById(int appointmentid) {
		// TODO Auto-generated method stub
		BookAppointmentBean bean = null;
		try {
			bean = stmt.queryForObject("select * from appointment where appointmentid=?",
					new Object[] { appointmentid }, BeanPropertyRowMapper.newInstance(BookAppointmentBean.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public BookAppointmentBean updateAppointment(BookAppointmentBean bean) {

		stmt.update(
				"update appointment set appointmentname=?,patientid=?,doctorid=?,statusid=?,appcreatedate=?,comment=?,clinicid=?,reference=?,complain=?,diagnosis=?,appointMentDate=?,appointMentTime=? where appointmentid=? ",
				bean.getAppointmentname(), bean.getPatientid(), bean.getDoctorid(), bean.getStatusid(),
				bean.getApp_create_date(), bean.getComment(), bean.getClinicid(), bean.getReference(),
				bean.getComplain(), bean.getDiagnosis(), bean.getAppointMentDate(), bean.getAppointMentTime(),
				bean.getAppointmentid());

		return bean;
		// TODO Auto-generated method stub

	}

}
