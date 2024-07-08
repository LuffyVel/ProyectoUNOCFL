package com.edu.espol.xd;

import java.util.Scanner;

public class InterfazUser {
    private static final Scanner scanner = new Scanner(System.in);

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static String solicitarInput(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public static void mostrarMano(Jugador jugador) {
        System.out.println("Mano de " + jugador.getNombre() + ":");
        jugador.mostrarMano();
    }
}
