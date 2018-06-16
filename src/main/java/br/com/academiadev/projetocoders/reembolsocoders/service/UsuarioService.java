package br.com.academiadev.projetocoders.reembolsocoders.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiadev.projetocoders.reembolsocoders.converter.UsuarioConverter;
import br.com.academiadev.projetocoders.reembolsocoders.dto.EmpresaDTO;
import br.com.academiadev.projetocoders.reembolsocoders.dto.UsuarioDTO;
import br.com.academiadev.projetocoders.reembolsocoders.exception.EmpresaExistenteException;
import br.com.academiadev.projetocoders.reembolsocoders.exception.EmpresaNaoEncontradaException;
import br.com.academiadev.projetocoders.reembolsocoders.exception.UsuarioExistenteException;
import br.com.academiadev.projetocoders.reembolsocoders.model.Autorizacao;
import br.com.academiadev.projetocoders.reembolsocoders.model.Empresa;
import br.com.academiadev.projetocoders.reembolsocoders.model.Usuario;
import br.com.academiadev.projetocoders.reembolsocoders.repository.EmpresaRepository;
import br.com.academiadev.projetocoders.reembolsocoders.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioConverter usuarioConverter;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private AutorizacaoService autorizacaoService;

	public UsuarioDTO Cadastrar(UsuarioDTO usuarioDTO, String empresaNome, Integer empresaCodigo)
			throws EmpresaNaoEncontradaException, EmpresaExistenteException, UsuarioExistenteException {
		if (usuarioRepository.findByNome(usuarioDTO.getNome()) != null) {
			throw new UsuarioExistenteException();
		}
		if(usuarioRepository.findByEmail(usuarioDTO.getEmail()) != null) {
			throw new EmpresaExistenteException();
		}

		Usuario usuario = usuarioConverter.toEntity(usuarioDTO);

		if (empresaNome == null || empresaNome == "") {
			Empresa empresa = empresaRepository.findByCodigo(empresaCodigo);
			if (empresa == null) {
				throw new EmpresaNaoEncontradaException();
			}
			usuario.setEmpresa(empresa);
			usuario.setAutorizacoes(getAutorizacoes("ROLE_USER"));
		} else {
			EmpresaDTO empresaDTO = new EmpresaDTO();
			empresaDTO.setNome(empresaNome);
			Empresa empresa = empresaService.Cadastrar(empresaDTO);
			usuario.setEmpresa(empresa);
			usuario.setAutorizacoes(getAutorizacoes("ROLE_ADMIN"));
		}
		
		usuario.setUltimaTrocaDeSenha(LocalDate.now());

		usuarioRepository.save(usuario);
		return usuarioConverter.toDTO(usuario);
	}

	public List<UsuarioDTO> ListaUsuariosEmpresa(Long empresaId) {
		List<Usuario> listUsuario = usuarioRepository.findByEmpresaId(empresaId);
		List<UsuarioDTO> listUsuarioDTO = new ArrayList<>();

		for (Usuario usuario : listUsuario) {
			listUsuarioDTO.add(usuarioConverter.toDTO(usuario));
		}

		return listUsuarioDTO;
	}

	public void Editar(UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioRepository.findOne(usuarioDTO.getId());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setNome(usuarioDTO.getNome());
		usuarioRepository.save(usuario);
	}
	
	private List<Autorizacao> getAutorizacoes(String autorizacao) {
		List<Autorizacao> list = new ArrayList<>();

		if(autorizacao.equals("ROLE_ADMIN")) {
			Autorizacao adminRole = autorizacaoService.findByNome("ROLE_ADMIN");
			list.add(adminRole != null ? adminRole : autorizacaoService.salvaNovaAutorizacao(new Autorizacao("ROLE_ADMIN")));	
		}
		else {
			Autorizacao adminRole = autorizacaoService.findByNome("ROLE_USER");
			list.add(adminRole != null ? adminRole : autorizacaoService.salvaNovaAutorizacao(new Autorizacao("ROLE_USER")));
		}
		return list;
	}
	
	public UsuarioDTO findByEmail(String email) {
		return usuarioConverter.toDTO(usuarioRepository.findByEmail(email));
	}

}
