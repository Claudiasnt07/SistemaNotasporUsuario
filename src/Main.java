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
}
