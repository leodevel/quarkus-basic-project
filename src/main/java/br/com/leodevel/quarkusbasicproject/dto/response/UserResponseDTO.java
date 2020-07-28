package br.com.leodevel.quarkusbasicproject.dto.response;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import br.com.leodevel.quarkusbasicproject.models.User;

public class UserResponseDTO {

	private Long id;
	private String name;
	private String username;
	private String password;
	private List<RoleResponseDTO> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<RoleResponseDTO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleResponseDTO> roles) {
		this.roles = roles;
	}

	public static UserResponseDTO fromEntity(User user) {
		try {
			UserResponseDTO userResponseDTO = new UserResponseDTO();
			BeanUtils.copyProperties(userResponseDTO, user);
			return userResponseDTO;
		}catch(Exception ex) {
			return null;
		}		
	}

}
