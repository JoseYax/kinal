/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Conexion", urlPatterns = {"/Conexion"})
public class Conexion extends HttpServlet {
       @Resource(name ="jdbc/prueba")
       private DataSource ds;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Conexion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Conexion at " + request.getContextPath() + "</h1>");
            //uso del try y catch 
            try(Connection cnx =ds.getConnection())
            {
            String sql = "Select * from Usuario ";
            Statement stat =cnx.createStatement();
            ResultSet rs =stat.executeQuery(sql);
            while (rs.next()){
                String nombres = rs.getString("Nombres"); 
                String apellidos = rs.getString("Apellidos ");
                 String alias = rs.getString("Alias");
                }   
                }catch (SQLException ex){
                  System .out.println("Error ;" +ex.getMessage()); 
                  out.println(ex.getMessage());
                }
            
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

}
