package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bean.PrescriptionBean;

@Repository
public class Prescriptiondao {
	

	@Autowired
	JdbcTemplate stmt;

	public int addPrescription(PrescriptionBean prescriptionBean) {
		// TODO Auto-generated method stub
		KeyHolder keyHolder = new GeneratedKeyHolder();
    	String insertSql = "insert into prescription(patientprofileid,doctorprofileid,appointmentid,description,prescriptiondate,generaladvice,followupcomment) values (?,?,?,?,?,?,?)";
    	
    	
    	stmt.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

                PreparedStatement pstmt = con.prepareStatement(insertSql, java.sql.Statement.RETURN_GENERATED_KEYS);
                pstmt.setInt(1, prescriptionBean.getPatientprofileid());
                pstmt.setInt(2, prescriptionBean.getDoctorprofileid());
                pstmt.setInt(3, prescriptionBean.getAppointmentid());
                pstmt.setString(4, prescriptionBean.getDescription());
                pstmt.setDate(5, prescriptionBean.getPrescriptiondate());
                pstmt.setString(6, prescriptionBean.getGeneraladvice());
                pstmt.setString(7, prescriptionBean.getFollowupcomment());
                
                return pstmt;
            }
        }, keyHolder);
    	int prescriptionid = (Integer) keyHolder.getKeys().get("prescriptionid");
    	prescriptionBean.setPrescriptionid(prescriptionid);
        return prescriptionBean.getPrescriptionid();
		
	}
	
	public void addPrescriptionMedicine(PrescriptionBean prescriptionBean) {
		// TODO Auto-generated method stub
		int prescriptionid = addPrescription(prescriptionBean);

        prescriptionBean.setPrescriptionid(prescriptionid);
		stmt.update("insert into prescriptionmedicine(prescriptionid,medicineid,frequency,duration,instructions) values(?,?,?,?,?)", 
				prescriptionBean.getPrescriptionid(),prescriptionBean.getMedicineid(),
				prescriptionBean.getFrequency(),prescriptionBean.getDuration(),
				prescriptionBean.getInstructions());
		
	}

	public List<PrescriptionBean> listPrescription() {
		// TODO Auto-generated method stub
		List<PrescriptionBean> prescriptionBean = stmt.query("select * from prescription",
				BeanPropertyRowMapper.newInstance(PrescriptionBean.class));
		return prescriptionBean;
	}

	public PrescriptionBean getPrescriptionById(int prescriptionId) {
		// TODO Auto-generated method stub
		PrescriptionBean prescriptionBean = null;

		try {
			prescriptionBean = stmt.queryForObject("select * from prescription where prescriptionid = ?",
					new Object[prescriptionId], BeanPropertyRowMapper.newInstance(PrescriptionBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prescriptionBean;
	
	}

	public void updatePrescription(PrescriptionBean prescriptionBean) {
		// TODO Auto-generated method stub
		stmt.update(
				"update prescription set patientprofileid = ?,doctorprofileid = ?,appointmentid = ?,description = ?,prescriptiondate = ?,generaladvice = ?,followupcomment = ? where prescriptionid = ?",
				prescriptionBean.getPatientprofileid(), prescriptionBean.getDoctorprofileid(),
				prescriptionBean.getAppointmentid(), prescriptionBean.getDescription(),
				prescriptionBean.getPrescriptiondate(), prescriptionBean.getGeneraladvice(),
				prescriptionBean.getFollowupcomment(), prescriptionBean.getPrescriptiondate());
	}

	public void deletePrescription(int prescriptionId) {
		// TODO Auto-generated method stub
		
	}

	public List<PrescriptionBean> listPrescription(int appointmentid) {
		List<PrescriptionBean> prescriptionBean = stmt.query("select pm.*,m.*,pres.* from prescriptionmedicine as pm,medicine as m,prescription as pres where pm.medicineid = m.medicineid and pm.prescriptionid = pres.prescriptionid and pres.appointmentid = ?",
				new Object[] {appointmentid},BeanPropertyRowMapper.newInstance(PrescriptionBean.class));
		return prescriptionBean;
	}



}
