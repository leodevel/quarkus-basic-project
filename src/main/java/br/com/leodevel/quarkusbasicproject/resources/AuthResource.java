package br.com.leodevel.quarkusbasicproject.resources;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import org.jose4j.lang.JoseException;

import br.com.leodevel.quarkusbasicproject.dto.request.UserRequestDTO;
import br.com.leodevel.quarkusbasicproject.dto.response.JwtResponseDTO;
import br.com.leodevel.quarkusbasicproject.dto.response.ResultResponseDTO;
import br.com.leodevel.quarkusbasicproject.dto.response.UserResponseDTO;
import br.com.leodevel.quarkusbasicproject.models.User;
import br.com.leodevel.quarkusbasicproject.services.TokenService;
import br.com.leodevel.quarkusbasicproject.services.UserService;
import io.quarkus.security.Authenticated;

@Path("/api/auth")
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {
	
	@Inject
	TokenService tokenService;
	
	@Inject
	UserService userService;
	
	@Context
	SecurityContext securityContext;
		
	@POST
	@Path("/login")
	@Transactional
	public ResultResponseDTO<JwtResponseDTO> login(UserRequestDTO userRequestDTO) throws JoseException{
		
		User user = userService.login(userRequestDTO.getUsername(), userRequestDTO.getPassword());
		
		if (user == null)
			return new ResultResponseDTO<JwtResponseDTO>(false, "User not found");
		
		String token = tokenService.generateToken(user);
		
		JwtResponseDTO jwtResponseDTO = new JwtResponseDTO(UserResponseDTO.fromEntity(user), token);
		
		return new ResultResponseDTO<JwtResponseDTO>(true, jwtResponseDTO);
			
	}
	
	@GET
	@Path("/user-logged")
	@Authenticated
	public ResultResponseDTO<UserResponseDTO> getUserLogged(){
		
		String username = securityContext.getUserPrincipal().getName();
		UserResponseDTO userResponseDTO = userService.findByUsername(username);
		return new ResultResponseDTO<UserResponseDTO>(true, userResponseDTO);
		
	}

}