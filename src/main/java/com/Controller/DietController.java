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

import com.bean.DietBean;
import com.bean.ResponseBean;
import com.dao.Dietdao;


@CrossOrigin
@RestController
public class DietController {
	
	@Autowired
	Dietdao dao;
	
	@PostMapping("/addDiet")
	public ResponseBean<DietBean> addDiet(@RequestBody DietBean dietBean){
		dao.addDiet(dietBean);
		ResponseBean<DietBean> response = new ResponseBean<>();
		response.setData(dietBean);
		response.setMsg("Diet Added successfully...!!");
		response.setStatus(200);
		return response;
		
	}
	
	@GetMapping("/listDiet")
	public ResponseBean<List<DietBean>> listDiet()
	{
		ResponseBean<List<DietBean>> response = new ResponseBean<>();

		java.util.List<DietBean> dietBean = dao.listDiet();
		response.setData(dietBean);
		response.setMsg("Diet List Display..!!!!");
		response.setStatus(201);
		return response;
	}
	
	@GetMapping("/getDiet/{dietid}")
	public ResponseBean<DietBean> getDiet(@PathVariable("dietid") int dietid , DietBean bean){
		
		ResponseBean<DietBean> responseBean = new ResponseBean<>();
		bean = dao.getDietById(dietid);
		responseBean.setData(bean);
		responseBean.setMsg("Single Diet Return");
		responseBean.setStatus(200);
	
		return responseBean;
	}
	
	@DeleteMapping("/addDiet/{dietid}")
	public ResponseBean<DietBean> deleteDiet(@PathVariable("dietid")int dietid){
		
		ResponseBean<DietBean> response = new ResponseBean<>();
		dao.deleteDiet(dietid);
		response.setMsg("Diet Deleted Successfully..!!");
		response.setStatus(200);
		return response;
	}
	
	@PutMapping("/updateDiet")
	public ResponseBean<DietBean> updateDiet(@RequestBody DietBean dietBean){
		dao.updateDiet(dietBean);
		ResponseBean<DietBean> response = new ResponseBean<>();
		response.setData(dietBean);
		response.setMsg("Diet Updated Successfully..!!");
		return response;
	}
	
	

}
