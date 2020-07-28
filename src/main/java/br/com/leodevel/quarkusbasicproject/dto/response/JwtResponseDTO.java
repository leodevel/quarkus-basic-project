package br.com.leodevel.quarkusbasicproject.dto.response;

public class JwtResponseDTO {

	private UserResponseDTO user;
	private String token;
	
	public JwtResponseDTO(UserResponseDTO user, String token) {
		this.user = user;
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserResponseDTO getUser() {
		return user;
	}

	public void setUser(UserResponseDTO user) {
		this.user = user;
	}
	
}
