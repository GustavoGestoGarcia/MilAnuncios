package com.example.microanuncios.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	public String user;
	public String email;
	public String password;
	
	@OneToMany
	@JoinColumn(name="user",referencedColumnName ="user" , insertable=false,updatable=false)
	public List<Anuncio> anuncios;

	public Usuario() {
		super();
	}

	public Usuario(String user, String email, String password) {
		super();
		this.user = user;
		this.email = email;
		this.password = password;
	}

	public Usuario(String user, String email, String password, List<Anuncio> anuncios) {
		super();
		this.user = user;
		this.email = email;
		this.password = password;
		this.anuncios = anuncios;
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

	public List<Anuncio> getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}
	
}
