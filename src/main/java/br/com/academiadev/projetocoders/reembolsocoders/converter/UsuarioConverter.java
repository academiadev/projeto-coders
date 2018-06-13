package br.com.academiadev.projetocoders.reembolsocoders.converter;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.academiadev.projetocoders.reembolsocoders.dto.UsuarioDTO;
import br.com.academiadev.projetocoders.reembolsocoders.model.Usuario;

@Component
public class UsuarioConverter implements Converter<Usuario, UsuarioDTO>{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired 
	private EmpresaConverter empresaConverter;

	@Override
	public UsuarioDTO toDTO(Usuario entity) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setEmail(entity.getEmail());
		dto.setNome(entity.getNome());
		dto.setSenha(entity.getSenha());
		dto.setEmpresa(empresaConverter.toDTO(entity.getEmpresa()));
		dto.setId(entity.getId());
		dto.setIsAdmin(entity.getAutorizacoes().get(0).getNome().equals("ROLE_ADMIN"));
		return dto;
	}

	@Override
	public Usuario toEntity(UsuarioDTO dto) {
		Usuario usuario = new Usuario();
		usuario.setEmail(dto.getEmail());
		usuario.setNome(dto.getNome());
		usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
		usuario.setDataCadastro(LocalDate.now());
		return usuario;
	}

}
