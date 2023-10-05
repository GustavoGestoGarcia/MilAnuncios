package com.example.microanuncios.interfaces;

import java.util.List;

import com.example.microanuncios.dto.AnuncioDTO;
import com.example.microanuncios.dto.CategoriaDTO;

public interface ICategoriaService {
	public List<CategoriaDTO> getCategorias();
	public List<AnuncioDTO> getAnunciosByCategoria(int idCategoria);
	public CategoriaDTO getCategoriaById(int idCategoria);
	public void deleteCategoriaById(int idCategoria);
	public void updateCategoria(CategoriaDTO categoriaDTO);
}
