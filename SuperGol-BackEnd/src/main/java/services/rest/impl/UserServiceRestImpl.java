package services.rest.impl;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.User;
import services.interfaces.UserService;
import utils.rest.request.UserRequest;

@Service
@Path("/userService")
public class UserServiceRestImpl {

	@Autowired
	private UserService userService;

	
	
	
	@POST
	@Path("/create")
	@Produces("application/json")
	public Response createPlayer(@Multipart(value = "request", type = "application/json") final String jsonRequest) {
	    try{
	    	UserRequest request = toRequest(jsonRequest);
	    	userService.save(toUser(request));
	    	 return Response.status(200).build();
	    }catch(Exception e){
	    	 return Response.serverError().entity(e.getMessage()).build();
	    }
	}




	private User toUser(UserRequest request) {
		User user = new User();
		user.setEmail(request.getEmail());
		user.setUserName(request.getNombre());
		user.setPassword(request.getPass());
		return user;
	}




	private UserRequest toRequest(String jsonRequest) {
		UserRequest request = new UserRequest();
        ObjectMapper mapper = new ObjectMapper();
        try {
            request = mapper.readValue(jsonRequest, UserRequest.class);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return request;
    }
	
}
