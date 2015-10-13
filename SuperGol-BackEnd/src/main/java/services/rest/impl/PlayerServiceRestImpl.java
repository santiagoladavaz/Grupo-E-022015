package services.rest.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;

import services.interfaces.PlayerService;

@Service
@Path("/playerService")
public class PlayerServiceRestImpl {


	private PlayerService playerService;

	
	
	@GET
	@Path("/player/{id}")
	@Produces("application/json")
	public int getPlayer(@PathParam("id") final int id) {
	      return 1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public PlayerService getPlayerService() {
		return playerService;
	}

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}	
	
}
