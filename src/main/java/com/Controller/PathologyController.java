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

import com.bean.PathologyBean;
import com.bean.ResponseBean;
import com.dao.Pathologydao;

@RestController
public class PathologyController {

	@Autowired
	Pathologydao dao;

	@PostMapping("addPathology")
	public ResponseBean<PathologyBean> addpathology(@RequestBody PathologyBean bean) {

		ResponseBean<PathologyBean> response = new ResponseBean<>();
		dao.addPathology(bean);
		response.setData(bean);
		response.setMsg("Pathology Added");
		response.setStatus(201);

		return response;

	}

	@GetMapping("listPathology")
	public ResponseBean<List<PathologyBean>> listPathology() {
		ResponseBean<List<PathologyBean>> response = new ResponseBean<>();
		List<PathologyBean> bean = dao.listPathology();
		response.setData(bean);
		response.setMsg("Pathology List");
		response.setStatus(201);
		return response;
	}

	@DeleteMapping("deletepathology/{pathologyid}")
	public ResponseBean<PathologyBean> deletepathology(@PathVariable("pathologyid") int pathologyid) {
		ResponseBean<PathologyBean> response = new ResponseBean<>();
		PathologyBean bean = dao.deletepathology(pathologyid);

		response.setData(bean);
		if (bean != null) {
			response.setMsg("Pathology removed");
		} else {
			response.setMsg("Pathology not removed");
		}
		response.setStatus(200);
		return response;
	}

	@PutMapping("updatepathology")
	public ResponseBean<PathologyBean> updatepathology(PathologyBean bean) {
		ResponseBean<PathologyBean> response = new ResponseBean<>();
		dao.updatePathology(bean);
		response.setData(bean);
		response.setMsg("Pathology Updated");
		response.setStatus(201);
		return response;
	}

}
