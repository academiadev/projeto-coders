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
		dto.setNome(entity.getNome());
		dto.setId(entity.getId());
		return dto;
	}

	@Override
	public Empresa toEntity(EmpresaDTO dto) {
		Empresa empresa = new Empresa();
		empresa.setCodigo(dto.getCodigo());
		empresa.setNome(dto.getNome());

		return empresa;
	}

}
