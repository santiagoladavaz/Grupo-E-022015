package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestPositionGoalKeeper {
	
	Position goalKeeper;
	
	@Before
	public void setUp(){
		goalKeeper = new GoalKeeper();
	}
	
	@Test
	public void testDescription(){
		assertEquals("Goal Keeper",goalKeeper.description());
	}
	
	@Test
	public void testPoints(){
		assertEquals(0,goalKeeper.points());
	}
	
	@Test
	public void testMaxPlayerInPosition(){
		assertEquals(1,goalKeeper.totalOfPlayerInPositionAllowed());
	}

}
