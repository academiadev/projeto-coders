package br.com.academiadev.projetocoders.reembolsocoders.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiadev.projetocoders.reembolsocoders.converter.FuncionarioConverter;
import br.com.academiadev.projetocoders.reembolsocoders.dto.FuncionarioDTO;
import br.com.academiadev.projetocoders.reembolsocoders.exception.EmpresaNaoEncontradaException;
import br.com.academiadev.projetocoders.reembolsocoders.model.Empresa;
import br.com.academiadev.projetocoders.reembolsocoders.model.Funcionario;
import br.com.academiadev.projetocoders.reembolsocoders.repository.EmpresaRepository;
import br.com.academiadev.projetocoders.reembolsocoders.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncionarioConverter funcionarioConverter;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public void Cadastrar(FuncionarioDTO funcionarioDTO) throws EmpresaNaoEncontradaException {
		Funcionario funcionario = funcionarioConverter.toEntity(funcionarioDTO);

		Empresa empresa = empresaRepository.findOne(funcionarioDTO.getIdEmpresa());
		if(empresa == null) {
			throw new EmpresaNaoEncontradaException();
		}
		funcionario.setEmpresa(empresa);
		
		funcionarioRepository.save(funcionario);
	}
	
	public List<FuncionarioDTO> ListaFuncionariosEmpresa(Long empresaId) {
		List<Funcionario> listFuncionario = funcionarioRepository.findByEmpresaId(empresaId);
		List<FuncionarioDTO> listFuncionarioDTO = new ArrayList<>();
		
		for (Funcionario funcionario : listFuncionario) {
			listFuncionarioDTO.add(funcionarioConverter.toDTO(funcionario));
		}
		
		return listFuncionarioDTO;
	}
	
	public void EditarFuncionario(FuncionarioDTO funcionarioDTO, Long funcionarioId) {
		Funcionario funcionario = funcionarioRepository.findOne(funcionarioId);
		funcionario.setEmail(funcionarioDTO.getEmail());
		funcionario.setNome(funcionarioDTO.getNome());
		funcionarioRepository.save(funcionario);
	}

}
