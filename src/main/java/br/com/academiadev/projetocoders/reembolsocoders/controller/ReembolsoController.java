package br.com.academiadev.projetocoders.reembolsocoders.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.academiadev.projetocoders.reembolsocoders.exception.ApiAlertException;
import br.com.academiadev.projetocoders.reembolsocoders.exception.ListaReembolsosCategoriaException;
import br.com.academiadev.projetocoders.reembolsocoders.exception.ListaReembolsosEmpresaException;
import br.com.academiadev.projetocoders.reembolsocoders.exception.ListaReembolsosUsuarioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/listaReembolsosUsuario")
	public List<ReembolsoDTO> listaReembolsosUsuario(@RequestParam Long usuarioId) throws ListaReembolsosUsuarioException{
		List<ReembolsoDTO> listReembolsoDTO = reembolsoService.ListaReembolsosUsuario(usuarioId);
		return listReembolsoDTO;
	}

	@GetMapping("/listaReembolsosEmpresa")
	public List<ReembolsoDTO> listaReembolsoEmpresa(@RequestParam Long empresaId) throws ListaReembolsosEmpresaException {
		List<ReembolsoDTO> listReembolso = reembolsoService.ListaReembolsosEmpresa(empresaId);
		return listReembolso;
	}

	@PostMapping("/listaReembolsosCategoria")
	public List<ReembolsoDTO> listaReembolsosCategoria(@RequestParam String categoria) throws ListaReembolsosCategoriaException {
		List<ReembolsoDTO> listReembolsoDTO = new ArrayList<>();
		return listReembolsoDTO;
	}
	
	@PostMapping("/editarReembolso")
	public void editarReembolso(@RequestBody ReembolsoDTO reembolsoDTO) {
		reembolsoService.EditarReembolso(reembolsoDTO);
	}
	
	@PostMapping("/excluirReembolso")
	public void excluirReembolso(@RequestParam Long reembolsoId) {
		reembolsoService.ExcluirReembolso(reembolsoId);
	}

}
