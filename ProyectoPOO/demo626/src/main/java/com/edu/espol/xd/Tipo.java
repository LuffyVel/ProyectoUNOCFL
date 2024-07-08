package com.edu.espol.xd;

public enum Tipo {
   CERO("0"),
   UNO("1"),
   DOS("2"),
   TRES("3"),
   CUATRO("4"),
   CINCO("5"),
   SEIS("6"),
   SIETE("7"),
   OCHO("8"),
   NUEVE("9"),
   REVERSE("^"),
   BLOQUEO("&"),
   CAMBIO_DE_COLOR("%"),
   MAS_CUATRO("+4"),
   MAS_DOS("+2");

   private String simbolo;

   // Constructor para inicializar el símbolo
   Tipo(String simbolo) {
      this.simbolo = simbolo;
   }

   // Método para obtener el símbolo
   public String getSimbolo() {
      return simbolo;
   }

   @Override
   public String toString() {
      return simbolo;
   }
}


