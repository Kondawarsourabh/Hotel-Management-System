package org.teca.Hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.teca.Hotel.dao.BookingDao;
import org.teca.Hotel.dao.PaymentDao;
import org.teca.Hotel.entity.BookingInformation;
import org.teca.Hotel.entity.Payment;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PaymentController 
{
	@Autowired
	private PaymentDao paymentdao;
	@Autowired
	private BookingDao bookingDao;
	@RequestMapping("/payment")
	@ResponseBody
	public String paymentdetails(Payment pay,HttpServletRequest request)
	{
	Payment Paymentdetails	=paymentdao.getPaymentDetails(pay);
	
	BookingInformation bookingInformation=(BookingInformation) 
			request.getSession().getAttribute("bookinginformation");
		
		bookingDao.getBookingDetails(bookingInformation);
		System.out.println(pay);
		return"UsersList";
	}


}
