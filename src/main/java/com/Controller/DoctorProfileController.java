package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
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
}
