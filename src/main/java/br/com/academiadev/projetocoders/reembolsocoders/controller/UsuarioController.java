package br.com.academiadev.projetocoders.reembolsocoders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.academiadev.projetocoders.reembolsocoders.dto.EmpresaDTO;
import br.com.academiadev.projetocoders.reembolsocoders.dto.UsuarioDTO;
import br.com.academiadev.projetocoders.reembolsocoders.exception.EmpresaExistenteException;
import br.com.academiadev.projetocoders.reembolsocoders.exception.EmpresaNaoEncontradaException;
import br.com.academiadev.projetocoders.reembolsocoders.exception.UsuarioExistenteException;
import br.com.academiadev.projetocoders.reembolsocoders.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/cadastrarUsuario")
	public void cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO, @RequestBody EmpresaDTO empresaDTO)
			throws EmpresaNaoEncontradaException, EmpresaExistenteException, UsuarioExistenteException {
		usuarioService.Cadastrar(usuarioDTO, empresaDTO);
	}

	@PostMapping("/listaUsuariosEmpresa")
	public List<UsuarioDTO> listaUsuariosEmpresa(@RequestParam Long empresaId) {
		List<UsuarioDTO> listUsuario = usuarioService.ListaUsuariosEmpresa(empresaId);
		return listUsuario;
	}

	@PostMapping("/editarUsuario")
	public void editarUsuario(@RequestBody UsuarioDTO UsuarioDTO, @RequestParam Long usuarioId) {
		usuarioService.Editar(UsuarioDTO, usuarioId);
	}
}
