package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.DietUserBean;
import com.bean.ResponseBean;
import com.dao.DietUserdao;

@RestController
@CrossOrigin
public class DietUserController {
	
	
	@Autowired
	DietUserdao dietUserDao;
	
	@PostMapping("/addDietUser")
	public ResponseBean<DietUserBean> addDietUser(@RequestBody DietUserBean dietUserBean){
		
		dietUserDao.addDietUser(dietUserBean);
		
		ResponseBean<DietUserBean> responseBean = new ResponseBean<>();
		
		responseBean.setData(dietUserBean);
		responseBean.setMsg("User Diet Added!!");
		responseBean.setStatus(200);
		
		return responseBean;
	}
	
	@GetMapping("/listDietUser/{patientid}")
	public ResponseBean<List<DietUserBean>> listDietUser(@PathVariable("patientid") int patientid){
		List<DietUserBean> dietUserBean = dietUserDao.listDietUser(patientid);
		
		ResponseBean<List<DietUserBean>> responseBean = new ResponseBean<>();
	
		responseBean.setData(dietUserBean);	
		responseBean.setMsg("User Diet List!!");
		responseBean.setStatus(200);
		
		return responseBean;
	}

}
