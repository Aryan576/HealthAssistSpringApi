package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	@GetMapping("listDoctClinic")
	public ResponseBean<java.util.List<Doctor_ClinicBean>> listDoctClinic()
	{
	ResponseBean<List<Doctor_ClinicBean>> response = new ResponseBean<>();

	List<Doctor_ClinicBean> doctClinicBean = dao.listDoctCLinic();
	response.setData(doctClinicBean);
	response.setMsg("Doctor Clinic Display..!!!!");
	response.setStatus(200);
	return response;
	}

	

}
