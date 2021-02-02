package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Doctor_ClinicBean;
import com.bean.ResponseBean;
import com.dao.Doctor_Clinicdao;
@CrossOrigin
@RestController
public class Doctor_ClinicController {
	@Autowired 
	Doctor_Clinicdao dao;
	
	@PostMapping("Doctor_Clinic")
	public ResponseBean<Doctor_ClinicBean> addDocClinic(@RequestBody Doctor_ClinicBean bean){
		
		ResponseBean<Doctor_ClinicBean> response = new ResponseBean<>();
		dao.addDoctorClinic(bean);
		response.setData(bean);
		response.setMsg("Doctor Clinic Added");
		response.setStatus(201);
		return response;
	}

}
