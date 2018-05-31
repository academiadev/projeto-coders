package br.com.academiadev.projetocoders.reembolsocoders;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.academiadev.projetocoders.reembolsocoders.dto.EmpresaDTO;
import br.com.academiadev.projetocoders.reembolsocoders.dto.FuncionarioDTO;
import br.com.academiadev.projetocoders.reembolsocoders.dto.ReembolsoDTO;
import br.com.academiadev.projetocoders.reembolsocoders.exception.EmpresaNaoEncontradaException;
import br.com.academiadev.projetocoders.reembolsocoders.repository.EmpresaRepository;
import br.com.academiadev.projetocoders.reembolsocoders.repository.FuncionarioRepository;
import br.com.academiadev.projetocoders.reembolsocoders.service.EmpresaService;
import br.com.academiadev.projetocoders.reembolsocoders.service.FuncionarioService;
import br.com.academiadev.projetocoders.reembolsocoders.service.ReembolsoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendApplicationTests {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private ReembolsoService reembolsoService;

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private EmpresaService empresaService;

	@Test
	public void CadastroInicial() throws EmpresaNaoEncontradaException {
		EmpresaDTO empresaDTO = CriarEmpresaDTO();
		empresaService.Cadastrar(empresaDTO);

		FuncionarioDTO funcionarioDTO = CriarFuncionarioDTO(empresaDTO);
		funcionarioService.Cadastrar(funcionarioDTO);

		ReembolsoDTO reembolsoDTO = CriarReembolsoDTO(funcionarioDTO);
		reembolsoService.Cadastrar(reembolsoDTO);
	}

	public FuncionarioDTO CriarFuncionarioDTO(EmpresaDTO empresaDTO) {
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
		funcionarioDTO.setIdEmpresa(empresaRepository.findByNome(empresaDTO.getNome()).getId());
		funcionarioDTO.setEmail("funcionario@gmail.com");
		funcionarioDTO.setNome("Felipe");
		funcionarioDTO.setSenha("123");

		return funcionarioDTO;
	}

	public ReembolsoDTO CriarReembolsoDTO(FuncionarioDTO funcionarioDTO) {
		ReembolsoDTO reembolsoDTO = new ReembolsoDTO();
		reembolsoDTO.setArquivoPath("C:\\path");
		reembolsoDTO.setCategoria("Alimentação");
		reembolsoDTO.setData("23/04/2018");
		reembolsoDTO.setDescricao("Almoço");
		reembolsoDTO.setIdFuncionario(funcionarioRepository.findByNome(funcionarioDTO.getNome()).getId());
		reembolsoDTO.setValor("500.65");
		reembolsoDTO.setStatus("AGUARDANDO");

		return reembolsoDTO;
	}

	public EmpresaDTO CriarEmpresaDTO() {
		EmpresaDTO empresaDTO = new EmpresaDTO();
		empresaDTO.setCodigo(1010l);
		empresaDTO.setEmail("empresa@gmail.com");
		empresaDTO.setNome("Empresa");
		empresaDTO.setSenha("123");

		return empresaDTO;
	}
}
