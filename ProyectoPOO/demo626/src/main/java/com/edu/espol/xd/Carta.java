package com.edu.espol.xd;

public class Carta {

   private Color color;
   private Tipo tipo;

   public Carta(Color color, Tipo tipo) {
      this.color = color;
      this.tipo = tipo;
   }

   public Color getColor() {
      return color;
   }

   public Tipo getTipo() {
      return tipo;
   }
   public boolean esComodin() {
      return tipo == Tipo.REVERSE || tipo == Tipo.BLOQUEO || tipo == Tipo.CAMBIO_DE_COLOR || tipo == Tipo.MAS_CUATRO || tipo == Tipo.MAS_DOS;
   }

   @Override
   public String toString() {
      return color.getAbreviatura() + tipo.getSimbolo();
   }
//     String var10000;
//     if (this.tipo == com.edu.espol.xd.Carta.Tipo.NUMERO) {
//        var10000 = String.valueOf(this.color);
//        return var10000 + " " + this.numero;
//     } else {
//        var10000 = String.valueOf(this.color);
//        return var10000 + " " + String.valueOf(this.tipo);
//     }
}

