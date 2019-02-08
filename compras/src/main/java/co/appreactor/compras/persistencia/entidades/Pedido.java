/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.compras.persistencia.entidades;

import java.util.Date;
import java.util.List;

/**
 *
 * @author lord_nightmare
 */
public class Pedido {

  private int numero;
  private Date fecha;
  private Direccion direccion;
  private Cliente cliente;
  private List<ConceptoPedido> cuerpo;

  public Pedido() {
  }

  public Pedido(int numero) {
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

  /**
   * @return the direccion
   */
  public Direccion getDireccion() {
    return direccion;
  }

  /**
   * @param direccion the direccion to set
   */
  public void setDireccion(Direccion direccion) {
    this.direccion = direccion;
  }

  /**
   * @return the cliente
   */
  public Cliente getCliente() {
    return cliente;
  }

  /**
   * @param cliente the cliente to set
   */
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  /**
   * @return the cuerpo
   */
  public List<ConceptoPedido> getCuerpo() {
    return cuerpo;
  }

  /**
   * @param cuerpo the cuerpo to set
   */
  public void setCuerpo(List<ConceptoPedido> cuerpo) {
    this.cuerpo = cuerpo;
  }
  
  
}
