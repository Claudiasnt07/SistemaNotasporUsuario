package src.servicio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotaServicio {

    private final Path notasFile;

    public NotaServicio(Path notasFile) {
        this.notasFile = notasFile;
    }

    public void crear(String titulo, String contenido) {
        try {
            Files.write(notasFile, Collections.singletonList(titulo + ";" + contenido), StandardOpenOption.APPEND);
        } catch (IOException e) {
        System.out.println("Error");
        e.printStackTrace();
        }
    }
    
}

public List<String> listar() {
    try {
        if (!Files.exists(notasFile)) Files.createFile(notasFile);
        return Files.readAllLines(notasFile);
    } catch (IOException e) {
        e.printStackTrace();
        return new ArrayList<>();
    }
}

    public void borrar(int index) {
        try {
            List<String> lista = listar();
            if (index < 0 || index >= lista.size()) {
                System.out.println("Error")
                return;
            }
            lista.remove(index);
            Files.write(notasFile, lista);
        } catch (IOException e) {
            System.out.println("Error borrando nota");
            e.printStackTrace();
        }
    }

    public String[] ver(int index) {
        try {
            List<String> lista = listar();
            if (index < 0 || index >= lista.size()) {
                System.out.println("Error");
                return null;
            }
            return lista.get(index).split(";");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
