package com.zuweichel.rootkata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.zuweichel.rootkata.model.Time;

public class TimeTest {

	private Time fourThirty;
	private Time fiveThirty;
	private Time fourThirtyOne;
	private Time twoTwenty;
	private Time fourTwentyNine;
	
	@Before
	public void setup(){
		fourThirty = new Time(4,30);
		fiveThirty = new Time (5,30);
		fourThirtyOne = new Time (4,31);
		twoTwenty  = new Time(2,20);
		fourTwentyNine = new Time(4,29);
	}
	
	@Test
	public void is_earlier_test() {		
		Assert.assertTrue(fourThirty.isEarlier(fiveThirty));
		Assert.assertTrue(fourThirty.isEarlier(fourThirtyOne));
		Assert.assertFalse(fourThirty.isEarlier(twoTwenty));
		Assert.assertFalse(fourThirty.isEarlier(fourTwentyNine));
		
	}
	
	@Test
	public void get_difference_in_hours() {
		Assert.assertEquals(1, fourThirty.getDifference(fiveThirty), 0.01);
		Assert.assertEquals(0.01, fourTwentyNine.getDifference(fourThirty), 0.01);
		Assert.assertEquals(0.03, fourTwentyNine.getDifference(fourThirtyOne), 0.01);
		Assert.assertEquals(2.15, twoTwenty.getDifference(fourTwentyNine) , 0.01);
	}
}
