package br.com.academiadev.projetocoders.reembolsocoders.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Arquivo nao encontrado, falha a resolver o (path)")
public class ReembolsoDowloadArquivoRecursoInexistenteException extends Exception{
}
