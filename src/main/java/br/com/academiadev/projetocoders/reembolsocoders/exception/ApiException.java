package br.com.academiadev.projetocoders.reembolsocoders.exception;

public abstract class ApiException extends Exception {

    private final String errorKey;

    protected ApiException(String message, String errorKey){
        super(message);
        this.errorKey = errorKey;
    }

    public String getErrorKey() {
        return errorKey;
    }
}
