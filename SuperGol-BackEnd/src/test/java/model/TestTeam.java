package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.EnoughtPlayersInPositionException;
import exceptions.PlayerDoesntExistException;
import exceptions.PlayerInTeamException;
import exceptions.TeamAlreadyFullException;
import factories.PlayerFactory;

public class TestTeam {
	
	Team boca;
	PlayerFactory factory;
	
	@Before
	public void setUp(){
		factory = new PlayerFactory();
		boca = new Team()
					.withName("Boca")
					.withPlayer(factory.createGoalKeeperWithTeam("Arquero", boca))
					.withPlayer(factory.createDefenderWithTeam("Defensor1", boca))
					.withPlayer(factory.createDefenderWithTeam("Defensor2", boca))
					.withPlayer(factory.createDefenderWithTeam("Defensor3", boca))
					.withPlayer(factory.createDefenderWithTeam("Defensor4", boca))
					.withPlayer(factory.createMidFielderWithTeam("Medio1", boca))
					.withPlayer(factory.createMidFielderWithTeam("Medio2", boca))
					.withPlayer(factory.createMidFielderWithTeam("Medio3", boca))
					.withPlayer(factory.createForwardWithTeam("Delantero1", boca))
					.withPlayer(factory.createForwardWithTeam("Delantero2", boca))
					.withFlag("Flag")
					.withOwner(new User()); 
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
		boca.addPlayer(factory.createForwardWithTeam("Delantero3", boca));
	}
	
	@Test(expected=PlayerInTeamException.class) 
	public void testAddPlayerAlreadyInTeam(){
		boca.addPlayer(factory.createForwardWithTeam("Delantero3", boca));
		boca.addPlayer(boca.getPlayer("Delantero3"));
	}

	@Test(expected=EnoughtPlayersInPositionException.class)
	public void testAddPlayerWithFullPositionsInTeam(){
		boca.addPlayer(factory.createDefenderWithTeam("delantero5", boca));
	}
	
	@Test(expected=TeamAlreadyFullException.class)
	public void testTeamFull(){
		boca.addPlayer(factory.createForwardWithTeam("Delantero3", boca));
		boca.addPlayer(factory.createForwardWithTeam("Delantero4", boca));
	}
	
	@Test(expected=PlayerDoesntExistException.class)
	public void testFailedGetPlayer(){
		boca.getPlayer("Failed Player");
	}
	
	@Test
	public void testGetPlayer(){
		assertNotNull(boca.getPlayer("Delantero1"));
	}
	
	@Test
	public void testScore(){
		boca.score(boca.getPlayer("Delantero1"));
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
