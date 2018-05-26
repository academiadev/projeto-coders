package br.com.academiadev.projetocoders.backend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.academiadev.projetocoders.backend.dto.EmpresaDTO;
import br.com.academiadev.projetocoders.backend.dto.FuncionarioDTO;
import br.com.academiadev.projetocoders.backend.dto.ReembolsoDTO;
import br.com.academiadev.projetocoders.backend.exception.EmpresaNaoEncontradaException;
import br.com.academiadev.projetocoders.backend.service.EmpresaService;
import br.com.academiadev.projetocoders.backend.service.FuncionarioService;
import br.com.academiadev.projetocoders.backend.service.ReembolsoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendApplicationTests {
	
	@Autowired
	private ReembolsoService reembolsoService;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private EmpresaService empresaService;

	@Test
	public void CadastroInicial() throws EmpresaNaoEncontradaException {
		EmpresaDTO empresaDTO = empresaService.CriarEmpresaDTO();
		empresaService.Cadastrar(empresaDTO);
		
		FuncionarioDTO funcionarioDTO = funcionarioService.CriarFuncionarioDTO(empresaDTO);
		funcionarioService.Cadastrar(funcionarioDTO, empresaDTO.getCodigo());
		
		ReembolsoDTO reembolsoDTO = reembolsoService.CriarReembolsoDTO(funcionarioDTO);
		reembolsoService.Cadastrar(reembolsoDTO, funcionarioDTO.getNome());
	}

}
