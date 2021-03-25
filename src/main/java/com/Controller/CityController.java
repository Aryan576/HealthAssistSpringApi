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

import com.bean.CityBean;
import com.bean.ResponseBean;
import com.dao.Citydao;

@CrossOrigin
@RestController
public class CityController {

	@Autowired
	Citydao citiesDao;

	@PostMapping("/addCities")
	public ResponseBean<CityBean> addCities(@RequestBody CityBean citiesBean) {
		citiesDao.addCities(citiesBean);
		ResponseBean<CityBean> response = new ResponseBean<>();
		response.setData(citiesBean);
		response.setMsg("Cities Inserted successfully...!!");
		response.setStatus(200);
		return response;

	}

	@GetMapping("/listCities")
	public ResponseBean<List<CityBean>> listCities() {
		ResponseBean<List<CityBean>> response = new ResponseBean<>();

		List<CityBean> roleBean = citiesDao.listCities();
		response.setData(roleBean);
		response.setMsg("Cities List Display..!!!!");
		response.setStatus(201);
		return response;
	}

	@DeleteMapping("/addCities/{CityId}")
	public ResponseBean<CityBean> deleteCities(@PathVariable("CityId") int CityId) {

		ResponseBean<CityBean> response = new ResponseBean<>();
		citiesDao.deleteCities(CityId);
		response.setMsg("Deleted Successfully..!!");
		response.setStatus(200);
		return response;
	}

	@GetMapping("/getCities/{cityid}")
	public ResponseBean<CityBean> getCities(@PathVariable("cityid") int cityid, CityBean bean) {
		ResponseBean<CityBean> responseBean = new ResponseBean<>();
		bean = citiesDao.getCityById(cityid);
		responseBean.setData(bean);
		responseBean.setMsg("Single City Return");
		responseBean.setStatus(200);

		return responseBean;
	}

	@PutMapping("/updateCities")
	public ResponseBean<CityBean> updateCities(@RequestBody CityBean cityBean) {
		citiesDao.updateCities(cityBean);
		ResponseBean<CityBean> response = new ResponseBean<>();
		response.setData(cityBean);
		response.setMsg("Cities Updated Successfully..!!");

		return response;
	}

}
