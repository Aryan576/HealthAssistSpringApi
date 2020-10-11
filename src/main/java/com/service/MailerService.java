package com.service;

import org.springframework.stereotype.Service;

import com.bean.DoctorProfileBean;
import com.bean.UserBean;

@Service
public class MailerService {
	public void sendOtpForUserVerification(UserBean userBean) {
		// mail logic
	}

	public void sendWelcomeMail(UserBean userBean) {

	}

	public void sendDoctorRegisterMail(DoctorProfileBean doctorProfileBean) {
		
	}

	public void sendDoctorWelcomeMail(DoctorProfileBean doctorProfileBean) {
		
	}

}
