package org.teca.Hotel.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teca.Hotel.entity.BookingInformation;
import org.teca.Hotel.entity.HotelInformation;
import org.teca.Hotel.entity.UserInformation;

import jakarta.servlet.http.HttpServletRequest;
@Controller
public class BookingController 
{
	@RequestMapping("/b")
	public String getBookingDetails(BookingInformation information ,Model model,HttpServletRequest request
			)
	{
		
	    request.getSession().setAttribute("bookinginformation", information);
		if(information.getBookingdate().isAfter(LocalDate.now())
				||information.getBookingdate().isEqual(LocalDate.now()))
		{
			
			model.addAttribute("totalprice",information.getPrice());
			System.out.println(information);
			return "AfterHotelPayment";
			
		}
		else
		{
			UserInformation userInformation =
					(UserInformation) request.getSession().getAttribute("user");
			model.addAttribute("user", userInformation);
			HotelInformation hotelInformation=(HotelInformation)request.getSession().getAttribute("balaramhotel");
			model.addAttribute("hotelname", hotelInformation.getHotelname());
			model.addAttribute("price", hotelInformation.getPrice());
			model.addAttribute("msg","Invalid Date");
			
			
			return "BookHotel";
			
		}
		
		
	}

}
