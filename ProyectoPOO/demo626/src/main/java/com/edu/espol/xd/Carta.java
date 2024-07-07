package com.edu.espol.xd;

public class Carta {

   private Color color;
   private int numero;

   public Carta(Color color) {
      this.color = color;
   }
   
   public Carta(Color color, int numero) {
      this(color);
      this.numero = numero;
   }

   public Color getColor() {
      return this.color;
   }

   public int getNumero() {
      return this.numero;
   }
   @Override
   public String toString() {
   return "Color"+color+"numero"+numero;
//     String var10000;
//     if (this.tipo == com.edu.espol.xd.Carta.Tipo.NUMERO) {
//        var10000 = String.valueOf(this.color);
//        return var10000 + " " + this.numero;
//     } else {
//        var10000 = String.valueOf(this.color);
//        return var10000 + " " + String.valueOf(this.tipo);
//     }
   }
}
