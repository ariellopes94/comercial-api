package com.ariellopes.comercial.rest;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ariellopes.comercial.model.Oportunidade;
import com.ariellopes.comercial.repositories.OportunidadeRepository;
import com.ariellopes.comercial.services.OportunidadeService;

@CrossOrigin
@RestController
@RequestMapping("/oportunidades")
public class Oportunidades {
	
	@Autowired
	OportunidadeRepository  oportunidadeRepository;
	
@Autowired
OportunidadeService oportunidadeService;

	@GetMapping
	public List<Oportunidade> list() {
		return oportunidadeService.buscarTodos();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Oportunidade> buscarPorId(@PathVariable Long id) {
	        Oportunidade obj = oportunidadeService.buscarPorId(id);
	        
	        if(obj ==null) {
	        	return ResponseEntity.badRequest().build();
	        }
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Oportunidade adicionar(@Valid @RequestBody Oportunidade oportunidade) {
		
		Optional<Oportunidade> oportunidadesExistente = oportunidadeRepository.
				findByDescricaoAndNomeProspecto(oportunidade.getDescricao(), oportunidade.getNomeProspecto());
		
		if(oportunidadesExistente.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Já existe uma oportunidade para esse prospecto com a mesma descicao e nome");
		}
	      return oportunidadeService.insertOportunidade(oportunidade);
	}
}