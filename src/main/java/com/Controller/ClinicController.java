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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ClinicBean;
import com.bean.PharmacyBean;
import com.bean.ResponseBean;
import com.dao.Clinicdao;
@CrossOrigin
@RestController
public class ClinicController {
	@Autowired
	Clinicdao dao;
	@PostMapping("addclinic")
	public ResponseBean<ClinicBean> addclinic( @RequestBody ClinicBean clinicBean )
	{
		ResponseBean<ClinicBean> response =new ResponseBean<>();
		dao.addclinic(clinicBean);
		response.setData(clinicBean);
		response.setMsg("Clinic Added");
		response.setStatus(201);
		
		return response;
	}
	@GetMapping("clinics")
	public ResponseBean<List<ClinicBean>> listClinic(){
		
		ResponseBean<List<ClinicBean>> response = new ResponseBean<>();
		List<ClinicBean> bean =dao.listclinic();
		response.setData(bean);
		response.setMsg("Clinic List");
		response.setStatus(201);
		return response;
	}
	@DeleteMapping("deleteClinic/{clinicid}")
	public ResponseBean<ClinicBean> deleteClinic(@PathVariable("clinicid") int clinicid){
		ResponseBean<ClinicBean> response =new ResponseBean<>();
		ClinicBean clinicBean = dao.deleteclinic(clinicid);
		response.setData(clinicBean);
		if(clinicBean != null)
		{
			response.setMsg("Clinic Deleted");
		}else {
			response.setMsg("Clinic not found!");
		}
		response.setStatus(201);
		return response;
		
	}
	@PutMapping("updateClinic")
	public ResponseBean<ClinicBean> updateClinic(@RequestBody ClinicBean clinicbean){
		ResponseBean<ClinicBean> response =new ResponseBean<>();
		
		dao.updateclinic(clinicbean);
		response.setData(clinicbean);
		response.setMsg("Clinic Updated");
		response.setStatus(201);
		return response;
	}
	
	@GetMapping("searchClinic")
	public ResponseBean<List<ClinicBean>> searchClinic(@RequestParam("clinicname") String searchName)
	{
		ResponseBean<List<ClinicBean>> response = new ResponseBean<>();
		
		List<ClinicBean> bean1  =dao.seachClinic(searchName);
		System.out.println("Body"+searchName);
		
		
		System.out.println("After Search "+bean1);
		response.setData(bean1);
		response.setMsg("List Of Clinics");
		response.setStatus(200);
		return response;
	}
	
	@GetMapping("getclinicById/{clinicid}")
	public ResponseBean<ClinicBean> getPharamcyById(@PathVariable("clinicid")int clinicid,ClinicBean bean){
		ResponseBean<ClinicBean> response =new ResponseBean<>();
		bean=dao.getClinicById(clinicid);
		response.setData(bean);
		response.setMsg("Pharamcy By ID");
		response.setStatus(200);
		return response;
		
	}
	
	
	
	
	
}
