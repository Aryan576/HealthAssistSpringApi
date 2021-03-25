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
import org.springframework.web.bind.annotation.RestController;

import com.bean.PathologyBean;
import com.bean.UserBean;

@RestController
public class Pathologydao {
	@Autowired
	JdbcTemplate stmt;

	public int addPathology(PathologyBean bean) {
		// TODO Auto-generated method stub

		/*
		 * stmt.update(
		 * "insert into pathology (pathologyname,timing,address,phoneno,rating,about,lat,log,cityid,pincode,specialization) values(?,?,?,?,?,?,?,?,?,?,?)"
		 * , bean.getPathologyname(), bean.getTiming(), bean.getAddress(),
		 * bean.getPhoneno(), bean.getRating(), bean.getAbout(), bean.getLat(),
		 * bean.getLog(), bean.getCityid(), bean.getPincode(),
		 * bean.getSpecialization());
		 */

		// TODO Auto-generated method stub
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String insertSql = "insert into pathology(pathologyname,timing,address,phoneno,rating,about,lat,log,cityid,pincode) values(?,?,?,?,?,?,?,?,?,?)";

		stmt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				PreparedStatement pstmt = con.prepareStatement(insertSql, java.sql.Statement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, bean.getPathologyname());
				pstmt.setString(2, bean.getTiming());
				pstmt.setString(3, bean.getAddress());
				pstmt.setString(4, bean.getPhoneno());
				pstmt.setString(5, bean.getRating());
				pstmt.setString(6, bean.getAbout());
				pstmt.setDouble(7, bean.getLat());
				pstmt.setDouble(8, bean.getLog());
				pstmt.setInt(9, bean.getCityid());
				pstmt.setInt(10, bean.getPincode());
				return pstmt;
			}
		}, keyHolder);
		int pathologyid = (Integer) keyHolder.getKeys().get("pathologyid");
		bean.setPathologyid(pathologyid);
		return bean.getPathologyid();

	}

	public List<PathologyBean> listPathology() {
		// TODO Auto-generated method stub

		List<PathologyBean> bean = stmt.query(
				"select *,city.cityname from pathology as p join city using(cityid) where p.cityid = cityid and p.isdeleted = 0",
				BeanPropertyRowMapper.newInstance(PathologyBean.class));
		return bean;
	}

	public PathologyBean deletepathology(int pathologyid) {
		// TODO Auto-generated method stub
		PathologyBean bean = null;
		bean = getPathologyById(pathologyid);
		if (bean != null) {
			stmt.update("update pathology set isdeleted = 1 where pathologyid=?", pathologyid);
		}
		return bean;
	}

	public PathologyBean getPathologyById(int pathologyid) {

		PathologyBean bean = null;
		try {
			bean = stmt.queryForObject("select * from pathology where pathologyid=?", new Object[] { pathologyid },
					BeanPropertyRowMapper.newInstance(PathologyBean.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return bean;

	}

	public PathologyBean updatePathology(PathologyBean bean) {
		stmt.update(
				"update pathology set pathologyname=?,timing=?,address=?,phoneno=?,rating=?,about=?,lat=?,log=?,cityid=?,pincode=?,specialization=? where pathologyid=? ",
				bean.getPathologyname(), bean.getTiming(), bean.getAddress(), bean.getPhoneno(), bean.getRating(),
				bean.getAbout(), bean.getLat(), bean.getLog(), bean.getCityid(), bean.getPincode(),
				bean.getSpecialization(), bean.getPathologyid());
		return bean;
	}

	public List<UserBean> listAssignUserPathology() {
		java.util.List<UserBean> pathologyBean = stmt.query("select * from users where roleid=5",
				BeanPropertyRowMapper.newInstance(UserBean.class));
		return pathologyBean;
	}

	public void addAssignUserPathology(PathologyBean pathologyBean) {
		// TODO Auto-generated method stub
		int pathologyid = addPathology(pathologyBean);

		pathologyBean.setPathologyid(pathologyid);
		
		stmt.update("insert into userpathology(userid,pathologyid) values(?,?)",
				pathologyBean.getUserid(), pathologyBean.getPathologyid());
	}
}
