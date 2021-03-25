package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.MedicineBean;

@Repository
public class Medicinedao {
	@Autowired
	JdbcTemplate stmt;
	
	public void addMedicine(MedicineBean medicineBean) {
		stmt.update("insert into medicine(medicinename,medicinetype) values(?,?)", medicineBean.getMedicinename(),
				medicineBean.getMedicinetype());

	}

	public List<MedicineBean> listMedicine() {
		List<MedicineBean> medicineBean = stmt.query("select * from medicine where isdeleted = 0",
				BeanPropertyRowMapper.newInstance(MedicineBean.class));
		return medicineBean;
	}

	public void updateMedicine(MedicineBean medicineBean) {
		stmt.update("update medicine set medicinename = ?, medicinetype = ? where medicineid = ?",
				medicineBean.getMedicinename(), medicineBean.getMedicinetype(), medicineBean.getMedicineid());

	}

	public void deleteMedicine(int medicineid) {
		stmt.update("update medicine set isdeleted = 1 where medicineid = ?", medicineid);

	}

	public MedicineBean getMedicineById(int medicineid) {
		MedicineBean medicineBean = null;
		try {
			medicineBean = stmt.queryForObject("select * from medicine where medicineid = ?",
					new Object[] { medicineid }, BeanPropertyRowMapper.newInstance(MedicineBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return medicineBean;
	}

}
