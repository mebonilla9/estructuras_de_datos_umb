package co.appreactor.busquedab.aplicacion;

import co.appreactor.busquedab.negocio.api.PersonaRest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Manuel Ernesto Bonilla Muñoz
 */
@ApplicationPath("api")
public class ApplicationConfig extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> resources = new HashSet<>();
    addRestResourcesClasses(resources);
    return resources;
  }

  private void addRestResourcesClasses(Set<Class<?>> resources) {
    resources.add(PersonaRest.class);
  }
}
