package br.com.academiadev.projetocoders.backend.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.academiadev.projetocoders.backend.dto.FuncionarioDTO;
import br.com.academiadev.projetocoders.backend.model.Funcionario;

@Component
public class FuncionarioConverter implements Converter<Funcionario, FuncionarioDTO> {
	
	@Autowired
	private EmpresaConverter empresaConverter;

	@Override
	public FuncionarioDTO toDTO(Funcionario entity) {
		FuncionarioDTO dto = new FuncionarioDTO();
		dto.setEmail(entity.getEmail());
		dto.setNome(entity.getNome());
		dto.setSenha(entity.getSenha());
		dto.setEmpresa(empresaConverter.toDTO(entity.getEmpresa()));
		return dto;
	}

	@Override
	public Funcionario toEntity(FuncionarioDTO dto) {
		Funcionario funcionario = new Funcionario();
		funcionario.setEmail(dto.getEmail());
		funcionario.setNome(dto.getNome());
		funcionario.setSenha(dto.getSenha());
		funcionario.setEmpresa(empresaConverter.toEntity(dto.getEmpresa()));
		return funcionario;
	}

}
