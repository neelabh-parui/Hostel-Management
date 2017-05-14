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
@WebServlet(urlPatterns = {"/AdminAdd"})
public class AdminAdd extends HttpServlet {

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
           
           PreparedStatement ps=con.prepareStatement("insert into Admin values(?,?,?,?)");
           int uid;
                   if(s1.equals(s2))
                   {
                       Statement stmt=con.createStatement();
                       ResultSet rs=stmt.executeQuery("select max(UserID) from Admin");
                       rs.next();
                       uid=rs.getInt(1);
                       uid++;
                       ps.setInt(1, uid);
                       ps.setString(2, s2);
                       ps.setString(3, s3);
                       ps.setString(4, s4);
                       int i=ps.executeUpdate();
                       out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <meta http-equiv=\\\"Content-Type\\\" content=\\\"text/html; charset=UTF-8\\\">\n" +
"        <title>Hostel Management</title>\n" +
"    </head>\n" +
"    <body>\n" +
"    <center><h1>\n" +
"        Successfully Added!!!\n" +
"        </h1>\n" +
"        <hr>\n" +
"Your New UserID is "+uid+
"        <hr>\n" +
"        <a href=\"Admin.jsp\">Home</a>\n" +
"        \n" +
"    </center>\n" +
"    </body>\n" +
"</html>");
                       
                    }
            
           
           
}catch(Exception e)
    {
         response.sendRedirect("DataError.jsp");
    }
           /* out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminAdd</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminAdd at " + request.getContextPath() + "</h1>");
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
