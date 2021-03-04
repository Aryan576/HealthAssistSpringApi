package com.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.bean.DoctorProfileBean;
import com.bean.LoginBean;
import com.bean.ResponseBean;

import com.bean.UserBean;
import com.dao.Otpdao;
import com.dao.Sessiondao;

import com.service.MailerService;
import com.service.OtpService;

@CrossOrigin
@RestController
public class SessionController {
	@Autowired
	Sessiondao sessionDao;
	@Autowired
	OtpService OtpService;
	@Autowired
	MailerService mailerService;

	@Autowired
	Otpdao otpdao;

	@PostMapping("login")
	public ResponseBean<UserBean> Login(@RequestBody LoginBean login) {
		UserBean signup = null;
		System.out.println(login.getEmail());
		ResponseBean<UserBean> response = new ResponseBean<>();
		signup = sessionDao.login(login.getEmail(), login.getPassword());

		if (signup != null) {
			response.setData(signup);
			response.setMsg("user Login");
			response.setStatus(200);
		} else {
			response.setMsg("User Not Found !!!");
			response.setStatus(201);
		}

		return response;
	}

	@PostMapping("/signup")
	public ResponseBean<UserBean> signup(@RequestBody UserBean userBean) {

		

		ResponseBean<UserBean> responseBean = new ResponseBean<>();
			if(sessionDao.getUserByEmail(userBean.getEmail())!=null)
			{
				responseBean.setMsg("You Are Already Register");
				responseBean.setStatus(201);
					
			}else {
				userBean.setOtp(OtpService.generateOtp());
				mailerService.sendOtpForUserVerification(userBean);
				sessionDao.insertUser(userBean);
					responseBean.setData(userBean);
					responseBean.setMsg("user successfully signup!!");
					responseBean.setStatus(200);
			}

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

	@GetMapping("resetpassword/{email}")
	public ResponseBean<UserBean> sendOtpForResetPassword(@PathVariable("email") String email, UserBean userBean) {
			System.out.println("Reset Called");
		userBean = sessionDao.getUserByEmail(email);
		ResponseBean<UserBean> responseBean = new ResponseBean<>();

		if (userBean == null) {

			responseBean.setMsg("Invalid Email Address");
			responseBean.setStatus(201);

		} else {
			String otp = OtpService.generateOtp();
			userBean.setOtp(otp);
			otpdao.updateOtp(email, otp);
			mailerService.sendOtpForForgetPassword(userBean);

			responseBean.setMsg("Please Check Email for OTP");
			responseBean.setStatus(200);

		}

		return responseBean;
	}

	@GetMapping("setnewpassword/{otp}/{password}/{email}")
	public ResponseBean<UserBean> setNewPasswordUsingOtp(@PathVariable("otp") String otp,
			@PathVariable("password") String password, @PathVariable("email") String email) {

		UserBean dbUser = sessionDao.getUserByEmail(email);

		ResponseBean<UserBean> responseBean = new ResponseBean<>();

		if (dbUser == null) {

			responseBean.setMsg("User not found");
			responseBean.setStatus(201);

		} else {
			dbUser.setPassword(password);
			if (dbUser.getOtp().equals(otp)) {
				otpdao.updateOtp(email, "");
				sessionDao.updatePassword(dbUser);
				mailerService.sendMailForPasswordUpdate(dbUser);
				responseBean.setMsg("Password Update...");
				responseBean.setStatus(200);

			} else {
				responseBean.setMsg("Invalid Otp....");
				responseBean.setStatus(201);

			}

		}

		return responseBean;
	}

}
