package app;

import controller.AuthController;
import controller.NotaController;
import model.Nota;
import utils.InputUtils;

public class Main {
    public static void main(String[] args) {
        AuthController auth = new AuthController();
        NotaController notas = new NotaController();

        int opcion;

        do {
            System.out.println("\--- SISTEMA DE NOTAS ---");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("0. Salir");

            opcion = InputUtils.leerNumero("Opcion: ");

            switch (opcion) {
                case 1 -> {
                    String email = InputUtils.leerTexto("Email: ");
                    String pass = InputUtils.leerTexto("Contraseña: ");

                    if (auth.registrar(email, contraseña)) {
                        System.out.println("Usuario registrado");
                    } else {
                        System.out.println("El usuario ya existe");
                    }
                }
                case 2 -> {
                    String email = InputUtils.leerTexto("Email: ");
                    String pass = InputUtils.leerTexto("Contraseña: ");

                    if (auth.login(email, contraseña)) {
                        System.out.println("Login correcto");
                    } else {
                        System.out.println("Credenciales incorrectas");
                    }
                }
            }
        } while (opcion != 0);
    }
}
