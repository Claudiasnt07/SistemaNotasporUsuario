package modelo;

public class Usuario {
    private String email;
    private String passwordHash;

    public Usuario(String email, String passwordHash) {
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }
    public String getPasswordHash() {
        return passwordHash;
    }
}