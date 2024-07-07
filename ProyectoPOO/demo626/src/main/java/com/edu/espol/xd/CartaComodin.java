package com.edu.espol.xd;

public class CartaComodin extends Carta{
    private Tipo tipo;
    public CartaComodin(Color color, Tipo tipo){
        super(color);
        this.tipo = tipo;
    }
    public Tipo getTipo(){
        return tipo;
    }
    @Override
    public String toString(){
        return "Color"+ getColor() +"Tipo" + tipo;
    }
}