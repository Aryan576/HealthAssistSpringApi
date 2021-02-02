package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ResponseBean;
import com.bean.User_PharmacyBean;
import com.dao.User_Pharmacydao;
@CrossOrigin
@RestController
public class User_PharmacyController {
	
	@Autowired
	User_Pharmacydao dao;
	
	@PostMapping("addUserPharmacy")
	public ResponseBean<User_PharmacyBean> addUserPharmacy(@RequestBody User_PharmacyBean bean){
		ResponseBean<User_PharmacyBean> response =new ResponseBean<>();
		dao.adduserpharmacy(bean);
		response.setData(bean);
		response.setMsg("User_Pharmacy Added");
		response.setStatus(200);
		return response;
	}
	
	@GetMapping("listuserpharmacy")
	public ResponseBean<List<User_PharmacyBean>> listuserpharmacy(){
		ResponseBean<List<User_PharmacyBean>> response = new ResponseBean<>();
		List<User_PharmacyBean> bean= dao.listuser();
		response.setData(bean);
		response.setMsg("User_Pharmacy");
		response.setStatus(200);
		return response;
	}
	

}
