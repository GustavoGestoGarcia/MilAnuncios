package com.example.microanuncios.dto;

import java.util.List;

public class CategoriaDTO {
	private int idCategoria;
	private String descripcion;
	
	private List<AnuncioDTO> anuncios;

	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(int idCategoria, String descripcion) {
		super();
		this.idCategoria = idCategoria;
		this.descripcion = descripcion;
	}

	public CategoriaDTO(int idCategoria, String descripcion, List<AnuncioDTO> anuncios) {
		super();
		this.idCategoria = idCategoria;
		this.descripcion = descripcion;
		this.anuncios = anuncios;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<AnuncioDTO> getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(List<AnuncioDTO> anuncios) {
		this.anuncios = anuncios;
	}

	@Override
	public String toString() {
		return "CategoriaDTO [idCategoria=" + idCategoria + ", descripcion=" + descripcion + ", anuncios=" + anuncios
				+ "]";
	}
	
	
}
