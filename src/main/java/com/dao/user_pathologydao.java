package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.user_pathologyBean;

@Repository
public class user_pathologydao {
	@Autowired
	JdbcTemplate stmt;

	public void adduserpathology(user_pathologyBean bean) {
		// TODO Auto-generated method stub\
		stmt.update("insert into userpathology (userid,pathologyid) values(?,?)", bean.getUserid(),
				bean.getPathologyid());

	}

}
