package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
@RestController
public class PatientProfileController {

	@Autowired
	PatientProfiledao dao;

	@PostMapping("patientprofile")
	public ResponseBean<PatientProfileBean> addpatientprofile(@RequestBody PatientProfileBean bean) {
		ResponseBean<PatientProfileBean> responsebean = new ResponseBean<>();
		dao.addpatientprofile(bean);

		responsebean.setData(bean);
		responsebean.setMsg(" Patent Profile Added");
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
	
	@GetMapping("/getuserPatient/{userid}")
	public ResponseBean<PatientProfileBean> getUser(@PathVariable("userid") int userid, PatientProfileBean bean) {

		ResponseBean<PatientProfileBean> responseBean = new ResponseBean<>();
		bean = dao.getPatientById(userid);
		responseBean.setData(bean);
		responseBean.setMsg("Single User Return");
		responseBean.setStatus(200);

		return responseBean;
	}
    
    @GetMapping("/getPatientprofile/{userid}")
	public ResponseBean<PatientProfileBean> getProfile(@PathVariable("userid") int userid, PatientProfileBean bean) {

		ResponseBean<PatientProfileBean> responseBean = new ResponseBean<>();
		bean = dao.getPatientProfileById(userid);
		responseBean.setData(bean);
		responseBean.setMsg("Single User Return");
		responseBean.setStatus(200);

		return responseBean;
	}
    
    
    @GetMapping("/listUserPatient/{userid}")
    public ResponseBean<java.util.List<PatientProfileBean>> listUserPatient(@PathVariable("userid") int userid) {
        ResponseBean<java.util.List<PatientProfileBean>> response = new ResponseBean<>();
     
        java.util.List<PatientProfileBean> userPatientBean = dao.listUserPatient(userid);
        response.setData(userPatientBean);
        response.setMsg("User Patient Display..!!!!");
        response.setStatus(201);
        return response;
    }
    
    @GetMapping("/getFamilyMember/{patientid}")
	public ResponseBean<PatientProfileBean> getFamilyMember(@PathVariable("patientid") int patientid, PatientProfileBean bean) {

		ResponseBean<PatientProfileBean> responseBean = new ResponseBean<>();
		bean = dao.getFamilyMember(patientid);
		responseBean.setData(bean);
		responseBean.setMsg("Single User Return");
		responseBean.setStatus(200);

		return responseBean;
	}
    
    @PutMapping("/updateFamilyMember")
    public ResponseBean<PatientProfileBean> updateFamilyMember(@RequestBody PatientProfileBean patientBean) {
    	dao.updateFamilyMember(patientBean);
        ResponseBean<PatientProfileBean> response = new ResponseBean<>();
        response.setData(patientBean);
        response.setMsg("Patient Updated Successfully..!!");
        return response;
    }
    
    

}
