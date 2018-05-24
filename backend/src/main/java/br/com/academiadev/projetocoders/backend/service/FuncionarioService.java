package br.com.academiadev.projetocoders.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiadev.projetocoders.backend.converter.FuncionarioConverter;
import br.com.academiadev.projetocoders.backend.dto.EmpresaDTO;
import br.com.academiadev.projetocoders.backend.dto.FuncionarioDTO;
import br.com.academiadev.projetocoders.backend.model.Empresa;
import br.com.academiadev.projetocoders.backend.model.Funcionario;
import br.com.academiadev.projetocoders.backend.repository.EmpresaRepository;
import br.com.academiadev.projetocoders.backend.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncionarioConverter funcionarioConverter;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public void CadastrarFuncionario(FuncionarioDTO funcionarioDTO, Long codigoEmpresa) {
		Funcionario funcionario = funcionarioConverter.toEntity(funcionarioDTO);
		Empresa empresa = empresaRepository.findByCodigo(codigoEmpresa);
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
