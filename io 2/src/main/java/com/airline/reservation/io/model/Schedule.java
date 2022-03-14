package com.airline.reservation.io.model;

import java.util.List;

import jakarta.*;
import lombok.Value;

@Value

public class Schedule {
	private String departDate;
	private String arriveDate;
	private String expectedDepartTime;
	private String expectedArriveTime;
	private boolean fullBooked;
	private boolean delay;
		

}
