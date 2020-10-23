package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ClinicBean;
import com.bean.ResponseBean;
import com.dao.Clinicdao;

@RestController
public class ClinicController {
	@Autowired
	Clinicdao dao;
	@PostMapping("addclinic")
	public ResponseBean<ClinicBean> addclinic(ClinicBean clinicBean)
	{
		ResponseBean<ClinicBean> response =new ResponseBean<>();
		dao.adddoctor(clinicBean);
		response.setData(clinicBean);
		response.setMsg("Clinic Added");
		response.setStatus(201);
		
		return response;
	}

}
