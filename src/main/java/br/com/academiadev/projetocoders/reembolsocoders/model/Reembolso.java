package br.com.academiadev.projetocoders.reembolsocoders.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "reembolso")
@Entity
public class Reembolso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column
	@NotNull
	private String descricao;

	@Enumerated(EnumType.ORDINAL)
	@Column
	@NotNull
	private Categoria categoria;

	@Column
	@NotNull
	private LocalDate data;

	@Column
	@NotNull
	private LocalDate dataEnviado;

	@Column
	private LocalDate dataRespondido;

	@Column
	@NotNull
	private BigDecimal valor;

	@Enumerated(EnumType.ORDINAL)
	@Column
	@NotNull
	private StatusReembolso status;

	@ManyToOne
	private Usuario usuario;

	@Column
	@NotNull
	private String arquivoPath;
	
	@Column
	@NotNull
	private Boolean excluido;

	public Boolean getExcluido() {
		return excluido;
	}

	public void setExcluido(Boolean excluido) {
		this.excluido = excluido;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getArquivoPath() {
		return arquivoPath;
	}

	public void setArquivoPath(String arquivoPath) {
		this.arquivoPath = arquivoPath;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario funcionario) {
		this.usuario = funcionario;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public LocalDate getDataEnviado() {
		return dataEnviado;
	}

	public void setDataEnviado(LocalDate dataEnviado) {
		this.dataEnviado = dataEnviado;
	}

	public LocalDate getDataRespondido() {
		return dataRespondido;
	}

	public void setDataRespondido(LocalDate dataRespondido) {
		this.dataRespondido = dataRespondido;
	}

	public StatusReembolso getStatus() {
		return status;
	}

	public void setStatus(StatusReembolso status) {
		this.status = status;
	}
}
