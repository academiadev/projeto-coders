package br.com.academiadev.projetocoders.reembolsocoders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.academiadev.projetocoders.reembolsocoders.dto.FuncionarioDTO;
import br.com.academiadev.projetocoders.reembolsocoders.exception.EmpresaNaoEncontradaException;
import br.com.academiadev.projetocoders.reembolsocoders.service.FuncionarioService;

@RestController
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@PostMapping("/cadastrarFuncionario")
	public void cadastrarFuncionario(
			@RequestBody FuncionarioDTO funcionarioDTO,
			@RequestParam Long codigoEmpresa
		) throws EmpresaNaoEncontradaException {
		funcionarioService.Cadastrar(funcionarioDTO, codigoEmpresa);
	}
}
