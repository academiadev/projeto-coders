package br.com.academiadev.projetocoders.reembolsocoders.converter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import br.com.academiadev.projetocoders.reembolsocoders.dto.ReembolsoDTO;
import br.com.academiadev.projetocoders.reembolsocoders.model.Usuario;
import br.com.academiadev.projetocoders.reembolsocoders.model.Categoria;
import br.com.academiadev.projetocoders.reembolsocoders.model.Reembolso;

@Component
public class ReembolsoConverter implements Converter<Reembolso, ReembolsoDTO> {
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Override
	public ReembolsoDTO toDTO(Reembolso entity) {
		ReembolsoDTO dto = new ReembolsoDTO();
		dto.setArquivoPath(entity.getArquivoPath());
		dto.setCategoria(entity.getCategoria().getId());
		dto.setData(entity.getData().format(formatter));
		dto.setDescricao(entity.getDescricao());
		dto.setIdUsuario(entity.getUsuario().getId());
		dto.setStatus(entity.getStatus().getId());
		dto.setValor(entity.getValor().toString());
		dto.setId(entity.getId());
		return dto;
	}

	@Override
	public Reembolso toEntity(ReembolsoDTO dto) {
		Reembolso reembolso = new Reembolso();
		reembolso.setArquivoPath(dto.getArquivoPath());
		reembolso.setCategoria(Categoria.valueOf(dto.getCategoria()));
		
		LocalDate data = LocalDate.parse(dto.getData(), formatter);		
		reembolso.setData(data);
		
		Usuario usuario = new Usuario();
		usuario.setId(dto.getIdUsuario());
		reembolso.setUsuario(usuario);
		
		reembolso.setDataEnviado(LocalDate.now());
		reembolso.setValor(new BigDecimal(dto.getValor()));		
		reembolso.setDescricao(dto.getDescricao());
		
		return reembolso;
	}



}
