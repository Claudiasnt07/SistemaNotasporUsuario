package controller;

import modelo.Nota;
import java.util.ArrayList;;
import java.util.List;

public class NotaController {
    private List<Nota> notas = new ArrayList<>();

    public void crearNota(String email, String titulo, String contenido) {
        notas.add(new Nota(email, titulo, contenido));
    }

    public List<Nota> listarNotas(String email) {
        List<Nota> resultado = new ArrayList<>();

        for (Nota n : notas) {
            if (n.getEmailUsuario().equals(email)) {
                resultado.add(n);
            }
        }

        return resultado;
    }

    public void eliminarNota(String email, int indice) {
        List<Nota> notaUsuario = listarNotas(email);

        if (indice < 0 || indice >= notasUsuario.size()) {
            System.out.println("Indice inválido");
            return;
        }

        notas.remove(notasUsuario.get(indice));
    }
}
