package com.zuweichel.rootkata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.zuweichel.rootkata.model.Driver;
import com.zuweichel.rootkata.model.DriverResult;
import com.zuweichel.rootkata.model.Time;
import com.zuweichel.rootkata.model.Trip;

public class Menu {
	
	private PrintWriter out;
	private Scanner in;
	private Register register;
	private Calculator calculator;
	

	public Menu(OutputStream output, File file) throws FileNotFoundException {
		this.out = new PrintWriter(output);
		this.in = new Scanner(file);
		this.calculator = new Calculator();
		this.register = new Register(calculator);
		
	}
	
	public void run() {
		readInput();
		printOutput();
	}
	
	private void readInput() {
		while(in.hasNext()) {
			String[] input = in.nextLine().split(" ");
			if(input[0].equals("Driver")) {
				Driver driver = new Driver(input[1]);
				register.addDriver(driver);
			}else if (input[0].equals("Trip")) {
				Driver driver = register.getDriver(input[1]);
				
				String[] start = input[2].split(":");
				Time tripStart = new Time(Integer.parseInt(start[0]), Integer.parseInt(start[1]));
				
				String[] end = input[3].split(":");
				Time tripEnd = new Time(Integer.parseInt(end[0]), Integer.parseInt(end[1]));
				
				double miles = Double.parseDouble(input[4]);
				
				Trip trip = new Trip(tripStart, tripEnd, miles);
				
				register.addDrivingRecord(driver, trip);;
				
			}
		}
	}

	private void printOutput() {
		for(DriverResult d : computeDrivers()) {
			out.println(d);
		}
		out.flush();
	}
	
	private List<DriverResult> computeDrivers() {
		List<DriverResult> results = new ArrayList<DriverResult>();
	
		for(Driver d : register.getAllDrivers()) {
			List<Trip> trips = register.getDrivingRecord(d);
			int miles = calculator.getTotalMiles(trips);
			int speed = calculator.getAverageSpeed(trips);		
			DriverResult result =  new DriverResult(d.getName(), miles, speed);		
			results.add(result);
		}
		Collections.sort(results);
		return results;
	}


}
