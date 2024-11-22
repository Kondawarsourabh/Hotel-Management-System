package org.teca.Hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teca.Hotel.entity.BookingInformation;

public interface BookingRepository  extends JpaRepository<BookingInformation, Integer>
{
	

}
