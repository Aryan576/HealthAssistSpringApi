package com.Controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.bean.DoctorProfileBean;
import com.bean.LoginBean;
import com.bean.ResponseBean;

import com.bean.UserBean;
import com.dao.Sessiondao;

import com.service.MailerService;
import com.service.OtpService;

@RestController
public class SessionController {
	@Autowired
	Sessiondao sessionDao;
	@Autowired
	OtpService OtpService;
	@Autowired
	MailerService mailerService;

	@PostMapping("login")
	public ResponseBean<UserBean> Login(@RequestBody LoginBean login) {
		UserBean signup = null;
		System.out.println(login.getEmail());
		ResponseBean<UserBean> response = new ResponseBean<>();
		signup = sessionDao.login(login.getEmail(), login.getPassword());
		response.setData(signup);
		response.setMsg("user Login");
		response.setStatus(200);

		return response;
	}

	@PostMapping("/signup")
	public ResponseBean<UserBean> signup(@RequestBody UserBean userBean) {

		userBean.setOtp(OtpService.generateOtp());
		mailerService.sendOtpForUserVerification(userBean);
		sessionDao.insertUser(userBean);

		ResponseBean<UserBean> responseBean = new ResponseBean<>();

		responseBean.setData(userBean);
		responseBean.setMsg("user successfully signup!!");
		responseBean.setStatus(200);

		return responseBean;
	}

	@PostMapping("/doctorsignup")
	public ResponseBean<UserBean> doctorSignup(@RequestBody DoctorProfileBean doctorProfileBean) {
		
		
		doctorProfileBean.setStatus(UserBean.KYC_DOCTOR);
		doctorProfileBean.setStatusReason("Your KYS is pending Our Team Will Contact You Soon..");
		mailerService.sendDoctorRegisterMail(doctorProfileBean);
			System.out.println("doctor");
			sessionDao.addDoctorProfile(doctorProfileBean);
		ResponseBean<UserBean> responseBean = new ResponseBean<>();
		
		responseBean.setData(doctorProfileBean);
		responseBean.setMsg("user successfully signup!!");
		responseBean.setStatus(200);

		return responseBean;
	}

	@GetMapping("users")
	public ResponseBean<List<UserBean>> Listuser() {
		ResponseBean<List<UserBean>> response = new ResponseBean<>();
		List<UserBean> signupbean = sessionDao.listuser();

		response.setData(signupbean);
		response.setMsg("Users");
		response.setStatus(200);
		return response;
	}

}
