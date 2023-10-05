package com.example.microanuncios.controller;

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

import com.example.microanuncios.dto.AnuncioDTO;
import com.example.microanuncios.dto.CategoriaDTO;
import com.example.microanuncios.interfaces.ICategoriaService;

@RestController
@RequestMapping("api/categorias")
public class CategoriaController {
	@Autowired
	ICategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> getCategorias() {
		List<CategoriaDTO> categorias = categoriaService.getCategorias();
		if(categorias == null || categorias.size() == 0) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(categorias);
	}
	@GetMapping("/{idCategoria}")
	public ResponseEntity<CategoriaDTO> getCategoriaById(@PathVariable("idCategoria") int idCategoria) {
		if(categoriaService.getCategoriaById(idCategoria) == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(categoriaService.getCategoriaById(idCategoria));
	}
	
	@GetMapping("/get_anuncios/{idCategoria}")
	public ResponseEntity<List<AnuncioDTO>> getAnunciosByCategoria(@PathVariable("idCategoria") int idCategoria) {
		List<AnuncioDTO> anuncios = categoriaService.getAnunciosByCategoria(idCategoria);
		if(anuncios == null || anuncios.size() == 0) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(anuncios);
	}
	
	@DeleteMapping("/{idCategoria}")
	public ResponseEntity<Integer> deleteCategoriaById(@PathVariable("idCategoria") int idCategoria) {
		if(categoriaService.getCategoriaById(idCategoria) == null) {
			return ResponseEntity.ok(1);
		}
		categoriaService.deleteCategoriaById(idCategoria);
		return ResponseEntity.ok(0);
	}
	
	@PostMapping
	public ResponseEntity<Integer> addCategoria(@RequestBody CategoriaDTO categoriaDTO) {
		System.out.println(categoriaDTO);
		CategoriaDTO  categoria = categoriaService.getCategoriaById(categoriaDTO.getIdCategoria());
		if(categoria == null) {
			
			categoriaService.updateCategoria(categoriaDTO);;
			return ResponseEntity.ok(0);
		} else {
			return ResponseEntity.ok(1);
		}
	}
	
	@PutMapping
	public ResponseEntity<Integer> updateCategoria(@RequestBody CategoriaDTO categoriaDTO) {
		CategoriaDTO categoria = categoriaService.getCategoriaById(categoriaDTO.getIdCategoria());
		if(categoria != null) {
			categoriaService.updateCategoria(categoriaDTO);;
			return ResponseEntity.ok(0);
		} else {
			return ResponseEntity.ok(1);
		}
	}
}
