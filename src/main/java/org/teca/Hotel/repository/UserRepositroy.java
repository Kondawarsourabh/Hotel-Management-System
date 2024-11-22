package org.teca.Hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teca.Hotel.entity.UserInformation;

public interface UserRepositroy extends  JpaRepository<UserInformation, Integer>
{
	UserInformation findByEmailidAndPassword(String emailid, String password);
}
