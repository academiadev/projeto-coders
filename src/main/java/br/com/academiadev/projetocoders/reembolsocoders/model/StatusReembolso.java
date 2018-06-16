package br.com.academiadev.projetocoders.reembolsocoders.model;

public enum StatusReembolso {
	AGUARDANDO("AGUARDANDO", "waiting"), APROVADO("APROVADO", "approved"), RECUSADO("RECUSADO", "canceled");

	private String id;
	private String descricao;

	private StatusReembolso(String id, String descricao) {
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
