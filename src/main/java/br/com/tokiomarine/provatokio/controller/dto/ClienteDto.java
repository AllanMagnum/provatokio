package br.com.tokiomarine.provatokio.controller.dto;

import java.math.BigDecimal;
import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;

import br.com.tokiomarine.provatokio.model.Cliente;

public class ClienteDto {
	private Long idCliente;
	@NotBlank
	private String nome;
	@NotNull
	private BigDecimal limiteCredito;
	@NotNull
	private RiscoDto riscoDto;
	
	public ClienteDto(Long idCliente, @NotBlank String nome, @NotNull BigDecimal limiteCredito,
			@NotNull RiscoDto riscoDto) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.limiteCredito = limiteCredito;
		this.riscoDto = riscoDto;
	}

	public ClienteDto(Cliente cliente) {
		this.idCliente = cliente.getIdCliente();
		this.nome = cliente.getNome();
		this.limiteCredito = cliente.getLimiteCredito();
		this.riscoDto = new RiscoDto(cliente.getRisco());
	}

	public ClienteDto() {
		super();
	}
	
	public Optional<Cliente> build() {
		return Optional.ofNullable(new Cliente(this.nome, this.limiteCredito, this.riscoDto.build()));
	}
	
	public static Page<ClienteDto> listFromClientes(Page<Cliente> clientePage) {
		return clientePage.map(ClienteDto::new);
	}
	
	
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(BigDecimal limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	public RiscoDto getRiscoDto() {
		return riscoDto;
	}
	public void setRiscoDto(RiscoDto riscoDto) {
		this.riscoDto = riscoDto;
	}
	
}
