package com.sscm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sscm.dao.AdminDao;
import com.sscm.entity.Admin;
import com.sscm.service.AdminService;
@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	@Resource
	private AdminDao adminDao;

	@Override
	public Admin login(String username, String password) {
		return adminDao.loginAdmin(username, password);
	}

	@Override
	public void change(Admin admin) {
		adminDao.change(admin);
	}

}
