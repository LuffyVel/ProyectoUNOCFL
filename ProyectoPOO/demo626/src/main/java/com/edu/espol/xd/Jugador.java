package com.edu.espol.xd;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private List<Carta> mano;
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

    public List<Carta> getMano() {
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

