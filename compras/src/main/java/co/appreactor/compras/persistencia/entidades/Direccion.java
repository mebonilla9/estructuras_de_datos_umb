/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.compras.persistencia.entidades;

import java.util.Date;

/**
 *
 * @author lord_nightmare
 */
public class Direccion {

  private int numero;
  private String calle;
  private String comuna;
  private String ciudad;
  private Date fecha;

  public Direccion() {
  }

  public Direccion(int numero) {
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
   * @return the calle
   */
  public String getCalle() {
    return calle;
  }

  /**
   * @param calle the calle to set
   */
  public void setCalle(String calle) {
    this.calle = calle;
  }

  /**
   * @return the comuna
   */
  public String getComuna() {
    return comuna;
  }

  /**
   * @param comuna the comuna to set
   */
  public void setComuna(String comuna) {
    this.comuna = comuna;
  }

  /**
   * @return the ciudad
   */
  public String getCiudad() {
    return ciudad;
  }

  /**
   * @param ciudad the ciudad to set
   */
  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  /**
   * @return the fecha
   */
  public Date getFecha() {
    return fecha;
  }

  /**
   * @param fecha the fecha to set
   */
  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  @Override
  public String toString() {
    return this.getCalle() + " - " + this.getNumero() + " - " + this.getCiudad();
  }

}
