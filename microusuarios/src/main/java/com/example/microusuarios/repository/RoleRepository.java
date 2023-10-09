package com.example.microusuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microusuarios.model.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}
