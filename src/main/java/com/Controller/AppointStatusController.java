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

import com.bean.AppointmentStatusBean;
import com.bean.ResponseBean;
import com.dao.AppointmentStatusdao;

@RestController
public class AppointStatusController {

	@Autowired
	AppointmentStatusdao dao;

	@PostMapping("appointmentstatus")
	public ResponseBean<AppointmentStatusBean> addappointmentstatus(@RequestBody AppointmentStatusBean bean) {
		ResponseBean<AppointmentStatusBean> response = new ResponseBean<>();
		dao.addappointmentstatus(bean);
		response.setData(bean);
		response.setMsg("Appointment Status added");
		response.setStatus(200);

		return response;
	}

	@GetMapping("Listappointmentstatus")
	public ResponseBean<List<AppointmentStatusBean>> Listappointmentstatus() {
		ResponseBean<List<AppointmentStatusBean>> response = new ResponseBean<>();
		List<AppointmentStatusBean> bean = dao.listappointmentstatus();

		response.setData(bean);
		response.setMsg("Appointment Status List");
		response.setStatus(200);

		return response;
	}

	@DeleteMapping("deleteappointmentstatus/{statusid}")
	public ResponseBean<AppointmentStatusBean> deletestatus(@PathVariable("statusid") int statusid) {

		ResponseBean<AppointmentStatusBean> response = new ResponseBean<>();
		AppointmentStatusBean bean = dao.deletestatus(statusid);
		response.setData(bean);

		if (bean != null) {
			response.setMsg("Appointmentstatus Deleted");
		} else {
			response.setMsg("Appointment Status Not Found");
		}
		response.setStatus(200);

		return response;
	}

	@PutMapping("updateappointmentstatus")
	public ResponseBean<AppointmentStatusBean> updateAppointmentstatus(@RequestBody AppointmentStatusBean bean) {
		ResponseBean<AppointmentStatusBean> response = new ResponseBean<>();
		dao.updateAppointmentstatus(bean);
		response.setData(bean);
		response.setMsg("AppointmentStatus Updated");
		response.setStatus(200);
		return response;
	}

}
