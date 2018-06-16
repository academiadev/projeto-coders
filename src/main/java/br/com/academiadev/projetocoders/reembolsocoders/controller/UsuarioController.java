package br.com.academiadev.projetocoders.reembolsocoders.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public UsuarioDTO cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO, @RequestParam Integer empresaCodigo, 
			@RequestParam(value="", required = false) String empresaNome)
			throws EmpresaNaoEncontradaException, EmpresaExistenteException, UsuarioExistenteException {
		return usuarioService.Cadastrar(usuarioDTO, empresaNome, empresaCodigo);
	}

	@PostMapping("/listaUsuariosEmpresa")
	public List<UsuarioDTO> listaUsuariosEmpresa(@RequestParam Long empresaId) {
		List<UsuarioDTO> listUsuario = usuarioService.ListaUsuariosEmpresa(empresaId);
		return listUsuario;
	}

	@PostMapping("/editarUsuario")
	public void editarUsuario(@RequestBody UsuarioDTO UsuarioDTO) {
		usuarioService.Editar(UsuarioDTO);
	}
	
	@GetMapping("/whoami")
	public UsuarioDTO user(Principal usuario) {
		return usuarioService.findByEmail(usuario.getName());
	}
}
