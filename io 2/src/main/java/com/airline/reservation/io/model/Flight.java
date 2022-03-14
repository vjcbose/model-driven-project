package com.airline.reservation.io.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Value;

@Value
@Entity
@Table

public class Flight {
	private String destination;
	private String departure;
	private String departTime;
	private String arriveTime;
	private int numOfSeats;
	
}
