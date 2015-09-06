package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestPositionForward {
	
Position forward;
	
	@Before
	public void setUp(){
		forward = new Forward();
	}
	
	@Test
	public void testDescription(){
		assertEquals("Forward",forward.description());
	}
	
	@Test
	public void testPoints(){
		assertEquals(1,forward.points());
	}
	
	@Test
	public void testMaxPlayerInPosition(){
		assertEquals(3,forward.totalOfPlayerInPositionAllowed());
	}

}
