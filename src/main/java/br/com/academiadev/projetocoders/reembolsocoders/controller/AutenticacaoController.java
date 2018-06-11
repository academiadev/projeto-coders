package br.com.academiadev.projetocoders.reembolsocoders.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.academiadev.projetocoders.reembolsocoders.common.DeviceProvider;
import br.com.academiadev.projetocoders.reembolsocoders.config.jwt.TokenHelper;
import br.com.academiadev.projetocoders.reembolsocoders.dto.LoginDTO;
import br.com.academiadev.projetocoders.reembolsocoders.dto.TokenDTO;
import br.com.academiadev.projetocoders.reembolsocoders.dto.TrocaSenhaDTO;
import br.com.academiadev.projetocoders.reembolsocoders.model.Usuario;
import br.com.academiadev.projetocoders.reembolsocoders.service.CustomUserDetailsService;

@RestController
public class AutenticacaoController {

    @Autowired
    private TokenHelper tokenHelper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private DeviceProvider deviceProvider;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> criarAutenticacaoAutorizada(@RequestBody LoginDTO authenticationRequest, HttpServletResponse response, Device dispositivo) throws AuthenticationException, IOException {
        final Authentication autenticacao = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getSenha()));
        SecurityContextHolder.getContext().setAuthentication(autenticacao);
        Usuario usuario = (Usuario) autenticacao.getPrincipal();
        String token = tokenHelper.gerarToken(usuario.getUsername(), dispositivo);
        int expiresIn = tokenHelper.getExpiredIn(dispositivo);
        return ResponseEntity.ok(new TokenDTO(token, Long.valueOf(expiresIn), usuario.getAutorizacoes().get(0).getNome()));
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.POST)
    public ResponseEntity<?> atualizarAutenticacao(HttpServletRequest request, HttpServletResponse response, Principal principal) {
        String token = tokenHelper.getToken(request);
        Device dispositivo = deviceProvider.getDispositivo(request);
        if (token != null && principal != null) {
            String tokenAtualizado = tokenHelper.atualizarToken(token, dispositivo);
            int expiracao = tokenHelper.getExpiredIn(dispositivo);
            return ResponseEntity.ok(new TokenDTO(tokenAtualizado, Long.valueOf(expiracao), ""));
        } else {
            TokenDTO tokenDTO = new TokenDTO();
            return ResponseEntity.accepted().body(tokenDTO);
        }
    }

    @RequestMapping(value = "/isauth", method = RequestMethod.POST)
    public ResponseEntity<?> estaAutenticado(HttpServletRequest request) {
        String token = tokenHelper.getToken(request);

        if (token != null) {
            String usuarioDoToken = tokenHelper.getUsuario(token);
            if (usuarioDoToken != null) {
                UserDetails usuario = userDetailsService.loadUserByUsername(usuarioDoToken);
                if (tokenHelper.validarToken(token, usuario)) {
                    Map<String, String> result = new HashMap<>();
                    result.put("isAuth", "true");
                    return ResponseEntity.ok().body(result);
                }
            }
        }

        Map<String, String> result = new HashMap<>();
        result.put("isAuth", "false");
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> trocarSenha(@RequestBody TrocaSenhaDTO trocaSenhaDTO) {
        userDetailsService.trocarSenha(trocaSenhaDTO.getOldPassword(), trocaSenhaDTO.getNewPassword());
        Map<String, String> result = new HashMap<>();
        result.put("result", "success");
        return ResponseEntity.accepted().body(result);
    }

}
