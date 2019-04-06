package co.appreactor.listas.persistencia.entidades;

import java.time.LocalDate;

public class Persona {

  private int id;
  private String nombre;
  private LocalDate fechaNac;

  public Persona(int id, String nombre, LocalDate fechaNac) {
    this.id = id;
    this.nombre = nombre;
    this.fechaNac = fechaNac;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public LocalDate getFechaNac() {
    return fechaNac;
  }

  public void setFechaNac(LocalDate fechaNac) {
    this.fechaNac = fechaNac;
  }

  @Override
  public String toString() {
    return this.nombre + " Nacido el: "+this.fechaNac.toString() +"\n";
  }
}
