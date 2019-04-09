/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.tiendahash.persistencia;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lord_nightmare
 */
public class GestorProductos {

  private final HashMap<String, Double> productos;

  public GestorProductos(HashMap<String, Double> productos) {
    this.productos = productos;
  }

  public void guardarProducto(String codigo, Double precio) {
    if (this.productos.containsKey(codigo)) {
      JOptionPane.showMessageDialog(
        null, "El producto con el codigo: " + codigo + " ya se encuentra registrado",
        "Registro de producto",
        JOptionPane.ERROR_MESSAGE
      );
      return;
    }
    this.productos.put(codigo, precio);
    JOptionPane.showMessageDialog(
      null, "El producto con el codigo: " + codigo + " ha sido registrado",
      "Registro de producto",
      JOptionPane.INFORMATION_MESSAGE
    );
  }

  public Double buscarProducto(String codigo) {
    if (!this.productos.containsKey(codigo)) {
      JOptionPane.showMessageDialog(
        null, "El producto con el codigo: " + codigo + " aun no se encuentra registrado",
        "Modificación de producto",
        JOptionPane.ERROR_MESSAGE
      );
      return null;
    }
    return this.productos.get(codigo);
  }

  public void modificarProducto(String codigo, Double precio) {
    if (!this.productos.containsKey(codigo)) {
      JOptionPane.showMessageDialog(
        null, "El producto con el codigo: " + codigo + " aun no se encuentra registrado",
        "Modificación de producto",
        JOptionPane.ERROR_MESSAGE
      );
      return;
    }
    this.productos.remove(codigo);
    this.productos.put(codigo, precio);
  }

  public void mostrarProductos(DefaultTableModel modelo) {
    this.limpiarTabla(modelo);
    Iterator iterador = this.productos.entrySet().iterator();
    Map.Entry producto;
    while (iterador.hasNext()) {
      producto = (Map.Entry) iterador.next();
      modelo.addRow(new Object[]{producto.getKey(), producto.getValue()});
    }
  }

  public void eliminarProducto(String codigo) {
    if (!this.productos.containsKey(codigo)) {
      JOptionPane.showMessageDialog(
        null, "El producto con el codigo: " + codigo + " aun no se encuentra registrado",
        "Eliminació de producto",
        JOptionPane.ERROR_MESSAGE
      );
      return;
    }
    this.productos.remove(codigo);
    JOptionPane.showMessageDialog(
      null, "El producto con el codigo: " + codigo + " ha sido eliminado",
      "Eliminacion de producto",
      JOptionPane.INFORMATION_MESSAGE
    );
  }

  private void limpiarTabla(DefaultTableModel modelo) {
    int rowCount = modelo.getRowCount();
    for (int i = rowCount - 1; i >= 0; i--) {
      modelo.removeRow(i);
    }
  }

}
