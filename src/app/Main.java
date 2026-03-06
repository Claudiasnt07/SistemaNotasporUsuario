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
                        int op;
                        do {
                            System.out.println("\n1. Crear nota");
                            System.out.println("2. Listar notas");
                            System.out.println("3. Eliminar nota");
                            System.out.println("0. Cerrar sesión");
                            op = InputUtils.leerNumero("Opción: ");

                            switch (op) {
                                case 1 -> {
                                    String titulo = InputUtils.leerTexto("Titulo: ");
                                    String cont = InputUtils.leerTexto("Contenido: ");
                                    notas.crearNota(email, titulo, cont);
                                }
                                case 2 -> {
                                    List<Nota> lista = notas.listarNotas(email);

                                    for (int i = 0; i < lista.size(); i++) {
                                        Nota n = lista.get(i);
                                        System.out.println((i + 1) + ". " + n.getTitulo() + " - " + n.getContenido());
                                    }
                                }
                                case 3 -> {
                                    int n = InputUtils.leerNumero("Número nota: ");
                                    notas.eliminarNota(email, n - 1);
                                }
                            }
                        } while (op != 0);
                        
                    } else {
                        System.out.println("Credenciales incorrectas");
                    }
                }
            }
        } while (opcion != 0);
    }
}
