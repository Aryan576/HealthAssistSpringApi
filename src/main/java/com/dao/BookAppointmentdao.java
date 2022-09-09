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

	public BookAppointmentBean getAppointmentById(int appointmentid) {
		// TODO Auto-generated method stub
		BookAppointmentBean bean = null;
		try {
			bean = stmt.queryForObject(
					"select ap.*,pp.*,cli.clinicname from appointment as ap,patientprofile as pp,clinic as cli where  ap.patientid=pp.patientid and ap.clinicid=cli.clinicid and  ap.appointmentid=?",
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
		java.util.List<BookAppointmentBean> appointmentBean = stmt.query(
				"select p.*,a.*,s.*,dp.*,cli.* from patientprofile as p,clinic as cli,users as u,doctorprofile as dp,appointment as a,appointmentstatus as s where a.patientid = p.patientid and u.userid = dp.userid and a.clinicid = cli.clinicid and a.statusid = s.statusid and dp.userid = ?",
				new Object[] { userid }, BeanPropertyRowMapper.newInstance(BookAppointmentBean.class));
		return appointmentBean;
	}

	public List<BookAppointmentBean> pastAppointmentList(int patientid) {
		List<BookAppointmentBean> bean = stmt.query(
				"select ap.*,cli.clinicname,pp.*,aps.* from appointment as ap,patientprofile as pp,clinic as cli,appointmentstatus as aps where ap.statusid = aps.statusid and aps.statusid = 7 and ap.patientid = pp.patientid and ap.clinicid = cli.clinicid and pp.patientid = ?",
				new Object[] { patientid }, BeanPropertyRowMapper.newInstance(BookAppointmentBean.class));
		return bean;
	}

	public void done_Appointment(BookAppointmentBean appointmentBean) {
		// TODO Auto-generated method stub
		stmt.update("update appointment set statusid=? where appointmentid=?", appointmentBean.getStatusid(), appointmentBean.getAppointmentid());
	}
	
	
	
	public List<BookAppointmentBean> todayAppointment(int userid) {
		// TODO Auto-generated method stub
		java.util.List<BookAppointmentBean> appointmentBean = stmt.query("select ap.*,u.*,dp.* from doctorprofile as dp,users as u,appointment as ap where u.userid = ap.doctorid and ap.doctorid = dp.userid and DATE(ap.appcreatedate) = current_date and u.userid = ?"
		+ "", new Object[] {userid} ,BeanPropertyRowMapper.newInstance(BookAppointmentBean.class));
		return appointmentBean;
		}

		public List<BookAppointmentBean> waitForAcceptAppointment(int userid) {
		// TODO Auto-generated method stub
		java.util.List<BookAppointmentBean> appointmentBean = stmt.query("select ap.*,u.*,dp.* from doctorprofile as dp,users as u,appointment as ap where u.userid = ap.doctorid and ap.doctorid = dp.userid and ap.statusid = 4 and u.userid = ?"
		+ "", new Object[] {userid} ,BeanPropertyRowMapper.newInstance(BookAppointmentBean.class));
		return appointmentBean;
		}

		public List<BookAppointmentBean> acceptAppointment(int userid) {
		// TODO Auto-generated method stub
		java.util.List<BookAppointmentBean> appointmentBean = stmt.query("select ap.*,u.*,dp.* from doctorprofile as dp,users as u,appointment as ap where u.userid = ap.doctorid and ap.doctorid = dp.userid and ap.statusid = 1 and u.userid = ?"
		+ "", new Object[] {userid} ,BeanPropertyRowMapper.newInstance(BookAppointmentBean.class));
		return appointmentBean;
		}

		public List<BookAppointmentBean> rescheduleAppointment(int userid) {
		// TODO Auto-generated method stub
		java.util.List<BookAppointmentBean> appointmentBean = stmt.query("select ap.*,u.*,dp.* from doctorprofile as dp,users as u,appointment as ap where u.userid = ap.doctorid and ap.doctorid = dp.userid and ap.statusid = 5 and u.userid = ?"
		+ "", new Object[] {userid} ,BeanPropertyRowMapper.newInstance(BookAppointmentBean.class));
		return appointmentBean;
		}

		public List<BookAppointmentBean> doneAppointment(int userid) {
		// TODO Auto-generated method stub
		java.util.List<BookAppointmentBean> appointmentBean = stmt.query("select ap.*,u.*,dp.* from doctorprofile as dp,users as u,appointment as ap where u.userid = ap.doctorid and ap.doctorid = dp.userid and ap.statusid = 7 and u.userid = ?"
		+ "", new Object[] {userid} ,BeanPropertyRowMapper.newInstance(BookAppointmentBean.class));
		return appointmentBean;
		}

		public void updateRejectAppointment(BookAppointmentBean appointmentBean) {
			// TODO Auto-generated method stub
			stmt.update("update appointment set statusreason=? where appointmentid=?", appointmentBean.getStatusreason(), appointmentBean.getAppointmentid());
		}

		public BookAppointmentBean getRescheduleReasonByEmail(String email, int appointmentid) {
			BookAppointmentBean appointmentBean = null;

	        try {
	        	appointmentBean = stmt.queryForObject("select ap.*,pp.*,dp.*,du.firstname,du.lastname from appointment as ap,users as du,doctorprofile as dp,patientprofile as pp where ap.doctorid = dp.userid and dp.userid = du.userid and ap.patientid = pp.patientid and pp.email=? and ap.appointmentid=?",

	                    new Object[]{email,appointmentid}, BeanPropertyRowMapper.newInstance(BookAppointmentBean.class));
	        	
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        return appointmentBean;
		}

		public void updateRescheduleAppointment(BookAppointmentBean appointmentBean) {
			// TODO Auto-generated method stub
			stmt.update("update appointment set statusreason=? where appointmentid=?", appointmentBean.getStatusreason(), appointmentBean.getAppointmentid());

			
		}

		public BookAppointmentBean getRejectReasonByEmail(String email, int appointmentid) {
			// TODO Auto-generated method stub
			BookAppointmentBean appointmentBean = null;

	        try {
	        	appointmentBean = stmt.queryForObject("select ap.*,pp.*,dp.*,du.firstname,du.lastname from appointment as ap,users as du,doctorprofile as dp,patientprofile as pp where ap.doctorid = dp.userid and dp.userid = du.userid and ap.patientid = pp.patientid and pp.email=? and ap.appointmentid=?",

	                    new Object[]{email,appointmentid}, BeanPropertyRowMapper.newInstance(BookAppointmentBean.class));
	        	
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        return appointmentBean;
		}

		public List<BookAppointmentBean> doneAppointmentForAllDoctor() {
			// TODO Auto-generated method stub
			java.util.List<BookAppointmentBean> appointmentBean = stmt.query("select ap.*,u.*,dp.* from doctorprofile as dp,users as u,appointment as ap where u.userid = ap.doctorid and ap.doctorid = dp.userid and ap.statusid = 7"
	        		+ "",BeanPropertyRowMapper.newInstance(BookAppointmentBean.class));
	        return appointmentBean;
		}

		public List<BookAppointmentBean> listAllAppointment() {
			java.util.List<BookAppointmentBean> appointmentBean = stmt.query("select ap.*,pp.*,s.*,dp.*,cli.*,du.firstname,du.lastname,du.userid from appointment as ap,patientprofile as pp,appointmentstatus as s,users as du,clinic as cli,doctorprofile as dp where ap.patientid = pp.patientid and ap.doctorid = dp.userid and dp.userid = du.userid and ap.statusid = s.statusid and ap.clinicid = cli.clinicid"
	        		+ "",BeanPropertyRowMapper.newInstance(BookAppointmentBean.class));
	        return appointmentBean;
		}

		public List<BookAppointmentBean> viewPatientAppointment(int userid) {
			java.util.List<BookAppointmentBean> appointmentBean = stmt.query("select p.*,a.*,s.*,u.*,cli.*,dp.userid,du.firstname,du.lastname from patientprofile as p,users as du, doctorprofile as dp,clinic as cli,users as u,appointment as a,appointmentstatus as s where not s.statusid = 5 and a.doctorid = dp.userid and dp.userid = du.userid and a.patientid = p.patientid and a.clinicid = cli.clinicid and a.statusid = s.statusid and p.userid = u.userid and u.userid = ?"
	        		, new Object[] {userid} ,BeanPropertyRowMapper.newInstance(BookAppointmentBean.class));
			return appointmentBean;
		}

		public BookAppointmentBean getPatientDetailsById(int appointmentid) {
			BookAppointmentBean bean = null;
	        try {
	            bean = stmt.queryForObject("select ap.*,pp.*,pres.*,cli.clinicname from appointment as ap,prescription as pres,clinic as cli,patientprofile as pp where  ap.patientid=pp.patientid and ap.appointmentid = pres.appointmentid and ap.clinicid = cli.clinicid and  ap.appointmentid=?", new Object[]{appointmentid},
	                    BeanPropertyRowMapper.newInstance(BookAppointmentBean.class));
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }
			return bean;
		}

}
