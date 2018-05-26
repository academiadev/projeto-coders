package br.com.academiadev.projetocoders.reembolsocoders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiadev.projetocoders.reembolsocoders.converter.ReembolsoConverter;
import br.com.academiadev.projetocoders.reembolsocoders.dto.ReembolsoDTO;
import br.com.academiadev.projetocoders.reembolsocoders.model.Funcionario;
import br.com.academiadev.projetocoders.reembolsocoders.model.Reembolso;
import br.com.academiadev.projetocoders.reembolsocoders.repository.FuncionarioRepository;
import br.com.academiadev.projetocoders.reembolsocoders.repository.ReembolsoRepository;

@Service
public class ReembolsoService {
	
	@Autowired
	private ReembolsoConverter reembolsoConverter;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private ReembolsoRepository reembolsoRepository;

	public void Cadastrar(ReembolsoDTO reembolsoDTO, String nomeFuncionario) {
		Reembolso reembolso = reembolsoConverter.toEntity(reembolsoDTO);
		
		Funcionario funcionario = funcionarioRepository.findByNome(nomeFuncionario);
		reembolso.setFuncionario(funcionario);
		
		reembolsoRepository.save(reembolso);
	}

}
