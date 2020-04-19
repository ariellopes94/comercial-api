package com.ariellopes.comercial.rest;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ariellopes.comercial.model.Oportunidade;

@RestController
@RequestMapping("/oportunidades")
public class Oportunidades {

	@GetMapping
	public List<Oportunidade> list() {
		
		Oportunidade oportunidade = new Oportunidade();
		oportunidade.setId(1L);
        oportunidade.setNomeProspecto("Angular e java");
        oportunidade.setDescricao("atuar como porgramador ");
        oportunidade.setValor(new BigDecimal(400_000L));
        
	return Arrays.asList(oportunidade);
	}
}
