package br.com.academiadev.projetocoders.reembolsocoders.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.academiadev.projetocoders.reembolsocoders.exception.ReembolsoNaoAguardandoException;
import br.com.academiadev.projetocoders.reembolsocoders.exception.ReembolsoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
		String message = reembolsoService.salvarArquivo(file);
		Map<String, String> result = new HashMap<>();
        result.put("path", message);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@GetMapping("/downloadArquivo")
	public ResponseEntity<?> getFile(@RequestParam String fileName) {
		Resource file = reembolsoService.downloadArquivo(fileName);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	@PostMapping("/cadastrarReembolso")
	public void cadastrarReembolso(@RequestBody ReembolsoDTO reembolsoDTO) {
		reembolsoService.Cadastrar(reembolsoDTO);
	}

	@PostMapping("/alterarStatusReembolso")
	public void alterarStatusReembolso(@RequestParam Long reembolsoId, @RequestParam String status) throws ReembolsoNaoEncontradoException, ReembolsoNaoAguardandoException {
		reembolsoService.AlterarStatus(reembolsoId, status);
	}

	@GetMapping("/listaReembolsosUsuario")
	public List<ReembolsoDTO> listaReembolsosUsuario(@RequestParam Long usuarioId){
		List<ReembolsoDTO> listReembolsoDTO = reembolsoService.ListaReembolsosUsuario(usuarioId);
		return listReembolsoDTO;
	}

	@GetMapping("/listaReembolsosEmpresa")
	public List<ReembolsoDTO> listaReembolsoEmpresa(@RequestParam Long empresaId) {
		List<ReembolsoDTO> listReembolso = reembolsoService.ListaReembolsosEmpresa(empresaId);
		return listReembolso;
	}

	@PostMapping("/listaReembolsosCategoria")
	public List<ReembolsoDTO> listaReembolsosCategoria(@RequestParam String categoria) {
		List<ReembolsoDTO> listReembolsoDTO = reembolsoService.ListaReembolsosCategoria(categoria);
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
