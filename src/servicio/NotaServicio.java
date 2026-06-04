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
