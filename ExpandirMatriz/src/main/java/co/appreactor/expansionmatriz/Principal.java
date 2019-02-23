package co.appreactor.expansionmatriz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {

  private BufferedReader lector;

  public Principal() {
    lector = new BufferedReader(new InputStreamReader(System.in));
  }

  public static void main(String... args) {
    try {
      new Principal().iniciar();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void iniciar() throws IOException {
    System.out.println("Elegir la dimensión de la matriz");
    int dimen = Integer.parseInt(lector.readLine());
    int desDimen = (int) Math.pow(dimen, 2);

    int[][] origen = new int[dimen][dimen];
    int[][] destino = new int[desDimen][desDimen];

    cargarOrigen(origen);
    mostrarMatriz(origen);

    for (int i = 0; i < origen.length; i++) {
      for (int j = 0; j < origen[i].length; j++) {
        replicarValor(i, j, origen[i][j], origen.length, destino);
      }
    }

    mostrarMatriz(destino);

  }

  private void replicarValor(int x, int y, int valor, int longitud, int[][] destino) {
    for (int i = 0; i < longitud; i++) {
      for (int j = 0; j < longitud; j++) {
        destino[i + (x * longitud)][j + (y * longitud)] = valor;
      }
    }
  }

  private void cargarOrigen(int[][] origen) {
    int contador = 0;
    for (int i = 0; i < origen.length; i++) {
      for (int j = 0; j < origen[i].length; j++) {
        origen[i][j] = ++contador;
      }
    }
  }

  private void mostrarMatriz(int[][] matriz) {
    for (int i = 0; i < matriz.length; i++) {
      for (int j = 0; j < matriz[i].length; j++) {
        System.out.print(matriz[i][j] + " ");
      }
      System.out.println();
    }
  }

}
