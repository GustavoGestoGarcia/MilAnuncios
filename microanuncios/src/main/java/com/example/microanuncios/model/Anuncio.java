package com.example.microanuncios.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="anuncios")
public class Anuncio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_anuncio")
	private int idAnuncio;
	private String titulo;
	private String descripcion;
	private double precio;
	@Column(name="fecha_publicacion")
	private Date fechaPublicacion;
	
	@Column(name="id_categoria")
	private int idCategoria;
	@ManyToOne
	@JoinColumn(name="id_categoria",referencedColumnName ="id_categoria" , insertable=false,updatable=false)
	private Categoria categoria;
	
	private String user;
	
	@ManyToOne
	@JoinColumn(name="user",referencedColumnName ="user" , insertable=false,updatable=false)
	private Usuario usuario;

	public Anuncio() {
		super();
	}

	public Anuncio(int idAnuncio, String titulo, String descripcion, double precio, Date fechaPublicacion) {
		super();
		this.idAnuncio = idAnuncio;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fechaPublicacion = fechaPublicacion;
	}

	public Anuncio(int idAnuncio, String titulo, String descripcion, double precio, Date fechaPublicacion,
			Categoria categoria, Usuario usuario) {
		super();
		this.idAnuncio = idAnuncio;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fechaPublicacion = fechaPublicacion;
		this.categoria = categoria;
		this.usuario = usuario;
		this.idCategoria = categoria.getIdCategoria();
		this.user = usuario.getUser();
	}

	public Anuncio(int idAnuncio, String titulo, String descripcion, double precio, Date fechaPublicacion,
			int idCategoria, String user) {
		super();
		this.idAnuncio = idAnuncio;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fechaPublicacion = fechaPublicacion;
		this.idCategoria = idCategoria;
		this.user = user;
	}

	public Anuncio(int idAnuncio, String titulo, String descripcion, double precio, Date fechaPublicacion,
			int idCategoria, Categoria categoria, String user, Usuario usuario) {
		super();
		this.idAnuncio = idAnuncio;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fechaPublicacion = fechaPublicacion;
		this.idCategoria = idCategoria;
		this.categoria = categoria;
		this.user = user;
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

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
