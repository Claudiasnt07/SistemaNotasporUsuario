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
}
