package com.example.microanuncios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microanuncios.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

}
