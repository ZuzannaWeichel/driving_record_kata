package com.zuweichel.rootkata.model;

public class DriverResult implements Comparable<DriverResult>{

	private String name;
	private int miles;
	private int speed;
	
	public DriverResult(String name, int miles, int speed) {
		this.name = name;
		this.miles = miles;
		this.speed = speed;
	}
	
	public int getMiles() {
		return miles;
	}

	public void setMiles(int miles) {
		this.miles = miles;
	}

	@Override
	public String toString() {
		if(miles == 0) {
			return name+": "+miles+" miles";
		}
		return name+": "+miles+" miles @ "+speed+" mph";
	}

	@Override
	public int compareTo(DriverResult d) {
		return d.getMiles() - miles;
	}
	
}
