/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.busquedab.negocio.excepciones;

import co.appreactor.busquedab.negocio.constantes.EMensajes;

/**
 *
 * @author Manuel Ernesto Bonilla Muñoz
 */
public class BusquedaException extends Exception {

    private int codigo;
    private String mensaje;
    private Object datos;

    public BusquedaException(EMensajes mensaje) {
        this.codigo = mensaje.getCodigo();
        this.mensaje = mensaje.getDescripcion();
    }

    public BusquedaException(EMensajes mensaje, Object datos) {
        this.codigo = mensaje.getCodigo();
        this.mensaje = mensaje.getDescripcion();
        this.datos = datos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getDatos() {
        return datos;
    }

    public void setDatos(Object datos) {
        this.datos = datos;
    }

}
