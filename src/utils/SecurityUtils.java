package utils;

import java.security.MessageDigest;

public class SecurityUtils {
    public static String hash(String texto) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(texto.getBytes());

            String resultado = " ";

            for (byte b : bytes) {
                resultado += String.format("%02x", b);
            }

            return resultado;
        } catch (Exception e) {
            return = "";
        }
    }
}
