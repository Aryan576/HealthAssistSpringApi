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

import com.bean.DiseaseBean;
import com.bean.ResponseBean;
import com.dao.Diseasedao;

@RestController
public class DiseaseController {
	@Autowired
	Diseasedao dao;
	
	@PostMapping("/addDisease")
	public ResponseBean<DiseaseBean> addDisease(@RequestBody DiseaseBean diseaseBean) {

		dao.addDisease(diseaseBean);

		ResponseBean<DiseaseBean> responseBean = new ResponseBean<>();

		responseBean.setData(diseaseBean);
		responseBean.setMsg("Disease Added!!");
		responseBean.setStatus(200);

		return responseBean;
	}

	@GetMapping("/listDisease")
	public ResponseBean<List<DiseaseBean>> listDisease() {
		List<DiseaseBean> diseaseBean = dao.listDisease();

		ResponseBean<List<DiseaseBean>> responseBean = new ResponseBean<>();

		responseBean.setData(diseaseBean);
		responseBean.setMsg("Disease List!!");
		responseBean.setStatus(200);

		return responseBean;
	}

	@PutMapping("/updateDisease")
	public ResponseBean<DiseaseBean> updateDisease(@RequestBody DiseaseBean diseaseBean) {

		dao.updateDisease(diseaseBean);

		ResponseBean<DiseaseBean> responseBean = new ResponseBean<>();

		responseBean.setData(diseaseBean);
		responseBean.setMsg("Disease Updated!!");
		responseBean.setStatus(200);

		return responseBean;
	}

	@DeleteMapping("/deleteDisease/{diseaseid}")
	public ResponseBean<DiseaseBean> deleteDisease(@PathVariable("diseaseid") int diseaseid) {

		DiseaseBean bean=dao.deleteDisease(diseaseid);

		ResponseBean<DiseaseBean> responseBean = new ResponseBean<>();

		responseBean.setMsg("Disease Deleted!!");
		responseBean.setStatus(200);

		return responseBean;
	}

}
