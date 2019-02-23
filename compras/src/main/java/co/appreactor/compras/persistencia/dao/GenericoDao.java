/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.compras.persistencia.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lord_nightmare
 */
public class GenericoDao<T> {

  protected String nombreArchivo;

  private final String rutaBase = System.getProperty("user.home") + File.separator + "/compras" + File.separator;

  public GenericoDao() {
    File archivo = new File(rutaBase);
    if (!archivo.exists()) {
      archivo.mkdirs();
    }
  }

  public List<T> leer() {
    List<T> lista = new ArrayList<>();
    try {
      BufferedReader br = new BufferedReader(
        new InputStreamReader(
          new FileInputStream(
            rutaBase + nombreArchivo
          )
        )
      );

      StringBuilder contenido = new StringBuilder();
      while (br.ready()) {
        contenido.append(br.readLine());
      }

      Type tipoDato = new TypeToken<List<T>>() {
      }.getType();
      lista = new Gson().fromJson(contenido.toString(), tipoDato);
      return new ArrayList<>();
    } catch (IOException e) {
      e.printStackTrace(System.err);
    }
    return lista;
  }

  /**
   * Guarda la informacion almacenada en estructuras de datos a un archivo plano
   * con formato JSON
   *
   * @param datos Lista de items que provienen de las estructuras de datos de la
   * aplicacion
   */
  public void escribir(List<T> datos) {
    try {
      PrintStream ps = new PrintStream(rutaBase + nombreArchivo);
      ps.print(new Gson().toJson(datos));
      ps.flush();
      ps.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace(System.err);
    }
  }

}
