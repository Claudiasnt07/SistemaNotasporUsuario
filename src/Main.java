package src;

import java.nio.file.*;
import java.util.*;
import src.servicio.NotaServicio;
import src.servicio.UsuarioServicio;
import src.util.HashUtil;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Path data = Paths.get("data");
    static Path usuariosFile = data.resolve("usuarios.txt");
    static Path usuariosFolder = data.resolve("usuarios");

    public static void main(String[] args) throws Exception {
        if (!Files.exists(data)) Files.createDirectory(data);
        if (!Files.exists(usuariosFolder)) Files.createDirectory(usuariosFolder);
        if (!Files.exists(usuariosFile)) Files.createFile(usuariosFile);

        UsuarioServicio usuarioServicio = new UsuarioServicio(usuariosFile, usuariosFolder);

        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n1 Registrarse\n2 Login\n0 Salir");
            opcion = Integer.parseInt(sc.nextLine());
            if (opcion == 1) {
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Password: ");
                String pass = sc.nextLine();
                usuarioServicio.registrar(email, pass);
            }
            if (opcion == 2) {
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Password: ");
                String pass = sc.nextLine();
                if (usuarioServicio.login(email, pass)) menuNotas(email);
                else System.out.println("Error");
            }
        }
    }
}
