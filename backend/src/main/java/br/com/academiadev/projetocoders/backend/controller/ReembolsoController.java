package br.com.academiadev.projetocoders.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.academiadev.projetocoders.backend.dto.ReembolsoDTO;
import br.com.academiadev.projetocoders.backend.service.ReembolsoService;

@RestController
public class ReembolsoController {

	@Autowired
	private ReembolsoService reembolsoService;

	@PostMapping("/cadastrarReembolso")
	public void cadastrarReembolso(@RequestBody ReembolsoDTO reembolsoDTO, @RequestParam String nomeFuncionario) {
		reembolsoService.CadastrarReembolso(reembolsoDTO, nomeFuncionario);
	}

}
