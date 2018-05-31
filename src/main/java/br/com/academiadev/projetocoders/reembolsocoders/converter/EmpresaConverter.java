package br.com.academiadev.projetocoders.reembolsocoders.converter;

import org.springframework.stereotype.Component;

import br.com.academiadev.projetocoders.reembolsocoders.dto.EmpresaDTO;
import br.com.academiadev.projetocoders.reembolsocoders.model.Empresa;

@Component
public class EmpresaConverter implements Converter<Empresa, EmpresaDTO> {

	@Override
	public EmpresaDTO toDTO(Empresa entity) {
		EmpresaDTO dto = new EmpresaDTO();
		dto.setCodigo(entity.getCodigo());
		dto.setEmail(entity.getEmail());
		dto.setNome(entity.getNome());
		dto.setSenha(entity.getSenha());

		return dto;
	}

	@Override
	public Empresa toEntity(EmpresaDTO dto) {
		Empresa empresa = new Empresa();
		empresa.setCodigo(dto.getCodigo());
		empresa.setEmail(dto.getEmail());
		empresa.setNome(dto.getNome());
		empresa.setSenha(dto.getSenha());

		return empresa;
	}

}
