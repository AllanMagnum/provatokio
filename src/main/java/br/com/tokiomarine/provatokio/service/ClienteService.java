package br.com.tokiomarine.provatokio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.provatokio.exception.ClienteNotFoundException;
import br.com.tokiomarine.provatokio.model.Cliente;
import br.com.tokiomarine.provatokio.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente save(Cliente cliente){
		
		this.clienteRepository.save(cliente);
		
		if(cliente.getIdCliente() == null)
			throw new ClienteNotFoundException("NOT FOUND");
		
		return cliente;
	}

	public Page<Cliente> findAll(Pageable pageRequest) {
		Page<Cliente> clientes = this.clienteRepository.findAll(pageRequest);
		
		if(clientes.isEmpty())
			throw new ClienteNotFoundException("NOT FOUND");
		
		return clientes;
	}

	public Optional<Cliente> findById(Long idCliente) {
		Optional<Cliente> cliente = this.clienteRepository.findById(idCliente);
		
		if(cliente.isPresent())
			return cliente;
		else
			throw new ClienteNotFoundException("NOT FOUND");
	}	 
	
	public void deleteById(Long idCliente) {
		this.findById(idCliente);
		
		this.clienteRepository.deleteById(idCliente);
	}
}
