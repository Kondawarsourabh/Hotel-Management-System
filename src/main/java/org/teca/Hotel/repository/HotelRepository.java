package org.teca.Hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.teca.Hotel.entity.HotelInformation;
import java.util.List;


public interface HotelRepository extends JpaRepository<HotelInformation, Integer>
{
	@Query("select hotel from HotelInformation hotel where hotel.city like %?1% or hotel.address like %?1%")
	List<HotelInformation> findByCity(String city);

}
