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

    static void menuNotas(String email) {
        Path notasPath = usuariosFolder.resolve(HashUtil.limpiarEmail(email)).resolve("notas.txt");
        NotaServicio notaService = new NotaServicio(notasPath);

        int op = -1;
        while (op != 0) {
            System.out.println("\\n1 Crear nota\\n2 Listar\\n3 Ver\\n4 Borrar\\n5 Buscar\\n0 Cerrar sesión");
            op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1 -> {
                    System.out.print("Titulo: "); String t = sc.nextLine();
                    System.out.print("Contenido: "); String c = sc.nextLine();
                    notaService.crear(t, c);
                }
                case 2 -> {
                    List<String> lista = notaService.listar();
                    for (int i = 0; i < lista.size(); i++)
                        System.out.println((i+1) + " " + lista.get(i).split(";")[0]);
                }
                case 3 -> {
                    System.out.print("Número: "); int n = Integer.parseInt(sc.nextLine())-1;
                    String[] nota = notaService.ver(n);
                    if (nota != null) {
                        System.out.println("Titulo: " + nota[0]);
                        System.out.println("Contenido: " + nota[1]);
                    }
                }
                case 4 -> {
                    System.out.print("Número: "); int n = Integer.parseInt(sc.nextLine())-1;
                    notaService.borrar(n);
                }
                case 5 -> {
                    System.out.print("Palabra: "); String p = sc.nextLine();
                    List<String> encontrados = notaService.buscar(p);
                    encontrados.forEach(e -> System.out.println("Encontrados: " + e));
                }
                
            }
        }
    }
}
