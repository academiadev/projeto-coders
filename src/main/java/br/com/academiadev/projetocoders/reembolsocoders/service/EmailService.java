package br.com.academiadev.projetocoders.reembolsocoders.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Service;

import br.com.academiadev.projetocoders.reembolsocoders.config.jwt.TokenHelper;
import br.com.academiadev.projetocoders.reembolsocoders.converter.UsuarioConverter;
import br.com.academiadev.projetocoders.reembolsocoders.model.Mail;
import br.com.academiadev.projetocoders.reembolsocoders.model.Usuario;
import br.com.academiadev.projetocoders.reembolsocoders.repository.UsuarioRepository;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;
    
    @Autowired
	private UsuarioRepository usuarioRepository;
    
    @Autowired
    private TokenHelper tokenHelper;
    
    @Autowired
    private UsuarioConverter usuarioConverter;
    
    public Boolean emailValido(String email) {
    	Usuario usuario = usuarioRepository.findByEmail(email);
    	if (usuario != null) {
    		return true;
    	}
    	return false;
    }

    public void sendSimpleMessage(String email, HttpServletRequest request, Device dispositivo){
    	Mail mail = new Mail();
    	
    	Usuario usuario = usuarioRepository.findByEmail(email);
    	String token = tokenHelper.gerarToken(usuarioConverter.toDTO(usuario), dispositivo);
    	
    	String url = request.getScheme() + "://localhost:4200";
    	url += "/redefinirNovaSenha?token=" + token;
    	
		mail.setFrom("reembolsocoders@gmail.com");
		mail.setTo(email);
		mail.setSubject("Resetar Senha Reembolso Azul");
		mail.setContent("Clique no link abaixo para alterar sua senha.\n" + url);
		
		SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());
        message.setTo(mail.getTo());
        message.setFrom(mail.getFrom());
    	
        emailSender.send(message);
    }

}
