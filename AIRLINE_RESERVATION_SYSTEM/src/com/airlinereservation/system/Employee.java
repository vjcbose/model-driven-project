package com.airlinereservation.system;

import java.util.Date;

public class Employee extends Person {

		private String role;

		public Employee(String name, String email, String mobile, Date dob,String role) {
			super(name, email, mobile, dob);
			this.role=role;
			// TODO Auto-generated constructor stub
		}

		//getter and setter to get and set the role for the employee
		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}
		
	
}
