package com.edu.espol.xd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {
    private List<Carta> cartas;

    public Baraja() {
        cartas = new ArrayList<>();
        inicializarBaraja();
        Collections.shuffle(cartas);
    }

    private void inicializarBaraja() {
        for (Carta.Color color : Carta.Color.values()) {
            if (color == Carta.Color.NEGRO) continue;
            for (int i = 0; i <= 9; i++) {
                cartas.add(new Carta(color, Carta.Tipo.NUMERO, i));
                if (i != 0) cartas.add(new Carta(color, Carta.Tipo.NUMERO, i));
            }
            cartas.add(new Carta(color, Carta.Tipo.REVERSE));
            cartas.add(new Carta(color, Carta.Tipo.REVERSE));
            cartas.add(new Carta(color, Carta.Tipo.BLOQUEO));
            cartas.add(new Carta(color, Carta.Tipo.BLOQUEO));
            cartas.add(new Carta(color, Carta.Tipo.MAS_DOS));
            cartas.add(new Carta(color, Carta.Tipo.MAS_DOS));
        }
        for (int i = 0; i < 4; i++) {
            cartas.add(new Carta(Carta.Color.NEGRO, Carta.Tipo.MAS_CUATRO));
            cartas.add(new Carta(Carta.Color.NEGRO, Carta.Tipo.CAMBIO_COLOR));
        }
    }

    public Carta robarCarta() {
        return cartas.isEmpty() ? null : cartas.remove(cartas.size() - 1);
    }

    public void devolverCarta(Carta carta) {
        cartas.add(0, carta);
    }
}
