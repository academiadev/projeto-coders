package br.com.academiadev.projetocoders.reembolsocoders.dto;

public class TrocaSenhaDTO {
    private String oldPassword;
    private String newPassword;

    public TrocaSenhaDTO(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public TrocaSenhaDTO() {
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
