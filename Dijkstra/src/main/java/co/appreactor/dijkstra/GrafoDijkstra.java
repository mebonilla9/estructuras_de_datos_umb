/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.dijkstra;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author lord_nightmare
 */
public class GrafoDijkstra {

  private char[] nodos; // Letras de identificación de nodo
  private int[][] grafo; // Matriz de distancias entre nodos
  private String rutaMasCorta; // distancia más corta
  private int longitudMasCorta = Integer.MAX_VALUE; // ruta más corta
  private List<Nodo> listos = null; // nodos revisados Dijkstra

  // construye el grafo con la serie de identificadores
  public GrafoDijkstra(String serieNodos) {
    nodos = serieNodos.toCharArray();
    grafo = new int[nodos.length][nodos.length];
  }

  // asigna el tamaño de la arista entre dos nodos
  public void agregarRuta(char origen, char destino, int distancia) {
    int n1 = posicionNodo(origen);
    int n2 = posicionNodo(destino);
    grafo[n1][n2] = distancia;
    grafo[n2][n1] = distancia;
  }

  // encuentra la ruta más corta desde un nodo origen a un nodo destino
  public String encontrarRutaMinimaDijkstra(char inicio, char fin) {
    // calcula la ruta más corta del inicio a los demás 
    encontrarRutaMinimaDijkstra(inicio);
    // recupera el nodo final de la lista de terminados 
    Nodo tmp = new Nodo(fin);
    if (!listos.contains(tmp)) {
      System.out.println("Error, nodo no alcanzable");
      return "Chaooooo....";
    }
    tmp = listos.get(listos.indexOf(tmp));
    int distancia = tmp.distancia;
    // crea una pila para almacenar la ruta desde el nodo final al origen 
    Stack<Nodo> pila = new Stack<Nodo>();
    while (tmp != null) {
      pila.add(tmp);
      tmp = tmp.procedencia;
    }
    String ruta = "";
    // recorre la pila para armar la ruta en el orden correcto 
    while (!pila.isEmpty()) {
      ruta += (pila.pop().id + " ");
    }
    return distancia + " : " + ruta;
  }

  // retorna la posición en el arreglo de un nodo específico
  private int posicionNodo(char nodo) {
    for (int i = 0; i < nodos.length; i++) {
      if (nodos[i] == nodo) {
        return i;
      }
    }
    return -1;
  }

  // encuentra la ruta más corta desde el nodo inicial a todos los demás
  public void encontrarRutaMinimaDijkstra(char inicio) {
    Queue<Nodo> cola = new PriorityQueue<Nodo>(); // cola de prioridad
    Nodo ni = new Nodo(inicio);// nodo inicial
    listos = new LinkedList<Nodo>(); // lista de nodos ya revisados
    cola.add(ni); // Agregar nodo inicial a la cola de prioridad
    while (!cola.isEmpty()) { // mientras que la cola no esta vacia
      Nodo tmp = cola.poll(); // saca el primer elemento
      listos.add(tmp);// lo manda a la lista de terminados
      int p = posicionNodo(tmp.id);
      for (int j = 0; j < grafo[p].length; j++) { // revisa los nodos hijos del nodo tmp
        if (grafo[p][j] == 0) { // si no hay conexión no lo evalua
          continue;
        }
        if (estaTerminado(j)) { // si ya fue agregado a la lista de terminados
          continue;
        }
        Nodo nod = new Nodo(nodos[j], tmp.distancia + grafo[p][j], tmp); // si no está en la cola de prioridad, lo agrega
        if (!cola.contains(nod)) {
          cola.add(nod);
          continue;
        }
        // si ya está en la cola de prioridad actualiza la distancia menor 
        for (Nodo x : cola) {
          if (x.id == nod.id && x.distancia > nod.distancia) {
            // si la distancia en la cola es mayor que la distancia calculada 
            cola.remove(x); // remueve el nodo de la cola
            cola.add(nod); // agrega el nodo con la nueva distancia
            break; // no sigue revisando
          }
        }
      }
    }
  }

  // verifica si un nodo ya está en lista de terminados
  public boolean estaTerminado(int j) {
    Nodo tmp = new Nodo(nodos[j]);
    return listos.contains(tmp);
  }
}
