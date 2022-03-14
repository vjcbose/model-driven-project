package com.airline.reservation.io.model;

import java.util.List;

import jakarta.persistence.Column;

import org.springframework.data.annotation.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Value;

@Entity
@Table

@Value

public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private String mobileNumber;
	private String roles;
	
	@Column(unique = true)
	private String userName;
	private String password;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Reservation> reservations;

}
