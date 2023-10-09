package com.example.microusuarios.interfaces;

import java.util.List;

import com.example.microusuarios.dto.RoleDTO;
import com.example.microusuarios.dto.UsuarioDTO;

public interface IUsuarioService {

	public List<UsuarioDTO> getUsuarios();
	
	public UsuarioDTO findUsuarioByUser(String user);
	
	public void updateUsuario(UsuarioDTO usuarioDTO);
	
	public void deleteUsuarioByUser(String user);
	
	public List<RoleDTO> getRolesByUser(String user);

	public void addRole(UsuarioDTO usuarioDTO, RoleDTO role);
	
	public void deleteRole(String user, String role);
}
