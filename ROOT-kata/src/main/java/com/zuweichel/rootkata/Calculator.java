package com.zuweichel.rootkata;

import java.util.List;

import com.zuweichel.rootkata.model.Trip;

public class Calculator {
	
	
	public Calculator() {
		
	}
	public int getTotalMiles(List<Trip> trips)  {
		double total = 0;
		for (Trip trip : trips) {
			total += trip.getMiles();
		}
		return (int) Math.round(total);
	}
	
	public int getAverageSpeed(List<Trip> trips) {
		return (int) Math.round(getTotalMiles(trips)/getTotalTime(trips));
		
	}
	
	public boolean isValid(Trip t) {
		double speed = t.getMiles()/ getTripLength(t);
		return speed >= 5 && speed <= 100; 
	}
	
	private double getTotalTime( List<Trip> trips) {
		double totalTime = 0;
		for(Trip t : trips) {
			totalTime += getTripLength(t);
		}
		return totalTime;
	}
	
	private double getTripLength(Trip t) {
		return t.getTripStart().getDifference(t.getTripEnd());
	}
}
