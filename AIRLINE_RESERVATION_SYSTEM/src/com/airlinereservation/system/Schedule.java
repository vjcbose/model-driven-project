package com.airlinereservation.system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Schedule {

	public Schedule(String schedId, String departDate, String arriveDate, String expectedDepartTime,
			String expectedArriveTime, boolean fullBook, boolean delay, Flight flight) {
		super();
		this.schedId = schedId;
		this.departDate = departDate;
		this.arriveDate = arriveDate;
		this.expectedDepartTime = expectedDepartTime;
		this.expectedArriveTime = expectedArriveTime;
		this.fullBook = fullBook;
		this.delay = delay;
		this.flight = flight;
	}

	public Schedule() {

	}

	private String schedId;
	private String departDate;
	private String arriveDate;
	private String expectedDepartTime;
	private String expectedArriveTime;
	private boolean fullBook;
	private boolean delay;
	Flight flight;

	public String getSchedId() {
		return schedId;
	}

	public void setSchedId(String schedId) {
		this.schedId = schedId;
	}

	public String getDepartDate() {
		return departDate;
	}

	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}

	public String getArriveDate() {
		return arriveDate;
	}

	public void setArriveDate(String arriveDate) {
		this.arriveDate = arriveDate;
	}

	public String getExpectedDepartTime() {
		return expectedDepartTime;
	}

	public void setExpectedDepartTime(String expectedDepartTime) {
		this.expectedDepartTime = expectedDepartTime;
	}

	public String getExpectedArriveTime() {
		return expectedArriveTime;
	}

	public void setExpectedArriveTime(String expectedArriveTime) {
		this.expectedArriveTime = expectedArriveTime;
	}

	public boolean getFullBook() {
		return fullBook;
	}

	public void setFullBook(boolean fullBook) {
		this.fullBook = fullBook;
	}

	public boolean getDelay() {
		return delay;
	}

	public void setDelay(boolean delay) {
		this.delay = delay;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	Map<String, Airport> airportMap;

	Map<String, Flight> flightCodeMap;

	Map<String, List<String>> dateFrequencyes;

	void getsaticMapsIntilized() {
		airportMap = new HashMap<String, Airport>();
		airportMap.put("MTL", new Airport("Montreal"));
		airportMap.put("TRN", new Airport("Toronto"));
		airportMap.put("CLG", new Airport("Calgary"));
		airportMap.put("VAN", new Airport("Vancour"));
		flightCodeMap = new HashMap<String, Flight>();
		flightCodeMap.put("MTL-TRN", new Flight(new Airport("Montreal"), new Airport("Toronto"), "7", "8", 10, null,
				new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), "BA1271"));
		flightCodeMap.put("TRN-MTL", new Flight(new Airport("Toronto"), new Airport("Montreal"), "1", "5", 10, null,
				new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), "BA1272"));
		flightCodeMap.put("MTL-CLG", new Flight(new Airport("Montreal"), new Airport("Calgary"), "7", "8", 10, null,
				new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), "BA1273"));
		flightCodeMap.put("CLG-MTL", new Flight(new Airport("Calgary"), new Airport("Montreal"), "1", "5", 10, null,
				new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), "BA1274"));
		flightCodeMap.put("MTL-VAN", new Flight(new Airport("Montreal"), new Airport("Vancour"), "7", "8", 10, null,
				new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), "BA1275"));
		flightCodeMap.put("VAN-MTL", new Flight(new Airport("Vancour"), new Airport("Montreal"), "1", "5", 10, null,
				new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), "BA1276"));
		flightCodeMap.put("TRN-CLG", new Flight(new Airport("Toronto"), new Airport("Calgary"), "7", "8", 10, null,
				new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), "BA1277"));
		flightCodeMap.put("CLG-TRN", new Flight(new Airport("Calgary"), new Airport("Toronto"), "1", "5", 10, null,
				new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), "BA1278"));
		flightCodeMap.put("TRN-VAN", new Flight(new Airport("Toronto"), new Airport("Vancour"), "1", "5", 10, null,
				new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), "BA1279"));
		flightCodeMap.put("VAN-TRN", new Flight(new Airport("Vancour"), new Airport("Toronto"), "7", "8", 10, null,
				new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), "BA1280"));

		dateFrequencyes = new HashMap<String, List<String>>();
		dateFrequencyes.put("MTL-TRN",
				new ArrayList<String>(Arrays.asList("1/03/21-2/03/21-111", "3/03/21-4/03/21-112")));
		dateFrequencyes.put("TRN-MTL",
				new ArrayList<String>(Arrays.asList("1/03/21-2/03/21-113", "3/03/21-4/03/21-114")));
		dateFrequencyes.put("MTL-CLG",
				new ArrayList<String>(Arrays.asList("1/03/21-2/03/21-115", "3/03/21-4/03/21-116")));
		dateFrequencyes.put("CLG-MTL",
				new ArrayList<String>(Arrays.asList("1/03/21-2/03/21-117", "3/03/21-4/03/21-118")));
		dateFrequencyes.put("MTL-VAN",
				new ArrayList<String>(Arrays.asList("1/03/21-2/03/21-119", "3/03/21-4/03/21-120")));
		dateFrequencyes.put("VAN-MTL",
				new ArrayList<String>(Arrays.asList("1/03/21-2/03/21-121", "3/03/21-4/03/21-122")));
		dateFrequencyes.put("TRN-CLG",
				new ArrayList<String>(Arrays.asList("1/03/21-2/03/21-123", "3/03/21-4/03/21-124")));
		dateFrequencyes.put("CLG-TRN",
				new ArrayList<String>(Arrays.asList("1/03/21-2/03/21-125", "3/03/21-4/03/21-126")));
		dateFrequencyes.put("TRN-VAN",
				new ArrayList<String>(Arrays.asList("1/03/21-2/03/21-127", "3/03/21-4/03/21-128")));
		dateFrequencyes.put("VAN-TRN",
				new ArrayList<String>(Arrays.asList("1/03/21-2/03/21-129", "3/03/21-4/03/21-130")));

	}

	/**
	 * method to get schedules available for a particular flight
	 */
	public List<Schedule> getFlightScdule() {
		getsaticMapsIntilized();
		System.out.println("Please select boarding point");
		Map<String, Airport> airport = airportMap;
		for (Map.Entry<String, Airport> entry : airport.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + ((Airport) entry.getValue()).getCity());
		}
		System.out.println("Enter the boarding point code");
		Scanner scanner = new Scanner(System.in);
		String boardingPointCode = scanner.next();
		for (Map.Entry<String, Airport> entry : airport.entrySet()) {
			if (!(entry.getKey().equalsIgnoreCase(boardingPointCode))) {
				System.out.println("Key = " + entry.getKey() + ", Value = " + ((Airport) entry.getValue()).getCity());
			}
		}

		System.out.println("Enter the destination point code");
		scanner = new Scanner(System.in);
		String destinationPointCode = scanner.next();
		for (Map.Entry<String, Airport> entry : airport.entrySet()) {
			if (!(entry.getKey().equalsIgnoreCase(boardingPointCode))) {
				System.out.println("Key = " + entry.getKey() + ", Value = " + ((Airport) entry.getValue()).getCity());
			}
		}
		String FlightCodewithDestinationCode = boardingPointCode + "-" + destinationPointCode;
		return getFlightwithCodes(FlightCodewithDestinationCode);

	}

	public Flight getFlight() {
		return flight;
	}

	/**
	 * method to get all the schedules of a particular flight code
	 * 
	 * @param flightCodewithDestinationCode
	 */
	public List<Schedule> getFlightwithCodes(String flightCodewithDestinationCode) {
		List<Schedule> sheduleList = new ArrayList<Schedule>();
		Flight flight = flightCodeMap.get(flightCodewithDestinationCode);
		List<String> dateList = dateFrequencyes.get(flightCodewithDestinationCode);
		for (String dates : dateList) {
			Schedule shedule = new Schedule();
			String[] split = dates.split("-");
			String startDate = split[0];
			String endDate = split[1];
			String sheduleId = split[2];
			shedule.setSchedId(sheduleId);
			shedule.setDepartDate(startDate);
			shedule.setArriveDate(endDate);
			shedule.setExpectedArriveTime(flight.getArriveTime());
			shedule.setExpectedDepartTime(flight.getDepartTime());
			shedule.setFlight(flight);
			shedule.setDelay(false);
			if (flight.getNumOfSeats() >= 1)
				shedule.setFullBook(false);
			else
				shedule.setFullBook(true);
			sheduleList.add(shedule);
		}

		return sheduleList;
	}

	@Override
	public String toString() {
		return "Schedule [schedId=" + schedId + ", departDate=" + departDate + ", arriveDate=" + arriveDate
				+ ", expectedDepartTime=" + expectedDepartTime + ", expectedArriveTime=" + expectedArriveTime
				+ ", fullBook=" + fullBook + ", delay=" + delay + ", flight=" + flight + "]";
	}

}
