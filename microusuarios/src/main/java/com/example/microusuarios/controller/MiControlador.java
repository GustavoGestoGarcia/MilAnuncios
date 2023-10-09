package com.example.microusuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microusuarios.dto.RoleDTO;
import com.example.microusuarios.dto.UsuarioDTO;
import com.example.microusuarios.interfaces.IUsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class MiControlador {

	@Autowired
	IUsuarioService usuarioService;
	
	@GetMapping("/listado_usuarios")
	public ResponseEntity<List<UsuarioDTO>> getUsuarios(){
		if(usuarioService.getUsuarios()==null||usuarioService.getUsuarios().size()==0) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(usuarioService.getUsuarios());
	}
	
	@GetMapping("/{user}")
	public ResponseEntity<UsuarioDTO> getCliente(@PathVariable("user")String user){
		if(usuarioService.findUsuarioByUser(user)==null) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(usuarioService.findUsuarioByUser(user));
	}
	
	@DeleteMapping("/{user}")
	public ResponseEntity<Integer> deleteUsuario(@PathVariable("user")String user){
		if(usuarioService.findUsuarioByUser(user)==null) {
			return ResponseEntity.ok(1);
		}
		usuarioService.deleteUsuarioByUser(user);
		return ResponseEntity.ok(0);
	}
	
	@PostMapping
	public ResponseEntity<Integer> addUsuario(@RequestBody UsuarioDTO usuarioDTO){
		UsuarioDTO usuario = usuarioService.findUsuarioByUser(usuarioDTO.getUser());
		
		if(usuario==null) {
			usuarioService.updateUsuario(usuarioDTO);
			return ResponseEntity.ok(0);
		}else {
			return ResponseEntity.ok(1);
		}
	}
	@PutMapping
	public ResponseEntity<Integer> updateUsuario(@RequestBody UsuarioDTO usuarioDTO){
		UsuarioDTO usuario = usuarioService.findUsuarioByUser(usuarioDTO.getUser());
		
		if(usuario!=null) {
			usuarioService.updateUsuario(usuarioDTO);
			return ResponseEntity.ok(0);
		}else {
			return ResponseEntity.ok(1);
		}
	}
	@GetMapping("/{user}/roles")
	public ResponseEntity<List<RoleDTO>> getRolesByUser(@PathVariable("user") String user){
	    List<RoleDTO> roles = usuarioService.getRolesByUser(user);
	    
	    if(roles == null || roles.isEmpty()) {
	        return ResponseEntity.noContent().build();
	    }

	    return ResponseEntity.ok(roles);
	}
	
}
