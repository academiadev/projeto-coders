package br.com.academiadev.projetocoders.reembolsocoders.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Usuario nao encontrado pelo ID.")
public class UsuarioNaoEncontradoException extends Exception {
}
