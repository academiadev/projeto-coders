package br.com.academiadev.projetocoders.reembolsocoders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiadev.projetocoders.reembolsocoders.converter.EmpresaConverter;
import br.com.academiadev.projetocoders.reembolsocoders.dto.EmpresaDTO;
import br.com.academiadev.projetocoders.reembolsocoders.model.Empresa;
import br.com.academiadev.projetocoders.reembolsocoders.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaConverter empresaConverter;
	
	public void Cadastrar(EmpresaDTO empresaDTO) {
		Empresa empresa = empresaConverter.toEntity(empresaDTO);		
		empresaRepository.save(empresa);
	}

}
