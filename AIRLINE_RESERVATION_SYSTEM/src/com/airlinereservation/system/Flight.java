package com.airlinereservation.system;

import java.util.List;

public class Flight {
		
		// Declaring member variables
		private String FlightNo;
		private Airport fromAirport;
		private Airport toAirport;
		private String departTime;
		private String arriveTime;
		private Integer numOfSeats;
		private AirLines airlines;
		private List<Integer> seatNumbers;
		private List<Employee> CrewMembers;
		//private List<Employee> assignedEmployee;
		
		// Constructors
		public Flight(Airport fromAirport, Airport toAirport, String departTime, String arriveTime, Integer numOfSeats,
				AirLines airlines, List<Integer> seatNumbers,String FlightNo) {
			super();
			this.fromAirport = fromAirport;
			this.toAirport = toAirport;
			this.departTime = departTime;
			this.arriveTime = arriveTime;
			this.numOfSeats = numOfSeats;
			this.airlines = airlines;
			this.seatNumbers = seatNumbers;
			this.FlightNo=FlightNo;
		}
		
		//getters and setters for airline, airport and employees with seat numbers
		public List<Integer> getSeatNumbers()	{
			return seatNumbers;
		}

		public void setSeatNumbers(List<Integer> seatNumbers) {
			this.seatNumbers = seatNumbers;
		}
		public Airport getFromAirport() {
			return fromAirport;
		}
		public void setFromAirport(Airport fromAirport) {
			this.fromAirport = fromAirport;
		}
		public Airport getToAirport() {
			return toAirport;
		}
		public void setToAirport(Airport toAirport) {
			this.toAirport = toAirport;
		}
		public String getDepartTime() {
			return departTime;
		}
		public void setDepartTime(String departTime) {
			this.departTime = departTime;
		}
		public String getArriveTime() {
			return arriveTime;
		}
		public void setArriveTime(String arriveTime) {
			this.arriveTime = arriveTime;
		}
		public Integer getNumOfSeats() {
			return numOfSeats;
		}
		public void setNumOfSeats(Integer numOfSeats) {
			this.numOfSeats = numOfSeats;
		}
		public AirLines getAirlines() {
			return airlines;
		}
		public void setAirlines(AirLines airlines) {
			this.airlines = airlines;
		}
		public String getFlightNo() {
			return FlightNo;
		}
		public void setFlightNo(String flightNo) {
			FlightNo = flightNo;
		}
		public List<Employee> getCrewMembers() {
			return CrewMembers;
		}
		public void setCrewMembers(List<Employee> crewMembers) {
			CrewMembers = crewMembers;
		}
		@Override
		public String toString() {
			return "FlightNo=" + FlightNo + ", fromAirport=" + fromAirport + ", toAirport=" + toAirport
					+ ", departTime=" + departTime + ", arriveTime=" + arriveTime + ", numOfSeats=" + numOfSeats
					+ ", airlines=" + airlines + ", seatNumbers=" + seatNumbers + "]";
		}
		
	

}
