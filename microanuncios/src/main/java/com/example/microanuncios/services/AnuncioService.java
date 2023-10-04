package com.example.microanuncios.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microanuncios.dto.AnuncioDTO;
import com.example.microanuncios.dto.CategoriaDTO;
import com.example.microanuncios.dto.UsuarioDTO;
import com.example.microanuncios.interfaces.IAnuncioService;
import com.example.microanuncios.model.Anuncio;
import com.example.microanuncios.repository.AnuncioRepository;

@Service
public class AnuncioService implements IAnuncioService {
	@Autowired
	AnuncioRepository anuncioRepository;
	@Override
	public List<AnuncioDTO> getAnuncios() {
		List<Anuncio> anuncios = anuncioRepository.findAll();
		List<AnuncioDTO> anunciosDTO = null;
		if(anuncios != null) {
			anunciosDTO = new ArrayList<AnuncioDTO>();
			for (Anuncio anuncio : anuncios) {
				anunciosDTO.add(anuncioModelToDTO(anuncio));
			}
		}
		return anunciosDTO;
	}
	@Override
	public List<AnuncioDTO> getAnunciosByCategoria(CategoriaDTO categoriaDTO) {
		return categoriaDTO.getAnuncios();
	}
	@Override
	public List<AnuncioDTO> getAnunciosByUsuario(UsuarioDTO usuarioDTO) {
		return usuarioDTO.getAnuncios();
	}
	@Override
	public List<AnuncioDTO> filterAnunciosByPrecio(double precioMin, double precioMax) {
		List<Anuncio> anuncios = anuncioRepository.filterAnunciosByPrecio(precioMin, precioMax);
		List<AnuncioDTO> anunciosDTO = null;
		if(anuncios != null) {
			anunciosDTO = new ArrayList<AnuncioDTO>();
			for (Anuncio anuncio : anuncios) {
				anunciosDTO.add(anuncioModelToDTO(anuncio));
			}
		}
		return anunciosDTO;
	}
	@Override
	public List<AnuncioDTO> filterAnunciosByFecha(Date fechaIni, Date fechaFin) {
		List<Anuncio> anuncios = anuncioRepository.filterAnunciosByFecha(fechaIni, fechaFin);
		List<AnuncioDTO> anunciosDTO = null;
		if(anuncios != null) {
			anunciosDTO = new ArrayList<AnuncioDTO>();
			for (Anuncio anuncio : anuncios) {
				anunciosDTO.add(anuncioModelToDTO(anuncio));
			}
		}
		return anunciosDTO;
	}
	@Override
	public AnuncioDTO getAnuncioByIdAnuncio(int idAnuncio) {
		return anuncioModelToDTO(anuncioRepository.findById(idAnuncio).orElse(null));
	}
	@Override
	public UsuarioDTO getUsuarioByIdAnuncio(int idAnuncio) {
		return getAnuncioByIdAnuncio(idAnuncio).getUsuario();
	}
	@Override
	public CategoriaDTO getCategoriaByIdAnuncio(int idAnuncio) {
		return getAnuncioByIdAnuncio(idAnuncio).getCategoria();
	}
	@Override
	public void updateAnuncio(AnuncioDTO anuncioDTO) {
		Anuncio anuncio = new Anuncio(anuncioDTO.getIdAnuncio(), anuncioDTO.getTitulo(), anuncioDTO.getDescripcion(), anuncioDTO.getPrecio(), anuncioDTO.getFechaPublicacion(), anuncioDTO.getCategoria().getIdCategoria(), anuncioDTO.getUsuario().getUser());
		anuncioRepository.save(anuncio);
	}
	@Override
	public void deleteAnuncioByIdAnuncio(int idAnuncio) {
		Anuncio anuncio = anuncioRepository.findById(idAnuncio).orElse(null);
		anuncioRepository.delete(anuncio);
	}

	private AnuncioDTO anuncioModelToDTO(Anuncio anuncio) {
		AnuncioDTO anuncioDTO = null;
		if(anuncio != null) {
			anuncioDTO = new AnuncioDTO(anuncio.getIdAnuncio(), anuncio.getTitulo(),anuncio.getDescripcion(), anuncio.getPrecio(), anuncio.getFechaPublicacion());
			CategoriaDTO categoriaDTO = new CategoriaDTO(anuncio.getCategoria().getIdCategoria(), anuncio.getCategoria().getDescripcion());
			UsuarioDTO usuarioDTO = new UsuarioDTO(anuncio.getUsuario().getUser(), anuncio.getUsuario().getEmail(), anuncio.getUsuario().getPassword());
			anuncioDTO.setCategoria(categoriaDTO);
			anuncioDTO.setUsuario(usuarioDTO);
			
		}
		return anuncioDTO;
	}

}
