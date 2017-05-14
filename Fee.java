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
@WebServlet(urlPatterns = {"/Fee"})
public class Fee extends HttpServlet {

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
           int id=Integer.parseInt(s1);
           Statement stmt=con.createStatement();
           ResultSet rs=stmt.executeQuery("select Sno from Student");
           int flag=1;
           int i;
           while(rs.next())
           {
               i=rs.getInt(1);
               if(i==id)
               {
                   flag=0;
                  out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Fees Submission</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>Fees Submission</h1>");
            out.println("<hr>");
            out.println("<hr>");
           
            out.println("<form action=\"FeeSubmit\" >");
            out.println("<p>For UserID<input type=\"text\" name=\"t2\" value=\""+id+"\">");
            out.println("<p>Fee Amount:</p>");
            out.println("<p><input type=\"text\" name=\"t1\"></p>");
            out.println("<p><input type=\"submit\" value=\"Submit\"></p>");
            out.println("</form>");
            out.println("<hr>");
            out.println("<hr>");
            out.println("<p><a href=\"fees.jsp\">Back</a></p>");
            out.println("<p><a href=\"Admin.jsp\">Home</a></p>");
            out.println("<p><a href=\"index.jsp\">Home</a></p>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>"); 
               }
           }
           
           if(flag==1)
           {
                response.sendRedirect("Incorrect.jsp");
           }
           
           
           
    }
            catch(Exception e)
    {
        response.sendRedirect("DataError.jsp");
    }
            
            
            
            
            
            
            
            
            
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Fee</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Fee at " + request.getContextPath() + "</h1>");
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
