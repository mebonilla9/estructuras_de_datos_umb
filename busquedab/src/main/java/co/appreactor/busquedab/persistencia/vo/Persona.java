
package co.appreactor.busquedab.persistencia.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @author Manuel Ernesto Bonilla Muñoz
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Persona implements Serializable {

  private Long id;
  private String nombre;
  private String cedula;
  private Long salario;


  public Persona() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCedula() {
    return cedula;
  }

  public void setCedula(String cedula) {
    this.cedula = cedula;
  }

  public Long getSalario() {
    return salario;
  }

  public void setSalario(Long salario) {
    this.salario = salario;
  }


}

