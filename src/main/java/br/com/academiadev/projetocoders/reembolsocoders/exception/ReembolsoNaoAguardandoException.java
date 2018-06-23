package br.com.academiadev.projetocoders.reembolsocoders.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Reembolso ja esta aceito ou recusado.")
public class ReembolsoNaoAguardandoException extends Exception{
}
