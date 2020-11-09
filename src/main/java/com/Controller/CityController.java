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

import com.bean.CityBean;
import com.bean.ResponseBean;
import com.dao.Citydao;

@RestController
public class CityController {

	@Autowired
	Citydao dao;

	@PostMapping("addCity")
	public ResponseBean<CityBean> addcity(@RequestBody CityBean bean) {
		ResponseBean<CityBean> response = new ResponseBean<>();
		dao.addcity(bean);
		response.setData(bean);
		response.setMsg("City Added");
		response.setStatus(201);
		return response;
	}

	@GetMapping("getCity")
	public ResponseBean<List<CityBean>> getCity() {
		ResponseBean<List<CityBean>> response = new ResponseBean<>();
		List<CityBean> bean = dao.getCity();
		response.setData(bean);
		response.setMsg("Lsit Of Cities");
		response.setStatus(201);
		return response;
	}

	

}
