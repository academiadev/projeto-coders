package br.com.academiadev.projetocoders.reembolsocoders.service;

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
		
//		Empresa empresa = empresaRepository.findByCodigo(codigoEmpresa);
		Empresa empresa = empresaRepository.findOne(funcionarioDTO.getIdEmpresa());
		if(empresa == null) {
			throw new EmpresaNaoEncontradaException();
		}
		funcionario.setEmpresa(empresa);
		
		funcionarioRepository.save(funcionario);
	}

}
