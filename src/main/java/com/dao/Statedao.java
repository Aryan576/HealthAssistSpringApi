package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.StateBean;

@Repository
public class Statedao {

	@Autowired
	JdbcTemplate stmt;

	public void addState(StateBean stateBean) {
		// TODO Auto-generated method stub
		stmt.update("insert into states(statename,stateid) values(?,?)", stateBean.getStatename());
	}

	public List<StateBean> listState() {
		// TODO Auto-generated method stub
		java.util.List<StateBean> stateBean = stmt.query("select * from states where isdeleted=0",
				BeanPropertyRowMapper.newInstance(StateBean.class));
		return stateBean;
	}

	public void deleteState(int stateid) {
		// TODO Auto-generated method stub
		stmt.update("update states set isdeleted = 1 where stateid = ?", stateid);
	}

	public StateBean getStateById(int stateid) {
		// TODO Auto-generated method stub
		StateBean bean = null;
		try {
			bean = stmt.queryForObject("select * from states where stateid=?", new Object[] { stateid },
					BeanPropertyRowMapper.newInstance(StateBean.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bean;
	}

	public void updateState(StateBean stateBean) {
		// TODO Auto-generated method stub
		stmt.update("update states set statename=? where stateid=?", stateBean.getStatename(), stateBean.getStateid());
	}

}
