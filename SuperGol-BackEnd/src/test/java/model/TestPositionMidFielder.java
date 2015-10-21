package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPositionMidFielder {
	
	Position midFielder;
	
	@Before
	public void setUp(){
		midFielder = new MidFielder();
	}
	
	@Test
	public void testDescription(){
		assertEquals("Mid Fielder",midFielder.description());
	}
	
	@Test
	public void testPoints(){
		assertEquals(1,midFielder.points());
	}
	
	@Test
	public void testMaxPlayerInPosition(){
		assertEquals(4,midFielder.totalOfPlayerInPositionAllowed());
	}

}
