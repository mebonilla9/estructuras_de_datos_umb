/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.ordenamiento.negocio.ejecucion;

import co.appreactor.ordenamiento.negocio.constantes.ECantidades;
import co.appreactor.ordenamiento.persistencia.orden.SuperOrdenador;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author lord_nightmare
 */
public class Principal {

  private final BufferedReader lector;

  public Principal() {
    lector = new BufferedReader(
      new InputStreamReader(
        System.in
      )
    );
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    try {
      new Principal().iniciar();
    } catch (IOException ex) {
      System.out.println("Error en la captura de valores, reiniciar el programa");
    }
  }

  /**
   * Base de inicio del programa
   *
   * @throws IOException
   */
  public void iniciar() throws IOException {
    int opcion = -1;
    while (opcion != 0) {
      opcion = menu();
      switch (opcion) {
        case 1:
          ordenar();
          break;
        case 0:
          System.out.println("Gracias por usar nuestro Poderosisismo Software... Adios!");
          break;
        default:
          System.out.println("Opcion incorrecta, intente nuevamente;");
          opcion = -1;
          break;
      }
    }
  }

  private void ordenar() throws IOException {
    int longitud = elegirLongitud();

    Integer[] arregloOriginal = new Integer[longitud];
    this.cargarArreglo(arregloOriginal, longitud);

    System.out.println("Información del arreglo original");
    //this.mostrarArreglo(arregloOriginal);

    /**
     * Resumen para ordenamiento burbuja
     */
    //new SuperOrdenador(arregloOriginal.clone(), this).ordenBurbuja();
    
    /**
     * Resumen para ordenamiento shell
     */
    //new SuperOrdenador(arregloOriginal.clone(), this).ordenShell();
    
    /**
     * Resumen para ordenamiento quick
     */
    new SuperOrdenador(arregloOriginal.clone(), this).ordenQuickSort();
    
  }

  /**
   * Determina la longitud del arreglo de numeros aleatorios a ordenar
   *
   * @return valor en numeros enteros de la longitud para el arreglo
   * @throws IOException
   */
  private int elegirLongitud() throws IOException {
    int longitud = 0;
    System.out.println("Elija la longitud del arreglo");
    System.out.println("1. " + ECantidades.PRIMERO);
    System.out.println("2. " + ECantidades.SEGUNDO);
    System.out.println("3. " + ECantidades.TERCERO);
    System.out.println("4. " + ECantidades.CUARTO);
    System.out.println("5. " + ECantidades.QUINTO);
    System.out.println("6. " + ECantidades.SEXTO);
    System.out.println("7. " + ECantidades.SEPTIMO);
    int opcion = Integer.parseInt(lector.readLine().charAt(0) + "");
    switch (opcion) {
      case 1:
        longitud = ECantidades.PRIMERO;
        break;
      case 2:
        longitud = ECantidades.SEGUNDO;
        break;
      case 3:
        longitud = ECantidades.TERCERO;
        break;
      case 4:
        longitud = ECantidades.CUARTO;
        break;
      case 5:
        longitud = ECantidades.QUINTO;
        break;
      case 6:
        longitud = ECantidades.SEXTO;
        break;
      case 7:
        longitud = ECantidades.SEPTIMO;
        break;
      default:
        System.out.println("Opcion invalida, intente nuevamente");
        longitud = elegirLongitud();
    }
    return longitud;
  }

  private void cargarArreglo(Integer[] arreglo, int longitud) {
    for (int i = 0; i < arreglo.length; i++) {
      arreglo[i] = (int) (Math.random() * longitud + 1);
    }
  }

  private void mostrarArreglo(Integer[] arreglo) {
    for (int i = 0; i < arreglo.length; i++) {
      System.out.print(arreglo[i] + ",");
    }
    System.out.println("");
  }
  
  public void mostrarArregloParcial(Integer[] arreglo) {
    for (int i = 0; i < 100; i++) {
      System.out.print(arreglo[i] + ",");
    }
    System.out.print(" ... ");
    for (int i = (arreglo.length -1)-100; i < arreglo.length; i++) {
      System.out.print(arreglo[i] + ",");
    }
    System.out.println("");
  }

  private int menu() throws IOException {
    System.out.println("Bienvenido al generador de ordenamiento, Elija una opcion");
    System.out.println("1. Ordenar");
    System.out.println("0. Salir");
    return Integer.parseInt(lector.readLine().charAt(0) + "");
  }

}
