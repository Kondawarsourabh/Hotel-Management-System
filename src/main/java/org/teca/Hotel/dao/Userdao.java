package org.teca.Hotel.dao;

import java.util.List;

import org.teca.Hotel.entity.UserInformation;

public interface Userdao
{
	UserInformation userRegitration(UserInformation un);
	UserInformation userLogIn(String emailid,String password);
	List<UserInformation> getAlluserdetails();

}
