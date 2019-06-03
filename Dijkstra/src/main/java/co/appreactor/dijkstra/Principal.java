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
public class Principal {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here

    //Crear el Grafo
    GrafoDijkstra g = new GrafoDijkstra("abcdef");
    //Agregar rutas
    g.agregarRuta('a', 'b', 3);
    g.agregarRuta('a', 'e', 6);
    g.agregarRuta('a', 'f', 10);
    g.agregarRuta('b', 'c', 5);
    g.agregarRuta('b', 'e', 2);
    g.agregarRuta('c', 'd', 8);
    g.agregarRuta('c', 'e', 9);
    g.agregarRuta('c', 'f', 7);
    g.agregarRuta('d', 'f', 4);
    g.agregarRuta('e', 'f', 4);
    //Definir nodo inicial y nodo final
    char inicio = 'a';
    char fin = 'd';
    //Obtener y mostrar ruta más corta
    String respuesta = g.encontrarRutaMinimaDijkstra(inicio, fin);
    System.out.println(respuesta);
  }

}
