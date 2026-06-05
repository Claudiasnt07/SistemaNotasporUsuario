package src.util;

import java.security.MessageDigest;

public class HashUtil {
    public static String hash(String pass) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(pass.getBytes());
            StringBuilder resultado = new StringBuilder();
            for (byte b : bytes) {
                resultado.append(String.format("%02x", b));
            }
            return resultado.toString();
        } catch (Exception e) {
            return pass;
        }
    }

    public static String limpiarEmail(String email) {
        return email.replace("@", "_").replace(".", "_");
    }
    
}
