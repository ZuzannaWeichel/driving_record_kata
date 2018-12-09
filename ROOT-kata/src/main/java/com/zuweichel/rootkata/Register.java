package com.zuweichel.rootkata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zuweichel.rootkata.model.Driver;
import com.zuweichel.rootkata.model.Trip;

public class Register {

	private Map<Driver, List<Trip>> register;
	private Calculator calculator;

	public Register(Calculator c) {
		register = new HashMap<>();
		this.calculator = c;
	}

	public void addDriver(Driver d) {
		register.putIfAbsent(d, new ArrayList<Trip>());
	}
	
	
	public void addDrivingRecord(Driver driver, Trip trip) {
		if(calculator.isValid(trip)) {
			register.get(driver).add(trip);
		}
	}

	public List<Trip> getDrivingRecord(Driver d){
		return register.get(d);
	}
	
	public Driver getDriver(String name) {
		Driver driver = null; 
		for(Driver d : register.keySet()) {
			if(d.getName().equals(name)) {
				 driver = d;
			}
		}
		return driver;
	 }
	
	public Set<Driver> getAllDrivers(){
		return register.keySet();
	}
}
