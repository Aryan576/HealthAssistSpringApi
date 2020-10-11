package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.RoleBean;

@Repository
public class Roledao {
	@Autowired
	JdbcTemplate stmt;

	public void addrole(RoleBean role) {
		// TODO Auto-generated method stub
		stmt.update("insert into role (rolename) values(?)", role.getRolename());

	}

	public List<RoleBean> listRole() {
		// TODO Auto-generated method stub

		List<RoleBean> role = stmt.query("select * from role", BeanPropertyRowMapper.newInstance(RoleBean.class));
		return role;
	}

	public RoleBean deleterole(int roleid) {
		// TODO Auto-generated method stub
		RoleBean roleBean = null;

		roleBean = getRoleById(roleid);

		if (roleBean != null) {

			stmt.update("delete from role where roleid=?", roleid);
			
		}

		return roleBean;
	}

	public RoleBean getRoleById(int roleid) {

		RoleBean role = null;
		try {

			role = stmt.queryForObject("select * from role where roleid=?", new Object[] { roleid },
					BeanPropertyRowMapper.newInstance(RoleBean.class));

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Role not  Found" + e.getMessage());
		}

		return role;
	}

	public RoleBean updateRole(RoleBean rolebean) {
		// TODO Auto-generated method stub
		stmt.update("update  role set rolename=? where roleid=?", rolebean.getRolename(), rolebean.getRoleid());
		return rolebean;
	}
}
