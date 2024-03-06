/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pildoras.spring_proyecto_crud_videos066_075.pruebaconecta;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
@WebServlet(name = "ConectaCrud", urlPatterns = {"/ConectaCrud"})
public class ConectaCrud extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * 
     * Se ejecuta por GET y POST
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
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Servlet ConectaCrud</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Servlet ConectaCrud at " + request.getContextPath() + "</h1>");
    out.println("<p>Estamos en processRequest llegados desde doGet</p>");
    out.println("<p>Intentando conectar...</p>");

    String jdbcURL = "jdbc:mysql://localhost:3306/gestionpedidoscrud?useSSL=false";
    String usuario = "root";
    String contra = "";

    out.print("<p>Nombre de la BBDD: " + jdbcURL + "</p>");

    try {
        // La siguiente línea es para evitar problemas de que el jar no encuentre el driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection miConexion = DriverManager.getConnection(jdbcURL, usuario, contra);
        out.print("<p>Conexión realizada!</p>");

        System.out.print("Conexión realizada!");

        // Resto del código...
    } catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(ConectaCrud.class.getName()).log(Level.SEVERE, null, ex);
        out.print("<p>Error al intentar conectar con la base de datos.</p>");
        out.print("<p>Mensaje de error: " + ex.getMessage() + "</p>");
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
        // al entrar en la página doGet llama a processRequest()
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
