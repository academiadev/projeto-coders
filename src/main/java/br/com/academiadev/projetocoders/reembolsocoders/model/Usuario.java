package br.com.academiadev.projetocoders.reembolsocoders.model;

import org.joda.time.DateTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "usuario")
@Entity
public class Usuario implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column
	@NotNull
	private String nome;

	@Column
	@NotNull
	private String email;

	@ManyToOne
	private Empresa empresa;

	@Column
	@NotNull
	private String senha;

	@OneToMany(mappedBy = "usuario")
	private List<Reembolso> reembolsos;

	@Column
	private LocalDate dataCadastro;

	@Column
	@NotNull
	private Boolean isAdmin;

	@Column(name = "ultima_troca_de_senha")
	private Timestamp ultimaTrocaDeSenha;

	public Timestamp getUltimaTrocaDeSenha() {
		return ultimaTrocaDeSenha;
	}

	public void setUltimaTrocaDeSenha(Timestamp ultimaTrocaDeSenha) {
		this.ultimaTrocaDeSenha = ultimaTrocaDeSenha;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Reembolso> getReembolsos() {
		return reembolsos;
	}

	public void setReembolsos(List<Reembolso> reembolsos) {
		this.reembolsos = reembolsos;
	}

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

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void setPassword(String password) {
		Timestamp now = new Timestamp(DateTime.now().getMillis());
		this.setUltimaTrocaDeSenha(now);
		this.senha = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
