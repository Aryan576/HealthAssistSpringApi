package com.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.DoctorProfileBean;
import com.bean.ResponseBean;
import com.bean.UserBean;
import com.dao.DoctorProfiledoa;

@RestController
public class DoctorProfileController {

	@Autowired
	DoctorProfiledoa dao;

	@GetMapping("/listDoctor")
	public ResponseBean<List<DoctorProfileBean>> listDoctor() {
		ResponseBean<List<DoctorProfileBean>> response = new ResponseBean<>();

		java.util.List<DoctorProfileBean> doctorBean = dao.listdoctor();
		response.setData(doctorBean);
		response.setMsg(" Doctor List Display..!!!!");
		response.setStatus(200);
		return response;
	}

	@GetMapping("getDoctorById/{userid}")
	public ResponseBean<DoctorProfileBean> getDoctorById(@PathVariable("userid") int userid, DoctorProfileBean bean) {
		ResponseBean<DoctorProfileBean> response = new ResponseBean<>();
		bean = dao.getDoctorById(userid);

		response.setData(bean);
		response.setMsg("Doctor By Id");
		response.setStatus(200);
		return response;

	}

	@PutMapping("updatedoctorprofile")
	public ResponseBean<DoctorProfileBean> updateDoctor(@RequestBody DoctorProfileBean bean) {

		ResponseBean<DoctorProfileBean> response = new ResponseBean<>();
		System.out.println(bean.getRegisterationno());
		System.out.println(bean.getStatus());

		dao.updatedoctor(bean);
		response.setData(bean);
		response.setMsg("Doctor Profile Updated");
		response.setStatus(200);
		return response;
	}

	@DeleteMapping("deletedoctor/{userid}")
	public ResponseBean<DoctorProfileBean> deleteDoctor(@PathVariable("userid") int userid, DoctorProfileBean bean) {
		ResponseBean<DoctorProfileBean> response = new ResponseBean<>();
		bean = dao.deleteDoctor(userid);

		response.setData(bean);
		if (bean != null) {
			response.setMsg("Doctor Deleted");
			response.setStatus(200);
		} else {
			response.setMsg("No Doctor Found");
			response.setStatus(201);
		}
		return response;

	}
	
	
	@GetMapping("/kycDoctor")
	public ResponseBean<java.util.List<DoctorProfileBean>> kycDoctor() {
		ResponseBean<java.util.List<DoctorProfileBean>> response = new ResponseBean<>();

		java.util.List<DoctorProfileBean> doctorBean = dao.kycDoctor();
		response.setData(doctorBean);
		response.setMsg("KYC Doctor List Display..!!!!");
		response.setStatus(201);
		return response;
	}
	
	@GetMapping("/activeDoctor")
	public ResponseBean<java.util.List<DoctorProfileBean>> activeDoctor() {
		ResponseBean<java.util.List<DoctorProfileBean>> response = new ResponseBean<>();

		java.util.List<DoctorProfileBean> doctorBean = dao.activeDoctor();
		response.setData(doctorBean);
		response.setMsg("Active Doctor List Display..!!!!");
		response.setStatus(201);
		return response;
	}
	
	@GetMapping("/pendingDoctor")
	public ResponseBean<java.util.List<DoctorProfileBean>> pendingDoctor() {
		ResponseBean<java.util.List<DoctorProfileBean>> response = new ResponseBean<>();

		java.util.List<DoctorProfileBean> doctorBean = dao.pendingDoctor();
		response.setData(doctorBean);
		response.setMsg("Pending Doctor List Display..!!!!");
		response.setStatus(201);
		return response;
	}
	
	
	@GetMapping("/pauseDoctor")
	public ResponseBean<java.util.List<DoctorProfileBean>> pauseDoctor() {
		ResponseBean<java.util.List<DoctorProfileBean>> response = new ResponseBean<>();

		java.util.List<DoctorProfileBean> doctorBean = dao.pauseDoctor();
		response.setData(doctorBean);
		response.setMsg("Pause Doctor List Display..!!!!");
		response.setStatus(201);
		return response;
	}

}
