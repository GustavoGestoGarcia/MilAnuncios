package com.example.microanuncios.interfaces;

import java.util.Date;
import java.util.List;

import com.example.microanuncios.dto.AnuncioDTO;
import com.example.microanuncios.dto.CategoriaDTO;
import com.example.microanuncios.dto.UsuarioDTO;

public interface IAnuncioService {
	
	public List<AnuncioDTO> getAnuncios();
	
	public List<AnuncioDTO> getAnunciosByCategoria(CategoriaDTO categoriaDTO);
	
	public List<AnuncioDTO> getAnunciosByUsuario(UsuarioDTO usuarioDTO);
	
	public List<AnuncioDTO> filterAnunciosByPrecio(double precioMin, double precioMax);
	
	public List<AnuncioDTO> filterAnunciosByFecha(Date fechaIni, Date fechaFin);
	
	public AnuncioDTO getAnuncioByIdAnuncio(int idAnuncio);
	
	public UsuarioDTO getUsuarioByIdAnuncio(int idAnuncio);
	
	public CategoriaDTO getCategoriaByIdAnuncio(int idAnuncio);
	
	public void updateAnuncio(AnuncioDTO anuncioDTO);
	
	public void deleteAnuncio(AnuncioDTO anuncioDTO);
	
}
