package com.edu.espol.xd;

import java.util.Scanner;
import java.util.ArrayList;

public class JuegoUNO {
    private Baraja baraja;
    private Jugador jugador;
    private Jugador maquina;
    private ArrayList<Carta> cartasenjuego;
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
        Carta cartaarobar = baraja.robarCarta();
        while (cartaarobar.getTipo() != Tipo.NUMERO) {
            baraja.devolverCarta(cartaarobar);;
            cartaarobar = baraja.robarCarta();
        }
        System.out.println("Carta inicial: " + cartaarobar);
        cartasenjuego.add(cartaarobar);
        turnoJugador();
    }

    private void turnoJugador() {
        System.out.println(jugador.getMano());
        System.out.println("Elija la carta que desea jugar: ");
        int indice = scanner.nextInt();
        scanner.nextLine();
        Carta cartaelegida = jugador.getMano().get(indice);
        if(esJugadaValida(cartaelegida)) {
            if((cartaelegida.getTipo()==Tipo.MAS_CUATRO || cartaelegida.getTipo() == Tipo.CAMBIO_COLOR)&& cartasenjuego.get(0).getTipo()==Tipo.NUMERO) {
                System.out.println("Elija el nuevo color a jugar: ");
                String nuevocolor = nextLine().toUpperCase();
                cartasenjuego.get(0).setColor(Color.valueOf(nuevocolor));
            }
            cartasenjuego.add(0, cartaelegida);
            jugador.jugarCarta(indice);
        }
        else {

        }
    }

    private String nextLine() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'nextLine'");
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

    public boolean esJugadaValida(Carta carta) {
        return carta.getColor() == (cartasenjuego.get(0)).getColor() || carta.getNumero() == (cartasenjuego.get(0)).getNumero() || carta.getTipo() == Tipo.CAMBIO_COLOR || carta.getTipo() == Tipo.MAS_CUATRO;
    }

    public static void main(String[] args) {
        JuegoUNO juego = new JuegoUNO();
        juego.iniciarJuego();
    }
}
