package co.appreactor.listas.negocio.ejecucion;

import co.appreactor.listas.persistencia.entidades.Lista;
import co.appreactor.listas.persistencia.entidades.Nodo;
import co.appreactor.listas.persistencia.entidades.Persona;

import java.time.LocalDate;

public class Principal {

  public static void main(String... args){
    new Principal().iniciar();
  }

  private void iniciar() {
    Lista<Persona> listaPersonas = new Lista<>();

    Nodo<Persona> nodPer1 = new Nodo<>(
      new Persona(
        1,
        "Boris Anacleto",
        LocalDate.parse("1990-10-21")
      )
    );
    listaPersonas.agregarAlInicio(nodPer1);
    System.out.println("Tamaño lista: "+listaPersonas.getTamano());

    Nodo<Persona> nodPer2 = new Nodo<>(
      new Persona(
        2,
        "Gilma Perez",
        LocalDate.parse("1970-02-12")
      )
    );
    listaPersonas.agregarAlInicio(nodPer2);
    System.out.println("Tamaño lista: "+listaPersonas.getTamano());

    Nodo<Persona> nodPer3 = new Nodo<>(
      new Persona(
        3,
        "Marcos Lopez",
        LocalDate.parse("1992-01-10")
      )
    );
    listaPersonas.agregarAlInicio(nodPer3);
    System.out.println("Tamaño lista: "+listaPersonas.getTamano());

    Nodo<Persona> nodPer4 = new Nodo<>(
      new Persona(
        4,
        "Maria Vega",
        LocalDate.parse("1962-07-28")
      )
    );
    listaPersonas.agregarAlFinal(nodPer4);
    System.out.println("Tamaño lista: "+listaPersonas.getTamano());

    listaPersonas.imprimirLista(null);
  }
}
