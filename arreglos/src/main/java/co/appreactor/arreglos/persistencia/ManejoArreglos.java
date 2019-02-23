/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.arreglos.persistencia;

import java.util.Arrays;

/**
 * Clase encargada de realizar la manipulacion de un arreglo unidimensional
 *
 * @author lord_nightmare
 */
public class ManejoArreglos {

  /**
   * Arreglo a manipular
   */
  private final int[] datos;

  public ManejoArreglos(int[] datos) {
    this.datos = datos;
  }

  /**
   * Metodo que realiza la suma de todos los valores almacenados en las
   * posiciones del arreglo
   *
   * @return sumatoria de los valores de las posiciones del arreglo
   */
  public int sumatoria() {
    int rSuma = 0;
    for (int i = 0; i < datos.length; i++) {
      rSuma += datos[i];
    }
    return rSuma;
  }

  /**
   * Metodo que se encarga de realizar el promedio de los valores que se
   * encuentran en el arreglo apoyandose en el metodo sumatoria para realizar la
   * mitad del proceso
   *
   * @return
   */
  public int promedio() {
    return sumatoria() / datos.length;
  }

  /**
   * Retorna el menor valor del arreglo despues de realizar el ordenamiento del
   * mismo en forma ascendente.
   *
   * El ordenamiento se realiza utilizando el api de <code>Arrays</code> de Java
   * 8
   *
   * @return valor menor del arreglo
   */
  public int menorValor() {
    Arrays.sort(datos);
    return datos[0];
  }

  /**
   * Retorna el mayor valor del arreglo despues de realizar el ordenamiento del
   * mismo en forma ascendente.
   *
   * El ordenamiento se realiza utilizando el api de <code>Arrays</code> de Java
   * 8
   *
   * @return valor menor del arreglo
   */
  public int mayorValor() {
    Arrays.sort(datos);
    return datos[datos.length - 1];
  }

  /**
   * Retorna a modo de cadena de caracteres la lista separada por coma los valores
   * del arreglo que son pares
   * 
   * @return <code>String</code> cadena de caracteres con los numeros pares
   */
  public String numerosPares() {
    Arrays.sort(datos);
    String nPares = "";
    for (int i = 0; i < datos.length; i++) {
      if ((datos[i] % 2) == 0) {
        nPares += datos[i] + ",";
      }
    }
    return nPares.substring(0, nPares.length() - 2);
  }
  
  /**
   * Retorna a modo de cadena de caracteres la lista separada por coma los valores
   * del arreglo que son impares
   * 
   * @return <code>String</code> cadena de caracteres con los numeros impares
   */
  public String numerosImpares() {
    Arrays.sort(datos);
    String nImpares = "";
    for (int i = 0; i < datos.length; i++) {
      if ((datos[i] % 2) != 0) {
        nImpares += datos[i] + ",";
      }
    }
    return nImpares.substring(0, nImpares.length() - 2);
  }

}
