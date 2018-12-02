package br.com.tokiomarine.provatokio.enums;

public enum TipoRisco {
	A("A"), B("B"), C("C");
	
	private String label;
    
    private TipoRisco(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}    
}
