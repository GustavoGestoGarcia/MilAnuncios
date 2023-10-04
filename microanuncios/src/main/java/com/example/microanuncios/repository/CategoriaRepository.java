package com.example.microanuncios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microanuncios.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
