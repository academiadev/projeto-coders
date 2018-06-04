package br.com.academiadev.projetocoders.reembolsocoders;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.academiadev.projetocoders.reembolsocoders.dto.EmpresaDTO;
import br.com.academiadev.projetocoders.reembolsocoders.dto.UsuarioDTO;
import br.com.academiadev.projetocoders.reembolsocoders.dto.ReembolsoDTO;
import br.com.academiadev.projetocoders.reembolsocoders.exception.EmpresaExistenteException;
import br.com.academiadev.projetocoders.reembolsocoders.exception.EmpresaNaoEncontradaException;
import br.com.academiadev.projetocoders.reembolsocoders.exception.UsuarioExistenteException;
import br.com.academiadev.projetocoders.reembolsocoders.repository.UsuarioRepository;
import br.com.academiadev.projetocoders.reembolsocoders.service.UsuarioService;
import br.com.academiadev.projetocoders.reembolsocoders.service.ReembolsoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendApplicationTests {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ReembolsoService reembolsoService;

	@Autowired
	private UsuarioService funcionarioService;

	@Test
	public void CadastroInicial()
			throws EmpresaNaoEncontradaException, EmpresaExistenteException, UsuarioExistenteException {
		
		EmpresaDTO empresaDTO = CriarEmpresaDTO();
		UsuarioDTO usuarioDTO = CriarFuncionarioDTO(empresaDTO);
		funcionarioService.Cadastrar(usuarioDTO, empresaDTO);

		ReembolsoDTO reembolsoDTO = CriarReembolsoDTO(usuarioDTO);
		reembolsoService.Cadastrar(reembolsoDTO);
	}
	
	@Test
	public void AlteraStatusReembolso() {
		reembolsoService.AlterarStatus(3l, "RECUSADO");
	}
	
	@Test
	public void ListarReembolsosFuncionario() {
		reembolsoService.ListaReembolsosUsuario(2l);
	}
	
	@Test
	public void ListarFuncionariosEmpresa() {
		funcionarioService.ListaUsuariosEmpresa(1l);
	}

	public UsuarioDTO CriarFuncionarioDTO(EmpresaDTO empresaDTO) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setEmail("funcionario@gmail.com");
		usuarioDTO.setNome("Fer");
		usuarioDTO.setSenha("123");

		return usuarioDTO;
	}

	public ReembolsoDTO CriarReembolsoDTO(UsuarioDTO usuarioDTO) {
		ReembolsoDTO reembolsoDTO = new ReembolsoDTO();
		reembolsoDTO.setArquivoPath("C:\\path");
		reembolsoDTO.setCategoria("Alimentação");
		reembolsoDTO.setData("23/04/2018");
		reembolsoDTO.setDescricao("Almoço");
		reembolsoDTO.setIdFuncionario(usuarioRepository.findByNome(usuarioDTO.getNome()).getId());
		reembolsoDTO.setValor("500.65");

		return reembolsoDTO;
	}

	public EmpresaDTO CriarEmpresaDTO() {
		EmpresaDTO empresaDTO = new EmpresaDTO();
		empresaDTO.setCodigo(5);

		return empresaDTO;
	}
}
