package com.example.microusuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microusuarios.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

}
