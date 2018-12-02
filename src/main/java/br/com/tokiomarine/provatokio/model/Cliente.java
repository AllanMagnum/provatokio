package br.com.tokiomarine.provatokio.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CLIENTE")
	private Long idCliente;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="LIMITE_CREDITO")
	private BigDecimal limiteCredito;
	
	@ManyToOne
	@JoinColumn(name="ID_RISCO", referencedColumnName="ID_RISCO")
	private Risco risco;
	
	public Cliente() {
		super();
	}

	public Cliente(String nome, BigDecimal limiteCredito, Risco risco) {
		this.nome = nome;
		this.limiteCredito = limiteCredito;
		this.risco = risco;
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
	public Risco getRisco() {
		return risco;
	}
	public void setRisco(Risco risco) {
		this.risco = risco;
	}	
}
