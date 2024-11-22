package org.teca.Hotel.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teca.Hotel.dao.HotelDao;
import org.teca.Hotel.dao.Userdao;
import org.teca.Hotel.entity.HotelInformation;
import org.teca.Hotel.entity.UserInformation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController
{
	@Autowired
	private Userdao dao;
	@Autowired
	private HotelDao hotelDao;
     @RequestMapping("/registration")     
	public String userRegistrationPage(Model model)
	{
    	 UserInformation information = new UserInformation();
    	 model.addAttribute("userinformation",information);
		return "AddUsers";
	}
//     @RequestMapping("/userInformation")
//     @ResponseBody
//public ModelAndView getUserInformation(UserInformation un,ModelAndView mv) {
//    	 UserInformation information= dao.userRegitration(un);
//    	 if (information!=null) {
//    		 mv.setViewName("Login");
//			return mv;
//		} else {
//			mv.addObject("message", "invalid information");
//			return mv;
//		}
     
     @RequestMapping("/userInformation")
//     @ResponseBody
     public String getUserInformation(UserInformation un,Model model) {
    	 UserInformation information= dao.userRegitration(un);
    	 if (information!=null) {
    		 
			return "Login";
			
		} else {
			model.addAttribute("msg", "Invalid details");
			return "Addusers";
		}
	
}
     
     @RequestMapping("/loginpage")
     public String loginpage() {
    	 return "Login";
		
	}
     
     
     @RequestMapping("/userlogin")
     public String userLoginDetails(String emailid,String password ,Model model,HttpServletRequest request) {
		UserInformation userInformation = dao.userLogIn(emailid, password);
		HttpSession session=request.getSession();
		//Store the user information in session object to male us
		//in hotel controller class
		
		session.setAttribute("user", userInformation);
		if(userInformation!=null) 
		{
			List<HotelInformation> listOfHotelInformations =hotelDao.getAllHotelDetails();
			model.addAttribute("HotelDetails", listOfHotelInformations);
			return "HotelList";
		}
		else {
			System.err.println("invalid details.....");
			model.addAttribute("msg1", "invalid details");
			return "Login";
		}
	}
     
     @RequestMapping("/searchByCity")
     public String getCity(String city,Model model)
     {
    	 System.out.println(city);
    	 List<HotelInformation> byCity=hotelDao.getHotelDetailsByCity(city);
    	 model.addAttribute("HotelDetails", byCity);
    	 System.out.println(byCity);
    	 return "HotelList";
     }
}