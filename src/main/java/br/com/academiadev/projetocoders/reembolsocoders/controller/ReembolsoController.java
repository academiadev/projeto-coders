package br.com.academiadev.projetocoders.reembolsocoders.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.academiadev.projetocoders.reembolsocoders.dto.EmpresaDTO;
import br.com.academiadev.projetocoders.reembolsocoders.dto.ReembolsoDTO;
import br.com.academiadev.projetocoders.reembolsocoders.service.ReembolsoService;

@RestController
public class ReembolsoController {

	@Autowired
	private ReembolsoService reembolsoService;

	@PostMapping("/cadastrarReembolso")
	public void cadastrarReembolso(@RequestBody ReembolsoDTO reembolsoDTO) {
		reembolsoService.Cadastrar(reembolsoDTO);
	}

	@PostMapping("/alterarStatusReembolso")
	public void alterarStatusReembolso(@RequestParam Long reembolsoId, @RequestParam String status) {
		reembolsoService.AlterarStatus(reembolsoId, status);
	}

	@PostMapping("/listaReembolsosUsuario")
	public List<ReembolsoDTO> listaReembolsosUsuario(@RequestParam Long usuarioId) {
		List<ReembolsoDTO> listReembolsoDTO = reembolsoService.ListaReembolsosUsuario(usuarioId);
		return listReembolsoDTO;
	}

	@PostMapping("/listaReembolsosEmpresa")
	public List<ReembolsoDTO> listaReembolsoEmpresa(@RequestBody EmpresaDTO empresaDTO) {
		List<ReembolsoDTO> listReembolso = reembolsoService.ListaReembolsosEmpresa(empresaDTO);
		return listReembolso;
	}

	@PostMapping("/listaReembolsosCategoria")
	public List<ReembolsoDTO> listaReembolsosCategoria(@RequestParam String categoria) {
		List<ReembolsoDTO> listReembolsoDTO = new ArrayList<>();
		return listReembolsoDTO;
	}

}
