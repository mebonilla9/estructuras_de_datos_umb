/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author lord_nightmare
 */
public class Principal {

  /**
   * @param args the command line arguments
   */
  //declaracion de la tabla
  private static int[][] warshall;
  private static int n = 0;
  private static final BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) {

    System.out.print("Ingrese n (tamaño de la matriz n X n) :");
    try {
      n = Integer.parseInt(leer.readLine());
    } catch (IOException | NumberFormatException e) {
    }
    int dato = 0;
    warshall = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.println("Inserte la componente W(" + i + ")(" + j + ")");
        try {
          dato = Integer.parseInt(leer.readLine());
        } catch (Exception e) {
        }
        warshall[i][j] = dato;
      }
    }

    for (int k = 0; k <= n - 1; k++) {
      for (int i = 0; i <= n - 1; i++) {
        for (int j = 0; j <= n - 1; j++) {
          warshall[i][j] = funcionwar(i, j, k);
        }
      }
    }
    
    System.out.println();
    System.out.println();
    System.out.println("Matriz de adyacencia correspondiente: ");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(warshall[i][j]);
      }
      System.out.println();
    }
  }

  public static int funcionwar(int i, int j, int k) {
    if ((warshall[i][j] == 1) || ((warshall[i][k] == 1) && (warshall[k][j] == 1))) {
      return 1;
    } else {
      return 0;
    }
  }

  public static void algoritmo() {
    Principal w = new Principal();
    w.algoritmo();
  }

}
