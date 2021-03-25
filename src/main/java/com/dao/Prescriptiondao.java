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

	public void deletePrescription(int prescriptionId) {
		// TODO Auto-generated method stub
		
	}

	public void updatePrescription(PrescriptionBean prescriptionBean) {
		// TODO Auto-generated method stub
		
	}

	public PrescriptionBean getPrescriptionById(int prescriptionId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PrescriptionBean> listPrescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addPrescriptionMedicine(PrescriptionBean prescriptionBean) {
		// TODO Auto-generated method stub
		
	}

	public void addPrescription(PrescriptionBean prescriptionBean) {
		// TODO Auto-generated method stub
		
	}



}
