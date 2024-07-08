package com.edu.espol.xd;

public enum Color {

   ROJO('R'),
   AMARILLO('A'),
   VERDE('V'),
   AZUL('Z'),
   NEGRO('N');

   private char abreviatura;

   Color(char abreviatura) {
      this.abreviatura = abreviatura;
   }


   public char getAbreviatura() {
      return abreviatura;
   }
}
