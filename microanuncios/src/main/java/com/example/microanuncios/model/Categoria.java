package com.example.microanuncios.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="categorias")
public class Categoria {
	@Id
	@Column(name="id_categoria")
	private int idCategoria;
	private String descripcion;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_categoria",referencedColumnName ="id_categoria" )
	private List<Anuncio> anuncios;

	public Categoria() {
		super();
	}

	public Categoria(int idCategoria, String descripcion) {
		super();
		this.idCategoria = idCategoria;
		this.descripcion = descripcion;
	}

	public Categoria(int idCategoria, String descripcion, List<Anuncio> anuncios) {
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

	public List<Anuncio> getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}
	
	
}
