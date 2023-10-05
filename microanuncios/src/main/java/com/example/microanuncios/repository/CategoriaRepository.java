package com.example.microanuncios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.microanuncios.model.Anuncio;
import com.example.microanuncios.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
	@Query(value="FROM Anuncio WHERE categoria = :categoria")
	List<Anuncio> findAnunciosByCategoria(Categoria categoria);

}
