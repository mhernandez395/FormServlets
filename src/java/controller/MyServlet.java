/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.validation;

/**
 *
 * @author alumne
 */
public class MyServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            /* -------------- validation content----------*/

            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>MyServlet formulario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Form MyServlet </h1>");
            
            /*----- Name--------*/
            
            if(validation.validateName(request.getParameter("nombre")))
            {
                out.println("<div class='alert alert-success col-sm-3'>nombre: "+request.getParameter("nombre")+"</div>");
            }
            else
            {
                out.println("<div class='alert alert-success col-sm-3'>Name: Format incorrect</div>");
            }
            
            /*------age-------*/
            
            if(validation.isInteger(request.getParameter("edad")))
            {
                out.println("<div class='alert alert-success col-sm-3'>Edad: "+request.getParameter("edad")+"</div>");
            }
            else
            {
                out.println("<div class='alert alert-success col-sm-3'>Edad: No number</div>");
            }
            
            /*------peso---------*/
            
            out.println("<div class='alert alert-success col-sm-3'>peso: "+request.getParameter("peso")+"</div>");
            
            
            /*--------email---------*/
            
            if(validation.validateEmail(request.getParameter("email")))
            {
              
            out.println("<div class='alert alert-success col-sm-3'>Email: "+request.getParameter("email")+"</div>");

            }
            else
            {
            out.println("<div class='alert alert-danger col-sm-3'>Email: Wrong e-mail</div>");
            }
            
            /*--------DNI---------*/
            
            if(validation.validarDNI(request.getParameter("dni")))
            {
              
            out.println("<div class='alert alert-success col-sm-3'>dni: "+request.getParameter("dni")+"</div>");

            }
            else
            {
            out.println("<div class='alert alert-danger col-sm-3'>dni: incorrect</div>");
            }
            
            /*------sexo--------*/
            
            String sexo[] = request.getParameterValues("sexo");
            for(int i=0;i<=sexo.length -1;i++){
            out.println("<div class='alert alert-success col-sm-3'>sexo: "+sexo[i]+"</div>");
            }
            
            /*-----hobbies-------*/
            
            String aficiones[] = request.getParameterValues("hobbies");
            for(int i=0;i<=aficiones.length -1;i++){
            out.println("<div class='alert alert-success col-sm-3'>aficions: "+aficiones[i]+"</div>");
            } 
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
