package br.com.leodevel.quarkusbasicproject.dto.response;

import br.com.leodevel.quarkusbasicproject.enums.RoleEnum;

public class RoleResponseDTO {

	private Long id;
	private RoleEnum role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}
	
}