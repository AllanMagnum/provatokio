package br.com.tokiomarine.provatokio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tokiomarine.provatokio.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
}
