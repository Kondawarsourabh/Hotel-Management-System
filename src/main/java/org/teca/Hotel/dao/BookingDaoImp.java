package org.teca.Hotel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.teca.Hotel.entity.BookingInformation;
import org.teca.Hotel.repository.BookingRepository;
@Component
public class BookingDaoImp implements BookingDao
{
	@Autowired
	 private BookingRepository bookingRepository;

	public BookingInformation getBookingDetails(BookingInformation bookinginformation) {
		
		
		return bookingRepository.save(bookinginformation);
	}
	

}
