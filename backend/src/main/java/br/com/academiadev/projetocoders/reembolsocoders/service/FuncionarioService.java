package br.com.academiadev.projetocoders.reembolsocoders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiadev.projetocoders.reembolsocoders.converter.FuncionarioConverter;
import br.com.academiadev.projetocoders.reembolsocoders.dto.EmpresaDTO;
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
	
	public void Cadastrar(FuncionarioDTO funcionarioDTO, Long codigoEmpresa) throws EmpresaNaoEncontradaException {
		Funcionario funcionario = funcionarioConverter.toEntity(funcionarioDTO);
		
		Empresa empresa = empresaRepository.findByCodigo(codigoEmpresa);
		if(empresa == null) {
			throw new EmpresaNaoEncontradaException();
		}
		funcionario.setEmpresa(empresa);
		
		funcionarioRepository.save(funcionario);
	}
	
	public FuncionarioDTO CriarFuncionarioDTO(EmpresaDTO empresaDTO) {
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
		funcionarioDTO.setEmpresa(empresaDTO);
		funcionarioDTO.setEmail("funcionario@gmail.com");
		funcionarioDTO.setNome("Felipe");
		funcionarioDTO.setSenha("123");
		
		return funcionarioDTO;
	}

}
