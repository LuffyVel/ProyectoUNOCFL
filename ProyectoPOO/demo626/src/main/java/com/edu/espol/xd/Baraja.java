package com.edu.espol.xd;

// import com.edu.espol.xd.Carta.Color;
// import com.edu.espol.xd.Carta.Tipo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {
   private List<Carta> cartas;

   public Baraja() {
      cartas = new ArrayList<>();
      inicializarBaraja();
      barajar();
   }

   private void inicializarBaraja() {
      // Carta.Color[] var4;
      // int var3 = (var4 = Color.values()).length;

      // for(int var2 = 0; var2 < var3; ++var2) {
      //    Carta.Color color = var4[var2];
      //    if (color != Color.NEGRO) {
      //       for(int i = 0; i <= 9; ++i) {
      //          this.cartas.add(new Carta(color, Tipo.NUMERO, i));
      //          if (i != 0) {
      //             this.cartas.add(new Carta(color, Tipo.NUMERO, i));
      //          }
      //       }

      //       this.cartas.add(new Carta(color, Tipo.REVERSE));
      //       this.cartas.add(new Carta(color, Tipo.REVERSE));
      //       this.cartas.add(new Carta(color, Tipo.BLOQUEO));
      //       this.cartas.add(new Carta(color, Tipo.BLOQUEO));
      //       this.cartas.add(new Carta(color, Tipo.MAS_DOS));
      //       this.cartas.add(new Carta(color, Tipo.MAS_DOS));
      //    }
      // }
      for (Color color : Color.values()){
         for(Tipo tipo : Tipo.values()){
            cartas.add(new Carta(color, tipo));
         }
      }
      for(int i = 0; i < 4; ++i) {
         this.cartas.add(new Carta(Color.NEGRO, Tipo.MAS_CUATRO));
         this.cartas.add(new Carta(Color.NEGRO, Tipo.CAMBIO_DE_COLOR));
      }

   }

   public void barajar() {
        Collections.shuffle(cartas);
   }

   public Carta robarCarta() {
      return cartas.remove(cartas.size() - 1);
   }

   public void devolverCarta(Carta carta) {
      cartas.add(0, carta);
   }
}