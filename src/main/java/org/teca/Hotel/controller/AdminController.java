package org.teca.Hotel.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.teca.Hotel.dao.AdminDao;
import org.teca.Hotel.dao.Userdao;
import org.teca.Hotel.entity.Admin;
import org.teca.Hotel.entity.UserInformation;

@Controller

public class AdminController {
	
	
        @Autowired		
	  private AdminDao adminDao;
		@Autowired
		private Userdao userdao;
		
		@RequestMapping("/adminregister")
		public String addAdmine() {
			
			return "AdminRegistration";
		}
		@RequestMapping("/adminregistration")
		public String adminRegistration(Admin admin) {
			System.out.println(admin);
			Admin admin2=adminDao.addingAdmin(admin);
			return "AdminLogin";
		}
		
		@RequestMapping("/adminlogin")

		public String adminLogin(String email, String password,Model model) {
			
			Admin admin= adminDao.adminValidation(email, password);
			if (admin!=null) {
				
				System.out.println(email);
				System.out.println(password);
				List< UserInformation> list=userdao.getAlluserdetails();
				model.addAttribute("userinformation", list);
				return "UsersList";
			} else {
				
				System.out.println(email);
				System.out.println(password);
				model.addAttribute("msg", "invalid details");
				return "AdminLogin";
			}
			
		}
		@RequestMapping("/adminloginpage")
		public String adminLoginpage() {
			return "AdminLogin";
			
		}
		@RequestMapping("/getbookingdetails")
		@ResponseBody
		public String getbookinginfo(@Param("userid") int userid) {
			System.out.println("userid: "+userid);
			return "got id";
			
		}
		@RequestMapping("/perticulerbookinginfo")
		public String bookinginformation(Model model) {
			List< UserInformation> list=userdao.getAlluserdetails();
			model.addAttribute("userinformation", list);
			return "UsersList";
			
		
	}

}
