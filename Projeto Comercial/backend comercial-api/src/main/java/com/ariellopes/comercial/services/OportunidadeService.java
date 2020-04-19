package com.ariellopes.comercial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ariellopes.comercial.model.Oportunidade;
import com.ariellopes.comercial.repositories.OportunidadeRepository;

@Service
public class OportunidadeService {
	
	@Autowired
	OportunidadeRepository oportunidades;
	
	
	public List<Oportunidade> buscarTodos(){
		return oportunidades.findAll();
	}

	public Oportunidade buscarPorId(Long id) {
		Optional<Oportunidade> obj = oportunidades.findById(id);
		return obj.orElse(null);
	}
	
	public Oportunidade insertOportunidade(Oportunidade oportunidade) {
		return oportunidades.save(oportunidade);
	}
	
	
}
