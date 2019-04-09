/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.frecuenciapalabras.negocio.servicio;

import co.appreactor.frecuenciapalabras.negocio.constantes.EOrigen;
import co.appreactor.frecuenciapalabras.negocio.util.ConsolaUtil;
import co.appreactor.frecuenciapalabras.persistencia.gestion.Nodo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

/**
 *
 * @author lord_nightmare
 */
public class ArbolServicio {

  private final JTextPane txtConsola;
  private final File archivo;
  private Nodo arbolPalabras;

  public ArbolServicio(JTextPane txtConsola, File archivo) {
    this.txtConsola = txtConsola;
    this.archivo = archivo;
  }

  public void procesarTexto() throws IOException, BadLocationException {
    ConsolaUtil.cargarMensaje(txtConsola.getStyledDocument(), EOrigen.PRESENTACION, "Inicia el procesamiento del texto");
    BufferedReader lector = new BufferedReader(
      new InputStreamReader(
        new FileInputStream(
          archivo
        )
      )
    );
    while (lector.ready()) {
      String[] palabras = preProcesarTexto(lector.readLine()).split(" ");
      cargarEnArbol(palabras);
    }
    lector.close();
    ConsolaUtil.cargarMensaje(txtConsola.getStyledDocument(), EOrigen.PRESENTACION, "Procesamiento del texto finalizado");
  }

  private String preProcesarTexto(String linea) {
    String lineaPreProcesada = linea.replace(".", "")
      .replace(",", "").replace(";", "").replace(":", "")
      .replace(".", "").replace("\\?", "").replace("?", "")
      .replace("!", "").replace("¿", "").replace("¡", "")
      .replace("~", "").replace("-", "").replace("(", "")
      .replace(")", "").replace("+", "").replace("=", "")
      .replace("\"", "").replace("_", "").replace("\\_", "")
      .replace("—", "").replace("'", "").replace("<", "")
      .replace(">", "").replace("|", "").replace("1", "")
      .replace("2", "").replace("3", "").replace("4", "")
      .replace("5", "").replace("6", "").replace("7", "")
      .replace("8", "").replace("9", "").replace("0", "")
      .replace("»", "");
    return lineaPreProcesada.toLowerCase();
  }

  private void cargarEnArbol(String[] palabras) {
    for (String palabra : palabras) {
      guardarEnArbol(palabra);
    }
  }

  private void guardarEnArbol(String palabra) {
    if (getArbolPalabras() == null) {
      arbolPalabras = new Nodo(palabra);
    } else {
      getArbolPalabras().agregar(palabra);
    }
  }
  
  public void buscarEnArbol(String palabra) throws BadLocationException{
    Optional<Nodo> nodo = this.arbolPalabras.buscarEnArbol(palabra);
    if (nodo.isEmpty()) {
      ConsolaUtil.cargarMensaje(txtConsola.getStyledDocument(), EOrigen.PRESENTACION, "Palabra no encontrada");
      return;
    }
    ConsolaUtil.cargarMensaje(txtConsola.getStyledDocument(), EOrigen.PRESENTACION, "Resultado: "+ nodo.get().getValor());
  }

  /**
   * @return the arbolPalabras
   */
  public Nodo getArbolPalabras() {
    return arbolPalabras;
  }

}
