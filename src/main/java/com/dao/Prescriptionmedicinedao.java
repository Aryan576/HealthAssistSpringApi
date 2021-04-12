package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.PrescriptionmedicineBean;

@Repository
public class Prescriptionmedicinedao {
	@Autowired
	JdbcTemplate stmt;

	public List<PrescriptionmedicineBean> listPrescriptionMedicine() {
		// TODO Auto-generated method stub
		List<PrescriptionmedicineBean> prescriptionmedicineBean = stmt.query(
				"select * from prescriptionmedicine where isdeleted=0",
				BeanPropertyRowMapper.newInstance(PrescriptionmedicineBean.class));
		return prescriptionmedicineBean;
	}

	public PrescriptionmedicineBean getPrescriptionMedicineById(int prescriptionmedicineid) {
		// TODO Auto-generated method stub
		PrescriptionmedicineBean prescriptionmedicineBean = null;
		try {
			prescriptionmedicineBean = stmt.queryForObject(
					"select * from prescriptionmedicine where prescriptionmedicineid=?",
					new Object[] { prescriptionmedicineid },
					BeanPropertyRowMapper.newInstance(PrescriptionmedicineBean.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return prescriptionmedicineBean;
	}

	public void updatePrescriptionMedicine(PrescriptionmedicineBean prescriptionmedicineBean) {
		// TODO Auto-generated method stub
		stmt.update(
				"update prescriptionmedicine set prescriptionid=?, medicineid=?, frequency=?, duration=?, instructions=? where prescriptionmedicineid = ?",
				prescriptionmedicineBean.getPrescriptionid(), prescriptionmedicineBean.getMedicineid(),
				prescriptionmedicineBean.getFrequency(), prescriptionmedicineBean.getDuration(),
				prescriptionmedicineBean.getInstructions(), prescriptionmedicineBean.getPrescriptionmedicineid());

	}

	public void deletePrescriptionMedicine(int prescriptionmedicineid) {
		// TODO Auto-generated method stub
		stmt.update("update prescriptionmedicine set isdeleted=1 where prescriptionmedicineid = ?",
				prescriptionmedicineid);

	}

}
