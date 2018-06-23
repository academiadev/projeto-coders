package br.com.academiadev.projetocoders.reembolsocoders.service;

import br.com.academiadev.projetocoders.reembolsocoders.config.jwt.TokenHelper;
import br.com.academiadev.projetocoders.reembolsocoders.converter.UsuarioConverter;
import br.com.academiadev.projetocoders.reembolsocoders.dto.TokenDTO;
import br.com.academiadev.projetocoders.reembolsocoders.model.Usuario;
import br.com.academiadev.projetocoders.reembolsocoders.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private TokenHelper tokenHelper;
    
    @Autowired
    private UsuarioConverter usuarioConverter;

    @Override
    public UserDetails loadUserByUsername(String useremail) throws UsernameNotFoundException {
        Usuario user = userRepository.findByEmail(useremail);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with useremail '%s'.", useremail));
        } else {
            return user;
        }
    }

    public TokenDTO trocarSenha(String newPassword, Device dispositivo) {
    	SecurityContext securityContext = SecurityContextHolder.getContext();
		Usuario user = (Usuario) securityContext.getAuthentication().getPrincipal();
		user.setSenha(passwordEncoder.encode(newPassword));
        userRepository.save(user);
		String token = tokenHelper.gerarToken(usuarioConverter.toDTO(user), dispositivo);
        int expiresIn = tokenHelper.getExpiredIn(dispositivo);
        
        return new TokenDTO(token, Long.valueOf(expiresIn));
    }
}

