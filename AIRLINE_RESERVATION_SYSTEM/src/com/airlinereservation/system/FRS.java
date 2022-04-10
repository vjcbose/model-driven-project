package com.airlinereservation.system;

	import java.util.Scanner;
	import java.util.List;
	import java.util.ArrayList;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	
	import java.util.stream.Collectors;

	// Main class for testing airline and passenger functionalities
	public class FRS {

		public static void main(String[] args) throws ParseException {
			// TODO Auto-generated method stub
			
			final List<Employee> EmployeeList = new ArrayList<Employee>(); 
			final List<Flight> FlightList = new ArrayList<Flight>();
			final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			final List<AirLines> airLineList= new ArrayList<AirLines>();
			final List<Schedule> scheduleList= new ArrayList<Schedule>();
			
			
			//Employee Test data
			EmployeeList.add(new Employee("ACi","ACi@gmail.com","5145145141",formatter.parse("28-04-1997"),"Pilot"));
			EmployeeList.add(new Employee("Pavitra","Pavitra@gmail.com","4383334444",formatter.parse("02-11-1985"),"Pilot"));
			EmployeeList.add(new Employee("Phani","phani@gmail.com","4389992222",formatter.parse("05-03-1995"),"Pilot"));
			EmployeeList.add(new Employee("Prudhvi","Prudhvi@gmail.com","438001111",formatter.parse("22-01-1991"),"crewMember"));
			EmployeeList.add(new Employee("Anu","Anu@gmail.com","4389994444",formatter.parse("11-03-1989"),"Pilot"));
			EmployeeList.add(new Employee("Karthik","Karthik@gmail.com","5142456100",formatter.parse("16-12-1988"),"crewMember"));
			EmployeeList.add(new Employee("Vineel","Vineel@gmail.com","4382124444",formatter.parse("02-02-1995"),"Pilot"));
			EmployeeList.add(new Employee("Bhogi","Bhogi@gmail.com","5142756100",formatter.parse("19-01-1989"),"crewMember"));
			EmployeeList.add(new Employee("Rahul","Rahul@gmail.com","5149994444",formatter.parse("22-04-1990"),"Pilot"));
			EmployeeList.add(new Employee("Prathap","Prathap@gmail.com","4385556100",formatter.parse("28-01-1993"),"crewMember"));
			EmployeeList.add(new Employee("Vinni","Vinni@gmail.com","5142456144",formatter.parse("16-10-1997"),"crewMember"));
			EmployeeList.add(new Employee("Monish","monish@gmail.com","4382129878",formatter.parse("01-01-1985"),"crewMember"));
			EmployeeList.add(new Employee("pavni","pavni@gmail.com","5142653221",formatter.parse("19-10-1989"),"crewMember"));
			EmployeeList.add(new Employee("pratyusha","pratyusha@gmail.com","5149765566",formatter.parse("11-03-1970"),"crewMember"));
			EmployeeList.add(new Employee("bose","bos@gmail.com","4385551122",formatter.parse("08-08-1997"),"crewMember"));
			//Flight Test Data
			FlightList.add(new Flight(new Airport("Toronto"), new Airport("Montreal"), "3", "9", 10, null,null,"BA1271"));
			FlightList.add(new Flight(new Airport("Montreal"), new Airport("Toronto"), "2", "7", 10, null,null,"BA1272"));
			FlightList.add(new Flight(new Airport("Vancouver"), new Airport("Toronto"), "6", "9", 10, null,null,"BA1273"));
			FlightList.add(new Flight(new Airport("Calgary"), new Airport("Montreal"), "2", "7", 10, null,null,"BA1274"));
			FlightList.add(new Flight(new Airport("Montreal"), new Airport("Vancouver"), "3", "10", 10, null,null,"BA1275"));
			FlightList.add(new Flight(new Airport("Toronto"), new Airport("Vancouver"), "2", "8", 10, null,null,"BA1276"));
			
			//Schedule Test Data
			
			//Creating different airline objects
			AirLines britishAirways= new AirLines("BA");
			AirLines Lufthansa= new AirLines("LA");
			AirLines AirCanada= new AirLines("AC");
			
			//Maintaining airline list
			airLineList.add(britishAirways);
			airLineList.add(Lufthansa);
			airLineList.add(AirCanada);
			
			//Assigning employees and flight to airlines
			britishAirways.setAirlineFlights(FlightList);
			britishAirways.setAirlineEmployees(EmployeeList);
			Lufthansa.setAirlineFlights(FlightList);
			Lufthansa.setAirlineEmployees(EmployeeList);
			AirCanada.setAirlineFlights(FlightList);
			AirCanada.setAirlineEmployees(EmployeeList);
			
			
			//Asking whether the user is an employee or a passenger
			Scanner scanner = new Scanner(System.in);
			System.out.println("Press E for employee Login and P for passengers:");
			String vistorType=scanner.next();
			
			//Employee operations for airline
			if(vistorType.equalsIgnoreCase("E")) {
				System.out.println("Welcome to Airline Management System:");
				System.out.println("Please select your Airline:");
				for(int i=0;i<airLineList.size();i++) {
					System.out.println(airLineList.get(i).getName());
				}
				String airLine=scanner.next();
				for(int i=0;i<airLineList.size();i++) {
					AirLines finder = airLineList.get(i);
					if(finder.getName().equalsIgnoreCase(airLine)) {
						System.out.println("Welcome to "+ finder.getName()+ "  Airlines");
						finder.getAirlineFlights().stream().forEach(System.out::println);
						System.out.println("Please select a flight to manage: ");
						String FlightString = scanner.next();
						try {
						for(Flight e : finder.getAirlineFlights()) {
							if(e.getFlightNo().equalsIgnoreCase(FlightString)) {
								System.out.println("Select the task:");
								System.out.println("1.Assigning Flight Crew");
								System.out.println("2.Cancelling Flight");
								String task = scanner.next();
								if(task.equals("1")) {
									int flightPilot=0;
									int flightCrew=0;
									List<Employee> FlightCrewList = new ArrayList<Employee>();
									if(e.getCrewMembers()!=null) {
										for(Employee flightEmployee : e.getCrewMembers()) {
											if(flightEmployee.getRole().equalsIgnoreCase("Pilot")) {
												flightPilot=flightPilot+1;
											}
											if(flightEmployee.getRole().equalsIgnoreCase("crewMember")) {
												flightCrew=flightCrew+1;
											}
										}
									}
									if(flightPilot<1 || e.getCrewMembers()==null) {
										List<Employee> PilotList = finder.getAirlineEmployees().stream().filter(a->a.getRole().equalsIgnoreCase("Pilot")).collect(Collectors.toList());
										
										FlightCrewList.add(PilotList.get(PilotList.size()-1));
										PilotList.remove(PilotList.size()-1);
									}
									if(flightCrew<2 || e.getCrewMembers()==null) {
										List<Employee> CrewList = finder.getAirlineEmployees().stream().filter(a->a.getRole().equalsIgnoreCase("crewMember")).collect(Collectors.toList());
										for(int j=0;j<3;j++) {
											FlightCrewList.add(CrewList.get(j));
										}
									}
									e.setCrewMembers(FlightCrewList);
									System.out.println("Added Crew are :");
									for(Employee E :FlightCrewList ) {
										System.out.println(E.getName());
									}
								}
								else {
								//OCL constraint: cancelling the flight if the flight exists	
							    finder.removeFlight(e);
							    System.out.println("Flight number "+ e.getFlightNo() + " is cancelled");
									
								}
							}
						}
						}
						catch(Exception e) {
						
						}
					}
				}
			}
			
			//Passenger operations on airline
			else if(vistorType.equalsIgnoreCase("P"))
			{
				System.out.print("press 1 to login and press 2 to sign up: ");
				
				int loginOrSignUp=scanner.nextInt();
				Reservation res= new Reservation();
				if(loginOrSignUp == 1) {
			    // Calling login method in passenger class
					res.login();
				}
				else if(loginOrSignUp == 2) {
					//Calling signup method in passenger class
					res.signUp();
				}	
			}
			else {
				System.out.println("Give the correct command");
				main(args);
			}
		}

}
