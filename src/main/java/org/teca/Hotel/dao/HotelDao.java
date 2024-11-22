package org.teca.Hotel.dao;

import java.util.List;


import org.teca.Hotel.entity.HotelInformation;

public interface HotelDao 
{
	HotelInformation addHotel(HotelInformation hi);
	List<HotelInformation> getAllHotelDetails();
	List<HotelInformation> getHotelDetailsByCity(String city);
	HotelInformation getHotelDetailsById(int hotelid);	
	

}
