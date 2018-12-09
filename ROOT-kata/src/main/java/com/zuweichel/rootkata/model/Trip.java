package com.zuweichel.rootkata.model;

public class Trip {

	private Time tripStart;
	private Time tripEnd;
	private double miles;
	
	public Trip( Time tripStart, Time tripEnd, double miles) {
		
		this.tripStart = tripStart;
		this.tripEnd = tripEnd;
		this.miles = miles;
	}

	public Time getTripStart() {
		return tripStart;
	}

	public void setTripStart(Time tripStart) {
		this.tripStart = tripStart;
	}

	public Time getTripEnd() {
		return tripEnd;
	}

	public void setTripEnd(Time tripEnd) {
		this.tripEnd = tripEnd;
	}

	public double getMiles() {
		return miles;
	}

	public void setMiles(double miles) {
		this.miles = miles;
	}
	
}
