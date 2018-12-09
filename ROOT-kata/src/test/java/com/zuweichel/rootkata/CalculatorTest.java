package com.zuweichel.rootkata;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.zuweichel.rootkata.model.Time;
import com.zuweichel.rootkata.model.Trip;

public class CalculatorTest {

	private Calculator cal;
	private List<Trip> trips;
	private Trip a;
	private Trip b;
	private Trip c;
	private Trip d;
	private Trip e;
	
	
	@Before
	public void setup() {
		cal = new Calculator();
		trips = new ArrayList<>();
		a = new Trip(new Time(4,30), new Time(4,45), 15.3);
		b = new Trip(new Time(4,40), new Time(5,0), 25.1);
		c = new Trip(new Time(4,50), new Time(6,10), 100.5);
		d = new Trip(new Time(4,10), new Time(4,30), 200);
		e = new Trip(new Time(4,0), new Time(6,10), 9.5);
	}
	
	@Test
	public void get_total_miles() {
		trips.add(a);
		trips.add(b);
		Assert.assertEquals(40, cal.getTotalMiles(trips),0.001);
		trips.add(c);
		Assert.assertEquals(141, cal.getTotalMiles(trips),0.001);
	}
	
	@Test
	public void get_average_speed() {
		trips.add(a);
		Assert.assertEquals(60, cal.getAverageSpeed(trips),0.001);
		trips.add(b);
		Assert.assertEquals(69, cal.getAverageSpeed(trips),0.001);
		trips.add(c);
		Assert.assertEquals(74, cal.getAverageSpeed(trips),0.001);
	}
	
	@Test
	public void is_valid_trip() {
		Assert.assertFalse(cal.isValid(d));
		Assert.assertFalse(cal.isValid(e));
	}
}
