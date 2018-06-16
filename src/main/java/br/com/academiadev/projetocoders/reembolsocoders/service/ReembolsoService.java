package br.com.academiadev.projetocoders.reembolsocoders.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiadev.projetocoders.reembolsocoders.converter.ReembolsoConverter;
import br.com.academiadev.projetocoders.reembolsocoders.dto.EmpresaDTO;
import br.com.academiadev.projetocoders.reembolsocoders.dto.ReembolsoDTO;
import br.com.academiadev.projetocoders.reembolsocoders.model.Reembolso;
import br.com.academiadev.projetocoders.reembolsocoders.model.StatusReembolso;
import br.com.academiadev.projetocoders.reembolsocoders.model.Usuario;
import br.com.academiadev.projetocoders.reembolsocoders.repository.ReembolsoRepository;
import br.com.academiadev.projetocoders.reembolsocoders.repository.UsuarioRepository;

@Service
public class ReembolsoService {

	@Autowired
	private ReembolsoConverter reembolsoConverter;

	@Autowired
	private UsuarioRepository funcionarioRepository;

	@Autowired
	private ReembolsoRepository reembolsoRepository;

	public Reembolso Cadastrar(ReembolsoDTO reembolsoDTO) {
		Reembolso reembolso = reembolsoConverter.toEntity(reembolsoDTO);
		reembolso.setStatus(StatusReembolso.AGUARDANDO);
		reembolso.setExcluido(false);

		Usuario usuario = funcionarioRepository.findOne(reembolsoDTO.getIdUsuario());
		reembolso.setUsuario(usuario);

		reembolso = reembolsoRepository.save(reembolso);
		return reembolso;
	}

	public void AlterarStatus(Long reembolsoId, String status) {
		Reembolso reembolso = reembolsoRepository.findOne(reembolsoId);
		if (reembolso != null && reembolso.getStatus() == StatusReembolso.AGUARDANDO) {
			reembolso.setStatus(StatusReembolso.valueOf(status));
			reembolso.setDataRespondido(LocalDate.now());
			reembolsoRepository.save(reembolso);
		}
	}

	public List<ReembolsoDTO> ListaReembolsosUsuario(Long usuarioId) {
		List<Reembolso> listReembolso = reembolsoRepository.findByUsuarioIdAndExcluido(usuarioId, false);
		List<ReembolsoDTO> listReembolsoDTO = new ArrayList<>();

		for (Reembolso reembolso : listReembolso) {
			listReembolsoDTO.add(reembolsoConverter.toDTO(reembolso));
		}

		return listReembolsoDTO;
	}

	public List<ReembolsoDTO> ListaReembolsosEmpresa(EmpresaDTO empresaDTO) {
//		List<Reembolso> listReembolso = reembolsoRepository.findAllPorEmpresa(empresaDTO.getCodigo());
		List<Reembolso> listReembolso = new ArrayList<>();
		List<ReembolsoDTO> listReembolsoDTO = new ArrayList<>();

		for (Reembolso reembolso : listReembolso) {
			listReembolsoDTO.add(reembolsoConverter.toDTO(reembolso));
		}

		return listReembolsoDTO;
	}

	public List<ReembolsoDTO> ListaReembolsosCategoria(String categoria) {
		List<Reembolso> listReembolso = reembolsoRepository.findByCategoriaAndExcluido(categoria, true);
		List<ReembolsoDTO> listReembolsoDTO = new ArrayList<>();

		for (Reembolso reembolso : listReembolso) {
			listReembolsoDTO.add(reembolsoConverter.toDTO(reembolso));
		}

		return listReembolsoDTO;
	}
	
	public void EditarReembolso(ReembolsoDTO reembolsoDTO) {
		Reembolso reembolso = reembolsoRepository.findOne(reembolsoDTO.getId());
		if(reembolso != null) {
			reembolso = reembolsoConverter.toEntity(reembolsoDTO);
			reembolsoRepository.save(reembolso);
		}
	}
	
	public void ExcluirReembolso(Long reembolsoId) {
		Reembolso reembolso = reembolsoRepository.findOne(reembolsoId);
		if (reembolso != null && reembolso.getExcluido() == false) {
			reembolso.setExcluido(true);
			reembolsoRepository.save(reembolso);
		}
	}

}
