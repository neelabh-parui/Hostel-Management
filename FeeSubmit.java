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
@WebServlet(urlPatterns = {"/FeeSubmit"})
public class FeeSubmit extends HttpServlet {

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
    
         
    int P=Integer.parseInt(request.getParameter("t1"));
    int i=Integer.parseInt(request.getParameter("t2"));
    /*Statement s=con.createStatement();
    ResultSet rs=s.executeQuery("select Sno, FeesPaid from Student");
    int id;
    while(rs.next())
    {
        id=rs.getInt(1);
        if(id==i);
        {
            int F=rs.getInt(2);
            P=P+F;
        }
    
    }*/
    
    PreparedStatement stmt=con.prepareStatement("update Student set FeesPaid=? where Sno=?");
    stmt.setInt(1, P);
    stmt.setInt(2, i);
    int j=stmt.executeUpdate();
     out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Success</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center><h1>Successfully Paid</h1>");
            out.println("<hr>");
            out.println("<hr>");
            out.println("<p><a href=\"Fees.jsp\">Back</a></p>");
            out.println("<p><a href=\"Admin.jsp\">Home</a></p>");
            out.println("<p><a href=\"index.jsp\">Logout</a></p>");
            out.println("</center></body>");
            out.println("</html>");
    
    
    
            }catch(Exception e)
    {
        response.sendRedirect("DataError.jsp");
    }
            
            
            
            
            
            
            
            
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FeeSubmit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FeeSubmit at " + request.getContextPath() + "</h1>");
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
