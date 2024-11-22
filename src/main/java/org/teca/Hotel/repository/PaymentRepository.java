package org.teca.Hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teca.Hotel.entity.Payment;

public interface PaymentRepository  extends JpaRepository<Payment,Integer>	
{

}
