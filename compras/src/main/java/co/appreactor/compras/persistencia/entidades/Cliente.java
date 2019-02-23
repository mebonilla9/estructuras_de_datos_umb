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
public class Cliente {

  private int numero;
  private double descuento;
  private int saldo;
  private int limiteCredito;
  private List<Direccion> direcciones;

  public Cliente() {
  }

  public Cliente(int numero) {
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
   * @return the descuento
   */
  public double getDescuento() {
    return descuento;
  }

  /**
   * @param descuento the descuento to set
   */
  public void setDescuento(double descuento) {
    this.descuento = descuento;
  }

  /**
   * @return the saldo
   */
  public int getSaldo() {
    return saldo;
  }

  /**
   * @param saldo the saldo to set
   */
  public void setSaldo(int saldo) {
    this.saldo = saldo;
  }

  /**
   * @return the limiteCredito
   */
  public int getLimiteCredito() {
    return limiteCredito;
  }

  /**
   * @param limiteCredito the limiteCredito to set
   */
  public void setLimiteCredito(int limiteCredito) {
    this.limiteCredito = limiteCredito;
  }

  /**
   * @return the direcciones
   */
  public List<Direccion> getDirecciones() {
    return direcciones;
  }

  /**
   * @param direcciones the direcciones to set
   */
  public void setDirecciones(List<Direccion> direcciones) {
    this.direcciones = direcciones;
  }

  @Override
  public String toString() {
    return this.getNumero()+"";
  }
  
}
