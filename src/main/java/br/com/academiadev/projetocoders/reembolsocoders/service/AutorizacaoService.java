package br.com.academiadev.projetocoders.reembolsocoders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiadev.projetocoders.reembolsocoders.model.Autorizacao;
import br.com.academiadev.projetocoders.reembolsocoders.repository.AutorizacaoRepository;

@Service
public class AutorizacaoService {
	
	@Autowired
	private AutorizacaoRepository autorizacaoRepository;

	public Autorizacao findByNome(String nome) {
		return autorizacaoRepository.findByNome(nome);
	}
	
	public Autorizacao salvaNovaAutorizacao(Autorizacao autorizacao) {
		return autorizacaoRepository.save(autorizacao);
	}

}
