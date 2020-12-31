package com.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class Otpdao {
	@Autowired
	JdbcTemplate stmt;

	public void updateOtp(String email, String otp) {

		stmt.update("update users set otp = ? where email = ?",otp,email);
		
	}
}
