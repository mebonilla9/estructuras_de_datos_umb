/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.compras.persistencia.entidades;

/**
 *
 * @author lord_nightmare
 */
public class ConceptoPedido {
  
  private Articulo articulo;
  private Pedido pedido;
  private int cantidad;

  public ConceptoPedido() {
  }

  public ConceptoPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  /**
   * @return the articulo
   */
  public Articulo getArticulo() {
    return articulo;
  }

  /**
   * @param articulo the articulo to set
   */
  public void setArticulo(Articulo articulo) {
    this.articulo = articulo;
  }

  /**
   * @return the pedido
   */
  public Pedido getPedido() {
    return pedido;
  }

  /**
   * @param pedido the pedido to set
   */
  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  /**
   * @return the cantidad
   */
  public int getCantidad() {
    return cantidad;
  }

  /**
   * @param cantidad the cantidad to set
   */
  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }
  
}
