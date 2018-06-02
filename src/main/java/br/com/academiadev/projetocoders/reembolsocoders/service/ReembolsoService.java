package br.com.academiadev.projetocoders.reembolsocoders.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiadev.projetocoders.reembolsocoders.converter.ReembolsoConverter;
import br.com.academiadev.projetocoders.reembolsocoders.dto.ReembolsoDTO;
import br.com.academiadev.projetocoders.reembolsocoders.model.Funcionario;
import br.com.academiadev.projetocoders.reembolsocoders.model.Reembolso;
import br.com.academiadev.projetocoders.reembolsocoders.model.StatusReembolso;
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

	public Reembolso Cadastrar(ReembolsoDTO reembolsoDTO) {
		Reembolso reembolso = reembolsoConverter.toEntity(reembolsoDTO);
		
		Funcionario funcionario = funcionarioRepository.findOne(reembolsoDTO.getIdFuncionario());
		reembolso.setFuncionario(funcionario);
		
		reembolso = reembolsoRepository.save(reembolso);
		return reembolso;
	}
	
	public void AlterarStatus(Long reembolsoId, String status) {
		Reembolso reembolso = reembolsoRepository.findOne(reembolsoId);
		if(reembolso.getStatus() == StatusReembolso.AGUARDANDO) {
			reembolso.setStatus(StatusReembolso.valueOf(status));
			reembolsoRepository.save(reembolso);
		}
	}
	
	public List<ReembolsoDTO> ListaReembolsosFuncionario(Long funcionarioId) {
		List<Reembolso> listReembolso = reembolsoRepository.findByFuncionarioId(funcionarioId);		
		List<ReembolsoDTO> listReembolsoDTO = new ArrayList<>();
		
		for (Reembolso reembolso : listReembolso) {
			listReembolsoDTO.add(reembolsoConverter.toDTO(reembolso));
		}
		
		return listReembolsoDTO;
	}
	
	public List<ReembolsoDTO> ListaReembolsosCategoria(String categoria) {
		List<Reembolso> listReembolso = reembolsoRepository.findByCategoria(categoria);
		List<ReembolsoDTO> listReembolsoDTO = new ArrayList<>();
		
		for (Reembolso reembolso : listReembolso) {
			listReembolsoDTO.add(reembolsoConverter.toDTO(reembolso));
		}
		
		return listReembolsoDTO;
	}

}
