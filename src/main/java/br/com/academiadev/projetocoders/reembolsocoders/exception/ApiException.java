package br.com.academiadev.projetocoders.reembolsocoders.exception;

public abstract class ApiException extends Exception {

    private static final long serialVersionUID = 1L;
    private final String errorKey;

    protected APIException(String message, String errorKey) {
        super(message);
        this.errorKey = errorKey;
    }
}
