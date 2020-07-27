package br.com.leodevel.aprendaquarkus.dto.response;

import org.apache.commons.beanutils.BeanUtils;

import br.com.leodevel.aprendaquarkus.models.User;

public class UserResponseDTO {

	private Long id;
	private String name;
	private String username;
	private String password;

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
