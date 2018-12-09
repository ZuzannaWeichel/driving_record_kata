package com.zuweichel.rootkata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.zuweichel.rootkata.model.Driver;
import com.zuweichel.rootkata.model.Time;
import com.zuweichel.rootkata.model.Trip;

public class RegisterTest {

	private Register reg;
	private Calculator cal;
	private Driver d;
	private Trip t;
	
	@Before
	public void setup() {
		cal = new Calculator();
		reg = new Register(cal);
		d = new Driver("Moris");
		t = new Trip(new Time(1, 15), new Time(2, 20), 75.3);
		
	}
	
	@Test
	public void add_driver() {
		reg.addDriver(d);
		Assert.assertEquals(1, reg.getAllDrivers().size());
	}
	
	@Test
	public void add_driving_record() {
		reg.addDriver(d);
		reg.addDrivingRecord(d, t);
		Assert.assertEquals(1, reg.getDrivingRecord(d).size());
	}
	
	@Test
	public void get_driver() {
		reg.addDriver(d);
		Assert.assertEquals(d, reg.getDriver("Moris"));
		Assert.assertEquals(null, reg.getDriver("Robert"));
	}
	
	@Test
	public void get_all_drivers() {
		reg.addDriver(d);
		reg.addDriver(d);
		Assert.assertEquals(1, reg.getAllDrivers().size());
	}
}
