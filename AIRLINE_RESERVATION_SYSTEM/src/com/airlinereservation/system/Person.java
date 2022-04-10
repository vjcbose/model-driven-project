package com.airlinereservation.system;

import java.util.Date;

public abstract class Person{
		
		private String name;
		private String email;
		private String mobile;
		private Date dob;
		
		//Constructors
		public Person() {
			super();		
		}
		public Person(String name, String email, String mobile, Date dob) {
			super();
			this.name = name;
			this.email = email;
			this.mobile = mobile;
			this.dob = dob;
		}
		
		//getters and setters for name, email and other attributes of the person
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public Date getDob() {
			return dob;
		}
		public void setDob(Date dob) {
			this.dob = dob;
		}
	

}
