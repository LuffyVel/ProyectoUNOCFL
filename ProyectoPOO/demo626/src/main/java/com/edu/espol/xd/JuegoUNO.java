package com.edu.espol.xd;

public class JuegoUNO {
   private Baraja baraja;
   private Jugador jugador;
   private Jugador maquina;
   private Carta cartaEnJuego;
   private boolean turno;

   public JuegoUNO() {
      this.baraja = new Baraja();
      this.jugador = new Jugador("Jugador");
      this.maquina = new Jugador("Máquina");
      this.turno = true;
   }

   public void iniciarJuego() {
      for(int i = 0; i < 7; ++i) {
         jugador.tomarCarta(baraja);
         maquina.tomarCarta(baraja);
      }

      cartaEnJuego = baraja.robarCarta();
      while (cartaEnJuego.esComodin()){
         baraja.devolverCarta(cartaEnJuego);
         cartaEnJuego = baraja.robarCarta();
      }
   //    for(this.cartaEnJuego = this.baraja.robarCarta(); this.cartaEnJuego.getTipo() != Tipo.NUMERO; this.cartaEnJuego = this.baraja.robarCarta()) {
   //       this.baraja.devolverCarta(this.cartaEnJuego);
   //    }

   //    System.out.println("Carta inicial: " + String.valueOf(this.cartaEnJuego));
   //    this.turnoJugador();
      mostrarEstadoJuego();
   }
   public void tomarCarta(Jugador jugador) {
      jugador.tomarCarta(baraja);
   }

   public boolean validarJugada(Carta carta, Jugador jugador) {
      return carta.getColor() == cartaEnJuego.getColor() || carta.getTipo() == cartaEnJuego.getTipo() || carta.getColor() == Color.NEGRO;
   }

   public void cambiarTurno() {
        turno = !turno;
   }

   public void mostrarEstadoJuego() {
        InterfazUser.mostrarMensaje("Carta actual: " + cartaEnJuego);
        InterfazUser.mostrarMano(jugador);
   }
   public void jugar() {
   while (jugador.tieneCartas() && maquina.tieneCartas()) {
      if (turno) {
         int cartaIndice = Integer.parseInt(InterfazUser.solicitarInput("Seleccione la carta a jugar (índice): "));
         Carta carta = jugador.getMano().obtenerCarta(cartaIndice);
         if (validarJugada(carta, jugador)) {
               cartaEnJuego = jugador.jugarCarta(cartaIndice);
               mostrarEstadoJuego();
               if (jugador.getMano().getCartas().size() == 1) {
                  InterfazUser.mostrarMensaje("UNO!");
               } 

               cambiarTurno();
         } 
         else {
               InterfazUser.mostrarMensaje("Jugada inválida. Intente de nuevo.");
         }
      } 
      else {
         for (int i = 0; i < maquina.getMano().getCartas().size(); i++) {
               Carta carta = maquina.getMano().obtenerCarta(i);
               if (validarJugada(carta, maquina)) {
                  cartaEnJuego = maquina.jugarCarta(i);
               }
         }

         if (maquina.getMano().getCartas().size() == 1) {
               InterfazUser.mostrarMensaje("UNO! Máquina");
         } 
         cambiarTurno();
      }
   }
   if(!jugador.tieneCartas()){
      InterfazUser.mostrarMensaje("¡Jugador gana!");
   }
   else if (!maquina.tieneCartas()){
      InterfazUser.mostrarMensaje("¡Máquina gana!");
   }
}
   // private void turnoJugador() {
   //    while(true) {
   //       System.out.println(this.jugador);
   //       System.out.println("Carta en juego: " + String.valueOf(this.cartaEnJuego));
   //       boolean tieneJugadaValida = false;
   //       Iterator var3 = this.jugador.getMano().iterator();

   //       while(var3.hasNext()) {
   //          Carta carta = (Carta)var3.next();
   //          if (this.esJugadaValida(carta)) {
   //             tieneJugadaValida = true;
   //             break;
   //          }
   //       }

   //       if (!tieneJugadaValida) {
   //          System.out.println("No tienes una jugada v\u00e1lida. Robas una carta.");
   //          this.jugador.tomarCarta(this.baraja.robarCarta());
   //          this.turnoMaquina();
   //          return;
   //       }

   //       System.out.print("Elige una carta (\u00edndice): ");
   //       int indice = this.scanner.nextInt();
   //       if (indice >= 0 && indice < this.jugador.getMano().size()) {
   //          Carta cartaJugada = this.jugador.jugarCarta(indice);
   //          if (this.esJugadaValida(cartaJugada)) {
   //             this.cartaEnJuego = cartaJugada;
   //             System.out.println("Has jugado: " + String.valueOf(cartaJugada));
   //             if (!this.jugador.tieneCartas()) {
   //                System.out.println("\u00a1Has ganado!");
   //                return;
   //             }

   //             this.turnoMaquina();
   //          } else {
   //             System.out.println("Jugada no v\u00e1lida. Intenta de nuevo.");
   //             this.jugador.tomarCarta(cartaJugada);
   //          }
   //       } else {
   //          System.out.println("\u00cdndice no v\u00e1lido. Intenta de nuevo.");
   //       }
   //    }
   // }

   // private void turnoMaquina() {
   //    boolean tieneJugadaValida = false;
   //    Iterator var3 = this.maquina.getMano().iterator();

   //    while(var3.hasNext()) {
   //       Carta carta = (Carta)var3.next();
   //       if (this.esJugadaValida(carta)) {
   //          tieneJugadaValida = true;
   //          break;
   //       }
   //    }

   //    if (!tieneJugadaValida) {
   //       System.out.println("La m\u00e1quina no tiene una jugada v\u00e1lida. Roba una carta.");
   //       this.maquina.tomarCarta(this.baraja.robarCarta());
   //       this.turnoJugador();
   //    } else {
   //       for(int i = 0; i < this.maquina.getMano().size(); ++i) {
   //          Carta cartaJugada = this.maquina.jugarCarta(i);
   //          if (this.esJugadaValida(cartaJugada)) {
   //             this.cartaEnJuego = cartaJugada;
   //             System.out.println("La m\u00e1quina ha jugado: " + String.valueOf(cartaJugada));
   //             if (this.maquina.tieneCartas()) {
   //                this.turnoJugador();
   //                return;
   //             }

   //             System.out.println("\u00a1La m\u00e1quina ha ganado!");
   //             break;
   //          }

   //          this.maquina.tomarCarta(cartaJugada);
   //       }

   //    }
   // }

   // private boolean esJugadaValida(Carta carta) {
   //    if (carta.getColor() != this.cartaEnJuego.getColor() && carta.getNumero() != this.cartaEnJuego.getNumero()) {
   //       return carta.getTipo() == Tipo.CAMBIO_COLOR || carta.getTipo() == Tipo.MAS_CUATRO;
   //    } else {
   //       return true;
   //    }
   // }

   public static void main(String[] args) {
      JuegoUNO juego = new JuegoUNO();
      juego.iniciarJuego();
      juego.jugar();
   }
}


//:D