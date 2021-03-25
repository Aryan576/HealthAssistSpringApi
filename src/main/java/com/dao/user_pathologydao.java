package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

	public List<user_pathologyBean> listUserPathology(int userid) {
		 java.util.List<user_pathologyBean> userPathologyBean = stmt.query("select u.*,p.*,up.* from users as u,pathology as p,userpathology as up where up.userid = u.userid and up.pathologyid = p.pathologyid and up.userid = ? ",new Object[] {userid}, BeanPropertyRowMapper.newInstance(user_pathologyBean.class));

			return userPathologyBean;
	}

}
