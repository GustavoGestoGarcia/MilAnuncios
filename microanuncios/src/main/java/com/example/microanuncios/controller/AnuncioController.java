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
import com.example.microanuncios.interfaces.IAnuncioService;

@RestController
@RequestMapping("api/anuncios")
public class AnuncioController {
	@Autowired
	IAnuncioService anuncioService;
	
	@GetMapping
	public ResponseEntity<List<AnuncioDTO>> getAnuncios() {
		if(anuncioService.getAnuncios() == null || anuncioService.getAnuncios().size() == 0) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(anuncioService.getAnuncios());
	}
	
	@GetMapping("/{idAnuncio}")
	public ResponseEntity<AnuncioDTO> getAnuncioById(@PathVariable("idAnuncio") int idAnuncio) {
		if(anuncioService.getAnuncioByIdAnuncio(idAnuncio) == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(anuncioService.getAnuncioByIdAnuncio(idAnuncio));
	}
	
	@DeleteMapping("/{idAnuncio}")
	public ResponseEntity<Integer> deleteAnuncioById(@PathVariable("idAnuncio") int idAnuncio) {
		if(anuncioService.getAnuncioByIdAnuncio(idAnuncio) == null) {
			return ResponseEntity.ok(1);
		}
		anuncioService.deleteAnuncioByIdAnuncio(idAnuncio);
		return ResponseEntity.ok(0);
	}
	
	@PostMapping
	public ResponseEntity<Integer> addAnuncio(@RequestBody AnuncioDTO anuncioDTO) {
		AnuncioDTO anuncio = anuncioService.getAnuncioByIdAnuncio(anuncioDTO.getIdAnuncio());
		if(anuncio == null) {
			anuncioService.updateAnuncio(anuncioDTO);
			return ResponseEntity.ok(0);
		} else {
			return ResponseEntity.ok(1);
		}
	}
	
	@PutMapping
	public ResponseEntity<Integer> updateAnuncio(@RequestBody AnuncioDTO anuncioDTO) {
		AnuncioDTO anuncio = anuncioService.getAnuncioByIdAnuncio(anuncioDTO.getIdAnuncio());
		if(anuncio != null) {
			anuncioService.updateAnuncio(anuncioDTO);
			return ResponseEntity.ok(0);
		} else {
			return ResponseEntity.ok(1);
		}
	}
}
