package com.edu.espol.xd;

public class Carta {
    public enum Color { ROJO, AMARILLO, VERDE, AZUL, NEGRO }
    public enum Tipo { NUMERO, REVERSE, BLOQUEO, CAMBIO_COLOR, MAS_DOS, MAS_CUATRO }

    private Color color;
    private Tipo tipo;
    private int numero;

    public Carta(Color color, Tipo tipo, int numero) {
        this.color = color;
        this.tipo = tipo;
        this.numero = numero;
    }

    public Carta(Color color, Tipo tipo) {
        this(color, tipo, -1);
    }

    public Color getColor() {
        return color;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        if (tipo == Tipo.NUMERO) {
            return color + " " + numero;
        } else {
            return color + " " + tipo;
        }
    }
}
