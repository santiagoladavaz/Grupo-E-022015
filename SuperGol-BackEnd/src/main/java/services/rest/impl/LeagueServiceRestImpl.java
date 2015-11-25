package services.rest.impl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import model.League;
import services.interfaces.LeagueService;
import services.rest.request.CreateLeagueRequest;
import services.rest.request.EditLeagueRequest;
import services.rest.request.JoinLeagueRequest;
import services.rest.response.LeagueResponse;




@Service
@Path("/leagueService")
public class LeagueServiceRestImpl {

	private LeagueService leagueService;	
	

	@GET
	@Path("/all")
	@Produces("application/json")
	public List<LeagueResponse> obtainAllLeagues(){
		List<League> leagues = leagueService.obtainAllLeagues();
		return leagueService.toResponse(leagues);
	}
	
	@POST
	@Path("/edit")
	@Produces("application/json")
	public Response editLeague(@Multipart(value = "jsonRequest", type = "application/json")
	final String jsonRequest){
		try{
			EditLeagueRequest request = toEditLeagueRequest(jsonRequest);
			leagueService.editLeague(request.getId(), request.getName(), request.getCantMax(),
					request.getCantMin());
			return Response.status(200).build();
		}catch(Exception e){
			 return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	
	@POST
	@Path("/create")
	@Produces("application/json")
	public LeagueResponse createLeague(@Multipart(value = "jsonRequest", type = "application/json")
	final String jsonRequest){
		try{
			CreateLeagueRequest request = toCreateLeagueRequest(jsonRequest);
			League l = leagueService.createLeague(request.getName(), request.getCantMax(),
					request.getCantMin());
			return new LeagueResponse(l);
		}catch(Exception e){
			 e.printStackTrace();
			 return null;
		}
	}
	
	
	@GET
	@Path("/remove/{id}")
	@Produces("application/json")
	public Response deleteLeague(@PathParam("id") final int id){
		try{
			leagueService.deleteLeagueById(id);
			return Response.status(200).build();
		}catch(Exception e){
			 return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	
	
	@POST
	@Path("/join")
	@Produces("application/json")
	public Response joinToLeague(@Multipart(value = "jsonRequest", type = "application/json")
	final String jsonRequest){
		try{
			JoinLeagueRequest request = toCreateJoinLeagueRequest(jsonRequest);
			leagueService.joinLeague(request.getUsername(),request.getIdLeague());
			return Response.status(200).build();
		}catch(Exception e){
			 return Response.serverError().entity(e.getMessage()).build();
		}
		
	}
	
	
	private JoinLeagueRequest toCreateJoinLeagueRequest(String jsonRequest) throws Exception{
		JoinLeagueRequest request = new JoinLeagueRequest();
		ObjectMapper mapper = new ObjectMapper();
		request = mapper.readValue(jsonRequest, JoinLeagueRequest.class);
		return request;
	}
	
	
	private CreateLeagueRequest toCreateLeagueRequest(String jsonRequest) throws Exception{
		CreateLeagueRequest request = new CreateLeagueRequest();
	    ObjectMapper mapper = new ObjectMapper();
	    request = mapper.readValue(jsonRequest, CreateLeagueRequest.class);
	    return request;
	}

	private EditLeagueRequest toEditLeagueRequest(String jsonRequest) throws Exception{
		EditLeagueRequest request = new EditLeagueRequest();
	    ObjectMapper mapper = new ObjectMapper();
	    request = mapper.readValue(jsonRequest, EditLeagueRequest.class);
	    return request;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	public LeagueService getLeagueService() {
		return leagueService;
	}

	public void setLeagueService(LeagueService leagueService) {
		this.leagueService = leagueService;
	}
	
	
}
