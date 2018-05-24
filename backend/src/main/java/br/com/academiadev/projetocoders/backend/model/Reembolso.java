package br.com.academiadev.projetocoders.backend.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    @Column
    @NotNull
    private String categoria;

    @Column
    @NotNull
    private LocalDate dataEnviado;

    @Column
    private LocalDate dataRespondido;

    @Column
    @NotNull
    private Statusreembolso status;
    
    @OneToMany(mappedBy = "reembolso")
    private Funcionario funcionario;
    
    @Column
    private String arquivoPath;
    
    public String getArquivoPath() {
		return arquivoPath;
	}

	public void setArquivoPath(String arquivoPath) {
		this.arquivoPath = arquivoPath;
	}
    
    public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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

    public Statusreembolso getStatus() {
        return status;
    }

    public void setStatus(Statusreembolso status) {
        this.status = status;
    }
}
