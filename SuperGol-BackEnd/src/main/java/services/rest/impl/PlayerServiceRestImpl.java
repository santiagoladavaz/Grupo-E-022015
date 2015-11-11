package services.rest.impl;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import services.interfaces.PlayerService;
import services.rest.request.PlayerRequest;
import services.rest.response.PlayerResponse;

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
	
	
	@POST
	@Path("/create")
	@Produces("application/json")
	public PlayerResponse createPlayer(@Multipart(value = "jsonRequest", type = "application/json")
	final String jsonRequest){
		try{
			PlayerRequest request = toPlayerRequest(jsonRequest);
			PlayerResponse pl = playerService.createPlayerByRequest(request);
			return pl;			
		}catch(Exception e){
			return null;
		}
	}
	
	@GET
	@Path("/getAll")
	public List<PlayerResponse> getPlayers(){
		return playerService.toResponse(playerService.getAll());
	}
	
	
	
	@POST
	@Path("/edit")
	@Produces("application/json")
	public Response editPlayer(@Multipart(value = "jsonRequest", type = "application/json")
	final String jsonRequest){
		try{
			PlayerRequest request= toPlayerRequest(jsonRequest);
			playerService.editPlayerByRequest(request);
			return Response.status(200).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).build();
		}
		
	}

	private PlayerRequest toPlayerRequest(String jsonRequest) throws JsonParseException, JsonMappingException, IOException {
		PlayerRequest request = new PlayerRequest();
	    ObjectMapper mapper = new ObjectMapper();
	    request = mapper.readValue(jsonRequest, PlayerRequest.class);
	    return request;
	}

	public PlayerService getPlayerService() {
		return playerService;
	}

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}	
	
}
