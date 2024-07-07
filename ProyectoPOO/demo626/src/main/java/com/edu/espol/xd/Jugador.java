package com.edu.espol.xd;

import java.util.ArrayList;


public class Jugador {
    private ArrayList<Carta> mano;
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
    }

    public void tomarCarta(Carta carta) {
        mano.add(carta);
    }

    public Carta jugarCarta(int indice) {
        return mano.remove(indice);
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean tieneCartas() {
        return !mano.isEmpty();
    }

    @Override
    public String toString() {
        return nombre + "'s mano: " + mano;
    }
}

