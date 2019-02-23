/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.compras.persistencia.entidades;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lord_nightmare
 */
public class Entidad {
  
  /**
   * Retorna en forma de un arreglo los nombres de los campos para ser implementados
   * en un <code>JTable</code>
   * @return Arreglo con los nombres de los campos de la entidad
   */
  public Object[] nombresAtributos(){
    List<String> atributosPrivados = new ArrayList<>();
    
    Field[] atributos = this.getClass().getDeclaredFields();
    
    for (Field atributo : atributos) {
      if (Modifier.isPrivate(atributo.getModifiers())) {
        atributosPrivados.add(atributo.getName());
      }
    }
    
    return atributosPrivados.toArray();
  }
  
  
}
