package utils;

import java.util.Scanner;

public class InputUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static String leerTesto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}
