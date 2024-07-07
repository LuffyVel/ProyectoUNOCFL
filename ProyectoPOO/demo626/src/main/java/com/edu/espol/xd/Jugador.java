package com.edu.espol.xd;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
   private List<Carta> mano;
   private String nombre;

   public Jugador(String nombre) {
      this.nombre = nombre;
      this.mano = new ArrayList();
   }

   public void tomarCarta(Carta carta) {
      this.mano.add(carta);
   }

   public Carta jugarCarta(int indice) {
      return (Carta)this.mano.remove(indice);
   }

   public List<Carta> getMano() {
      return this.mano;
   }

   public String getNombre() {
      return this.nombre;
   }

   public boolean tieneCartas() {
      return !this.mano.isEmpty();
   }

   public String toString() {
      String var10000 = this.nombre;
      return var10000 + "'s mano: " + String.valueOf(this.mano);
   }
}


