package model;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import daos.interfaces.TeamDAO;
import daos.interfaces.UserDAO;
import factories.TeamFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/beans/service-beans.xml",
					 "/config/dataSource.xml"})
public class TestTeamDAO {

	@Autowired
	public TeamDAO teamDAO;
	@Autowired 
	public UserDAO userDAO;
	public TeamFactory teamFactory = new TeamFactory();
	Team t1;
	User u1;
	
	
	@Before
	public void setUp(){
		t1 = teamFactory.createFullTeam("Atlanta", "a");
		teamDAO.saveTeam(t1);
		u1 = new User();
		u1.setEmail("aaa@gmail.com");
		u1.setUserName("LALA");
		u1.setPassword("1234");
		userDAO.save(u1);
	}
	
	@Test
	public void testDAONotNull(){
		assertNotNull(teamDAO);
	}
	
	@Test
	public void testGetTeamByName(){
		t1 = teamDAO.getTeamByName("Atlanta");
		u1 = userDAO.obtainUser("LALA");
		assertNotNull(t1);
		assertNotNull(t1.getPlayers());
	}
	
	@After
	public void tearDown(){
		if(t1 != null){
			teamDAO.deleteTeam(t1);			
		}
		if(u1 != null){
			userDAO.deleteUser(u1);
		}
	}
	
	
}
