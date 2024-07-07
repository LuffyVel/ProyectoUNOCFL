package com.edu.espol.xd;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    private ArrayList<Carta> cartas;

    public Baraja() {
        cartas = new ArrayList<>();
        inicializarBaraja();
    }

    public void inicializarBaraja() {
        for (Color color : Color.values()) {
            if (color != Color.N) {
                for (int i = 0; i <= 9; i++) {
                    cartas.add(new Carta(color, Tipo.NUMERO, i));
                    if (i != 0) 
                        cartas.add(new Carta(color, Tipo.NUMERO, i));
                }
                cartas.add(new Carta(color, Tipo.REVERSE));
                cartas.add(new Carta(color, Tipo.REVERSE));
                cartas.add(new Carta(color, Tipo.BLOQUEO));
                cartas.add(new Carta(color, Tipo.BLOQUEO));
                cartas.add(new Carta(color, Tipo.MAS_DOS));
                cartas.add(new Carta(color, Tipo.MAS_DOS));
                cartas.add(new Carta(color, Tipo.MAS_CUATRO));
                cartas.add(new Carta(color, Tipo.MAS_CUATRO));
            }
        }
        for (int i = 0; i < 4; i++) {
            cartas.add(new Carta(Color.N, Tipo.MAS_CUATRO));
            cartas.add(new Carta(Color.N, Tipo.CAMBIO_COLOR));
        }
        Collections.shuffle(cartas);
    }

    public Carta robarCarta() {
        if (!cartas.isEmpty()) {
            Carta carta1 = cartas.get(0);
            cartas.remove(0);
            return carta1;
        }
        return null;
    }

    public void devolverCarta(Carta carta) {
        cartas.add(carta);
    }
}
