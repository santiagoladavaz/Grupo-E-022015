package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import daos.interfaces.PlayerDAO;
import factories.PlayerFactory;
import factories.TeamFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"../beans/service-beans.xml",
					 "../config/dataSource.xml"})
public class TestPlayerDAO {

	
	@Autowired
	public PlayerDAO playerDAO;
	public PlayerFactory playerFactory = new PlayerFactory();
	public TeamFactory teamFactory = new TeamFactory();
	
	
	
	@Before
	public void setUp(){
		playerDAO.erase();
		Player p = playerFactory.createDefender("A");
		Player p2 = playerFactory.createMidFielder("B");
		Player p3 = playerFactory.createForward("C");
		Player p4 = playerFactory.createGoalKeeper("D");
		playerDAO.savePlayer(p);
		playerDAO.savePlayer(p4);
		playerDAO.savePlayer(p3);
		playerDAO.savePlayer(p2);
		
	}
	@Test
	public void testNotNull(){
		assertNotNull(playerDAO);
	}
	
	@Test
	public void testGetPlayerDefender(){
		Player santi = playerDAO.searchPlayerByName("A");
		assertEquals(santi.getName(),"A");
		assertTrue(santi.getPosition() instanceof Defender);
	}
	
	@Test
	public void testGetPlayerMidFielder(){
		Player santi = playerDAO.searchPlayerByName("B");
		assertEquals(santi.getName(),"B");
		assertTrue(santi.getPosition() instanceof MidFielder);
	}
	
	@Test
	public void testGetPlayerForward(){
		Player santi = playerDAO.searchPlayerByName("C");
		assertEquals(santi.getName(),"C");
		assertTrue(santi.getPosition() instanceof Forward);
	}
	
	@Test
	public void testGetPlayerGoalKeeper(){
		Player santi = playerDAO.searchPlayerByName("D");
		assertEquals(santi.getName(),"D");
		assertTrue(santi.getPosition() instanceof GoalKeeper);
	}
	
	
}
