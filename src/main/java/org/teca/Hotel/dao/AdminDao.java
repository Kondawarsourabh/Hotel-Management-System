package org.teca.Hotel.dao;

import org.teca.Hotel.entity.Admin;

public interface AdminDao {
	
	Admin addingAdmin(Admin admin);
	Admin adminValidation(String email,String password);


}
