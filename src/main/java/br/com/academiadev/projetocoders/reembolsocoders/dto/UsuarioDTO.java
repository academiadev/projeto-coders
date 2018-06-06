package br.com.academiadev.projetocoders.reembolsocoders.dto;

public class UsuarioDTO {

	private Long id;

	private String nome;

	private String email;

	private Long idEmpresa;

	private String senha;
	
	private Boolean isAdmin;
	
	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

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
