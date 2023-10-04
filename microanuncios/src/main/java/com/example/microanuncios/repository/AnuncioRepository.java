package com.example.microanuncios.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.microanuncios.model.Anuncio;

public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {
	
	@Query(value="FROM Anuncio WHERE precio > :precioMin AND precio < :precioMax")
	List<Anuncio> filterAnunciosByPrecio(@Param("precioMin") double precioMin, @Param("precioMax") double precioMax);
	
	@Query(value="FROM Anuncio WHERE fechaPublicacion > :fechaIni AND fechaPublicacion < :fechaFin")
	List<Anuncio> filterAnunciosByFecha(@Param("fechaIni") Date fechaIni, @Param("fechaFin") Date fechaFin);

}
