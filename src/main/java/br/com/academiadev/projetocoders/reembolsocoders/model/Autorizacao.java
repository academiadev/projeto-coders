package br.com.academiadev.projetocoders.reembolsocoders.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "autorizacao")
public class Autorizacao implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	public Autorizacao(String name) {
		super();
		this.nome = name;
	}

	@Override
	public String getAuthority() {
		return nome;
	}

	@JsonIgnore
	public String getNome() {
		return nome;
	}

	@JsonIgnore
	public Long getId() {
		return id;
	}
}
