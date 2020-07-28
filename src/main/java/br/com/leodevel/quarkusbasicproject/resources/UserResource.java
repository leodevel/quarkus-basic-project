package br.com.leodevel.quarkusbasicproject.resources;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.leodevel.quarkusbasicproject.dto.request.UserRequestDTO;
import br.com.leodevel.quarkusbasicproject.dto.response.ResultResponseDTO;
import br.com.leodevel.quarkusbasicproject.dto.response.UserResponseDTO;
import br.com.leodevel.quarkusbasicproject.enums.RoleEnum;
import br.com.leodevel.quarkusbasicproject.services.UserService;
import io.quarkus.security.Authenticated;

@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

	@Inject
	UserService userService;
	
    @GET
    @Authenticated
    public ResultResponseDTO<List<UserResponseDTO>> findUsers() {
    	return new ResultResponseDTO<List<UserResponseDTO>>(true, userService.findUsers());        
    }
    
    @POST
    @RolesAllowed(RoleEnum.Names.ROLE_ADMIN)
    public ResultResponseDTO<UserResponseDTO> save(UserRequestDTO userRequestDTO) {
    	return new ResultResponseDTO<UserResponseDTO>(true, userService.save(userRequestDTO));
    }   
    
}