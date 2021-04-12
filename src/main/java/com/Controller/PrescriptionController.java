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

import com.bean.PrescriptionBean;
import com.bean.ResponseBean;
import com.dao.Prescriptiondao;

@CrossOrigin
@RestController
public class PrescriptionController {
	@Autowired
	Prescriptiondao prescriptionDao;

	@PostMapping("/addPrescription")
	public ResponseBean<PrescriptionBean> addPrescription(@RequestBody PrescriptionBean prescriptionBean) {
		prescriptionDao.addPrescription(prescriptionBean);

		ResponseBean<PrescriptionBean> responseBean = new ResponseBean<>();

		responseBean.setData(prescriptionBean);
		responseBean.setMsg("Prescription Added!!");
		responseBean.setStatus(200);

		return responseBean;
	}
	
	@PostMapping("/addPrescriptionMedicine")
    public ResponseBean<PrescriptionBean> addPrescriptionMedicine(@RequestBody PrescriptionBean prescriptionBean) {
		prescriptionDao.addPrescriptionMedicine(prescriptionBean);
        ResponseBean<PrescriptionBean> response = new ResponseBean<>();
        response.setData(prescriptionBean);
        response.setMsg("Prescription Medicine Added...!!");
        response.setStatus(200);
        return response;

    }

	@GetMapping("/listPrescription")
	public ResponseBean<List<PrescriptionBean>> listPrescription() {

		List<PrescriptionBean> prescriptionBean = prescriptionDao.listPrescription();

		ResponseBean<List<PrescriptionBean>> responseBean = new ResponseBean<>();

		responseBean.setData(prescriptionBean);
		responseBean.setMsg("Prescription List!!");
		responseBean.setStatus(200);

		return responseBean;
	}

	@GetMapping("/getPrescriptionById/{prescriptionId}")
	public ResponseBean<PrescriptionBean> getPrescriptionById(@PathVariable("prescriptionId") int prescriptionId) {
		PrescriptionBean prescriptionBean = prescriptionDao.getPrescriptionById(prescriptionId);

		ResponseBean<PrescriptionBean> responseBean = new ResponseBean<>();

		responseBean.setData(prescriptionBean);
		responseBean.setMsg("Prescription By Id!!");
		responseBean.setStatus(200);

		return responseBean;
	}

	@PutMapping("/updatePrescription")
	public ResponseBean<PrescriptionBean> updatePrescription(@RequestBody PrescriptionBean prescriptionBean) {
		prescriptionDao.updatePrescription(prescriptionBean);

		ResponseBean<PrescriptionBean> responseBean = new ResponseBean<>();

		responseBean.setData(prescriptionBean);
		responseBean.setMsg("Prescription Updated");
		responseBean.setStatus(200);

		return responseBean;
	}
	
	@DeleteMapping("/deletePrescription/{prescriptionid}")
	public ResponseBean<PrescriptionBean> deletePrescription(@PathVariable("prescriptionid") int prescriptionid){
		prescriptionDao.deletePrescription(prescriptionid);
	
		ResponseBean<PrescriptionBean> responseBean = new ResponseBean<>();
		
		responseBean.setMsg("Prescription Deleted!!");
		responseBean.setStatus(200);
	
		return responseBean;
	}
}
