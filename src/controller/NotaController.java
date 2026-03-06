package controller;

import modelo.Nota;
import java.util.ArrayList;;
import java.util.List;

public class NotaController {
    private List<Nota> notas = new ArrayList<>();

    public void crearNota(String email, String titulo, String contenido) {
        notas.add(new Nota(email, titulo, contenido));
    }
}
