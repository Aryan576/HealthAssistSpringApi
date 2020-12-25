package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.AppointmentStatusBean;

@Repository
public class AppointmentStatusdao {

	@Autowired
	JdbcTemplate stmt;

	public void addappointmentstatus(AppointmentStatusBean bean) {
		// TODO Auto-generated method stub

		stmt.update("insert into appointmentstatus (statusname) values(?)", bean.getStatusname());

	}

	public List<AppointmentStatusBean> listappointmentstatus() {
		// TODO Auto-generated method stub
		List<AppointmentStatusBean> bean = stmt.query("select * from appointmentstatus",
				BeanPropertyRowMapper.newInstance(AppointmentStatusBean.class));
		return bean;
	}

	public AppointmentStatusBean deletestatus(int statusid) {
		// TODO Auto-generated method stub
		AppointmentStatusBean bean = null;
		bean = getAppointStatusById(statusid);
		if (bean != null) {
			stmt.update("delete from appointmentstatus where statusid=?", statusid);
		}

		return bean;
	}

	private AppointmentStatusBean getAppointStatusById(int statusid) {
		// TODO Auto-generated method stub

		AppointmentStatusBean bean = null;
		try {
			bean = stmt.queryForObject("select * from appointmentstatus where statusid=?", new Object[] { statusid },
					BeanPropertyRowMapper.newInstance(AppointmentStatusBean.class));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bean;
	}

	public AppointmentStatusBean updateAppointmentstatus(AppointmentStatusBean bean) {

		stmt.update("update appointmentstatus set statusname=? where statusid=?", bean.getStatusname(),
				bean.getStatusid());

		return bean;
		// TODO Auto-generated method stub

	}
}
