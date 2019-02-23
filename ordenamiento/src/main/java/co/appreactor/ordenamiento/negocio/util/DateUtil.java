/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.ordenamiento.negocio.util;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author lord_nightmare
 */
public final class DateUtil {

  /**
   * Retorna el delta del tiempo como texto para el resumen de rendimiento 
   * @param tFinal
   * @param tInicial
   * @return 
   */
  public static long obtenerTiempoSegundos(long tFinal, long tInicial) {
    long deltaTiempo = tFinal - tInicial;
    return TimeUnit.NANOSECONDS.toMillis(deltaTiempo);
  }

}