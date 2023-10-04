package com.example.microanuncios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microanuncios.dto.AnuncioDTO;
import com.example.microanuncios.interfaces.IAnuncioService;

@RestController
@RequestMapping("api/anuncios")
public class MiControlador {
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
}
