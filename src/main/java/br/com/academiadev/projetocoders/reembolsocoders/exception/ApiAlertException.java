package br.com.academiadev.projetocoders.reembolsocoders.exception;


public class ApiAlertException extends ApiException {

    private static final long serialVersionUID = 1L;

    public ApiAlertException(String message, String errorKey) {
        super(message, errorKey);
    }

}
