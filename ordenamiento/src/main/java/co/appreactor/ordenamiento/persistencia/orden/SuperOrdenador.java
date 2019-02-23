/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.ordenamiento.persistencia.orden;

import co.appreactor.ordenamiento.negocio.constantes.ETipoOrden;
import co.appreactor.ordenamiento.negocio.ejecucion.Principal;
import co.appreactor.ordenamiento.negocio.util.DateUtil;
import co.appreactor.ordenamiento.persistencia.orden.ordenes.BubbleSort;
import co.appreactor.ordenamiento.persistencia.orden.ordenes.QuickSort;
import co.appreactor.ordenamiento.persistencia.orden.ordenes.ShellSort;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lord_nightmare
 */
public final class SuperOrdenador {

  private final Integer[] arreglo;
  private final Principal principal;

  public SuperOrdenador(Integer[] arreglo, Principal principal) {
    this.arreglo = arreglo;
    this.principal = principal;
  }

  /**
   * Ordena por metodo burbuja un arreglo de numeros enteros con una longitud
   * definida, adicional a esto imprime el tiempo que le tardo procesar el
   * ordenamiento
   */
  public void ordenBurbuja() {
    long tInicial = System.nanoTime();
    Integer[] sort = BubbleSort.sort(this.arreglo);
    long tfinal = System.nanoTime();
    System.out.println(mostrarResumen(tfinal, tInicial, ETipoOrden.BURBUJA));
    this.principal.mostrarArregloParcial(arreglo);
  }

  /**
   * Ordena por metodo shell un arreglo de numeros enteros con una longitud
   * definida, adicional a esto imprime el tiempo que le tardo procesar el
   * ordenamiento
   */
  public void ordenShell() {
    long tInicial = System.nanoTime();
    Integer[] sort = ShellSort.sort(obtenerSaltos(), this.arreglo.clone());
    long tfinal = System.nanoTime();
    System.out.println(mostrarResumen(tfinal, tInicial, ETipoOrden.SHELL));
    this.principal.mostrarArregloParcial(sort);
  }

  /**
   * Ordena por metodo quick un arreglo de numeros enteros con una longitud
   * definida, adicional a esto imprime el tiempo que le tardo procesar el
   * ordenamiento
   */
  public void ordenQuickSort() {
    long tInicial = System.nanoTime();
    Integer[] sort = QuickSort.sort(QuickSort.PIVOT_TYPE.MIDDLE, arreglo);
    long tfinal = System.nanoTime();
    System.out.println(mostrarResumen(tfinal, tInicial, ETipoOrden.QUICK));
    this.principal.mostrarArregloParcial(sort);
  }

  private String mostrarResumen(long tFinal, long tInicial, ETipoOrden tipoOrden) {
    StringBuilder sb = new StringBuilder();
    sb.append("Ejecucion para un arreglo de ")
      .append(this.arreglo.length)
      .append(".")
      .append("\n")
      .append("Tiempo que tardo en ordenarlo: ")
      .append(DateUtil.obtenerTiempoSegundos(tFinal, tInicial)/1000.0)
      .append("seg. \n")
      .append("Utilizando el ordenamiento: ")
      .append(tipoOrden)
      .append("\n");
    return sb.toString();
  }
  
  private int[] obtenerSaltos(){
    List<Integer> saltos = new ArrayList<>();
    int tamano = arreglo.length;
    while (tamano > 1) {
      saltos.add(tamano /= 2);
    }
    //saltos.remove(saltos.size()-1);
    Object[] valores = saltos.toArray();
    int[] numeros = new int[valores.length];
    for (int i = 0; i < valores.length; i++) {
      numeros[i] = (Integer)valores[i];
    }
    return numeros;
  }

}
