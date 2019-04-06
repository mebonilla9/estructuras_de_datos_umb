package co.appreactor.busquedab.persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.Time;
import co.appreactor.busquedab.persistencia.vo.*;
import co.appreactor.busquedab.negocio.util.DateUtil;
import co.appreactor.busquedab.persistencia.conexion.ConexionBD;
import co.appreactor.busquedab.persistencia.dao.crud.*;

public class PersonaDAO extends PersonaCRUD {

  public PersonaDAO(Connection cnn){
    super(cnn);
  }

  @Override
  public List<Persona> consultar() throws SQLException {
    PreparedStatement sentencia = null;
    List<Persona> lista = new ArrayList<>();
    try {

      String sql = "select * from persona order by nombre asc limit 1000";
      sentencia = cnn.prepareStatement(sql);
      ResultSet rs = sentencia.executeQuery();
      while (rs.next()) {
        lista.add(getPersona(rs));
      }
    } finally {
      ConexionBD.desconectar(sentencia);
    }
    return lista;

  }
}
