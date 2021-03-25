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
		bean.setStatusid(4);
		stmt.update(
				"insert into appointment (patientid,doctorid,statusid,appcreatedate,comment,clinicid,reference,complain,appointmentdate,appointmenttime) values(?,?,?,?,?,?,?,?,?,?)",
				bean.getPatientid(), bean.getDoctorid(), bean.getStatusid(), bean.getApp_create_date(),
				bean.getComment(), bean.getClinicid(), bean.getReference(), bean.getComplain(),
				bean.getAppointMentDate(), bean.getAppointMentTime());

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
		return bean;
	}

	public BookAppointmentBean updateAppointment(BookAppointmentBean bean) {

		stmt.update(
				"update appointment set patientid=?,doctorid=?,statusid=?,appcreatedate=?,comment=?,clinicid=?,reference=?,complain=?,appointMentDate=?,appointMentTime=? where appointmentid=? ",
				bean.getPatientid(), bean.getDoctorid(), bean.getStatusid(), bean.getApp_create_date(),
				bean.getComment(), bean.getClinicid(), bean.getReference(), bean.getComplain(),
				bean.getAppointMentDate(), bean.getAppointMentTime(), bean.getAppointmentid());

		return bean;
		// TODO Auto-generated method stub

	}

	public void accept_reject_Appointment(BookAppointmentBean appointmentBean) {
		// TODO Auto-generated method stub
		stmt.update("update appointment set statusid=? where appointmentid=?", appointmentBean.getStatusid(),
				appointmentBean.getAppointmentid());

	}

	public List<BookAppointmentBean> ListAppointment(int userid) {
		// TODO Auto-generated method stub
		List<BookAppointmentBean> appointmentBean = stmt.query(
				"select p.*,a.*,s.*,u.*,dp.*,cli.* from patientprofile as p,clinic as cli,doctorprofile as dp,users as u,appointment as a,appointmentstatus as s where a.patientid = p.patientid and a.clinicid = cli.clinicid and a.statusid = s.statusid and u.userid = a.doctorid and a.doctorid = dp.userid  and u.userid = ?",
				new Object[] { userid }, BeanPropertyRowMapper.newInstance(BookAppointmentBean.class));
		return appointmentBean;

	}

	public List<BookAppointmentBean> listAppointmentForDoctor(int userid) {
		// TODO Auto-generated method stub
		java.util.List<BookAppointmentBean> appointmentBean = stmt.query("select p.*,a.*,s.*,dp.*,cli.* from patientprofile as p,clinic as cli,users as u,doctorprofile as dp,appointment as a,appointmentstatus as s where a.patientid = p.patientid and u.userid = dp.userid and a.clinicid = cli.clinicid and a.statusid = s.statusid and dp.userid = ?"
        		, new Object[] {userid} ,BeanPropertyRowMapper.newInstance(BookAppointmentBean.class));
        return appointmentBean;
	}

}
