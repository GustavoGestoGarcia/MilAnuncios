package com.example.microusuarios.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microusuarios.dto.RoleDTO;
import com.example.microusuarios.dto.UsuarioDTO;
import com.example.microusuarios.interfaces.IUsuarioService;
import com.example.microusuarios.model.Role;
import com.example.microusuarios.model.Usuario;
import com.example.microusuarios.repository.UsuarioRepository;



@Service
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<UsuarioDTO> getUsuarios(){
	List<Usuario> usuarios=(List<Usuario>)usuarioRepository.findAll();
	List<UsuarioDTO> usuariosDTO=new ArrayList();
	for(Usuario usuario : usuarios) {
		UsuarioDTO usuarioDTO= new UsuarioDTO(usuario.getUser(),usuario.getEmail(),usuario.getPassword());
		usuariosDTO.add(usuarioDTO);
		}
	return usuariosDTO;
	}

	@Override
	public void deleteUsuarioByUser(String user) {
		usuarioRepository.deleteById(user);
	}

	@Override
	public UsuarioDTO findUsuarioByUser(String user) {
		Usuario usuario = usuarioRepository.findById(user).orElse(null);
		UsuarioDTO usuarioDTO;
		if(usuario==null)return null;
		else {
			usuarioDTO= new UsuarioDTO(usuario.getUser(),usuario.getEmail(),usuario.getPassword());
		}
		return usuarioDTO;
	}

	@Override
	public void updateUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario(usuarioDTO.getUser(),usuarioDTO.getEmail(),usuarioDTO.getPassword(), null);
		usuarioRepository.save(usuario);
	}

	@Override
	public List<RoleDTO> getRolesByUser(String user) {
		Usuario usuario = usuarioRepository.findById(user).orElse(null);
		List<RoleDTO> rolesDTO = new ArrayList<RoleDTO>();
		if(usuario != null) {
			List<Role> roles = new ArrayList<Role>(usuario.getRoles());
			for (Role role : roles) {
				RoleDTO roleDTO = new RoleDTO(role.getRole(), role.getFuncion(), null);
				rolesDTO.add(roleDTO);
			}
		}
		return rolesDTO;
	}
	
	
}
