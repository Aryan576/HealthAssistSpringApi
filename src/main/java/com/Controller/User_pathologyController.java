package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ResponseBean;
import com.bean.user_pathologyBean;
import com.dao.user_pathologydao;
@CrossOrigin
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
	
	 @GetMapping("/listUserPathology/{userid}")
	    public ResponseBean<java.util.List<user_pathologyBean>> listUserPathology(@PathVariable("userid") int userid) {
	        ResponseBean<java.util.List<user_pathologyBean>> response = new ResponseBean<>();

	        java.util.List<user_pathologyBean> userPathologyBean = dao.listUserPathology(userid);
	        response.setData(userPathologyBean);
	        response.setMsg("List Display..!!!!");
	        response.setStatus(201);
	        return response;
	    }
	

}
