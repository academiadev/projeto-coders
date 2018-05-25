package br.com.academiadev.projetocoders.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiadev.projetocoders.backend.converter.ReembolsoConverter;
import br.com.academiadev.projetocoders.backend.dto.FuncionarioDTO;
import br.com.academiadev.projetocoders.backend.dto.ReembolsoDTO;
import br.com.academiadev.projetocoders.backend.dto.StatusDTO;
import br.com.academiadev.projetocoders.backend.model.Funcionario;
import br.com.academiadev.projetocoders.backend.model.Reembolso;
import br.com.academiadev.projetocoders.backend.repository.FuncionarioRepository;
import br.com.academiadev.projetocoders.backend.repository.ReembolsoRepository;

@Service
public class ReembolsoService {
	
	@Autowired
	private ReembolsoConverter reembolsoConverter;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private ReembolsoRepository reembolsoRepository;

	public void CadastrarReembolso(ReembolsoDTO reembolsoDTO, String nomeFuncionario) {
		Reembolso reembolso = reembolsoConverter.toEntity(reembolsoDTO);
		
		Funcionario funcionario = funcionarioRepository.findByNome(nomeFuncionario);
		reembolso.setFuncionario(funcionario);
		
		reembolsoRepository.save(reembolso);
	}
	
	public ReembolsoDTO CriarReembolsoDTO(FuncionarioDTO funcionarioDTO) {
		ReembolsoDTO reembolsoDTO = new ReembolsoDTO();
		reembolsoDTO.setArquivoPath("C:\\path");
		reembolsoDTO.setCategoria("Alimentação");
		reembolsoDTO.setData("23/04/2018 15:50");
		reembolsoDTO.setDescricao("Almoço");
		reembolsoDTO.setFuncionario(funcionarioDTO);
		
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatus("AGUARDANDO");
		reembolsoDTO.setStatus(statusDTO);
		
		return reembolsoDTO;
	}

}
