/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica2.Servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author jordani-vaio
 */
@MultipartConfig
public class SubirArchivo extends HttpServlet {

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
        
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            // get access to file that is uploaded from client
            Part p1 = request.getPart("file");
            InputStream is = p1.getInputStream();
            
            String fileName = getFileName(p1);

            // get filename to use on the server
            String outputfile = this.getServletContext().getRealPath(fileName);  // get path on the server
            long contador;
            // write bytes taken from uploaded file to target file
            try (FileOutputStream os = new FileOutputStream (outputfile)) {
                // write bytes taken from uploaded file to target file
                int ch = is.read();
                contador = 0;
                while (ch != -1) {
                    os.write(ch);
                    ch = is.read();
                    contador++;
                }
            }
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
            out.println("<li><a href=\"./verinfo\">Informaciones de la sesion</a></li>");
            out.println("<li class=\"active\"><a href=\"./enviarArchivo.html\">Subir archivo</a></li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("</div><!-- /.container-fluid -->");
            out.println("</nav>");
            out.println("<div id=\"jumbo\">");
            out.println("<div class=\"jumbotron\">");
            out.println("<h2>Subiendo Archivo:  <span class=\"label label-info\">" + fileName + "</span>"
                    + " <hr>Con tamaño: <span class=\"label label-info\">" + contador + " bytes</span></h2>");
            out.println("</div></div>");
            out.println("</body>");
            out.println("</html>");
            
        }
        catch(IOException | ServletException ex) {
           out.println("Exception -->" + ex.getMessage());
        }
        finally { 
            out.close();
        }
    }

    private String getFileName(Part part) {    
       for (String cd : part.getHeader("content-disposition").split(";")) {
          if (cd.trim().startsWith("filename")) {
            return cd.substring(cd.indexOf('=') + 1).trim()
                .replace("\"", "");
          }
        }
        return null;
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
