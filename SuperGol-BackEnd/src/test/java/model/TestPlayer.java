package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import factories.PlayerFactory;

public class TestPlayer {
	
	PlayerFactory factory;
	Player tevez;
	
	@Before
	public void setUp(){
		factory = new PlayerFactory();
		tevez = factory.createMidFielder("Tevez");
		// add mock of team class
		tevez.setTeam(new Team());
	}
	
	
	@Test
	public void testName(){
		assertEquals("Tevez",tevez.getName());
	}
	
	@Test 
	public void testPosition(){
		assertTrue(tevez.getPosition() != null);
	}
	
	@Test
	public void testTeam(){
		assertTrue(tevez.getTeam() != null);
	}
	
	@Test
	public void testMaxPlayerInPositionAllowed(){
		assertEquals(4,tevez.maxOfPlayerInMyPosition());
	}
	
	@Test
	public void testPoints(){
		assertEquals(tevez.getPoints(),1);
	}
	
	@Test
	public void testPositionDescription(){
		assertEquals(tevez.getPositionDescription(),"Mid Fielder");
	}
	
	@Test
	public void score(){
		assertEquals(tevez.score(),1);
	}
	
	@Test
	public void testEquals(){
		Player p2 = factory.createMidFielder("Messi");
		assertFalse(tevez.equals(p2));
		assertFalse(tevez.equals(null));
		assertFalse(tevez.equals(new Object()));
		assertTrue(tevez.equals(tevez));
	}
	
}
