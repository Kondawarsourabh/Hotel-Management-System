package org.teca.Hotel.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.teca.Hotel.entity.HotelInformation;
import org.teca.Hotel.repository.HotelRepository;

@Component
public class HotelDaoImp implements HotelDao {

	@Autowired
	private HotelRepository hotelRepository;
	
	public HotelInformation addHotel(HotelInformation h) {
		System.out.println(h);
		return hotelRepository.save(h);
	}

	@Override
	public List<HotelInformation> getAllHotelDetails() {
		return hotelRepository.findAll();
		
	}

	@Override
	public List<HotelInformation> getHotelDetailsByCity(String city) {
	
		return hotelRepository.findByCity(city);
	}

	@Override
	public HotelInformation getHotelDetailsById(int hotelid) {
		HotelInformation hotelInformation=
		hotelRepository.findById(hotelid).orElse(new HotelInformation());
		return hotelInformation ;
		
		
	}

	

}
