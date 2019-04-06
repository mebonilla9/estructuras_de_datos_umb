/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.busquedab.negocio.delegado;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import co.appreactor.busquedab.negocio.constantes.EMensajes;
import co.appreactor.busquedab.negocio.excepciones.BusquedaException;
import co.appreactor.busquedab.persistencia.conexion.ConexionBD;
import co.appreactor.busquedab.persistencia.dao.crud.IGenericoDAO;
import co.appreactor.busquedab.persistencia.dto.AuditoriaDTO;

/**
 *
 * @author Manuel Ernesto Bonilla Muñoz
 */
public abstract class GenericoDelegado<T> {

    protected Connection cnn;
    protected IGenericoDAO genericoDAO;
    protected boolean confirmar=true;


    public GenericoDelegado(Connection cnn,AuditoriaDTO auditoriaDTO) throws BusquedaException {
        this.cnn=cnn;
    }

    public void insertar(T entidad) throws BusquedaException {
        try {
            genericoDAO.insertar(entidad);
            } catch (SQLException ex) {
            ConexionBD.rollback(cnn);
            throw new BusquedaException(EMensajes.ERROR_INSERTAR);
        } 
    }

    public void editar(T entidad) throws BusquedaException {
        try {
            genericoDAO.editar(entidad);
           
        } catch (SQLException ex) {
            ConexionBD.rollback(cnn);
            throw new BusquedaException(EMensajes.ERROR_MODIFICAR);
        } 
    }

    public List<T> consultar() throws BusquedaException {
        try {
            return genericoDAO.consultar();
        } catch (SQLException ex) {
            ConexionBD.rollback(cnn);
            throw new BusquedaException(EMensajes.ERROR_CONSULTAR);
        } 
    }

    public T consultar(long id) throws BusquedaException {
        try {
            return (T) genericoDAO.consultar(id);
        } catch (SQLException ex) {
            ConexionBD.rollback(cnn);
            throw new BusquedaException(EMensajes.ERROR_CONSULTAR);
        }
    }

}
