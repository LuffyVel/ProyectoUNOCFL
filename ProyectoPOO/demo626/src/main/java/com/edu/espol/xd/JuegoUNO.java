package com.edu.espol.xd;

import java.util.Iterator;
import java.util.Scanner;

public class JuegoUNO {
   private Baraja baraja = new Baraja();
   private Jugador jugador = new Jugador("Jugador");
   private Jugador maquina = new Jugador("Maquina");
   private Carta cartaEnJuego;
   private Scanner scanner;

   public JuegoUNO() {
      this.scanner = new Scanner(System.in);
   }

   public void iniciarJuego() {
      for(int i = 0; i < 7; ++i) {
         this.jugador.tomarCarta(this.baraja.robarCarta());
         this.maquina.tomarCarta(this.baraja.robarCarta());
      }

      for(this.cartaEnJuego = this.baraja.robarCarta(); this.cartaEnJuego.getTipo() != Tipo.NUMERO; this.cartaEnJuego = this.baraja.robarCarta()) {
         this.baraja.devolverCarta(this.cartaEnJuego);
      }

      System.out.println("Carta inicial: " + String.valueOf(this.cartaEnJuego));
      this.turnoJugador();
   }

   private void turnoJugador() {
      while(true) {
         System.out.println(this.jugador);
         System.out.println("Carta en juego: " + String.valueOf(this.cartaEnJuego));
         boolean tieneJugadaValida = false;
         Iterator var3 = this.jugador.getMano().iterator();

         while(var3.hasNext()) {
            Carta carta = (Carta)var3.next();
            if (this.esJugadaValida(carta)) {
               tieneJugadaValida = true;
               break;
            }
         }

         if (!tieneJugadaValida) {
            System.out.println("No tienes una jugada v\u00e1lida. Robas una carta.");
            this.jugador.tomarCarta(this.baraja.robarCarta());
            this.turnoMaquina();
            return;
         }

         System.out.print("Elige una carta (\u00edndice): ");
         int indice = this.scanner.nextInt();
         if (indice >= 0 && indice < this.jugador.getMano().size()) {
            Carta cartaJugada = this.jugador.jugarCarta(indice);
            if (this.esJugadaValida(cartaJugada)) {
               this.cartaEnJuego = cartaJugada;
               System.out.println("Has jugado: " + String.valueOf(cartaJugada));
               if (!this.jugador.tieneCartas()) {
                  System.out.println("\u00a1Has ganado!");
                  return;
               }

               this.turnoMaquina();
            } else {
               System.out.println("Jugada no v\u00e1lida. Intenta de nuevo.");
               this.jugador.tomarCarta(cartaJugada);
            }
         } else {
            System.out.println("\u00cdndice no v\u00e1lido. Intenta de nuevo.");
         }
      }
   }

   private void turnoMaquina() {
      boolean tieneJugadaValida = false;
      Iterator var3 = this.maquina.getMano().iterator();

      while(var3.hasNext()) {
         Carta carta = (Carta)var3.next();
         if (this.esJugadaValida(carta)) {
            tieneJugadaValida = true;
            break;
         }
      }

      if (!tieneJugadaValida) {
         System.out.println("La m\u00e1quina no tiene una jugada v\u00e1lida. Roba una carta.");
         this.maquina.tomarCarta(this.baraja.robarCarta());
         this.turnoJugador();
      } else {
         for(int i = 0; i < this.maquina.getMano().size(); ++i) {
            Carta cartaJugada = this.maquina.jugarCarta(i);
            if (this.esJugadaValida(cartaJugada)) {
               this.cartaEnJuego = cartaJugada;
               System.out.println("La m\u00e1quina ha jugado: " + String.valueOf(cartaJugada));
               if (this.maquina.tieneCartas()) {
                  this.turnoJugador();
                  return;
               }

               System.out.println("\u00a1La m\u00e1quina ha ganado!");
               break;
            }

            this.maquina.tomarCarta(cartaJugada);
         }

      }
   }

   private boolean esJugadaValida(Carta carta) {
      if (carta.getColor() != this.cartaEnJuego.getColor() && carta.getNumero() != this.cartaEnJuego.getNumero()) {
         return carta.getTipo() == Tipo.CAMBIO_COLOR || carta.getTipo() == Tipo.MAS_CUATRO;
      } else {
         return true;
      }
   }

   public static void main(String[] args) {
      JuegoUNO juego = new JuegoUNO();
      juego.iniciarJuego();
   }
}
