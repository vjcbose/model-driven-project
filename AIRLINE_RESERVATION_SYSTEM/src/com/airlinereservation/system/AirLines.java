package com.airlinereservation.system;

import java.util.List;

public class AirLines {

	    private List<Employee> AirlineEmployees;
		private String name;
		private List<Flight> AirlineFlights;
		//constructor
		public AirLines(String name) {
			super();
			this.name = name;
		}
		//getters and setters
		public List<Employee> getAirlineEmployees() {
			return AirlineEmployees;
		}

		public void setAirlineEmployees(List<Employee> airlineEmployees) {
			AirlineEmployees = airlineEmployees;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Flight> getAirlineFlights() {
			return AirlineFlights;
		}

		public void setAirlineFlights(List<Flight> airlineFlights) {
			AirlineFlights = airlineFlights;
		}

	    //Remove flights
		public void removeFlight(Flight flight) {
			AirlineFlights.remove(flight);
		}
		//Adding Flights
		public void addFlight(Flight flight) {
			AirlineFlights.add(flight);
		}
		
		@Override
		public String toString() {
			return "AirLines [name=" + name + "]";
		}
		

}
