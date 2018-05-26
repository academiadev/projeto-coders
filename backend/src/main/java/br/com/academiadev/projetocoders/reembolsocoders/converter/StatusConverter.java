package br.com.academiadev.projetocoders.reembolsocoders.converter;

import org.springframework.stereotype.Component;

import br.com.academiadev.projetocoders.reembolsocoders.dto.StatusDTO;
import br.com.academiadev.projetocoders.reembolsocoders.model.StatusReembolso;

@Component
public class StatusConverter implements Converter<StatusReembolso, StatusDTO>{

	@Override
	public StatusDTO toDTO(StatusReembolso entity) {
		StatusDTO dto = new StatusDTO();
		dto.setStatus(entity.getDescricao());
		return dto;
	}

	@Override
	public StatusReembolso toEntity(StatusDTO dto) {
		return StatusReembolso.valueOf(dto.getStatus());
	}

}
