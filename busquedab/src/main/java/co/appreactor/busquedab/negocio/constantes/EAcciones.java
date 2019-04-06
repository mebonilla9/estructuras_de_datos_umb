/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.busquedab.negocio.constantes;

/**
 *
 * @author Manuel Ernesto Bonilla Muñoz
 */
public enum EAcciones {

    NO_EXISTE("La url no existe"),
    INSERTAR("/insertar"),
    CONSULTAR("/consultar"),
    BUSCAR("/buscar"),
    MODIFICAR("/modificar");

    private String accion;

    private EAcciones(String accion) {
        this.accion = accion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public static EAcciones parse(String accion) {
        EAcciones[] acciones = values();
        for (EAcciones accione : acciones) {
            if (accione.getAccion().equalsIgnoreCase(accion)) {
                return accione;
            }
        }
        return EAcciones.NO_EXISTE;
    }

}
