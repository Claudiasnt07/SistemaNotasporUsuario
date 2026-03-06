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
        } while (opcion != 0);
    }
}
