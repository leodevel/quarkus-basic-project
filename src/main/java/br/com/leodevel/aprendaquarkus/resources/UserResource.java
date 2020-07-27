package br.com.leodevel.aprendaquarkus.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.leodevel.aprendaquarkus.dto.request.UserRequestDTO;
import br.com.leodevel.aprendaquarkus.dto.response.UserResponseDTO;
import br.com.leodevel.aprendaquarkus.services.UserService;

@Path("/users")
public class UserResource {

	@Inject
	UserService userService;
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserResponseDTO> findUsers() {
    	return userService.findUsers();        
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public UserResponseDTO save(UserRequestDTO userRequestDTO) {
    	return userService.save(userRequestDTO);
    }
    
    
}