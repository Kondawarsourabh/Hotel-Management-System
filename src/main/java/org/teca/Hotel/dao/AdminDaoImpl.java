package org.teca.Hotel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.teca.Hotel.entity.Admin;
import org.teca.Hotel.repository.AdminRepository;

@Component
public class AdminDaoImpl  implements AdminDao
{
	
	@Autowired
	private AdminRepository adminRepository;
	public Admin addingAdmin(Admin admin) {
		
		return adminRepository.save(admin);
	}
	public Admin adminValidation(String email, String password) {
		
		return adminRepository.findByEmailAndPassword(email, password);
	}


}
