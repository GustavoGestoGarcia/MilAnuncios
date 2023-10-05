package com.example.microanuncios.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microanuncios.dto.AnuncioDTO;
import com.example.microanuncios.dto.CategoriaDTO;
import com.example.microanuncios.dto.UsuarioDTO;
import com.example.microanuncios.interfaces.ICategoriaService;
import com.example.microanuncios.model.Anuncio;
import com.example.microanuncios.model.Categoria;
import com.example.microanuncios.repository.CategoriaRepository;

@Service
public class CategoriaService implements ICategoriaService {
	@Autowired
	CategoriaRepository categoriaRepository;
	@Override
	public List<CategoriaDTO> getCategorias() {
		List<Categoria> categorias = categoriaRepository.findAll();
		List<CategoriaDTO> categoriasDTO = null;
		if(categorias != null) {
			categoriasDTO = new ArrayList<CategoriaDTO>();
			for (Categoria categoria : categorias) {
				categoriasDTO.add(categoriaModelToDTO(categoria));
			}
		}
		return categoriasDTO;
	}

	@Override
	public List<AnuncioDTO> getAnunciosByCategoria(int idCategoria) {
		Categoria categoria = categoriaRepository.findById(idCategoria).orElse(null);
		List<Anuncio> anuncios = categoriaRepository.findAnunciosByCategoria(categoria);
		List<AnuncioDTO> anunciosDTO = null;
		if(anuncios != null) {
			anunciosDTO = new ArrayList<AnuncioDTO>();
			for (Anuncio anuncio : anuncios) {
				AnuncioDTO anuncioDTO = new AnuncioDTO(anuncio.getIdAnuncio(), anuncio.getTitulo(),anuncio.getDescripcion(), anuncio.getPrecio(), anuncio.getFechaPublicacion());
				CategoriaDTO categoriaDTO = new CategoriaDTO(anuncio.getCategoria().getIdCategoria(), anuncio.getCategoria().getDescripcion());
				UsuarioDTO usuarioDTO = new UsuarioDTO(anuncio.getUsuario().getUser(), anuncio.getUsuario().getEmail(), anuncio.getUsuario().getPassword());
				anuncioDTO.setCategoria(categoriaDTO);
				anuncioDTO.setUsuario(usuarioDTO);
				anunciosDTO.add(anuncioDTO);
			}
		}
		return anunciosDTO;
	}
	
	@Override
	public CategoriaDTO getCategoriaById(int idCategoria) {
		Categoria categoria = categoriaRepository.findById(idCategoria).orElse(null);
		return categoriaModelToDTO(categoria);
	}

	@Override
	public void deleteCategoriaById(int idCategoria) {
		Categoria categoria = categoriaRepository.findById(idCategoria).orElse(null);
		categoriaRepository.delete(categoria);
	}

	@Override
	public void updateCategoria(CategoriaDTO categoriaDTO) {
		System.out.println(categoriaDTO);
		Categoria categoria = new Categoria(categoriaDTO.getIdCategoria(), categoriaDTO.getDescripcion());
		System.out.println(categoria);
		categoriaRepository.save(categoria);
	}
	
	private CategoriaDTO categoriaModelToDTO(Categoria categoria) {
		CategoriaDTO categoriaDTO = null;
		if(categoria != null) {
			categoriaDTO = new CategoriaDTO(categoria.getIdCategoria(), categoria.getDescripcion());
//			List<Anuncio> anuncios = categoria.getAnuncios();
//			if(anuncios != null) {
//				List<AnuncioDTO> anunciosDTO = new ArrayList<AnuncioDTO>();
//				for (Anuncio anuncio : anuncios) {
//					AnuncioDTO anuncioDTO = new AnuncioDTO(anuncio.getIdAnuncio(), anuncio.getTitulo(),anuncio.getDescripcion(), anuncio.getPrecio(), anuncio.getFechaPublicacion());
//					UsuarioDTO usuarioDTO = new UsuarioDTO(anuncio.getUsuario().getUser(), anuncio.getUsuario().getEmail(), anuncio.getUsuario().getPassword());
//					anuncioDTO.setCategoria(categoriaDTO);
//					anuncioDTO.setUsuario(usuarioDTO);
//					anunciosDTO.add(anuncioDTO);
//				}
//				categoriaDTO.setAnuncios(anunciosDTO);
//			}
			
		}
		return categoriaDTO;
	}

}
