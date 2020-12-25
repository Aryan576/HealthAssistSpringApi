package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.PatientProfileBean;
import com.bean.ResponseBean;
import com.dao.PatientProfiledao;

@RestController
public class PatientProfileController {

	@Autowired
	PatientProfiledao dao;

	@PostMapping("patientprofile")
	public ResponseBean<PatientProfileBean> addpatientprofile(@RequestBody PatientProfileBean bean) {
		ResponseBean<PatientProfileBean> responsebean = new ResponseBean<>();
		dao.addpatientprofile(bean);

		responsebean.setData(bean);
		responsebean.setMsg(" Patent Profile Updated");
		responsebean.setStatus(200);

		return responsebean;
	}

	@GetMapping("ListPatientprofile")
	public ResponseBean<List<PatientProfileBean>> listPatientprofile() {
		ResponseBean<List<PatientProfileBean>> responsebean = new ResponseBean<>();
		List<PatientProfileBean> bean = dao.listprofile();

		responsebean.setData(bean);
		responsebean.setMsg("Patient Profile");
		responsebean.setStatus(200);

		return responsebean;

	}

	@DeleteMapping("PatientProfile/{patientid}")
	public ResponseBean<PatientProfileBean> deletepatientprofile(@PathVariable("patientid") int patientid) {
		ResponseBean<PatientProfileBean> response = new ResponseBean<>();
		PatientProfileBean bean = dao.deletepatientprofile(patientid);
		response.setData(bean);
		if (bean != null) {
			response.setMsg("PatientProfile delete");
		} else {
			response.setMsg("PatientProfile not Remove");
		}
		response.setStatus(200);

		return response;
	}

	@PutMapping("updatePatientProfile")
	public ResponseBean<PatientProfileBean> updatepatientprofile(@RequestBody PatientProfileBean bean) {
		ResponseBean<PatientProfileBean> response = new ResponseBean<>();
		dao.updatepatientprofile(bean);
		response.setData(bean);
		response.setMsg("Patient Profile Updated");
		response.setStatus(200);

		return response;
	}

}
