/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.compras.persistencia.dao;

import co.appreactor.compras.negocio.constantes.ERutaArchivo;
import co.appreactor.compras.persistencia.entidades.Direccion;

/**
 *
 * @author lord_nightmare
 */
public class DireccionDao extends GenericoDao<Direccion>{

  public DireccionDao() {
    this.nombreArchivo = ERutaArchivo.ARCHIVO_DIRECCION;
  }

}
