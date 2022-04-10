package com.airlinereservation.system;

	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Date;
	import java.util.List;
	import java.util.Scanner;
	import java.util.stream.Collectors;


	public class Passenger extends Person{
		
		private String paymentInfo;
		static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	    static List<Passenger> listOfPassengers=null;
	    
	    public String getPaymentInfo() {
			return paymentInfo;
		}

		public void setPaymentInfo(String paymentInfo) {
			this.paymentInfo = paymentInfo;
		}

	    
	    //Constructors
		public Passenger(String name, String email, String mobile, Date dob, String paymentInfo) {
			super(name, email, mobile, dob);
			this.paymentInfo=paymentInfo;
			// TODO Auto-generated constructor stub
		}
		
		public Passenger() {
			super();
		}
		//removed static
		// Static test data for testing out the passenger login functionality
		static {
			try {
				listOfPassengers=new ArrayList<>(List.of(
						new Passenger("Vinishaa","vinishaareddy@gmail.com","9999999999", formatter.parse("02-08-1998"),"A12"),
				        new Passenger("Veena","veena@gmail.com","7777777777",formatter.parse("07-05-2000"),"B12")
				        ));
			}
			catch(ParseException e) {
				e.printStackTrace();
			}
		}
		
		//passenger login functionality for verification of email address to access the application
		public void login() {
			System.out.println("Please enter your Email ID");
			Scanner scanner = new Scanner(System.in);
			String name=scanner.next();
			List<Passenger> passengerList = listOfPassengers.stream().filter(e->e.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
			if(passengerList != null && passengerList.size()==1) {
				System.out.println("Welcome.................."+passengerList.get(0).getName());
			}	
		}

	

}
