package com.ariellopes.comercial.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oportunidades")
public class Oportunidades {

	@GetMapping
	public String list() {
		return "Hello Word";
	}
}
