package br.com.academiadev.projetocoders.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiadev.projetocoders.backend.converter.EmpresaConverter;
import br.com.academiadev.projetocoders.backend.dto.EmpresaDTO;
import br.com.academiadev.projetocoders.backend.model.Empresa;
import br.com.academiadev.projetocoders.backend.repository.EmpresaRepository;

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
	
	public EmpresaDTO CriarEmpresaDTO() {
		EmpresaDTO empresaDTO = new EmpresaDTO();
		empresaDTO.setCodigo(1010l);
		empresaDTO.setEmail("empresa@gmail.com");
		empresaDTO.setNome("Empresa");
		empresaDTO.setSenha("123");
		
		return empresaDTO;
	}
}
