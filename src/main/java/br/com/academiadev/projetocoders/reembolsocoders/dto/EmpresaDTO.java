package br.com.academiadev.projetocoders.reembolsocoders.dto;

public class EmpresaDTO {
	
	private Long id;

	private String nome;

	private Integer codigo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}
