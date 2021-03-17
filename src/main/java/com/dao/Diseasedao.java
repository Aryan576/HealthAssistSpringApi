package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.DiseaseBean;

@Repository
public class Diseasedao {
	@Autowired
	JdbcTemplate stmt;
	public void addDisease(DiseaseBean diseaseBean) {
		stmt.update("insert into disease(diseasename) values(?)", diseaseBean.getDiseasename());

	}

	public List<DiseaseBean> listDisease() {
		List<DiseaseBean> diseaseBean = stmt.query("select * from disease where isdeleted = 0",
				BeanPropertyRowMapper.newInstance(DiseaseBean.class));
		return diseaseBean;
	}

	public void updateDisease(DiseaseBean diseaseBean) {
		stmt.update("update disease set diseasename = ? where diseaseid = ?",diseaseBean.getDiseasename(),diseaseBean.getDiseaseid());
	}

	public DiseaseBean deleteDisease(int diseaseid) {
		DiseaseBean bean=null;
		bean=getDiseaseById(diseaseid);
		
		stmt.update("delete from disease where diseaseid = ?",diseaseid);
		
		return bean;
		
	}

}
