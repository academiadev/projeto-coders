package br.com.academiadev.projetocoders.reembolsocoders;

import br.com.academiadev.projetocoders.reembolsocoders.service.EmailService;
import br.com.academiadev.projetocoders.reembolsocoders.service.EmpresaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.academiadev.projetocoders.reembolsocoders.dto.EmpresaDTO;
import br.com.academiadev.projetocoders.reembolsocoders.dto.UsuarioDTO;
import br.com.academiadev.projetocoders.reembolsocoders.exception.EmailJaCadastradoException;
import br.com.academiadev.projetocoders.reembolsocoders.exception.EmpresaExistenteException;
import br.com.academiadev.projetocoders.reembolsocoders.exception.EmpresaNaoEncontradaException;
import br.com.academiadev.projetocoders.reembolsocoders.exception.UsuarioExistenteException;
import br.com.academiadev.projetocoders.reembolsocoders.service.UsuarioService;
import br.com.academiadev.projetocoders.reembolsocoders.service.ReembolsoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendApplicationTests {

	@Autowired
	private EmailService emailService;

	@Autowired
	private ReembolsoService reembolsoService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private EmpresaService empresaService;

	@Test
	public void ListarReembolsosFuncionario() {
		reembolsoService.ListaReembolsosUsuario(2l);
	}
	
	@Test
	public void ListarUsuariosEmpresa() {
		usuarioService.ListaUsuariosEmpresa(1l);
	}


	public UsuarioDTO CriarUsuarioDTO(String opt) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		if (opt == "admin"){
			usuarioDTO.setEmail("PLACEHOLDERADM@mail.com");
			usuarioDTO.setNome("PLACEHOLDER ADM TEST");
			usuarioDTO.setSenha("PLACEHOLDERADM");
		}
		if (opt == "user"){
			usuarioDTO.setEmail("PLACEHOLDER@mail.com");
			usuarioDTO.setNome("PLACEHOLDER TEST");
			usuarioDTO.setSenha("PLACEHOLDER");
		}

		return usuarioDTO;
	}

	public EmpresaDTO CriarEmpresaDTO() {
		EmpresaDTO empresaDTO = new EmpresaDTO();
		empresaDTO.setNome("PLACEHOLDER");
		empresaDTO.setCodigo(0);

		return empresaDTO;
	}
}
