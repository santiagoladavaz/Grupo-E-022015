package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestPositionDefender {
	
	
Position defender;
	
	@Before
	public void setUp(){
		defender = new Defender();
	}
	
	@Test
	public void testDescription(){
		assertEquals("Defender",defender.description());
	}
	
	@Test
	public void testPoints(){
		assertEquals(3,defender.points());
	}
	
	@Test
	public void testMaxPlayerInPosition(){
		assertEquals(4,defender.totalOfPlayerInPositionAllowed());
	}

}
