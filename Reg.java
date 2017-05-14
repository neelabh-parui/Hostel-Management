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
@WebServlet(urlPatterns = {"/Reg"})
public class Reg extends HttpServlet {

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
           
             try
    {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
     
    
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hostel","root","15c4131");
            
     String s1=request.getParameter("t1");
     String s2=request.getParameter("t2");
     String s3=request.getParameter("t3");
     String s4=request.getParameter("t4");
     String s5=request.getParameter("t5");
     String s6=request.getParameter("t6");
     String s7=request.getParameter("t7");
     String s8=request.getParameter("t8");
     String s9=request.getParameter("t9");
     int a=Integer.parseInt(s3);
     int id=Integer.parseInt(s1);
     int R=Integer.parseInt(s4);
     int F=Integer.parseInt(s5);
     int Y=Integer.parseInt(s6);
     
    PreparedStatement ps=con.prepareStatement("insert into Student values(?,?,?,?,?,?,?,?,?)");
    ps.setInt(1, id);
    ps.setInt(3, a);
    ps.setInt(4, R);
    ps.setInt(5, F);
    ps.setInt(6, Y);  
    ps.setString(2, s2);
    ps.setString(7, s7);
    ps.setString(8, s8);
    ps.setString(9, s9);
    int i=ps.executeUpdate();
            response.sendRedirect("AddSuccess.jsp");
            
    }
             catch(Exception e)
    {
        response.sendRedirect("DataError.jsp");
    }
            
            
            
            
            
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Reg</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Reg at " + request.getContextPath() + "</h1>");
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
