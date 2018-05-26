package br.com.academiadev.projetocoders.reembolsocoders.dto;

public class ReembolsoDTO {

	private Long id;

	private String descricao;

	private String categoria;

	private String data;

	private StatusDTO status;

	private Long idFuncionario;

	private String arquivoPath;

	private String valor;
	
	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long id_funcionario) {
		this.idFuncionario = id_funcionario;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public StatusDTO getStatus() {
		return status;
	}

	public void setStatus(StatusDTO status) {
		this.status = status;
	}

	public String getArquivoPath() {
		return arquivoPath;
	}

	public void setArquivoPath(String arquivoPath) {
		this.arquivoPath = arquivoPath;
	}

}
