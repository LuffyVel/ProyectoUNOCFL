package com.edu.espol.xd;

import java.util.Scanner;

public class JuegoUNO {
    private Baraja baraja;
    private Jugador jugador;
    private Jugador maquina;
    private Carta cartaEnJuego;
    private Scanner scanner;

    public JuegoUNO() {
        baraja = new Baraja();
        jugador = new Jugador("Jugador");
        maquina = new Jugador("Maquina");
        scanner = new Scanner(System.in);
    }

    public void iniciarJuego() {
        for (int i = 0; i < 7; i++) {
            jugador.tomarCarta(baraja.robarCarta());
            maquina.tomarCarta(baraja.robarCarta());
        }
        cartaEnJuego = baraja.robarCarta();
        while (cartaEnJuego.getTipo() != Carta.Tipo.NUMERO) {
            baraja.devolverCarta(cartaEnJuego);
            cartaEnJuego = baraja.robarCarta();
        }
        System.out.println("Carta inicial: " + cartaEnJuego);
        turnoJugador();
    }

    private void turnoJugador() {
        while (true) {
            System.out.println(jugador);
            System.out.println("Carta en juego: " + cartaEnJuego);
            boolean tieneJugadaValida = false;

            for (Carta carta : jugador.getMano()) {
                if (esJugadaValida(carta)) {
                    tieneJugadaValida = true;
                    break;
                }
            }

            if (!tieneJugadaValida) {
                System.out.println("No tienes una jugada válida. Robas una carta.");
                jugador.tomarCarta(baraja.robarCarta());
                turnoMaquina();
                return;
            }

            System.out.print("Elige una carta (índice): ");
            int indice = scanner.nextInt();
            if (indice < 0 || indice >= jugador.getMano().size()) {
                System.out.println("Índice no válido. Intenta de nuevo.");
                continue;
            }
            Carta cartaJugada = jugador.jugarCarta(indice);
            if (esJugadaValida(cartaJugada)) {
                cartaEnJuego = cartaJugada;
                System.out.println("Has jugado: " + cartaJugada);
                if (!jugador.tieneCartas()) {
                    System.out.println("¡Has ganado!");
                    break;
                }
                turnoMaquina();
            } else {
                System.out.println("Jugada no válida. Intenta de nuevo.");
                jugador.tomarCarta(cartaJugada);
            }
        }
    }

    private void turnoMaquina() {
        boolean tieneJugadaValida = false;

        for (Carta carta : maquina.getMano()) {
            if (esJugadaValida(carta)) {
                tieneJugadaValida = true;
                break;
            }
        }

        if (!tieneJugadaValida) {
            System.out.println("La máquina no tiene una jugada válida. Roba una carta.");
            maquina.tomarCarta(baraja.robarCarta());
            turnoJugador();
            return;
        }

        for (int i = 0; i < maquina.getMano().size(); i++) {
            Carta cartaJugada = maquina.jugarCarta(i);
            if (esJugadaValida(cartaJugada)) {
                cartaEnJuego = cartaJugada;
                System.out.println("La máquina ha jugado: " + cartaJugada);
                if (!maquina.tieneCartas()) {
                    System.out.println("¡La máquina ha ganado!");
                    break;
                }
                turnoJugador();
                return;
            } else {
                maquina.tomarCarta(cartaJugada);
            }
        }
    }

    private boolean esJugadaValida(Carta carta) {
        if (carta.getColor() == cartaEnJuego.getColor() || carta.getNumero() == cartaEnJuego.getNumero()) {
            return true;
        }
        if (carta.getTipo() == Carta.Tipo.CAMBIO_COLOR || carta.getTipo() == Carta.Tipo.MAS_CUATRO) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        JuegoUNO juego = new JuegoUNO();
        juego.iniciarJuego();
    }
}
