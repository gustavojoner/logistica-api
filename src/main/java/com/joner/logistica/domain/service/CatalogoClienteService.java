package com.joner.logistica.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joner.logistica.domain.exception.NegocioException;
import com.joner.logistica.domain.model.Cliente;
import com.joner.logistica.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogoClienteService {
	
	private ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if(emailEmUso) {
			throw new NegocioException("E-mail já cadastrado.");
		}
		
		return clienteRepository.save(cliente);
	}

	@Transactional
	public void excluir(Cliente cliente) {
		clienteRepository.delete(cliente); 
	}
	
	
	
}
