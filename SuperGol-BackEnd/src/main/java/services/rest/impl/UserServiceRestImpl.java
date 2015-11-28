package services.rest.impl;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aspect.Aspectable;
import model.User;
import services.interfaces.UserService;
import services.rest.request.UserRequest;

@Service
@Path("/userService")
public class UserServiceRestImpl {

	@Autowired
	private UserService userService;
	
	
	@Aspectable
	@GET
	@Path("/create/{id}")
	@Produces("application/json")
	public int getPlayer(@PathParam("id") final int id) {
	      return 5;
	}
	
	@Aspectable
	@POST
	@Path("/create")
	@Produces("application/json")
	public Response createPlayer(@Multipart(value = "jsonRequest", type = "application/json") final String jsonRequest) {
	    try{
	    	UserRequest request = toCreateUserRequest(jsonRequest);
	    	userService.save(toUser(request));
	    	 return Response.status(200).build();
	    }catch(Exception e){
	    	e.printStackTrace();
	    	 return Response.serverError().entity(e.getMessage()).build();
	    }
	}




	private User toUser(UserRequest request) {
		User user = new User();
		user.setEmail(request.getEmail().replaceAll("\\s", ""));
		user.setUserName(request.getNombre().replaceAll("\\s",""));
		user.setPassword(request.getPass().replaceAll("\\s", ""));
		return user;
	}




	private UserRequest toCreateUserRequest(String jsonRequest) {
		UserRequest request = new UserRequest();
        ObjectMapper mapper = new ObjectMapper();
        try {
            request = mapper.readValue(jsonRequest, UserRequest.class);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return request;
    }




	
	
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	
	
	
	
}
