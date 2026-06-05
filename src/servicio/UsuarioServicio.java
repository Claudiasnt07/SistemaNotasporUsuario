package src.servicio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.util.List;
import java.util.Collections;

import src.util.HashUtil;

public class UsuarioServicio {
    private final Path usuariosFile;
    private final Path usuariosFolder;

    public UsuarioServicio(Path usuariosFile, Path usuariosFolder) {
        this.usuariosFile = usuariosFile;
        this.usuariosFolder = usuariosFolder;
    }

    public boolean registrar(String email, String pass) {
        if (email.isEmpty() || pass.isEmpty()) {
            System.out.println("Obligatorio");
            return false;
        }

        try {
            if (!Files.exists(usuariosFile)) Files.createFile(usuariosFile);
            List<String> lista = Files.readAllLines(usuariosFile);
            for (String u : lista) {
                if (u.split(";")[0].equals(email)) {
                    System.out.println("El usuario ya existe");
                    return false;
                }
            }

            String hashPass = HashUtil.hash(pass);
            Files.write(usuariosFile,
                        Collections.singletonList(email + ";" + hashPass),
                        StandardOpenOption.APPEND);
            Path carpeta = usuariosFolder.resolve(HashUtil.limpiarEmail(email));
            Files.createDirectories(carpeta);
            Files.createFile(carpeta.resolve("notas.txt"));

            System.out.println("El usuario ha sido creado");
            return true;

        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
            return false;
        }
    }

    public boolean login(String email, String pass) {
        try {
            if (!Files.exists(usuariosFile)) return false;

            String hashPass = HashUtil.hash(pass);
            List<String> lista = Files.readAllLines(usuariosFile);
            for (String u : lista) {
                String[] p = u.split(";");
                if (p[0].equals(email) && p[1].equals(hashPass)) {
                    return true;
                }
            }
            return false;

        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
            return false;
        }
    }
}
