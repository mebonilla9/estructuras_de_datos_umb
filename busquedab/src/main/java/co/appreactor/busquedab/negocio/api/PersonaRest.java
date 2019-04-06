package co.appreactor.busquedab.negocio.api;

import co.appreactor.busquedab.negocio.constantes.EMensajes;
import co.appreactor.busquedab.negocio.constantes.ERutas;
import co.appreactor.busquedab.negocio.delegado.PersonaDelegado;
import co.appreactor.busquedab.negocio.excepciones.BusquedaException;
import co.appreactor.busquedab.persistencia.conexion.ConexionBD;
import co.appreactor.busquedab.persistencia.dto.RespuestaDTO;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * @author Manuel Ernesto Bonilla Muñoz
 */
@Path(ERutas.CONTROL_BASE)
public class PersonaRest {

  @Context
  private UriInfo context;

  public PersonaRest() {
  }

  @POST
  @Path(ERutas.Persona.PERSONA_CONSULTAR)
  @Produces(MediaType.APPLICATION_JSON)
  public RespuestaDTO consultar() throws BusquedaException {
    RespuestaDTO respuesta = new RespuestaDTO(EMensajes.CONSULTO);
    respuesta.setDatos(
      new PersonaDelegado(
        ConexionBD.conectar(),
        null
      ).consultar());
    return respuesta;
  }

}
