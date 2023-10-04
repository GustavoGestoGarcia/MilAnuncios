package com.example.microanuncios.dto;

import java.util.Date;

public class AnuncioDTO {
	private int idAnuncio;
	private String titulo;
	private String descripcion;
	private double precio;
	
	private Date fechaPublicacion;
	
	private CategoriaDTO categoria;
	private UsuarioDTO usuario;
	public AnuncioDTO() {
		super();
	}
	public AnuncioDTO(int idAnuncio, String titulo, String descripcion, double precio, Date fechaPublicacion) {
		super();
		this.idAnuncio = idAnuncio;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fechaPublicacion = fechaPublicacion;
	}
	public AnuncioDTO(int idAnuncio, String titulo, String descripcion, double precio, Date fechaPublicacion,
			CategoriaDTO categoria, UsuarioDTO usuario) {
		super();
		this.idAnuncio = idAnuncio;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fechaPublicacion = fechaPublicacion;
		this.categoria = categoria;
		this.usuario = usuario;
	}
	public int getIdAnuncio() {
		return idAnuncio;
	}
	public void setIdAnuncio(int idAnuncio) {
		this.idAnuncio = idAnuncio;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	public CategoriaDTO getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "AnuncioDTO [idAnuncio=" + idAnuncio + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", fechaPublicacion=" + fechaPublicacion + ", categoria=" + categoria
				+ ", usuario=" + usuario + "]";
	}
	
	
}
