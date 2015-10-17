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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
			 return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	
	
	private Team toTeam(TeamRequest request) throws Exception{
		User u = userService.obtainUser(request.getUsuario().trim());
		Team t = new Team();
		t.setName(request.getNombreEquipo().trim());
		for (Method m : request.getClass().getMethods()){
			if (m.getName().contains("Arquero") || m.getName().contains("Volante") ||
					m.getName().contains("Defensor") || m.getName().contains("Delantero")){
				
				t.addPlayer(toPlayer((PlayerRequest) m.invoke(request), t));
			}
		}
		u.setUserTeam(t);
		t.setOwner(u);
		return t;
	}
	
	
	
	private Player toPlayer(PlayerRequest request,Team t){
		if (request.getPuesto().equals("Arquero")){
			return playerFactory.createGoalKeeperWithTeam(request.getNombre().trim() + " " +request.getApellido().trim(), t);
		}
		if(request.getPuesto().equals("Defensor")){
			return playerFactory.createDefenderWithTeam(request.getNombre().trim() + " " +request.getApellido().trim(), t);
		}
		
		if(request.getPuesto().equals("Volante")){
			return playerFactory.createMidFielderWithTeam(request.getNombre().trim() + " " +request.getApellido().trim(), t);
		}
		return playerFactory.createForwardWithTeam(request.getNombre().trim() + " " +request.getApellido().trim(), t);
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
