/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.compras.persistencia.dao;

import co.appreactor.compras.negocio.constantes.ERutaArchivo;
import co.appreactor.compras.persistencia.entidades.Fabrica;

/**
 *
 * @author lord_nightmare
 */
public class FabricaDao extends GenericoDao<Fabrica>{

  public FabricaDao() {
    this.nombreArchivo = ERutaArchivo.ARCHIVO_FABRICA;
  }
  
}
