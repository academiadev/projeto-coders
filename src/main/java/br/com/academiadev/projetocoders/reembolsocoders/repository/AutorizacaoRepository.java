package br.com.academiadev.projetocoders.reembolsocoders.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.academiadev.projetocoders.reembolsocoders.model.Autorizacao;

public interface AutorizacaoRepository extends CrudRepository<Autorizacao, Long> {
	
	public Autorizacao findByNome(String nome);

}
