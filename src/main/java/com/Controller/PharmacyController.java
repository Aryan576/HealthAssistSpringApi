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

import com.bean.PharmacyBean;
import com.bean.ResponseBean;
import com.bean.UserBean;
import com.dao.Pharmacydao;
@CrossOrigin
@RestController
public class PharmacyController {
	@Autowired
	Pharmacydao dao;

	@PostMapping("addpharmacy")
	public ResponseBean<PharmacyBean> addpharmacy(@RequestBody PharmacyBean bean) {
		ResponseBean<PharmacyBean> response = new ResponseBean<>();
		
		
		dao.addpharmacy(bean);
		response.setData(bean);
		response.setMsg("Pharmacy Added");
		response.setStatus(201);
		return response;
	}

	@GetMapping("listpharmacy")
	public ResponseBean<List<PharmacyBean>> listpharmacy() {
		ResponseBean<List<PharmacyBean>> response = new ResponseBean<>();
		List<PharmacyBean> bean = dao.listpharmacy();
		response.setData(bean);
		response.setMsg("Pharmacy List");
		response.setStatus(201);
		return response;
	}

	@DeleteMapping("deletepharmacy/{pharmacyid}")
	public ResponseBean<PharmacyBean> deletepharmacy(@PathVariable("pharmacyid") int pharmacyid) {

		ResponseBean<PharmacyBean> response = new ResponseBean<>();
				System.out.println(pharmacyid);
		PharmacyBean bean = dao.deletepharacy(pharmacyid);

		response.setData(bean);

		if (bean != null) {
			response.setMsg("Pharmacy Deleted");
		} else {
			response.setMsg("pharmacy not found");
		}
		response.setStatus(200);

		return response;
	}
		
	@PutMapping("updatepharmacy")
	public ResponseBean<PharmacyBean> updatepharmacy( @RequestBody PharmacyBean bean){
		ResponseBean<PharmacyBean> response = new ResponseBean<>();
		
		
		dao.updatepharmacy(bean);
		System.out.println("Pharamcy Update call");
		System.out.println(bean.getTiming()+bean.getAddress());
		response.setData(bean);
		response.setMsg("Pharmacy updated");
		response.setStatus(200);
		
		return response;
		
		
	}
	@GetMapping("getPharmacyById/{pharmacyid}")
	public ResponseBean<PharmacyBean> getPharamcyById(@PathVariable("pharmacyid")int pharmacyid,PharmacyBean bean){
		ResponseBean<PharmacyBean> response =new ResponseBean<>();
		bean=dao.getPharmacyById(pharmacyid);
		response.setData(bean);
		response.setMsg("Pharamcy By ID");
		response.setStatus(200);
		return response;
		
	}
	
	 @GetMapping("/getAssignUserPharmacy")
	    public ResponseBean<java.util.List<UserBean>> getAssignUserPharmacy() {
	        ResponseBean<java.util.List<UserBean>> response = new ResponseBean<>();

	        java.util.List<UserBean> pharmacyBean = dao.listAssignUserPharmacy();
	        response.setData(pharmacyBean);
	        response.setMsg("User Pharmacy List Display..!!!!");
	        response.setStatus(201);
	        return response;
	    }
	
}
