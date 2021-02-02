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
import com.bean.RoleBean;
import com.dao.Roledao;
@CrossOrigin
@RestController
public class RoleController {
	@Autowired
	Roledao dao;

	@PostMapping("addrole")
	public ResponseBean<RoleBean> addrole(@RequestBody RoleBean role) {
		dao.addrole(role);
		ResponseBean<RoleBean> response = new ResponseBean<>();

		response.setData(role);
		response.setMsg("Role Added");
		response.setStatus(200);

		return response;
	}

	@GetMapping("listRole")
	public ResponseBean<List<RoleBean>> listrole() {

		ResponseBean<List<RoleBean>> response = new ResponseBean<>();
		List<RoleBean> role = dao.listRole();
		response.setData(role);
		response.setMsg("List of Roles");
		response.setStatus(200);

		return response;
	}

	@DeleteMapping("deleteRole/{roleid}")
	public ResponseBean<RoleBean> deleterole(@PathVariable("roleid") int roleid) {

		ResponseBean<RoleBean> response = new ResponseBean<>();

		RoleBean role = dao.deleterole(roleid);

		response.setData(role);
		if (role != null) {
			response.setMsg("Role Deleted");
		} else {

			response.setMsg("Role Not Found");
		}
		response.setStatus(200);
		return response;
	}

	@PutMapping("updateRole")
	public ResponseBean<RoleBean> updateRole(RoleBean rolebean) {
		ResponseBean<RoleBean> response = new ResponseBean<>();
		dao.updateRole(rolebean);
		response.setData(rolebean);
		response.setMsg("Role Updated");
		response.setStatus(200);

		return response;
	}
}
