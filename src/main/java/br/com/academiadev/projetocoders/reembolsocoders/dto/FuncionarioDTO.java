package br.com.academiadev.projetocoders.reembolsocoders.dto;

public class FuncionarioDTO {

	private String nome;

	private String email;

	private Long idEmpresa;

	private String senha;
	
	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long id_empresa) {
		this.idEmpresa = id_empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
