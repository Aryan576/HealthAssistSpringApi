package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.PrescriptionmedicineBean;
import com.bean.ResponseBean;
import com.dao.Prescriptionmedicinedao;

@RestController
@CrossOrigin
public class PrescriptionmedicineController {

	@Autowired
	Prescriptionmedicinedao prescriptionmedicineDao;

	@GetMapping("/listPrescriptionMedicine")
	public ResponseBean<java.util.List<PrescriptionmedicineBean>> listPrescriptionMedicine() {
		ResponseBean<java.util.List<PrescriptionmedicineBean>> response = new ResponseBean<>();

		java.util.List<PrescriptionmedicineBean> prescriptionmedicineBean = prescriptionmedicineDao
				.listPrescriptionMedicine();
		response.setData(prescriptionmedicineBean);
		response.setMsg("Prescription Medicine List Display..!!!!");
		response.setStatus(201);
		return response;
	}

	@GetMapping("/getPrescriptionMedicine/{prescriptionmedicineid}")
	public ResponseBean<PrescriptionmedicineBean> getPrescriptionMedicine(
			@PathVariable("prescriptionmedicineid") int prescriptionmedicineid,
			PrescriptionmedicineBean prescriptionmedicineBean) {
		ResponseBean<PrescriptionmedicineBean> responseBean = new ResponseBean<>();
		prescriptionmedicineBean = prescriptionmedicineDao.getPrescriptionMedicineById(prescriptionmedicineid);
		responseBean.setData(prescriptionmedicineBean);
		responseBean.setMsg("Single Prescription Medicine Return");
		responseBean.setStatus(200);

		return responseBean;
	}

	@PutMapping("/updatePrescriptionMedicine")
	public ResponseBean<PrescriptionmedicineBean> updatePrescriptionMedicine(
			@RequestBody PrescriptionmedicineBean prescriptionmedicineBean) {
		prescriptionmedicineDao.updatePrescriptionMedicine(prescriptionmedicineBean);
		ResponseBean<PrescriptionmedicineBean> response = new ResponseBean<>();
		response.setData(prescriptionmedicineBean);
		response.setMsg("Prescription Medicine Updated..!!");

		return response;
	}

	@DeleteMapping("/addPrescriptionMedicine/{prescriptionmedicineid}")
	public ResponseBean<PrescriptionmedicineBean> deletePrescriptionMedicine(
			@PathVariable("prescriptionmedicineid") int prescriptionmedicineid) {

		ResponseBean<PrescriptionmedicineBean> response = new ResponseBean<>();
		prescriptionmedicineDao.deletePrescriptionMedicine(prescriptionmedicineid);
		response.setMsg("Prescription Medicine Deleted..!!");
		response.setStatus(200);
		return response;
	}

}
