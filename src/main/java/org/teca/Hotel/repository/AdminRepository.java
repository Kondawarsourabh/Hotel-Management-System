package org.teca.Hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teca.Hotel.entity.Admin;

public interface AdminRepository  extends JpaRepository<Admin, Integer>{

	Admin findByEmailAndPassword(String email, String password);



}
