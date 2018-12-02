package br.com.tokiomarine.provatokio.controller.dto;


import javax.validation.constraints.NotBlank;

import br.com.tokiomarine.provatokio.enums.TipoRisco;
import br.com.tokiomarine.provatokio.model.Risco;

public class RiscoDto {
	@NotBlank
	private String descricao;
	
	public RiscoDto() {
		super();
	}
	public RiscoDto(@NotBlank String descricao) {
		this.descricao = descricao;
	}
	public RiscoDto(Risco risco) {
		this.descricao = risco.getDescricao().getLabel();	
	}
	
	public Risco build() {
		return new Risco(  TipoRisco.valueOf(this.descricao) );
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
