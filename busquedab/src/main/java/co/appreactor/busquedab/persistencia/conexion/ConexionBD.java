/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.busquedab.persistencia.conexion;

import co.appreactor.busquedab.negocio.constantes.EMensajes;
import co.appreactor.busquedab.negocio.excepciones.BusquedaException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Manuel Ernesto Bonilla Muñoz
 */
public class ConexionBD {

  public static Connection conectar() throws BusquedaException {
    try {
      Class.forName("org.postgresql.Driver");

      // Conexion via Pool
      Context ctx = new InitialContext();
      // obtener el datasource
      DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/PersonasDs");

      Connection cnn = ds.getConnection();
      cnn.setAutoCommit(false);
      return cnn;
    } catch (SQLException | ClassNotFoundException | NamingException ex) {
      ex.printStackTrace();
      throw new BusquedaException(EMensajes.ERROR_CONEXION_BD);
    }
  }

  public static void desconectar(Connection cnn) {
    desconectar(cnn, null);
  }

  public static void desconectar(PreparedStatement ps) {
    desconectar(null, ps);

  }

  public static void desconectar(Connection cnn, PreparedStatement ps) {
    try {
      if (ps != null) {
        ps.close();
      }
      if (cnn != null) {
        cnn.close();
      }
    } catch (SQLException ex) {
      Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public static void rollback(Connection cnn) {
    try {
      cnn.rollback();
    } catch (SQLException ex) {
      Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

}
