package br.com.academiadev.projetocoders.backend.converter;

import org.springframework.stereotype.Component;

import br.com.academiadev.projetocoders.backend.dto.StatusDTO;
import br.com.academiadev.projetocoders.backend.model.StatusReembolso;

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
