package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.AppointmentDiseaseBean;

@Repository
public class AppointmentDiseasedao {

	@Autowired
	JdbcTemplate stmt;
	
	public void addAppointmentDisease(AppointmentDiseaseBean appointmentDiseaseBean) {
		// TODO Auto-generated method stub
		stmt.update("insert into appointmentdisease(appointmentid,diseaseid,patientprofileid) values(?,?,?)", 
				appointmentDiseaseBean.getAppointmentid(),appointmentDiseaseBean.getDiseaseid(),appointmentDiseaseBean.getPatientprofileid());
	}

	public List<AppointmentDiseaseBean> listAppointmentDisease(int appointmentid) {
		// TODO Auto-generated method stub
		List<AppointmentDiseaseBean> appointmentDiseaseBean = stmt.query("select ap.*,ad.*,d.* from appointmentdisease as ad,appointment as ap,disease as d join disease using(diseaseid) where ad.diseaseid = d.diseaseid and ad.appointmentid = ap.appointmentid and ap.appointmentid = ?",
				new Object[] {appointmentid},BeanPropertyRowMapper.newInstance(AppointmentDiseaseBean.class));
		return appointmentDiseaseBean;
	}

	public void updateAppointmentDisease(AppointmentDiseaseBean appointmentDiseaseBean) {
		// TODO Auto-generated method stub
		stmt.update("update appointmentdisease set appointmentid = ?, diseaseid = ?, patientprofileid =? where appointmentdiseaseid = ?",
				appointmentDiseaseBean.getAppointmentid(), appointmentDiseaseBean.getDiseaseid(), appointmentDiseaseBean.getPatientprofileid(),appointmentDiseaseBean.getAppointmentdiseaseid());

	}

	public AppointmentDiseaseBean getAppointmentDiseaseById(int appointmentdiseaseid) {
		// TODO Auto-generated method stub
		AppointmentDiseaseBean appointmentDiseaseBean = null;
        try {
        	appointmentDiseaseBean = stmt.queryForObject("select * from appointmentdisease where appointmentdiseaseid=?", new Object[]{appointmentdiseaseid},
                    BeanPropertyRowMapper.newInstance(AppointmentDiseaseBean.class));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
		return appointmentDiseaseBean;
	}

	public void deleteAppointmentDisease(int appointmentdiseaseid) {
		// TODO Auto-generated method stub
		stmt.update("update appointmentdisease set isdeleted=1 where appointmentdiseaseid = ?",appointmentdiseaseid);
	}

}
