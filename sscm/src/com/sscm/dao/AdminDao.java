package com.sscm.dao;

import com.sscm.entity.Admin;

public interface AdminDao {
	public Admin loginAdmin(String username,String password);
}
