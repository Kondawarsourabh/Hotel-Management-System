package org.teca.Hotel.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HotelInformation 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotelid;
	private String hotelname;
	private double price;
	private String address;
	@Column(length=10)
	private String contactnumber;
	private String city;
}
