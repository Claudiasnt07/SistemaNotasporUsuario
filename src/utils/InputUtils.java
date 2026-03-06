package utils;

import java.util.Scanner;

public class InputUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public static int leerTexto(String mensaje) {
        System.out.print(mensaje);
        return Integer.parseInt(scanner.nextLine());
    }
}
