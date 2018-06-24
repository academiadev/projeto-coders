package br.com.academiadev.projetocoders.reembolsocoders.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Url mal formada no arquivo do reembolso")
public class ReembolsoDownloadArquivoUrlException extends Exception{
}
