package br.com.academiadev.projetocoders.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.academiadev.projetocoders.backend.dto.EmpresaDTO;
import br.com.academiadev.projetocoders.backend.service.EmpresaService;

@RestController
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@PostMapping("/cadastrarEmpresa")
	public void cadastrarEmpresa(@RequestBody EmpresaDTO empresaDTO) {
		empresaService.CadastrarEmpresa(empresaDTO);
	}

}
