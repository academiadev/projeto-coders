package br.com.academiadev.projetocoders.backend.model;

import javax.persistence.*;
import java.time.LocalDate;


@Table(name = "reembolso")
@Entity
public class Reembolso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String descricao;

    @Column
    private String categoria;

    @Column
    private LocalDate dataEnviado;

    @Column
    private LocalDate dataRespondido;

    @Column
    private Statusreembolso status;

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
