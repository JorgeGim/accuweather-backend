package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Day;
import model.Sport;

public class SportEqualTest {
	
	@Test
	public void sportsEqualtest() 
	{
		Sport sport = new Sport("Volleyball");
		Sport sport2 = new Sport("Volleyball");
		
		assertTrue(sport.equals(sport2));
	}
	
	@Test
	public void sportsDifferentNameTest() 
	{
		Sport sport = new Sport("Volleyball");
		Sport sport2 = new Sport("Football");
		
		assertFalse(sport.equals(sport2));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void differentObjectTest() 
	{
		Sport sport = new Sport("Volleyball");
		Day day = new Day();
		
		assertFalse(sport.equals(day));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void nullObjectTest() 
	{
		Sport sport = new Sport("Volleyball");
		Day day = null;
		
		assertFalse(sport.equals(day));
	}
}
