package co.appreactor.busquedab.persistencia.dao.crud;

import co.appreactor.busquedab.persistencia.conexion.ConexionBD;
import co.appreactor.busquedab.persistencia.vo.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonaCRUD implements IGenericoDAO<Persona> {

  protected final int ID = 1;
  protected Connection cnn;

  public PersonaCRUD(Connection cnn) {
    this.cnn = cnn;
  }

  @Override
  public void insertar(Persona persona) throws SQLException {
    PreparedStatement sentencia = null;
    try {
      int i = 1;
      String sql = "insert into persona(nombre,cedula,salario) values (?,?,?)";
      sentencia = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      sentencia.setObject(i++, persona.getNombre());
      sentencia.setObject(i++, persona.getCedula());
      sentencia.setObject(i++, persona.getSalario());

      sentencia.executeUpdate();
      ResultSet rs = sentencia.getGeneratedKeys();
      if (rs.next()) {
        persona.setId(rs.getLong(ID));
      }
    } finally {
      ConexionBD.desconectar(sentencia);
    }
  }

  @Override
  public void editar(Persona persona) throws SQLException {
    PreparedStatement sentencia = null;
    try {
      int i = 1;
      String sql = "update persona set nombre=?,cedula=?,salario=? where id=?";
      sentencia = cnn.prepareStatement(sql);
      sentencia.setObject(i++, persona.getNombre());
      sentencia.setObject(i++, persona.getCedula());
      sentencia.setObject(i++, persona.getSalario());
      sentencia.setObject(i++, persona.getId());

      sentencia.executeUpdate();
    } finally {
      ConexionBD.desconectar(sentencia);
    }
  }

  @Override
  public List<Persona> consultar() throws SQLException {
    PreparedStatement sentencia = null;
    List<Persona> lista = new ArrayList<>();
    try {

      String sql = "select * from persona";
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

  @Override
  public Persona consultar(Long id) throws SQLException {
    PreparedStatement sentencia = null;
    Persona obj = null;
    try {

      String sql = "select * from persona where id=?";
      sentencia = cnn.prepareStatement(sql);
      sentencia.setLong(1, id);
      ResultSet rs = sentencia.executeQuery();
      if (rs.next()) {
        obj = getPersona(rs);
      }
    } finally {
      ConexionBD.desconectar(sentencia);
    }
    return obj;
  }

  public static Persona getPersona(ResultSet rs) throws SQLException {
    Persona persona = new Persona();
    persona.setId(rs.getLong("id"));
    persona.setNombre(rs.getString("nombre"));
    persona.setCedula(rs.getString("cedula"));
    persona.setSalario(rs.getLong("salario"));

    return persona;
  }

  public static Persona getPersona(ResultSet rs, Map<String, Integer> columnas) throws SQLException {
    Persona persona = new Persona();
    Integer columna = columnas.get("persona_id");
    if (columna != null) {
      persona.setId(rs.getLong(columna));
    }
    columna = columnas.get("persona_nombre");
    if (columna != null) {
      persona.setNombre(rs.getString(columna));
    }
    columna = columnas.get("persona_cedula");
    if (columna != null) {
      persona.setCedula(rs.getString(columna));
    }
    columna = columnas.get("persona_salario");
    if (columna != null) {
      persona.setSalario(rs.getLong(columna));
    }
    return persona;
  }

}
