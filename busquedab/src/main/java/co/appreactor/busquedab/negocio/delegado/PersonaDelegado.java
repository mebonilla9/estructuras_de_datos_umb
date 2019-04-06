/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.busquedab.negocio.delegado;

import co.appreactor.busquedab.negocio.constantes.EMensajes;
import co.appreactor.busquedab.negocio.excepciones.BusquedaException;
import co.appreactor.busquedab.persistencia.dao.PersonaDAO;
import co.appreactor.busquedab.persistencia.vo.Persona;
import co.appreactor.busquedab.persistencia.dto.AuditoriaDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Manuel Ernesto Bonilla Muñoz
 */
public class PersonaDelegado extends GenericoDelegado<Persona> {

    private final PersonaDAO personaDAO;

    public PersonaDelegado(Connection cnn,AuditoriaDTO auditoria) throws BusquedaException {
        super(cnn,auditoria);
        personaDAO = new PersonaDAO(cnn);
        genericoDAO = personaDAO;
    }

    @Override
    public List<Persona> consultar() throws BusquedaException {
        try{
            return personaDAO.consultar();
        } catch (SQLException e){
            throw new BusquedaException(EMensajes.ERROR_CONSULTAR);
        }
    }
}
