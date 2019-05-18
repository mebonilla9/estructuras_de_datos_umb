/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.dijkstra;

/**
 *
 * @author lord_nightmare
 */
public class Nodo implements Comparable<Nodo> {

  private char id;
  private int distancia = Integer.MAX_VALUE;
  private Nodo procedencia;

  public Nodo(char id, int distancia, Nodo nodo){
    this.id= id;
    this.distancia = distancia;
    this.procedencia = nodo;
  }
  
  public Nodo(char id){
    this(id, 0, null);
  }
  
  @Override
  public int compareTo(Nodo nodo) {
    return this.distancia - nodo.distancia;
  }

  @Override
  public boolean equals(Object obj) {
    Nodo temporal = (Nodo) obj;
    return temporal.id == this.id;
  }

}
