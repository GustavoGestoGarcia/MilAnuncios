package com.example.microusuarios.interfaces;

import java.util.List;

import com.example.microusuarios.dto.RoleDTO;

public interface IRoleService {

	public RoleDTO getRole(String role);
	public List<RoleDTO> getRoles();
}
