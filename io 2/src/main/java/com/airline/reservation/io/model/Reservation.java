package com.airline.reservation.io.model;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Value;

@Value

public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private String invoiceNum;
	private int SeatNumber;

	@ManyToMany
	private List<Flight> flights;


}
