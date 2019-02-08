/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.compras.persistencia.entidades;

import java.util.List;

/**
 *
 * @author lord_nightmare
 */
public class Articulo {
  private int numero;
  private List<Fabrica> fabricas;
  private int existencias;
  private String descripcion;

  public Articulo() {
  }

  public Articulo(int numero) {
    this.numero = numero;
  }

  /**
   * @return the numero
   */
  public int getNumero() {
    return numero;
  }

  /**
   * @param numero the numero to set
   */
  public void setNumero(int numero) {
    this.numero = numero;
  }

  /**
   * @return the fabricas
   */
  public List<Fabrica> getFabricas() {
    return fabricas;
  }

  /**
   * @param fabricas the fabricas to set
   */
  public void setFabricas(List<Fabrica> fabricas) {
    this.fabricas = fabricas;
  }

  /**
   * @return the existencias
   */
  public int getExistencias() {
    return existencias;
  }

  /**
   * @param existencias the existencias to set
   */
  public void setExistencias(int existencias) {
    this.existencias = existencias;
  }

  /**
   * @return the descripcion
   */
  public String getDescripcion() {
    return descripcion;
  }

  /**
   * @param descripcion the descripcion to set
   */
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
  
  
}
