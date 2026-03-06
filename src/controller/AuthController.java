package controller;

import model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class AuthController {
    private List<Usuario> usuarios = new ArrayList<>();

    public boolean registrar(String email, String contraseña) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email)) {
                return false;
            }
        }

        usuarios.add(new Usuario(email, contraseña));
        return true;
    }
}
