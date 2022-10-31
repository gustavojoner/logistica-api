package com.joner.logistica.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joner.logistica.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("João");
		cliente1.setEmail("joaorosa@gmail.com");
		cliente1.setTelefone("987654321");
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Maria");
		cliente2.setEmail("mariarosa@gmail.com");
		cliente2.setTelefone("987654321");
		
		return Arrays.asList(cliente1, cliente2);
	}
}
