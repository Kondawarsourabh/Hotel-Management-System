package org.teca.Hotel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.teca.Hotel.entity.Payment;
import org.teca.Hotel.repository.PaymentRepository;
@Component
public class PaymentDaoImp implements PaymentDao
{

	@Autowired
	private  PaymentRepository repository;
	@Override
	public Payment getPaymentDetails(Payment payment) 
	{
		return repository.save(payment);
	}
	

}
