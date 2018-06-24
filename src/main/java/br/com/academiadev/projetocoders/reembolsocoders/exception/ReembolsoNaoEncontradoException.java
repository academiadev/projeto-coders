package br.com.academiadev.projetocoders.reembolsocoders.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "ID Reembolso nao encontrado.")
public class ReembolsoNaoEncontradoException extends Exception {
}
