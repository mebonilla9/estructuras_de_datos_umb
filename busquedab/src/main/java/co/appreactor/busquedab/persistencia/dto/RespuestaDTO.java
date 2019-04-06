/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.busquedab.persistencia.dto;

import co.appreactor.busquedab.negocio.constantes.EMensajes;

/**
 *
 * @author Manuel Ernesto Bonilla Muñoz
 */
public class RespuestaDTO {

    private int codigo;
    private String mensaje;
    private Object datos;

    public RespuestaDTO() {

    }

    public RespuestaDTO(EMensajes mensaje) {
        this.codigo = mensaje.getCodigo();
        this.mensaje = mensaje.getDescripcion();
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
