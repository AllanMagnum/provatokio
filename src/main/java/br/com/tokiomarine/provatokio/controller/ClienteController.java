package br.com.tokiomarine.provatokio.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.tokiomarine.provatokio.controller.dto.ClienteDto;
import br.com.tokiomarine.provatokio.model.Cliente;
import br.com.tokiomarine.provatokio.service.ClienteService;

@RestController
public class ClienteController {

	private ClienteService clienteService;

	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping(value="/api/clientes", produces=MediaType.APPLICATION_JSON_VALUE)
	public Page<ClienteDto> list(@PageableDefault(sort="nome", direction=Sort.Direction.DESC) Pageable pageRequest){		
	
		Page<Cliente> clientes = this.clienteService.findAll(pageRequest);
		
		return ClienteDto.listFromClientes(clientes);
	}
	
	@PostMapping(value="/api/cliente/save",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@Valid @RequestBody ClienteDto clienteDto, UriComponentsBuilder uriBuilder){
		
		Optional<Cliente> cliente = clienteDto.build();
		
		clienteService.save(cliente.get());
		
		URI path = uriBuilder.path("/api/clintes/{id}").buildAndExpand(cliente.get().getIdCliente()).toUri();	
		
		return cliente.map(t -> ResponseEntity.created(path).body(new ClienteDto(t))).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(value="/api/cliente/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable("idCliente") Long idCliente){
		
		Optional<Cliente> cliente = clienteService.findById(idCliente);
		
		return cliente.map(t -> ResponseEntity.ok(new ClienteDto(t))).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(value="/api/cliente/delete/{idCliente}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteById(@PathVariable("idCliente") Long idCliente){
		
		this.clienteService.deleteById(idCliente);
		
		return ResponseEntity.ok("Registro de cliente excluído");
	}
	
}
