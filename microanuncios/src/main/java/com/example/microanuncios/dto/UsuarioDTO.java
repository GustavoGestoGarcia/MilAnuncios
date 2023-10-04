package com.example.microanuncios.dto;

import java.util.List;

public class UsuarioDTO {
	public String user;
	public String email;
	public String password;
	
	private List<AnuncioDTO> anuncios;

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(String user, String email, String password) {
		super();
		this.user = user;
		this.email = email;
		this.password = password;
	}

	public UsuarioDTO(String user, String email, String password, List<AnuncioDTO> anuncios) {
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

	public List<AnuncioDTO> getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(List<AnuncioDTO> anuncios) {
		this.anuncios = anuncios;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [user=" + user + ", email=" + email + ", password=" + password + ", anuncios=" + anuncios
				+ "]";
	}
	
	
}
