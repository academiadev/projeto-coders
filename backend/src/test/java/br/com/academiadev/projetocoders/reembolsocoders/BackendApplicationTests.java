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
import br.com.academiadev.projetocoders.reembolsocoders.service.EmpresaService;
import br.com.academiadev.projetocoders.reembolsocoders.service.FuncionarioService;
import br.com.academiadev.projetocoders.reembolsocoders.service.ReembolsoService;

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
