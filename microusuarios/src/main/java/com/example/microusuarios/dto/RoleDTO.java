package com.example.microusuarios.dto;

import java.util.List;

public class RoleDTO {

	 private String role;
	 private String funcion;
	 private List<UsuarioDTO> usuarios;
	 
	 
	public RoleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RoleDTO(String role, String funcion, List<UsuarioDTO> usuarios) {
		super();
		this.role = role;
		this.funcion = funcion;
		this.usuarios = usuarios;
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


	public List<UsuarioDTO> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<UsuarioDTO> usuarios) {
		this.usuarios = usuarios;
	}


	@Override
	public String toString() {
		return "RoleDTO [role=" + role + ", funcion=" + funcion + ", usuarios=" + usuarios + "]";
	}
	
	
	 
	 
}
