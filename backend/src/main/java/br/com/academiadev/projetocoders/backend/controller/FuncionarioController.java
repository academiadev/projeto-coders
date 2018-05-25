package br.com.academiadev.projetocoders.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.academiadev.projetocoders.backend.dto.FuncionarioDTO;
import br.com.academiadev.projetocoders.backend.service.FuncionarioService;

@RestController
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@PostMapping("/cadastrarFuncionario")
	public void cadastrarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO,@RequestParam Long codigoEmpresa) {
		funcionarioService.CadastrarFuncionario(funcionarioDTO, codigoEmpresa);
	}
}
