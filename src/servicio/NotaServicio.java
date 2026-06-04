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
}
