package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ResponseBean;
import com.bean.user_pathologyBean;
import com.dao.user_pathologydao;

@RestController
public class User_pathologyController {
	
	@Autowired
	user_pathologydao dao;
	
	@PostMapping("addUserPathology")
	public ResponseBean<user_pathologyBean> adduserpathology(@RequestBody user_pathologyBean bean){
		ResponseBean<user_pathologyBean> resposne = new ResponseBean<>();
			dao.adduserpathology(bean);
		resposne.setData(bean);
		resposne.setMsg("User_Pathology Added");
		resposne.setStatus(201);
		return resposne;
	}
	

}
