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
import com.service.MailerService;

@CrossOrigin
@RestController
public class BookAppointmentController {

	@Autowired
	BookAppointmentdao dao;
	@Autowired
	MailerService mailerService;

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
	 
	 @GetMapping("/pastAppointmentList/{patientid}")
		public ResponseBean<List<BookAppointmentBean>> pastAppointmentList(@PathVariable("patientid") int patientid){
			List<BookAppointmentBean> Bean = dao.pastAppointmentList(patientid);
			
			ResponseBean<List<BookAppointmentBean>> responseBean = new ResponseBean<>();
		
			responseBean.setData(Bean);	
			responseBean.setMsg("User Diet List!!");
			responseBean.setStatus(200);
			
			return responseBean;
		}
	 
	 @PutMapping("/done_appointment")
	 public ResponseBean<BookAppointmentBean> done_Appointment(@RequestBody BookAppointmentBean appointmentBean) {
	 dao.done_Appointment(appointmentBean);
	 ResponseBean<BookAppointmentBean> response = new ResponseBean<>();
	 response.setData(appointmentBean);
	 response.setMsg("Details Submited Successfully..!!");
	 return response;
	 }
	 
	 @GetMapping("/todayAppointment/{userid}")
	 public ResponseBean<java.util.List<BookAppointmentBean>> todayAppointment(@PathVariable("userid") int userid) {
	 ResponseBean<java.util.List<BookAppointmentBean>> response = new ResponseBean<>();
	 java.util.List<BookAppointmentBean> appointmentBean = dao.todayAppointment(userid);
	 response.setData(appointmentBean);
	 response.setMsg(" Today Appointment Display..!!!!");
	 response.setStatus(201);
	 return response;
	 }

	 @GetMapping("/waitForAcceptAppointment/{userid}")
	 public ResponseBean<java.util.List<BookAppointmentBean>> waitForAcceptAppointment(@PathVariable("userid") int userid) {
	 ResponseBean<java.util.List<BookAppointmentBean>> response = new ResponseBean<>();
	 java.util.List<BookAppointmentBean> appointmentBean = dao.waitForAcceptAppointment(userid);
	 response.setData(appointmentBean);
	 response.setMsg(" Wait For Accept Appointment Display..!!!!");
	 response.setStatus(201);
	 return response;
	 }

	 @GetMapping("/acceptAppointment/{userid}")
	 public ResponseBean<java.util.List<BookAppointmentBean>> acceptAppointment(@PathVariable("userid") int userid) {
	 ResponseBean<java.util.List<BookAppointmentBean>> response = new ResponseBean<>();
	 java.util.List<BookAppointmentBean> appointmentBean = dao.acceptAppointment(userid);
	 response.setData(appointmentBean);
	 response.setMsg("Accept Appointment Display..!!!!");
	 response.setStatus(201);
	 return response;
	 }

	 @GetMapping("/rescheduleAppointment/{userid}")
	 public ResponseBean<java.util.List<BookAppointmentBean>> rescheduleAppointment(@PathVariable("userid") int userid) {
	 ResponseBean<java.util.List<BookAppointmentBean>> response = new ResponseBean<>();
	 java.util.List<BookAppointmentBean> appointmentBean = dao.rescheduleAppointment(userid);
	 response.setData(appointmentBean);
	 response.setMsg("Reschedule Appointment Display..!!!!");
	 response.setStatus(201);
	 return response;
	 }

	 @GetMapping("/doneAppointment/{userid}")
	 public ResponseBean<java.util.List<BookAppointmentBean>> doneAppointment(@PathVariable("userid") int userid) {
	 ResponseBean<java.util.List<BookAppointmentBean>> response = new ResponseBean<>();
	 java.util.List<BookAppointmentBean> appointmentBean = dao.doneAppointment(userid);
	 response.setData(appointmentBean);
	 response.setMsg("Done Appointment Display..!!!!");
	 response.setStatus(201);
	 return response;
	 }
	 
	 @PutMapping("/updateRescheduleAppointment")
	 public ResponseBean<BookAppointmentBean> updateRescheduleAppointment(@RequestBody BookAppointmentBean appointmentBean) {
	 System.out.println("fhfhf"+appointmentBean.getStatusreason());
		 dao.updateRescheduleAppointment(appointmentBean);
	 
	 ResponseBean<BookAppointmentBean> response = new ResponseBean<>();
	 response.setData(appointmentBean);
	 response.setMsg("Appointment Reject Successfully..!!");
	 return response;
	 }
	 
	 @PutMapping("/updateRejectAppointment")
	 public ResponseBean<BookAppointmentBean> updateRejectAppointment(@RequestBody BookAppointmentBean appointmentBean) {
	 System.out.println("fhfhf"+appointmentBean.getStatusreason());
		 dao.updateRejectAppointment(appointmentBean);
	 
	 ResponseBean<BookAppointmentBean> response = new ResponseBean<>();
	 response.setData(appointmentBean);
	 response.setMsg("Appointment Reject Successfully..!!");
	 return response;
	 }


	 @GetMapping("/rescheduleReason/{email}/{appointmentid}")
	 public ResponseBean<BookAppointmentBean> sendRescheduleReason(@PathVariable("email") String email,@PathVariable("appointmentid") int appointmentid) {
	 System.out.println("Reschedule Reason call...");

	 BookAppointmentBean bean = dao.getRescheduleReasonByEmail(email,appointmentid);

	 ResponseBean<BookAppointmentBean> responseBean = new ResponseBean<>();

	 responseBean.setData(bean);

	 if (bean == null) {

	 responseBean.setMsg("Invalid Email Address");
	 responseBean.setStatus(201);

	 } else {


	 mailerService.sendRescheduleReason(bean);

	 responseBean.setMsg("Email sent for Reschedule");
	 responseBean.setStatus(200);

	 }

	 return responseBean;
	 }
	 
	 
	 
	 
	 @GetMapping("/rejectReason/{email}/{appointmentid}")
	 public ResponseBean<BookAppointmentBean> sendRejectReason(@PathVariable("email") String email,@PathVariable("appointmentid") int appointmentid) {
	 System.out.println("Reject Reason call...");

	 BookAppointmentBean bean = dao.getRejectReasonByEmail(email,appointmentid);

	 ResponseBean<BookAppointmentBean> responseBean = new ResponseBean<>();

	 responseBean.setData(bean);

	 if (bean == null) {

	 responseBean.setMsg("Invalid Email Address");
	 responseBean.setStatus(201);

	 } else {


	 mailerService.sendRejectReason(bean);

	 responseBean.setMsg("Email sent for Reject");
	 responseBean.setStatus(200);

	 }

	 return responseBean;
	 }
	 
	 @GetMapping("/doneAppointmentForAllDoctor")
	    public ResponseBean<java.util.List<BookAppointmentBean>> doneAppointmentForAllDoctor() {
	        ResponseBean<java.util.List<BookAppointmentBean>> response = new ResponseBean<>();
	        java.util.List<BookAppointmentBean> appointmentBean = dao.doneAppointmentForAllDoctor();
	        response.setData(appointmentBean);
	        response.setMsg("Done Appointment Display..!!!!");
	        response.setStatus(201);
	        return response;
	    }
	 
	 
	 @GetMapping("/listAllAppointment")
	    public ResponseBean<java.util.List<BookAppointmentBean>> listAllAppointment() {
	        ResponseBean<java.util.List<BookAppointmentBean>> response = new ResponseBean<>();
	        java.util.List<BookAppointmentBean> appointmentBean = dao.listAllAppointment();
	        response.setData(appointmentBean);
	        response.setMsg("Appointment List Display..!!!!");
	        response.setStatus(201);
	        return response;
	    }
	 
	 @GetMapping("/viewPatientAppointment/{userid}")
	    public ResponseBean<java.util.List<BookAppointmentBean>> viewPatientAppointment(@PathVariable("userid") int userid) {
	        ResponseBean<java.util.List<BookAppointmentBean>> response = new ResponseBean<>();
	        
	        java.util.List<BookAppointmentBean> appointmentBean = dao.viewPatientAppointment(userid);
	        response.setData(appointmentBean);
	        response.setMsg("Appointment List Display..!!!!");
	        response.setStatus(201);
	        return response;
	    }
	 
	 @GetMapping("/getPatientDetails/{appointmentid}")
	    public ResponseBean<BookAppointmentBean> getPatientDetails(@PathVariable("appointmentid") int appointmentid, BookAppointmentBean bean) {
	        ResponseBean<BookAppointmentBean> responseBean = new ResponseBean<>();
	        bean = dao.getPatientDetailsById(appointmentid);
	        responseBean.setData(bean);
	        responseBean.setMsg("Single Patient Details Return");
	        responseBean.setStatus(200);

	        return responseBean;
	    }
	   
	 
	 
}
