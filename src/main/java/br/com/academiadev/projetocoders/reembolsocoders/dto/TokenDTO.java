package br.com.academiadev.projetocoders.reembolsocoders.dto;

public class TokenDTO {
    private String accessToken;
    private Long expiresIn;
    private String autorizacao;

    public TokenDTO(String accessToken, Long expiresIn, String autorizacao) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.autorizacao = autorizacao;
    }

    public TokenDTO(){

    }

    public String getAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}

	public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }
}
