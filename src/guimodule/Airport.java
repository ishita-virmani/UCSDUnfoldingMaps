package guimodule;

import java.util.ArrayList;
import java.util.Collections;

public class Airport implements Comparable<Airport> {

	private int AirportID;
	private String name;
	private String city;
	private String country;
	private String code3;

	public Airport(int id, String name, String city, String country, String code3) {
		this.AirportID = id;
		this.city = city;
		this.code3 = code3;
		this.country = country;
		this.name = name;
	}

	public int getAirportID() {
		return AirportID;
	}

	public void setAirportID(int airportID) {
		AirportID = airportID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCode3() {
		return code3;
	}

	public void setCode3(String code3) {
		this.code3 = code3;
	}

	@Override
	public int compareTo(Airport other) {
		// TODO Auto-generated method stub
		return (this.getCity()).compareTo(other.getCity());
	}

	public String toString() {
		return "(Airport ID:" + this.getAirportID() + "; Name:" + this.getName() + "; City:" + this.getCity()
				+ "; Country:" + this.getCountry() + "; Code:" + this.getCode3() + ")";
	}

	public static void main(String[] args) {
		ArrayList<Airport> airports = new ArrayList<Airport>();

		airports.add(new Airport(23, "IGI", "New Delhi", "India", "NKD"));
		airports.add(new Airport(213, "MUM", "Mumbai", "INDIA", "MDK"));
		airports.add(new Airport(682, "Montreal", "Canada", "USA", "JDS"));

		Collections.sort(airports);

		System.out.println(airports.toString());
	}
}
