/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.frecuenciapalabras.persistencia.gestion;

import co.appreactor.frecuenciapalabras.aplicacion.Principal;
import co.appreactor.frecuenciapalabras.negocio.constantes.EOrigen;
import co.appreactor.frecuenciapalabras.negocio.util.ConsolaUtil;
import co.appreactor.frecuenciapalabras.persistencia.entidades.Palabra;
import javax.swing.text.BadLocationException;

/**
 *
 * @author lord_nightmare
 */
public class Nodo {

  private static final int COMPARADOR = 0;
  private static final int FRECUENCIA_BASE = 1;

  private Nodo derecha;
  private Nodo izquierda;
  private Palabra palabra;

  public Nodo(String valor) {
    this.palabra = new Palabra();
    this.palabra.setValor(valor);
    this.palabra.setFrecuencia(FRECUENCIA_BASE);
  }

  /**
   * Agrega el valor nuevo a un nodo del arbol, evaluando su valor con nodos
   * existentes para colocarlo en la posicion adecuada.
   *
   * @param valor valor a agregar al nodo
   */
  public void agregar(String valor) {
    if (this.palabra.getValor().compareTo(valor) == COMPARADOR) {
      this.palabra.setFrecuencia(this.palabra.getFrecuencia() + 1);
      return;
    }
    if (this.palabra.getValor().compareTo(valor) > COMPARADOR) {
      if (this.izquierda != null) {
        this.izquierda.agregar(valor);
      } else {
        this.izquierda = new Nodo(valor);
      }
    } else if (this.palabra.getValor().compareTo(valor) < COMPARADOR) {
      if (this.derecha != null) {
        this.derecha.agregar(valor);
      } else {
        this.derecha = new Nodo(valor);
      }
    }
  }

  public void imprimirInOrden() throws BadLocationException {
    if (this.izquierda != null) {
      this.izquierda.imprimirInOrden();
    }
    ConsolaUtil.cargarMensaje(Principal.txtConsola.getStyledDocument(), EOrigen.ARBOL, this.palabra.toString());
    //System.out.println(this.palabra);
    if (this.derecha != null) {
      this.derecha.imprimirInOrden();
    }
  }

  public void imprimirPreOrden() throws BadLocationException {
    ConsolaUtil.cargarMensaje(Principal.txtConsola.getStyledDocument(), EOrigen.ARBOL, this.palabra.toString());
    //System.out.println(this.palabra);
    if (this.izquierda != null) {
      this.izquierda.imprimirPreOrden();
    }
    if (this.derecha != null) {
      this.derecha.imprimirPreOrden();
    }
  }

  public void imprimirPostOrden() throws BadLocationException {
    if (this.izquierda != null) {
      this.izquierda.imprimirPostOrden();
    }
    if (this.derecha != null) {
      this.derecha.imprimirPostOrden();
    }
    ConsolaUtil.cargarMensaje(Principal.txtConsola.getStyledDocument(), EOrigen.ARBOL, this.palabra.toString());
    //System.out.println(this.palabra);
  }

  //<editor-fold defaultstate="collapsed" desc="Encapsulamiento Get, Set">
  /**
   * @return the derecha
   */
  public Nodo getDerecha() {
    return derecha;
  }

  /**
   * @param derecha the derecha to set
   */
  public void setDerecha(Nodo derecha) {
    this.derecha = derecha;
  }

  /**
   * @return the izquierda
   */
  public Nodo getIzquierda() {
    return izquierda;
  }

  /**
   * @param izquierda the izquierda to set
   */
  public void setIzquierda(Nodo izquierda) {
    this.izquierda = izquierda;
  }

  /**
   * @return the valor
   */
  public Palabra getValor() {
    return palabra;
  }

  /**
   * @param palabra the valor to set
   */
  public void setValor(Palabra palabra) {
    this.palabra = palabra;
  }
  //</editor-fold>
}
