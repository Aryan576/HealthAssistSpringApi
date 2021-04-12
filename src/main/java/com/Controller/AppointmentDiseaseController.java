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

import com.bean.AppointmentDiseaseBean;
import com.bean.ResponseBean;
import com.dao.AppointmentDiseasedao;

@RestController
@CrossOrigin
public class AppointmentDiseaseController {
	
	@Autowired
	AppointmentDiseasedao appointmentdiseaseDao;
	
	@PostMapping("/addAppointmentDisease")
	public ResponseBean<AppointmentDiseaseBean> addAppointmentDisease(@RequestBody AppointmentDiseaseBean appointmentDiseaseBean){
		
		appointmentdiseaseDao.addAppointmentDisease(appointmentDiseaseBean);
		
		ResponseBean<AppointmentDiseaseBean> responseBean = new ResponseBean<>();
		
		responseBean.setData(appointmentDiseaseBean);
		responseBean.setMsg("Appointment Disease Added!!");
		responseBean.setStatus(200);
		
		return responseBean;
	}
	
	@GetMapping("/listAppointmentDisease/{appointmentid}")
	public ResponseBean<List<AppointmentDiseaseBean>> listAppointmentDisease(@PathVariable("appointmentid") int appointmentid){
		List<AppointmentDiseaseBean> appointmentDiseaseBean = appointmentdiseaseDao.listAppointmentDisease(appointmentid);
		
		ResponseBean<List<AppointmentDiseaseBean>> responseBean = new ResponseBean<>();
	
		responseBean.setData(appointmentDiseaseBean);	
		responseBean.setMsg("Appointment Disease List!!");
		responseBean.setStatus(200);
		
		return responseBean;
	}
	
	@PutMapping("/updateAppointmentDisease")
	public ResponseBean<AppointmentDiseaseBean> updateAppointmentDisease(@RequestBody AppointmentDiseaseBean appointmentDiseaseBean){
		appointmentdiseaseDao.updateAppointmentDisease(appointmentDiseaseBean);
		
		ResponseBean<AppointmentDiseaseBean> responseBean = new ResponseBean<>();
		
		responseBean.setData(appointmentDiseaseBean);
		responseBean.setMsg("Appointment Disease Updated!!");
		responseBean.setStatus(200);
		
		return responseBean;
	}
	
	@GetMapping("/getAppointmentDisease/{appointmentdiseaseid}")
    public ResponseBean<AppointmentDiseaseBean> getAppointmentDisease(@PathVariable("appointmentdiseaseid") int appointmentdiseaseid, AppointmentDiseaseBean appointmentDiseaseBean) {
        ResponseBean<AppointmentDiseaseBean> responseBean = new ResponseBean<>();
        appointmentDiseaseBean = appointmentdiseaseDao.getAppointmentDiseaseById(appointmentdiseaseid);
        responseBean.setData(appointmentDiseaseBean);
        responseBean.setMsg("Single Appointment Disease Return");
        responseBean.setStatus(200);

        return responseBean;
    }
	
	@DeleteMapping("/deleteAppointmentDisease/{appointmentdiseaseid}")
	public ResponseBean<AppointmentDiseaseBean> deleteAppointmentDisease(@PathVariable("medicineid") int appointmentdiseaseid){
		appointmentdiseaseDao.deleteAppointmentDisease(appointmentdiseaseid);
		
		ResponseBean<AppointmentDiseaseBean> responseBean = new ResponseBean<>();
		
		responseBean.setMsg("Appointment Disease Deleted!!");
		responseBean.setStatus(200);
		
		return responseBean;
	}

}
