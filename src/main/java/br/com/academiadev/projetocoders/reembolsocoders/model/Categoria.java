package br.com.academiadev.projetocoders.reembolsocoders.model;

public enum Categoria {
	
	HOSPEDAGEM("HOSPEDAGEM", "Hospedagem"), ALIMENTACAO("ALIMENTACAO", "Alimentação"), TRANSPORTE("TRANSPORTE", "Transporte"),
	OUTROS("OUTROS", "Outros");

	private String id;
	private String descricao;

	private Categoria(String id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
