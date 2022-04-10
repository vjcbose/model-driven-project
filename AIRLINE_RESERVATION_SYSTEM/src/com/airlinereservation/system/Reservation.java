package com.airlinereservation.system;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

//reservation class for reservation related activities for extra provisions to the user.
public class Reservation {

	// member variables
	private String bookingId;
	private List<Integer> seatNumbers;
	private Integer numOfSeats = 0;
	private String invoiceNumber;
	Schedule shedule;
	static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	static List<Passenger> listOfPassengers = null;

	// constructor
	public Reservation(String bookingId, ArrayList<Integer> seatNumbers, String invoiceNumber, Schedule shedule) {
		super();
		this.bookingId = bookingId;
		this.seatNumbers = seatNumbers;
		this.invoiceNumber = invoiceNumber;
		this.shedule = shedule;
	}

	public Reservation() {
		super();
	}

	// static data for testing the passengers list
	static {
		try {
			listOfPassengers = new ArrayList<Passenger>(Arrays.asList(
					new Passenger("vinishaa", "vinishaareddy@gmail.com", "9999999999", formatter.parse("02-08-1998"),
							"A12"),
					new Passenger("Veena", "veena@gmail.com", "7777777777", formatter.parse("07-05-2000"), "B12")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	// maintaining reservations of all passengers
	static Map<String, Reservation> passengarReservation;

	// Get booking id
	public String getBookingId() {
		return bookingId;
	}

	// set booking id
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	// get seat numbers
	public List<Integer> getSeatNumber() {
		return seatNumbers;
	}

	// set seat numbers
	public void setSeatNumber(List<Integer> seatNumbers) {
		this.seatNumbers = seatNumbers;
	}

	public Integer getNumOfSeats() {
		return numOfSeats;
	}

	public void setNumOfSeats(Integer numOfSeats) {
		this.numOfSeats = numOfSeats;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Schedule getShedule() {
		return shedule;
	}

	public void setShedule(Schedule shedule) {
		this.shedule = shedule;
	}


	/**
	 * Method to login for passengers to make reservations and do associated
	 * activities.
	 */
	public void login() {
		System.out.println("please enter your emailid");
		Scanner scanner = new Scanner(System.in);
		String email = scanner.next();
		List<Passenger> passengerList = listOfPassengers.stream().filter(e -> e.getEmail().equalsIgnoreCase(email))
				.collect(Collectors.toList());
		if (passengerList != null && passengerList.size() == 1) {
			System.out.println("welcome.................." + passengerList.get(0).getName());
			Passenger passenger = passengerList.get(0);
			getPaserngerReservationData(passenger);
			if (passengarReservation == null
					|| passengarReservation.get(passengerList.get(0).getEmail()) == null) {
				addReservation(passenger);
			} else if ((passengarReservation != null) && passengarReservation.size() >= 1) {
				System.out.println("Press 1 to make a reservation");
				System.out.println("Press 2 for modify reservstion");
				System.out.println("Press 3 for cancel reservation");
			

				int nextInt = scanner.nextInt();
				switch (nextInt) {

				case 1:
					System.out.println("Add a new Reservation");
					addReservation(passenger);
					break;
				case 2:
					System.out.println("Modify reservation");
					modification(passenger);
					break;
				case 3:
					System.out.println("Cancel reservation method");
					Cancellation(passenger);
					break;
				
				default:
					System.out.println("Select option not available");
				}

			}
		} else {
			System.out.println("User not available please sign up");
			signUp();

		}
	}

	
	/**
	 * Method to modify the passenger details
	 * 
	 * @param passenger
	 */
	private void modification(Passenger passenger) {
		Reservation reservation = passengarReservation.get(passenger.getEmail());
		System.out.println("Current reservaton status " + reservation);
		System.out.println("Current seats reserved " + reservation.getSeatNumber());
		System.out.println("Press yes if you want modify seatNumber");
		Scanner scanner = new Scanner(System.in);
		String modifySeatNumber = scanner.next();
		if (modifySeatNumber.equalsIgnoreCase("yes")) {
			System.out.println("Select the seat number to be modified");
			int toChange = scanner.nextInt();
			reservation.getShedule().getFlight().getSeatNumbers().add(toChange - 1, toChange);
			System.out.println("Select any seat from below ");
			reservation.getShedule().getFlight().getSeatNumbers().stream().forEach(System.out::println);
			int newSeatNumber = scanner.nextInt();
			reservation.getShedule().getFlight().getSeatNumbers().remove(newSeatNumber - 1);
			reservation.getShedule().getFlight()
					.setNumOfSeats(reservation.getShedule().getFlight().getSeatNumbers().size());
			reservation.getSeatNumber().remove(new Integer(toChange));
			reservation.getSeatNumber().add(newSeatNumber);
			reservation.setInvoiceNumber(passenger.getEmail() + "" + newSeatNumber);

			System.out.println("Updated reservation status");
			System.out.println(reservation);
		}
	}

	private void Cancellation(Passenger passenger) {
		// OCL Constraint: Canceling the booking only if there exists a booking
		if (passengarReservation.containsKey(passenger.getEmail())) {
			passengarReservation.remove(passenger.getEmail());
			System.out.println("succesfully cancelled booking");
		}
	}

	private void getPaserngerReservationData(Passenger passenger) {
		if (passengarReservation == null) {
			passengarReservation = new HashMap<String, Reservation>();
			passengarReservation.put("vinishaareddy@gmail.com", new Reservation("BA001",
					new ArrayList<>(List.of(2, 3)), "vinishaareddy@gmail.com2",
					new Schedule("444", "3/03/21", "4/03/21", "2", "4", false, false,
							new Flight(new Airport("Hyderbad"), new Airport("Vizag"), "2", "4", 9,
									new AirLines("indian Arilines"),
									new ArrayList<Integer>(Arrays.asList(1, 4, 5, 6, 7, 8, 9, 10)), "BA1271"))));
			passengarReservation.put("veena@gmail.com",
					new Reservation("BA002", new ArrayList<>(List.of(2, 3)), "veena@gmail.com3",
							new Schedule("222", "3/03/21", "4/03/21", "2", "4", false, false,
									new Flight(new Airport("Hyderbad"), new Airport("Vizag"), "2", "4", 9,
											new AirLines("indian Arilines"),
											new ArrayList<Integer>(Arrays.asList(1, 4, 5, 6, 7, 8, 9, 10)), "222"))));
		}

	}

	/**
	 * Method to add the reservation
	 * 
	 * @param passenger
	 */
	public void addReservation(Passenger passenger) {
		String email = passenger.getEmail();
		Reservation userReservation = passengarReservation.get(email);
//			System.out.println("Your Previous Reservations are :" );
		if (userReservation != null) {
			System.out.println("Your Previous Reservations are :");
			System.out.println("Flight Number " + userReservation.getShedule().getFlight().getFlightNo()
					+ " with invoice --  " + userReservation.getInvoiceNumber());
		}
		final Schedule schdule = new Schedule(); // getFlightwithCodes
		List<Schedule> flightList = schdule.getFlightScdule();
		for (int i = 0; i < flightList.size(); i++) {
			Schedule schedule = flightList.get(i);
			System.out.println("shedule code " + schedule.getSchedId());
			System.out.println("Flight Code " + schedule.getFlight().getFlightNo());
			System.out.println("arrive date  " + schedule.getArriveDate());
			System.out.println("depart date " + schedule.getDepartDate());
			System.out.println("expected arrival time " + schedule.getExpectedArriveTime());
			System.out.println("expected depart time " + schedule.getExpectedDepartTime());
			System.out.println("any delay " + schedule.getDelay());
			System.out.println("fully booked " + schedule.getFullBook());
			System.out.println("no of seats available  " + schedule.getFlight().getNumOfSeats());
			System.out.println("\n");
		}

		System.out.println("select schedule no ");

		Scanner scanner = new Scanner(System.in);

		String scheduleNo = scanner.next();

		Reservation reservation = passengarReservation.get(email);

		while (reservation.getShedule().getSchedId().equalsIgnoreCase(scheduleNo)) {
			System.out.println("Cannot book this");
			scheduleNo = scanner.next();
		}
		String finalScheduleCode = scheduleNo;
		List<Schedule> filteredSheduleList = flightList.stream()
				.filter(s -> s.getSchedId().equalsIgnoreCase(finalScheduleCode)).collect(Collectors.toList());
		Schedule schedule = filteredSheduleList.get(0);
		System.out.println("You have selected the flight : " + schedule.getSchedId());

		Flight selectedFlight = schedule.getFlight();
		List<Integer> seatNumbers = new ArrayList<Integer>();
		System.out.println("Press 1 to book 1 seat and press 2 to book 2 seats");
		boolean loop = true;
		while (loop) {
			int noOfSeats = scanner.nextInt();
			selectedFlight.getSeatNumbers().stream().forEach(System.out::print);
			System.out.println("select " + noOfSeats + " from above List");
			if (noOfSeats == 1) {
				System.out.println("Select seat no");

				boolean innerLoop = true;
				while (innerLoop) {
					int seatNumber = scanner.nextInt();
					if (selectedFlight.getSeatNumbers().contains(seatNumber)) {
						seatNumbers.add(seatNumber);
						innerLoop = false;
					} else {
						System.out.println("Please try again that seat is not available");
					}
				}
				loop = false;
			} else if (noOfSeats == 2) {
				System.out.println("Select seat 1st seat");

				boolean innerLoop = true;
				while (innerLoop) {
					int firstSeat = scanner.nextInt();
					if (selectedFlight.getSeatNumbers().contains(firstSeat)) {
						seatNumbers.add(firstSeat);
						innerLoop = false;
					} else {
						System.out.println("Please try again that seat is not available");
					}
				}
				System.out.println("Select seat 2nd seat");

				boolean innerLoop2 = true;
				while (innerLoop2) {

					int secondSeat = scanner.nextInt();

					if (selectedFlight.getSeatNumbers().contains(secondSeat)) {
						seatNumbers.add(secondSeat);
						innerLoop2 = false;
					} else {
						System.out.println("Please try again that seat is not available");
					}
				}
				loop = false;
			} else {
				System.out.println("Please try again that seat is not available");
			}
		}
		bookSeatNumber(seatNumbers, email, schedule);


		System.out.println("Thank you for reservation");
	}

	@Override
	public String toString() {
		return "Reservation datails \n" + "seatNumber=" + seatNumbers + ",\n invoiceNumber=" + invoiceNumber
				+ "\n, shedule=" + shedule + "";
	}

	private Map<String, Reservation> getPaasengerReservationMap() {
		if (passengarReservation == null) {
			passengarReservation = new HashMap<String, Reservation>();
			return passengarReservation;
		} else {
			return passengarReservation;
		}
	}

	/**
	 * Method for sign up for new passengers
	 */
	public void signUp() {
		try {
			Passenger newPassenger = new Passenger();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please enter your name ");
			String name = scanner.next();
			newPassenger.setName(name);
			System.out.println("Please enter your mobile ");
			String mobile = scanner.next();
			newPassenger.setMobile(mobile);
			System.out.println("Please enter your email ");
			String email = scanner.next();
			newPassenger.setEmail(email);
			System.out.println("Please give your card details");
			String pay = scanner.next();
			newPassenger.setPaymentInfo(pay);
			System.out.println("Please enter your dob in format (dd-mm-yyyy)");
			String dob = scanner.next();
			Date date = formatter.parse(dob);
			// Converting obtained Date object to LocalDate object
			Instant instant = date.toInstant();
			ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
			LocalDate givenDate = zone.toLocalDate();
			// Calculating the difference between given date to current date.
			Period period = Period.between(givenDate, LocalDate.now());
			System.out.println("Hello " + name + " your current age is: ");
			System.out.println(period.getYears() + " years " + period.getMonths() + " months");
			newPassenger.setDob(date);
			// OCL constraint: Validating if the users age is above 18
			if (period.getYears() > 18) {
				listOfPassengers.add(newPassenger);
				System.out.println("Sign-up is successful \n\n Please login to book tickets");
				login();
			} else {
				System.out.println("We are sorry, you need to be above 18 years to use this application");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Date StringToDate(String dob) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); // Instantiating the SimpleDateFormat class
		Date date = formatter.parse(dob); // Parsing the given String to Date object
		System.out.println("Date object value: " + date);
		return date;
	}

	/**
	 * Method to book a particular seat for the passenger
	 * 
	 * @param seatNumberList
	 * @param email
	 * @param schedule
	 */
	public void bookSeatNumber(List<Integer> seatNumberList, String email, Schedule schedule) {
		Flight flight = schedule.getFlight();

		for (Integer seatToBeRemoved : seatNumberList) {
			flight.getSeatNumbers().remove(seatToBeRemoved - 1);
		}

		flight.setNumOfSeats(flight.getSeatNumbers().size());
		schedule.setFlight(flight);
		Reservation reservation = new Reservation();
		reservation.setSeatNumber(seatNumberList);
		reservation.setInvoiceNumber(flight.getFlightNo() + reservation.getSeatNumber().toString());

		reservation.setShedule(schedule);
		Reservation.passengarReservation = getPaasengerReservationMap();
		Reservation.passengarReservation.put(email, reservation);
		System.out.println("reservation completed");
		Reservation completedReservation = passengarReservation.get(email);
		System.out.println(completedReservation);
	}
}
