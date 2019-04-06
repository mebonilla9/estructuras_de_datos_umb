/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.frecuenciapalabras.negocio.util;

import co.appreactor.frecuenciapalabras.negocio.constantes.EOrigen;
import java.awt.Color;
import java.time.LocalDateTime;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author lord_nightmare
 */
public final class ConsolaUtil {

  public static void cargarMensaje(
    StyledDocument documento,
    EOrigen origen,
    String mensaje
  ) throws BadLocationException {
    switch (origen) {
      case PRESENTACION:
        mensajePresentacion(documento, mensaje);
        break;
      case ARBOL:
        mensajeServicio(documento, mensaje);
        break;
      case ARCHIVO:
        mensajePersistencia(documento, mensaje);
        break;
    }
  }

  private static void mensajePresentacion(
    StyledDocument documento,
    String mensaje
  ) throws BadLocationException {
    SimpleAttributeSet estilos = new SimpleAttributeSet();
    StyleConstants.setForeground(estilos, Color.GREEN);
    escribirMensaje(documento, estilos, mensaje);
  }

  private static void mensajeServicio(
    StyledDocument documento,
    String mensaje
  ) throws BadLocationException {
    SimpleAttributeSet estilos = new SimpleAttributeSet();
    StyleConstants.setForeground(estilos, Color.BLUE);
    escribirMensaje(documento, estilos, mensaje);
  }

  private static void mensajePersistencia(
    StyledDocument documento, 
    String mensaje
  ) throws BadLocationException {
    SimpleAttributeSet estilos = new SimpleAttributeSet();
    StyleConstants.setForeground(estilos, Color.GRAY);
    escribirMensaje(documento, estilos, mensaje);
  }

  private static void escribirMensaje(
    StyledDocument documento, 
    SimpleAttributeSet estilos, 
    String mensaje
  ) throws BadLocationException {
    LocalDateTime hora = LocalDateTime.now();
    StringBuilder sb = new StringBuilder();
    sb.append("[ ")
      .append(hora.toString())
      .append(" ] - ")
      .append(mensaje)
      .append("\n");
    documento.insertString(documento.getLength(), sb.toString(), estilos);
  }

}
