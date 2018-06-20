package br.com.academiadev.projetocoders.reembolsocoders.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.academiadev.projetocoders.reembolsocoders.dto.ReembolsoDTO;
import br.com.academiadev.projetocoders.reembolsocoders.exception.ApiAlertException;
import br.com.academiadev.projetocoders.reembolsocoders.service.ReembolsoService;

@RestController
public class ReembolsoController {

	@Autowired
	private ReembolsoService reembolsoService;
	
	@PostMapping("/salvarArquivo")
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
		String message = "";
		reembolsoService.salvarArquivo(file);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}

	@PostMapping("/cadastrarReembolso")
	public void cadastrarReembolso(@RequestBody ReembolsoDTO reembolsoDTO) {
		reembolsoService.Cadastrar(reembolsoDTO);
	}

	@PostMapping("/alterarStatusReembolso")
	public void alterarStatusReembolso(@RequestParam Long reembolsoId, @RequestParam String status) {
		reembolsoService.AlterarStatus(reembolsoId, status);
	}

	@GetMapping("/listaReembolsosUsuario")
	public List<ReembolsoDTO> listaReembolsosUsuario(@RequestParam Long usuarioId) throws ApiAlertException {
		List<ReembolsoDTO> listReembolsoDTO = reembolsoService.ListaReembolsosUsuario(usuarioId);
		return listReembolsoDTO;
	}

	@GetMapping("/listaReembolsosEmpresa")
	public List<ReembolsoDTO> listaReembolsoEmpresa(@RequestParam Long empresaId) throws ApiAlertException {
		List<ReembolsoDTO> listReembolso = reembolsoService.ListaReembolsosEmpresa(empresaId);
		return listReembolso;
	}

	@PostMapping("/listaReembolsosCategoria")
	public List<ReembolsoDTO> listaReembolsosCategoria(@RequestParam String categoria) throws ApiAlertException {
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
