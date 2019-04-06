/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.busquedab.negocio.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.appreactor.busquedab.negocio.constantes.EAcciones;
import co.appreactor.busquedab.negocio.excepciones.BusquedaException;
import co.appreactor.busquedab.persistencia.dto.RespuestaDTO;

/**
 *
 * @author Manuel Ernesto Bonilla Muñoz
 */
public abstract class GenericoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            RespuestaDTO respuesta;
            EAcciones accion = getAccion(request.getServletPath());
            try {
                respuesta = procesar(request, accion);
            } catch (BusquedaException ex) {
                respuesta = new RespuestaDTO();
                respuesta.setCodigo(ex.getCodigo());
                respuesta.setMensaje(ex.getMensaje());
            }
            out.print(new Gson().toJson(respuesta));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public abstract RespuestaDTO procesar(HttpServletRequest request, EAcciones accion) throws BusquedaException;

    private EAcciones getAccion(String url) {
        return EAcciones.parse(getURLAccion(url));
    }

    private String getURLAccion(String url) {
        String[] partes = url.split("/");
        String accion = "/" + partes[partes.length - 1];
        return accion;
    }

}
