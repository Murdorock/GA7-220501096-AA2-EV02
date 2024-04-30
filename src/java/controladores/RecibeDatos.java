/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import static java.lang.System.out;
import java.sql.*;

/**
 *
 * @author Guigo
 */
public class RecibeDatos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String msg)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado del Registro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + msg + "</h1>");
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
        
        String usuario="root";
        String password="murdock1984-";
        String url="jdbc:mysql://localhost:3306/control";
        Connection conexion;
        Statement statement;
        
        String ced = request.getParameter("Cedula");
        String nom = request.getParameter("Nombre");
        String ape = request.getParameter("Apellido");
        String cor = request.getParameter("Correo");
        String tel = request.getParameter("Telefono");
        

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexion= DriverManager.getConnection(url,usuario,password);
            statement= conexion.createStatement();
            
            statement.executeUpdate("INSERT INTO CLIENTES(CEDULA,NOMBRE,APELLIDO,CORREO,TELEFONO) VALUES ('"+ced+"','"+nom+"','"+ape+"','"+cor+"','"+tel+"')");
        //out.print("<h1>Datos ingresados con exito<h1>");
        processRequest(request, response, "Registro de datos exitoso");
        }
        catch(Exception e){
            processRequest(request, response, "No se pudo completar el registro");
            //out.print("<h1>Error<h1>");
            
        }
        
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
