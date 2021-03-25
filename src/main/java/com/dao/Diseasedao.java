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
		// TODO Auto-generated method stub
		stmt.update("insert into disease(diseasename) values(?)", diseaseBean.getDiseasename());
	}

	public List<DiseaseBean> listDisease() {
		// TODO Auto-generated method stub
		List<DiseaseBean> diseaseBean = stmt.query("select * from disease where isdeleted = 0",
				BeanPropertyRowMapper.newInstance(DiseaseBean.class));
		return diseaseBean;
	}
	

	public void updateDisease(DiseaseBean diseaseBean) {
		// TODO Auto-generated method stub
		stmt.update("update disease set diseasename = ? where diseaseid = ?",diseaseBean.getDiseasename(),diseaseBean.getDiseaseid());
	}

	public void deleteDisease(int diseaseId) {
		// TODO Auto-generated method stub
		stmt.update("update disease set isdeleted=1 where diseaseid = ?",diseaseId);
	}

	public DiseaseBean getDiseaseById(int diseaseid) {
		// TODO Auto-generated method stub
		DiseaseBean bean = null;
        try {
            bean = stmt.queryForObject("select * from disease where diseaseid=?", new Object[]{diseaseid},
                    BeanPropertyRowMapper.newInstance(DiseaseBean.class));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
		return bean;
	}

}
