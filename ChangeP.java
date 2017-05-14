/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Parui
 */
@WebServlet(urlPatterns = {"/ChangeP"})
public class ChangeP extends HttpServlet {

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
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
     
    
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hostel","root","15c4131");
    
         
    String P=request.getParameter("t1");
    int i=Integer.parseInt(request.getParameter("t2"));
    PreparedStatement stmt=con.prepareStatement("update Admin set Pword=? where UserID=?");
    stmt.setString(1, P);
    stmt.setInt(2, i);
    int j=stmt.executeUpdate();
     out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Success</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center><h1>Successfully Changed</h1></center>");
            out.println("<hr>");
            out.println("<hr>");
            out.println("<p><center><a href=\"index.jsp\">Home</a></center></p>");
            out.println("</body>");
            out.println("</html>");
    
    
    
            }catch(Exception e)
    {
         response.sendRedirect("DataError.jsp");
    }
            /*
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChangeP</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangeP at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
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
