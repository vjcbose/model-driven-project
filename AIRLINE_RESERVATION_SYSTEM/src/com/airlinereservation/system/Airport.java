package com.airlinereservation.system;


	public class Airport {

		private String city;
		

	    //constructor
		public Airport(String city) {
			super();
			this.city = city;
		}
		
		//To print the airport city details
		@Override
		public String toString() {
			return "Airport [city=" + city + "]";
		}
		
		//getters and setters to set and get the city details
		public String getCity() {
			return city;
		}
		
		public void setCity(String city) {
			this.city = city;
		}
		
	
}
