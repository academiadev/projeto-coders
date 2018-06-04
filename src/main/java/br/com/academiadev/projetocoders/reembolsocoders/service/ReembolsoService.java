package br.com.academiadev.projetocoders.reembolsocoders.service;

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

		Usuario funcionario = funcionarioRepository.findOne(reembolsoDTO.getIdFuncionario());
		reembolso.setFuncionario(funcionario);

		reembolso = reembolsoRepository.save(reembolso);
		return reembolso;
	}

	public void AlterarStatus(Long reembolsoId, String status) {
		Reembolso reembolso = reembolsoRepository.findOne(reembolsoId);
		if (reembolso.getStatus() == StatusReembolso.AGUARDANDO) {
			reembolso.setStatus(StatusReembolso.valueOf(status));
			reembolsoRepository.save(reembolso);
		}
	}

	public List<ReembolsoDTO> ListaReembolsosUsuario(Long usuarioId) {
		List<Reembolso> listReembolso = reembolsoRepository.findByUsuarioId(usuarioId);
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
		List<Reembolso> listReembolso = reembolsoRepository.findByCategoria(categoria);
		List<ReembolsoDTO> listReembolsoDTO = new ArrayList<>();

		for (Reembolso reembolso : listReembolso) {
			listReembolsoDTO.add(reembolsoConverter.toDTO(reembolso));
		}

		return listReembolsoDTO;
	}

}
