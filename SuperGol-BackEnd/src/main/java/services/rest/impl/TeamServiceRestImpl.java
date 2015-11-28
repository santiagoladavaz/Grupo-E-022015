package services.rest.impl;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import aspect.Aspectable;
import factories.PlayerFactory;
import model.Player;
import model.Team;
import model.User;
import services.interfaces.TeamService;
import services.interfaces.UserService;
import services.rest.request.PlayerRequest;
import services.rest.request.TeamRequest;

@Service
@Path("/teamService")
public class TeamServiceRestImpl {
	
	private TeamService teamService;
	private UserService userService;
	
	PlayerFactory playerFactory;
	
	{
		playerFactory = new PlayerFactory();
	}

	
	
	
	
	
	@Aspectable
	@POST
	@Path("/create")
	@Produces("application/json")
	public Response createTeam(@Multipart(value = "jsonRequest", type = "application/json")
		final String jsonRequest){
		try{
			TeamRequest request = toCreateTeamRequest(jsonRequest);
			Team team = toTeam(request);
			teamService.saveTeam(team);
			return Response.status(200).build();
		}catch(Exception e){
			e.printStackTrace();
			 return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	
	
	private Team toTeam(TeamRequest request) throws Exception{
		User u = userService.obtainUser(request.getUsuario().trim());
		Team t = new Team();
		t.setName(request.getNombreEquipo().trim());
		for (Method m : request.getClass().getMethods()){
			if ((m.getName().contains("Arquero") || m.getName().contains("Volante") ||
					m.getName().contains("Defensor") || m.getName().contains("Delantero")) 
					&& m.getName().contains("get")){
				t.addPlayer(toPlayer((PlayerRequest) m.invoke(request), t));
			}
		}
		u.setUserTeam(t);
		t.setOwner(u);
		return t;
	}
	
	
	
	private Player toPlayer(PlayerRequest request,Team t){
		if (request.getPosition().equals("Goal Keeper")){
			return playerFactory.createGoalKeeperWithTeam(request.getName().trim(), t);
		}
		if(request.getPosition().equals("Defender")){
			return playerFactory.createDefenderWithTeam(request.getName().trim(), t);
		}
		
		if(request.getPosition().equals("Forward")){
			return playerFactory.createForwardWithTeam(request.getName().trim(), t);
		}
		return playerFactory.createMidFielderWithTeam(request.getName().trim(), t);
	}
	
	
	private TeamRequest toCreateTeamRequest(String jsonRequest) 
			throws JsonParseException, JsonMappingException, IOException {
		TeamRequest request = new TeamRequest();
	    ObjectMapper mapper = new ObjectMapper();
	    request = mapper.readValue(jsonRequest, TeamRequest.class);
	    return request;
	}





	public TeamService getTeamService() {
		return teamService;
	}

	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	
	
	
	

}
