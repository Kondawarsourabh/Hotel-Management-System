package org.teca.Hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.teca.Hotel.dao.HotelDao;
import org.teca.Hotel.entity.HotelInformation;
import org.teca.Hotel.entity.UserInformation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HotelController {

	@Autowired
	private HotelDao hotelDao;
	@RequestMapping("/addHotel")
	public String getHotel(Model model) {
		HotelInformation hotelInformation = new HotelInformation();
		model.addAttribute("hotelinformation", hotelInformation);
		return "AddHotel";		
	}
	
	@RequestMapping("/hotelInformation")
	@ResponseBody
	public String addHotel(HotelInformation he) {
		HotelInformation hotelInformation=hotelDao.addHotel(he);
		System.out.println(hotelInformation);
		if(hotelInformation!=null)
		{
			return "hotel added";
		}
		else {
			return "BookHotel";
		}
	}
	@RequestMapping("/gethotelbyid")
	public String getHotelId(int hotelid,HttpServletRequest request,Model model)
	{
		//System.out.println(hotelid);
		
		HotelInformation hotelinformation=hotelDao.getHotelDetailsById(hotelid);
		
		HttpSession session=request.getSession();
		
		UserInformation userinformation=(UserInformation) session.getAttribute("user");
		model.addAttribute("user", userinformation);
		
		session.setAttribute("balaramhotel", hotelinformation);
		
		model.addAttribute("hotelname", hotelinformation.getHotelname());
		model.addAttribute("price", hotelinformation.getPrice());
		System.out.println(hotelinformation);
		System.out.println(userinformation);
		
		return "BookHotel";
	}
	
}