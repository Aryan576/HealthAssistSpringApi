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

import com.bean.ResponseBean;
import com.bean.StateBean;
import com.dao.Statedao;

@CrossOrigin
@RestController
public class StateController {

	@Autowired
	Statedao stateDao;

	@PostMapping("/addState")
	public ResponseBean<StateBean> addState(@RequestBody StateBean stateBean) {
		stateDao.addState(stateBean);
		ResponseBean<StateBean> response = new ResponseBean<>();
		response.setData(stateBean);
		response.setMsg("State Inserted successfully...!!");
		response.setStatus(200);
		return response;

	}

	@GetMapping("/listState")
	public ResponseBean<java.util.List<StateBean>> listState() {
		ResponseBean<List<StateBean>> response = new ResponseBean<>();

		List<StateBean> roleBean = stateDao.listState();
		response.setData(roleBean);
		response.setMsg("State List Display..!!!!");
		response.setStatus(201);
		return response;
	}

	@DeleteMapping("/addState/{stateid}")
	public ResponseBean<StateBean> deleteState(@PathVariable("stateid") int stateid) {

		ResponseBean<StateBean> response = new ResponseBean<>();
		stateDao.deleteState(stateid);
		response.setMsg("State Deleted Successfully..!!");
		response.setStatus(200);
		return response;
	}

	@GetMapping("/getState/{stateid}")
	public ResponseBean<StateBean> getStateid(@PathVariable("stateid") int stateid, StateBean bean) {
		ResponseBean<StateBean> responseBean = new ResponseBean<>();
		bean = stateDao.getStateById(stateid);
		responseBean.setData(bean);
		responseBean.setMsg("Single City Return");
		responseBean.setStatus(200);

		return responseBean;
	}

	@PutMapping("/updateState")
	public ResponseBean<StateBean> updateCities(@RequestBody StateBean stateBean) {
		stateDao.updateState(stateBean);
		ResponseBean<StateBean> response = new ResponseBean<>();
		response.setData(stateBean);
		response.setMsg("State Updated Successfully..!!");

		return response;
	}

}
