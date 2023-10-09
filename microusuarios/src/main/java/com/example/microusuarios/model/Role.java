package com.example.microusuarios.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Role {

	@Id
	@Column(name="role")
	private String role;
	private String funcion;
	
	@ManyToMany(mappedBy = "roles")
	private List<Usuario> usuario;
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Role(String role, String funcion) {
		super();
		this.role = role;
		this.funcion = funcion;
	}



	public Role(String role, String funcion, List<Usuario> usuario) {
		super();
		this.role = role;
		this.funcion = funcion;
		this.usuario = usuario;
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

	public List<Usuario> getUsuario() {
		return usuario;
	}



	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}



	@Override
	public String toString() {
		return "Role [role=" + role + ", funcion=" + funcion + ", usuario=" + usuario + "]";
	}

	
	
	
}
