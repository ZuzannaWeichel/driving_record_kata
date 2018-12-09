package com.zuweichel.rootkata.model;

public class Time {

	private int hour;
	private int min;
	
	public Time(int hour, int min) {
		this.hour = hour;
		this.min = min;
	}
	
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int sec) {
		this.hour = sec;
	}
	public boolean isEarlier(Time time) {
		boolean isEarlier = false;
		if(this.hour < time.getHour() ) {
			isEarlier = true;
		}else if(this.hour == time.getHour()){
			if(this.min < time.getMin()) {
				isEarlier = true;
			}
		}
		return isEarlier;
	}
	public double getDifference(Time time) {
		return (time.getMin() - this.min)/60.0 + (time.getHour() - this.hour);
	}
	
	
}
