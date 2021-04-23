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

	public List<AppointmentDiseaseBean> listAppointmentDisease(int patientid) {
		// TODO Auto-generated method stub
		List<AppointmentDiseaseBean> appointmentDiseaseBean = stmt.query("select ap.*,ad.*,pp.*,d.* from appointment as ap,patientprofile as pp,appointmentdisease as ad,disease as d where ad.appointmentid = ap.appointmentid and ad.diseaseid = d.diseaseid and ad.patientprofileid = ap.patientid and ap.patientid = pp.patientid  and pp.patientid = ?",
				new Object[] {patientid},BeanPropertyRowMapper.newInstance(AppointmentDiseaseBean.class));
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
