package br.com.tokiomarine.provatokio.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.tokiomarine.provatokio.enums.TipoRisco;

@Entity
@Table(name="RISCO")
public class Risco {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_RISCO")
	private Long idRisco;
	
	@Enumerated(EnumType.STRING)
	@Column(name="DESCRICAO")
	private TipoRisco descricao;
	
	@Column(name="TAXA_JUROS")
	private BigDecimal taxaJuros;
	
	public Risco() {
		super();
	}
	
	public Risco(TipoRisco descricao) {
		this.descricao = descricao;
		
		if("A".equals(descricao.name()))
			this.taxaJuros = new BigDecimal(0);
		else if("B".equals(descricao.name()))
			this.taxaJuros = new BigDecimal(10);
		else
			this.taxaJuros = new BigDecimal(20);
	}
	
	public Long getIdRisco() {
		return idRisco;
	}
	public void setIdRisco(Long idRisco) {
		this.idRisco = idRisco;
	}
	public TipoRisco getDescricao() {
		return descricao;
	}
	public void setDescricao(TipoRisco descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getTaxaJuros() {
		return taxaJuros;
	}
	public void setTaxaJuros(BigDecimal taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
}
