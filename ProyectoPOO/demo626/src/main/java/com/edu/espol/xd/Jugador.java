package com.edu.espol.xd;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
   private Mano mano;
   private String nombre;

   public Jugador(String nombre) {
      this.nombre = nombre;
      this.mano = new Mano();
   }

   public void tomarCarta(Baraja baraja) {
      Carta carta = baraja.robarCarta();
      mano.agregarCarta(carta);
   }

   public Carta jugarCarta(int indice) {
      return mano.removerCarta(indice);
   }

   public Mano getMano() {
      return mano;
   }

   public String getNombre() {
      return nombre;
   }

   public boolean tieneCartas() {
      return !mano.getCartas().isEmpty();
   }

   public void mostrarMano() {
      for (int i = 0; i < mano.getCartas().size(); i++) {
         System.out.println(i + ": " + mano.getCartas().get(i));
      }
   }

   public String toString() {
      String var10000 = this.nombre;
      return var10000 + "'s mano: " + String.valueOf(this.mano);
   }
}


