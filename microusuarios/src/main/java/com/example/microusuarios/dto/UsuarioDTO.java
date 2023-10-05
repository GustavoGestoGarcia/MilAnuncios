package com.example.microusuarios.dto;

import java.util.List;

import com.example.microusuarios.model.Role;

public class UsuarioDTO {
	
	private String user;
	private String email;
	private String password;
	private List<RoleDTO> rolesDTO;
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioDTO(String user, String email, String password) {
		super();
		this.user = user;
		this.email = email;
		this.password = password;
		this.rolesDTO = rolesDTO;
	}

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<RoleDTO> getRolesDTO() {
		return rolesDTO;
	}

	public void setRolesDTO(List<RoleDTO> rolesDTO) {
		this.rolesDTO = rolesDTO;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [user=" + user + ", email=" + email + ", password=" + password + ", rolesDTO=" + rolesDTO
				+ "]";
	}

	
	
	
	
}
