package br.com.academiadev.projetocoders.reembolsocoders.converter;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import br.com.academiadev.projetocoders.reembolsocoders.dto.FuncionarioDTO;
import br.com.academiadev.projetocoders.reembolsocoders.model.Empresa;
import br.com.academiadev.projetocoders.reembolsocoders.model.Funcionario;

@Component
public class FuncionarioConverter implements Converter<Funcionario, FuncionarioDTO> {

	@Override
	public FuncionarioDTO toDTO(Funcionario entity) {
		FuncionarioDTO dto = new FuncionarioDTO();
		dto.setEmail(entity.getEmail());
		dto.setNome(entity.getNome());
		dto.setSenha(entity.getSenha());
		dto.setIdEmpresa(entity.getEmpresa().getId());
		return dto;
	}

	@Override
	public Funcionario toEntity(FuncionarioDTO dto) {
		Funcionario funcionario = new Funcionario();
		funcionario.setEmail(dto.getEmail());
		funcionario.setNome(dto.getNome());
		funcionario.setSenha(dto.getSenha());
		Empresa empresa = new Empresa();
		empresa.setId(dto.getIdEmpresa());
		funcionario.setEmpresa(empresa);
		funcionario.setDataCadastro(LocalDate.now());
		return funcionario;
	}

}
