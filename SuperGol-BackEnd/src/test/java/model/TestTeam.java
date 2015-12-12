package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import exceptions.EnoughtPlayersInPositionException;
import exceptions.PlayerDoesntExistException;
import exceptions.PlayerInTeamException;
import exceptions.TeamAlreadyFullException;
import factories.PlayerFactory;
import factories.TeamFactory;

public class TestTeam {
	
	Team boca;
	PlayerFactory factory;
	TeamFactory teamFactory;
	
	@Before
	public void setUp(){
		factory = new PlayerFactory();
		teamFactory = new TeamFactory();
		boca = teamFactory.createFullTeam("Boca", "h");
	}
	
	@Test
	public void testName(){
		assertEquals(boca.getName(),"Boca");
	}
	
	@Test
	public void testFlag(){
		assertEquals(boca.getFlag(),"Flag");
	}
	
	@Test
	public void testAddPlayerSuccessfully(){
		boca.removePlayerWithName("Delantero3h");
		boca.addPlayer(factory.createForwardWithTeam("Delantero3h", boca));
	}
	
	@Test(expected=PlayerInTeamException.class) 
	public void testAddPlayerAlreadyInTeam(){
		boca.addPlayer(factory.createForwardWithTeam("Delantero3h", boca));
		boca.addPlayer(boca.getPlayer("Delantero3h"));
	}

	@Test(expected=EnoughtPlayersInPositionException.class)
	public void testAddPlayerWithFullPositionsInTeam(){
		boca.getPlayers().remove(0);
		boca.getPlayers().remove(0);
		boca.addPlayer(factory.createDefenderWithTeam("delantero5h", boca));
		boca.addPlayer(factory.createDefenderWithTeam("delantero12h", boca));
		boca.addPlayer(factory.createDefenderWithTeam("delantero6h", boca));
		
	}
	
	@Test(expected=TeamAlreadyFullException.class)
	public void testTeamFull(){
		boca.addPlayer(factory.createForwardWithTeam("Delantero3h", boca));
		boca.addPlayer(factory.createForwardWithTeam("Delantero4h", boca));
	}
	
	@Test(expected=PlayerDoesntExistException.class)
	public void testFailedGetPlayer(){
		boca.getPlayer("Failed Player");
	}
	
	@Test
	public void testGetPlayer(){
		assertNotNull(boca.getPlayer("Delantero1h"));
	}
	
	@Test
	public void testScore(){
		boca.score(boca.getPlayer("Delantero1h"));
		assertEquals(boca.getMatchPoints(), 1);
	}
	
	@Test
	public void testScoreOfOtherPlayer(){
		boca.score(factory.createDefender("Noname"));
		assertEquals(boca.getMatchPoints(),0);
	}
	
	@Test
	public void testGetPlayers(){
		assertNotNull(boca.getPlayers());
	}
	
	@Test
	public void testGetOwner(){
		assertNotNull(boca.getOwner());
	}

}
