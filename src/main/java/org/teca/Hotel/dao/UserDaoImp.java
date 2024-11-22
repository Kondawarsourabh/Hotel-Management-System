package org.teca.Hotel.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.teca.Hotel.entity.UserInformation;
import org.teca.Hotel.repository.UserRepositroy;


@Component
public class UserDaoImp implements Userdao{

	@Autowired
	private UserRepositroy repositroy;
	@Override
	public UserInformation userRegitration(UserInformation un) {		
		 
		  return repositroy.save(un);
	}
	@Override
	public UserInformation userLogIn(String emailid, String password) {
		return repositroy.findByEmailidAndPassword(emailid, password);
	}
	@Override
	public List<UserInformation> getAlluserdetails() {
	
		return repositroy.findAll();
	}

}
