package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.DietBean;

@Repository
public class Dietdao {
	@Autowired
	JdbcTemplate stmt;

	public void addDiet(DietBean dietBean) {
		// TODO Auto-generated method stub
		
		stmt.update("insert into diet (diettype,dietcontent,agegroup) values(?,?,?)", 
				dietBean.getDiettype(),dietBean.getDietcontent(),dietBean.getAgegroup());
		
	}

	public List<DietBean> listDiet() {
		// TODO Auto-generated method stub
		List<DietBean> dietBean = stmt.query("select * from diet where isdeleted=0", BeanPropertyRowMapper.newInstance(DietBean.class));
		return dietBean;
		
	}

	public DietBean getDietById(int dietid) {
		// TODO Auto-generated method stub

		DietBean bean = null;
		try {
			bean = stmt.queryForObject("select * from diet where dietid=?", new Object[] { dietid },
					BeanPropertyRowMapper.newInstance(DietBean.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bean;
	}

	public void deleteDiet(int dietid) {
		// TODO Auto-generated method stub
		
		stmt.update("update diet set isdeleted = 1 where dietid = ?",dietid);
		
	}
	
	public void updateDiet(DietBean dietBean) {
		// TODO Auto-generated method stub
		stmt.update("update diet set diettype=?,dietcontent=?,agegroup=? where dietid=?",
				dietBean.getDiettype(),dietBean.getDietcontent(),dietBean.getAgegroup(),dietBean.getDietid());
	}

}
