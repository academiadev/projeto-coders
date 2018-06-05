package br.com.academiadev.projetocoders.reembolsocoders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiadev.projetocoders.reembolsocoders.converter.EmpresaConverter;
import br.com.academiadev.projetocoders.reembolsocoders.dto.EmpresaDTO;
import br.com.academiadev.projetocoders.reembolsocoders.exception.EmpresaExistenteException;
import br.com.academiadev.projetocoders.reembolsocoders.model.Empresa;
import br.com.academiadev.projetocoders.reembolsocoders.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private EmpresaConverter empresaConverter;

	public Empresa Cadastrar(EmpresaDTO empresaDTO) throws EmpresaExistenteException {
		if (empresaRepository.findByNome(empresaDTO.getNome()) != null) {
			throw new EmpresaExistenteException();
		}

		Empresa empresa = empresaConverter.toEntity(empresaDTO);
		empresa.setCodigo(generateCode());
		empresaRepository.save(empresa);
		return empresa;
	}

	private Integer generateCode() {
		Integer codigo = empresaRepository.findMaxCodigo();
		if (codigo != null) {
			return codigo + 5;
		} else {
			return 5;
		}
	}
}
