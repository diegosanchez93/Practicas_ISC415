/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica2.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diego
 */
public class VisualizarCookie extends HttpServlet {

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

            Cookie[] cookie = request.getCookies();
            Boolean existeDatosUsuario = false;

            for(Cookie cookies : cookie){ 
                if(cookies.getName().matches("datosUsuario")){
                    /* TODO output your page here. You may use following sample code. */
                    existeDatosUsuario = true;
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
                    out.println("<li class=\"active\"><a href=\"./vercookie\">Visualizar cookies</a></li>");
                    out.println("<li><a href=\"./verinfo\">Informaciones de la sesion</a></li>");
                    out.println("<li><a href=\"./enviarArchivo.html\">Subir archivo</a></li>");
                    out.println("</ul>");
                    out.println("</div>");
                    out.println("</div><!-- /.container-fluid -->");
                    out.println("</nav>");
                    out.println("<div id=\"jumbo\">");
                    out.println("<div class=\"jumbotron\" id=\"jumboU\">");
                    out.println("<h1><span class=\"glyphicon glyphicon-user\">Usuario: </span><span class=\"label label-info\">" + cookies.getValue() + "</span></h1>");
                    out.println("</div></div>");
                    out.println("</body>");
                    out.println("</html>");
                    break;
                }
            }
            
            if(!existeDatosUsuario){
                response.sendRedirect("./login.html");
            }
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
