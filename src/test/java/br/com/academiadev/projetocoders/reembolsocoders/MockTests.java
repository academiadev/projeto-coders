package br.com.academiadev.projetocoders.reembolsocoders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.time.LocalDate;

import br.com.academiadev.projetocoders.reembolsocoders.dto.ReembolsoDTO;
import br.com.academiadev.projetocoders.reembolsocoders.dto.UsuarioDTO;
import br.com.academiadev.projetocoders.reembolsocoders.exception.ReembolsoJaExcluidoException;
import br.com.academiadev.projetocoders.reembolsocoders.exception.ReembolsoNaoAguardandoException;
import br.com.academiadev.projetocoders.reembolsocoders.exception.ReembolsoNaoEncontradoException;
import br.com.academiadev.projetocoders.reembolsocoders.exception.UsuarioNaoEncontradoException;
import br.com.academiadev.projetocoders.reembolsocoders.model.*;
import br.com.academiadev.projetocoders.reembolsocoders.repository.ReembolsoRepository;
import br.com.academiadev.projetocoders.reembolsocoders.repository.UsuarioRepository;
import br.com.academiadev.projetocoders.reembolsocoders.service.ReembolsoService;
import br.com.academiadev.projetocoders.reembolsocoders.service.UsuarioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.mockito.BDDMockito.given;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockTests {

	@MockBean
	private UsuarioRepository usuarioRepository;

	@MockBean
	private ReembolsoRepository reembolsoRepository;

	@Autowired
	private ReembolsoService reembolsoService;

	@Autowired
	private UsuarioService usuarioService;

	@Test
	public void alterandoStatusReembolso() throws ReembolsoNaoEncontradoException, ReembolsoNaoAguardandoException {
		Reembolso reembolso = mockReembolso();
		given(reembolsoRepository.findOne(-1l)).willReturn(reembolso);

		reembolsoService.AlterarStatus(-1l,"RECUSADO");
	}

	@Test
	public void alterandoStatusReembolsoRecusado() throws ReembolsoNaoEncontradoException, ReembolsoNaoAguardandoException {
		Reembolso reembolso = mockReembolso();
		reembolso.setStatus(StatusReembolso.RECUSADO);
		given(reembolsoRepository.findOne(-1l)).willReturn(reembolso);

		reembolsoService.AlterarStatus(-1l,"RECUSADO");
	}

	@Test
	public void alterandoStatusReembolsoNaoEncontrado() throws ReembolsoNaoEncontradoException, ReembolsoNaoAguardandoException {
		Reembolso reembolso = mockReembolso();
		given(reembolsoRepository.findOne(-1l)).willReturn(reembolso);

		reembolsoService.AlterarStatus(-2l,"RECUSADO");
	}

	@Test
	public void excluindoReembolso() throws ReembolsoNaoEncontradoException, ReembolsoJaExcluidoException {
		Reembolso reembolso = mockReembolso();
		given(reembolsoRepository.findOne(-1l)).willReturn(reembolso);

		reembolsoService.ExcluirReembolso(-1l);
	}

	@Test
	public void excluindoReembolsoJaExcluido() throws ReembolsoNaoEncontradoException, ReembolsoJaExcluidoException {
		Reembolso reembolso = mockReembolso();
		reembolso.setExcluido(true);
		given(reembolsoRepository.findOne(-1l)).willReturn(reembolso);

		reembolsoService.ExcluirReembolso(-1l);
	}

	@Test
	public void editarUsuario() throws UsuarioNaoEncontradoException{
		Usuario usuario = mockUsuario();
		given(usuarioRepository.findOne(-1l)).willReturn(usuario);
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setEmail("placeholder@mail.com");
		usuarioDTO.setNome("name placeholder");
		usuarioDTO.setId(-1l);
		usuarioService.Editar(usuarioDTO);
	}

	public Usuario mockUsuario(){
		Usuario usuario = new Usuario();
		usuario.setSenha("PLACEHOLDER SENHA");
		usuario.setDataCadastro(LocalDate.now());
		usuario.setEmail("PLACEHOLDER@mail.com");
		usuario.setEmpresa(new Empresa());
		usuario.setId(-1l);
		usuario.setNome("PLACEHOLDER NAME");
		return usuario;
	}

	public Reembolso mockReembolso(){
		Reembolso reembolso = new Reembolso();
		reembolso.setValor(new BigDecimal(369));
		reembolso.setArquivoPath("PLACEHOLDER PATH");
		reembolso.setCategoria(Categoria.OUTROS);
		reembolso.setData(LocalDate.now());
		reembolso.setDescricao("PLACEHOLDER DESCRICAO");
		reembolso.setUsuario(new Usuario());
		reembolso.setDataEnviado(LocalDate.now());
		reembolso.setExcluido(false);
		reembolso.setStatus(StatusReembolso.AGUARDANDO);
		reembolso.setId(-1l);
		return reembolso;
	}

}