package com.Controller;


import java.util.Date;
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

import com.bean.BookAppointmentBean;
import com.bean.ResponseBean;
import com.dao.BookAppointmentdao;

@CrossOrigin
@RestController
public class BookAppointmentController {

	@Autowired
	BookAppointmentdao dao;

	@PostMapping("bookAppointment")
	public ResponseBean<BookAppointmentBean> bookAppointment(@RequestBody BookAppointmentBean bean) {
			
		ResponseBean<BookAppointmentBean> response = new ResponseBean<>();
		bean.setApp_create_date(new Date());
		dao.bookppointment(bean);
		response.setData(bean);
		response.setMsg("AppointmentBooked...");
		response.setStatus(200);

		return response;

	}

	@GetMapping("ListAppointment")
	public ResponseBean<List<BookAppointmentBean>> ListAppointment() {
		ResponseBean<List<BookAppointmentBean>> response = new ResponseBean<>();
		List<BookAppointmentBean> bean = dao.ListAppointment();

		response.setData(bean);
		response.setMsg("Appointment List");
		response.setStatus(200);

		return response;

	}
	
	@GetMapping("ListAppointmentUser/{userid}")
	public ResponseBean<List<BookAppointmentBean>> ListAppointment(@PathVariable("userid") int userid) {
		ResponseBean<List<BookAppointmentBean>> response = new ResponseBean<>();
		List<BookAppointmentBean> bean = dao.ListAppointment(userid);

		response.setData(bean);
		response.setMsg("Appointment List");
		response.setStatus(200);

		return response;

	}

	@DeleteMapping("deleteappointment/{appointmentid}")
	public ResponseBean<BookAppointmentBean> deleteappointment(@PathVariable("appointmentid") int appointmentid) {
		ResponseBean<BookAppointmentBean> response = new ResponseBean<>();
		BookAppointmentBean bean = dao.deleteappointment(appointmentid);

		response.setData(bean);
		if (bean != null) {
			response.setMsg("Appointment Deleted");
		} else {
			response.setMsg("Appointment Not Found");
		}
		response.setStatus(200);

		return response;
	}

	@PutMapping("updateappointment")
	public ResponseBean<BookAppointmentBean> updateAppointment(@RequestBody BookAppointmentBean bean) {
		ResponseBean<BookAppointmentBean> response = new ResponseBean<>();
		dao.updateAppointment(bean);
		response.setData(bean);
		response.setMsg("Appointment Updated");
		response.setStatus(200);
		return response;
	}
	
	@PutMapping("accept_reject_Appointment")
	public ResponseBean<BookAppointmentBean> Accept_Reject_Appointment(@RequestBody BookAppointmentBean appointmentBean)
	{
		ResponseBean<BookAppointmentBean> response =new ResponseBean<>();
		dao.accept_reject_Appointment(appointmentBean);
		response.setData(appointmentBean);
		response.setMsg("Appointment Status Updated successfuly");
		response.setStatus(200);
		
		return response;
		
	}
	
	 @GetMapping("/listAppointmentForDoctor/{userid}")
	    public ResponseBean<java.util.List<BookAppointmentBean>> listAppointmentForDoctor(@PathVariable("userid") int userid) {
	        ResponseBean<java.util.List<BookAppointmentBean>> response = new ResponseBean<>();
	        System.out.println("Appointment ID "+userid);
	        java.util.List<BookAppointmentBean> appointmentBean = dao.listAppointmentForDoctor(userid);
	        response.setData(appointmentBean);
	        response.setMsg("Appointment List Display..!!!!");
	        response.setStatus(201);
	        return response;
	    }
	 
	 @GetMapping("/getappointmentid/{appointmentid}")
	    public ResponseBean<BookAppointmentBean> getUser(@PathVariable("appointmentid") int appointmentid, BookAppointmentBean bean) {

	        ResponseBean<BookAppointmentBean> responseBean = new ResponseBean<>();
	        bean = dao.getAppointmentById(appointmentid);
	        responseBean.setData(bean);
	        responseBean.setMsg("Single Appointment Return");
	        responseBean.setStatus(200);

	        return responseBean;
	    }
}
