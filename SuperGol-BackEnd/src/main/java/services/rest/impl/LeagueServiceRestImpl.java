package services.rest.impl;

import java.util.ArrayList;
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

import aspect.Aspectable;
import model.League;
import services.interfaces.LeagueService;
import services.interfaces.TeamService;
import services.rest.request.CreateLeagueRequest;
import services.rest.request.EditLeagueRequest;
import services.rest.request.JoinLeagueRequest;
import services.rest.request.UploadFileRequest;
import services.rest.response.DetailLeagueResponse;
import services.rest.response.LeagueResponse;




@Service
@Path("/leagueService")
public class LeagueServiceRestImpl {

	private LeagueService leagueService;
	private TeamService teamService;
	
	@Aspectable
	@GET
	@Path("/all")
	@Produces("application/json")
	public List<LeagueResponse> obtainAllLeagues(){
		List<League> leagues = leagueService.obtainAllLeagues();
		return leagueService.toResponse(leagues);
	}
	
	@Aspectable
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
	
	@Aspectable
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
	
	@Aspectable
	@GET
	@Path("/remove/{id}")
	@Produces("application/json")
	public Response deleteLeague(@PathParam("id") final int id){
		try{
			leagueService.deleteLeagueById(id);
			return Response.status(200).build();
		}catch(Exception e){
			e.printStackTrace();
			 return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	
	@Aspectable
	@GET
	@Path("/createFixture/{id}")
	@Produces("application/json")
	public Response createFixture(@PathParam("id") final int id){
		try{
			leagueService.createFixture(id);
			return Response.status(200).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	
	@Aspectable
	@POST
	@Path("/join")
	@Produces("application/json")
	public Response joinToLeague(@Multipart(value = "jsonRequest", type = "application/json")
	final String jsonRequest){
		try{
			// VALIDAR SI EL USUARIO TIENE EQUIPO PARA EJECUTAR EL UNIRSE A UNA LIGA
			JoinLeagueRequest request = toCreateJoinLeagueRequest(jsonRequest);
			leagueService.joinLeague(request.getUsername(),request.getIdLeague());
			return Response.status(200).build();
		}catch(Exception e){
			e.printStackTrace();
			 return Response.serverError().entity(e.getMessage()).build();
		}
		
	}
	
	
	@Aspectable
	@GET
	@Path("/myLeagues/{id}")
	@Produces("application/json")
	public List<LeagueResponse> myLeagues(@PathParam("id") final String idUser){
		League l = leagueService.getLeagueByUser(idUser);
		List<League>lss = new ArrayList<League>();
		lss.add(l);
		return leagueService.toResponse(lss);
	}
	
	
	@Aspectable
	@GET
	@Path("/detailLeague/{id}")
	@Produces("application/json")
	public DetailLeagueResponse obtainDetailLeague(@PathParam("id") final int idLeague){
		League l = leagueService.obtainLeagueById(idLeague);
		return new DetailLeagueResponse(l,teamService);
		
	}
	
	
	@Aspectable
	@POST
	@Path("/upload")
	@Produces("application/json")
	public Response uploadFile(@Multipart(value = "request", type = "application/json") final String jsonRequest){
		
		try{
			UploadFileRequest request = toFileRequest(jsonRequest);
			leagueService.saveFile(request);
			return Response.status(200).build();			
		}catch(Exception e){
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	
	private UploadFileRequest toFileRequest(String jsonRequest) throws Exception{
		UploadFileRequest request = new UploadFileRequest();
		request.setContent(jsonRequest);
		return request;
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

	public TeamService getTeamService() {
		return teamService;
	}

	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}
	
	
	
	
	
	
}
