package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.DoctorProfileBean;
import com.bean.ResponseBean;
import com.dao.DoctorProfiledoa;

@RestController
public class DoctorProfileController {

	@Autowired
	DoctorProfiledoa dao;

	@PostMapping("addDoctor")
	public ResponseBean<DoctorProfileBean> addDoctor(DoctorProfileBean db) {
		ResponseBean<DoctorProfileBean> response = new ResponseBean<>();

		dao.addDoctor(db);

		response.setData(db);
		response.setMsg("Doctor Added");
		response.setStatus(201);

		return response;
	}
	@GetMapping("/listDoctor")
	public ResponseBean<List<DoctorProfileBean>> listDoctor() {
	ResponseBean<List<DoctorProfileBean>> response = new ResponseBean<>();

	java.util.List<DoctorProfileBean> doctorBean = dao.listdoctor();
	response.setData(doctorBean);
	response.setMsg(" Doctor List Display..!!!!");
	response.setStatus(201);
	return response;
	}
	
	
	
	
}
