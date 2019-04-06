/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.frecuenciapalabras.persistencia.entidades;

/**
 *
 * @author lord_nightmare
 */
public class Palabra {

  private String valor;
  private int frecuencia;

  /**
   * @return the valor
   */
  public String getValor() {
    return valor;
  }

  /**
   * @param valor the valor to set
   */
  public void setValor(String valor) {
    this.valor = valor;
  }

  /**
   * @return the frecuencia
   */
  public int getFrecuencia() {
    return frecuencia;
  }

  /**
   * @param frecuencia the frecuencia to set
   */
  public void setFrecuencia(int frecuencia) {
    this.frecuencia = frecuencia;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Palabra: ")
      .append(this.valor)
      .append(" | ")
      .append("Frecuencia: ")
      .append(this.frecuencia)
      .append("\n-------------\n");
    return sb.toString();
  }

}
