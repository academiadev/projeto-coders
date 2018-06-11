package br.com.academiadev.projetocoders.reembolsocoders.converter;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.academiadev.projetocoders.reembolsocoders.dto.UsuarioDTO;
import br.com.academiadev.projetocoders.reembolsocoders.model.Empresa;
import br.com.academiadev.projetocoders.reembolsocoders.model.Usuario;

@Component
public class UsuarioConverter implements Converter<Usuario, UsuarioDTO>{

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UsuarioDTO toDTO(Usuario entity) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setEmail(entity.getEmail());
		dto.setNome(entity.getNome());
		dto.setSenha(entity.getSenha());
		dto.setIdEmpresa(entity.getEmpresa().getId());
		dto.setId(entity.getId());
		return dto;
	}

	@Override
	public Usuario toEntity(UsuarioDTO dto) {
		Usuario usuario = new Usuario();
		usuario.setEmail(dto.getEmail());
		usuario.setNome(dto.getNome());
		usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
		Empresa empresa = new Empresa();
		empresa.setId(dto.getIdEmpresa());
		usuario.setEmpresa(empresa);
		usuario.setDataCadastro(LocalDate.now());
		return usuario;
	}

}
