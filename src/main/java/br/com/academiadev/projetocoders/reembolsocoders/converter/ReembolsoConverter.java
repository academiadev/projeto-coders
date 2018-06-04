package br.com.academiadev.projetocoders.reembolsocoders.converter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import br.com.academiadev.projetocoders.reembolsocoders.dto.ReembolsoDTO;
import br.com.academiadev.projetocoders.reembolsocoders.model.Usuario;
import br.com.academiadev.projetocoders.reembolsocoders.model.Reembolso;

@Component
public class ReembolsoConverter implements Converter<Reembolso, ReembolsoDTO> {

	@Override
	public ReembolsoDTO toDTO(Reembolso entity) {
		ReembolsoDTO dto = new ReembolsoDTO();
		dto.setArquivoPath(entity.getArquivoPath());
		dto.setCategoria(entity.getCategoria());
		dto.setData(entity.getData().toString());
		dto.setDescricao(entity.getDescricao());
		dto.setIdFuncionario(entity.getFuncionario().getId());
		dto.setStatus(entity.getStatus().getId());
		dto.setValor(entity.getValor().toString());
		return dto;
	}

	@Override
	public Reembolso toEntity(ReembolsoDTO dto) {
		Reembolso reembolso = new Reembolso();
		reembolso.setArquivoPath(dto.getArquivoPath());
		reembolso.setCategoria(dto.getCategoria());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(dto.getData(), formatter);		
		reembolso.setData(data);
		
		Usuario funcionario = new Usuario();
		funcionario.setId(dto.getIdFuncionario());
		reembolso.setFuncionario(funcionario);
		
		reembolso.setDataEnviado(LocalDate.now());
		reembolso.setValor(new BigDecimal(dto.getValor()));		
		reembolso.setDescricao(dto.getDescricao());
		
		return reembolso;
	}



}
