package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bean.DoctorProfileBean;
import com.bean.UserBean;

@Repository
public class Sessiondao {
	@Autowired
	JdbcTemplate stmt;

	public int insertUser(UserBean userBean) {
		// TODO Auto-generated method stub
		KeyHolder keyholder = new GeneratedKeyHolder();
		String insertSql = "insert into users (email,password,firstname,lastname,gender,roleid,status,statusreason,otp) values(?,?,?,?,?,?,?,?,?)";

		stmt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				PreparedStatement pstmt = con.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, userBean.getEmail());
				pstmt.setString(2, userBean.getPassword());
				pstmt.setString(3, userBean.getFirstname());
				pstmt.setString(4, userBean.getLastname());
				pstmt.setString(5, userBean.getGender());
				pstmt.setInt(6, userBean.getRoleid());
				pstmt.setInt(7, userBean.getStatus());
				pstmt.setString(8, userBean.getStatusReason());
				pstmt.setString(9, userBean.getOtp());

				return pstmt;
			}
		}, keyholder);

		int userId = (Integer) keyholder.getKeys().get("userid");
		System.out.println(userId);
		userBean.setUserid(userId);
		return userBean.getUserid();

	}

	public void addDoctorProfile(DoctorProfileBean doctorProfileBean) {
		UserBean userBean = new UserBean();
		userBean.setEmail(doctorProfileBean.getEmail());
		userBean.setPassword(doctorProfileBean.getPassword());
		userBean.setFirstname(doctorProfileBean.getFirstname());
		userBean.setLastname(doctorProfileBean.getLastname());
		userBean.setGender(doctorProfileBean.getGender());
		userBean.setRoleid(doctorProfileBean.getRoleid());
		userBean.setStatus(doctorProfileBean.getStatus());
		userBean.setStatusReason(doctorProfileBean.getStatusReason());
		userBean.setOtp(doctorProfileBean.getOtp());

		int userId = insertUser(userBean);
		doctorProfileBean.setUserid(userId);
		System.out.println("userid");

		stmt.update(
				"insert into doctorprofile (userid,qualification,specialization,experience,profilepic,about,registrationno) values(?,?,?,?,?,?,?)",
				doctorProfileBean.getUserid(), doctorProfileBean.getQualification(),
				doctorProfileBean.getSpecialization(), doctorProfileBean.getExperience(),
				doctorProfileBean.getProfilepic(), doctorProfileBean.getAbout(),
				doctorProfileBean.getRegisterationno());
		System.out.println("insert call");

	}

	public List<UserBean> listuser() {
		// TODO Auto-generated method stub
		List<UserBean> user = stmt.query("select * from users", BeanPropertyRowMapper.newInstance(UserBean.class));

		return user;
	}

	public UserBean login(String email, String password) {
		// TODO Auto-generated method stub
		UserBean signup = null;
		try {
			signup = stmt.queryForObject("select * from users where email=? and password=?",
					new Object[] { email, password }, BeanPropertyRowMapper.newInstance(UserBean.class));
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("No such user");
		}
		return signup;
	}

}
