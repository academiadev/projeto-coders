package br.com.academiadev.projetocoders.reembolsocoders.controller;

import java.security.Principal;
import java.util.List;

import br.com.academiadev.projetocoders.reembolsocoders.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.academiadev.projetocoders.reembolsocoders.config.jwt.TokenHelper;
import br.com.academiadev.projetocoders.reembolsocoders.converter.UsuarioConverter;
import br.com.academiadev.projetocoders.reembolsocoders.dto.TokenDTO;
import br.com.academiadev.projetocoders.reembolsocoders.dto.UsuarioDTO;
import br.com.academiadev.projetocoders.reembolsocoders.model.Usuario;
import br.com.academiadev.projetocoders.reembolsocoders.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
    private TokenHelper tokenHelper;
	
	@Autowired
    private UsuarioConverter usuarioConverter;

	@PostMapping("/cadastrarUsuario")
	public UsuarioDTO cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO, @RequestParam Integer empresaCodigo, 
			@RequestParam(value="", required = false) String empresaNome)
			throws EmpresaNaoEncontradaException, EmpresaExistenteException, UsuarioExistenteException {
		return usuarioService.Cadastrar(usuarioDTO, empresaNome, empresaCodigo);
	}

	@PostMapping("/listaUsuariosEmpresa")
	public List<UsuarioDTO> listaUsuariosEmpresa(@RequestParam Long empresaId) throws ApiAlertException {
		List<UsuarioDTO> listUsuario = usuarioService.ListaUsuariosEmpresa(empresaId);
		return listUsuario;
	}

	@PostMapping("/editarUsuario")
	public ResponseEntity<?> editarUsuario(@RequestBody UsuarioDTO UsuarioDTO, Device dispositivo) throws UsuarioNaoEncontradoException {
		usuarioService.Editar(UsuarioDTO);
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Usuario user = (Usuario) securityContext.getAuthentication().getPrincipal();
		user.setEmail(UsuarioDTO.getEmail());
		String token = tokenHelper.gerarToken(usuarioConverter.toDTO(user), dispositivo);
        int expiresIn = tokenHelper.getExpiredIn(dispositivo);
        return ResponseEntity.ok(new TokenDTO(token, Long.valueOf(expiresIn)));
	}
	
	@GetMapping("/whoami")
	public UsuarioDTO user(Principal usuario) {
		return usuarioService.findByEmail(usuario.getName());
	}
	
	@GetMapping("/pesquisaUsuario")
	public UsuarioDTO pesquisaUsuario(@RequestParam Long usuarioId) {
		return usuarioService.pesquisaUsuario(usuarioId);
	}
}
