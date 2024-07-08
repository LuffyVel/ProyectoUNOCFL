package com.edu.espol.xd;

import java.util.ArrayList;
import java.util.List;

public class Mano {
    private List<Carta> cartas;

    public Mano() {
        cartas = new ArrayList<>();
    }

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    public Carta removerCarta(int indice) {
        return cartas.remove(indice);
    }

    public Carta obtenerCarta(int indice) {
        return cartas.get(indice);
    }

    public List<Carta> getCartas() {
        return cartas;
    }
}

