/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica2.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author diego
 */
public class MostrarInfoSesion extends HttpServlet {

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
             HttpSession sesion = request.getSession();
            
            ArrayList<String> sesiones;
            if(sesion.getAttribute("listaAccesos") == null)
            {
                sesiones = new ArrayList<>();
            }
            else
            {
                sesiones = (ArrayList<String>)sesion.getAttribute("listaAccesos");
            }
            
            DateFormat formato = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
            Date fecha = new Date();
            sesiones.add(formato.format(fecha));
            
            sesion.setAttribute("listaAccesos", sesiones);
            
            Iterator accesos = sesiones.iterator();
            
            out.println("<!DOCTYPE HTML>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<title>Pr&aacute;ctica 2 - Jordani Roz&oacute;n & Diego S&aacute;nchez</title>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
            out.println("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("<link href=\"css/login.css\" rel=\"stylesheet\">");
            out.println("<script src=\"js/login.js\"></script>");
            out.println("<body>");
            out.println("<!DOCTYPE HTML>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<title>Pr&aacute;ctica 2 - Jordani Roz&oacute;n & Diego S&aacute;nchez</title>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
            out.println("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("<link href=\"css/login.css\" rel=\"stylesheet\">");
            out.println("<script src=\"js/login.js\"></script>");
            out.println("<body>");
            out.println("<nav class=\"navbar navbar-default navbar-static-top\" role=\"navigation\">");
            out.println("<div class=\"container-fluid\">");
            out.println("<!-- Brand and toggle get grouped for better mobile display -->");
            out.println("<div class=\"navbar-header\">");
            out.println("<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">");
            out.println("<span class=\"sr-only\">Toggle navigation</span>");
            out.println("<span class=\"icon-bar\"></span>");
            out.println("<span class=\"icon-bar\"></span>");
            out.println("<span class=\"icon-bar\"></span>");
            out.println("</button>");
            out.println("<a class=\"navbar-brand\" href=\"./bienvenido.html\"><span class=\"glyphicon glyphicon-book\">Pr&aacute;ctica 2</span></a>");
            out.println("</div>");
            out.println("<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">");
            out.println("<ul class=\"nav navbar-nav\">");
            out.println("<li><a href=\"./bienvenido.html\">Inicio</a></li>");
            out.println("<li><a href=\"./vercookie\">Visualizar cookies</a></li>");
            out.println("<li a class=\"active\"><a href=\"./verinfo\">Informaciones de la sesion</a></li>");
            out.println("<li><a href=\"./enviarArchivo.html\">Subir archivo</a></li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("</div><!-- /.container-fluid -->");
            out.println("</nav>");
            out.println("<hr>");
            out.println("<div class=\"alert alert-info\">");
            out.println("<h2>Numero de accesos del usuario: <span class=\"label label-info\">"+sesiones.size()+"</span></h2></div>");
            out.println("<ul class=\"list-group\">");
            while(accesos.hasNext())
                 out.println("<li class=\"list-group-item\">"+(String)accesos.next()+"</li>");
            out.println("</ul>");
            
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
