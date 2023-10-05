package com.example.microusuarios.dto;

import java.util.List;

public class RoleDTO {

	 private String role;
	 private String funcion;
	 private List<UsuarioDTO> usuariosDTO;
	 
	 
	public RoleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RoleDTO(String role, String funcion, List<UsuarioDTO> usuariosDTO) {
		super();
		this.role = role;
		this.funcion = funcion;
		this.usuariosDTO = usuariosDTO;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getFuncion() {
		return funcion;
	}


	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}


	public List<UsuarioDTO> getUsuariosDTO() {
		return usuariosDTO;
	}


	public void setUsuariosDTO(List<UsuarioDTO> usuariosDTO) {
		this.usuariosDTO = usuariosDTO;
	}


	@Override
	public String toString() {
		return "RoleDTO [role=" + role + ", funcion=" + funcion + ", usuariosDTO=" + usuariosDTO + "]";
	}
	
	
	 
	 
}
