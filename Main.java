/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Parui
 */
@WebServlet(urlPatterns = {"/Main"})
public class Main extends HttpServlet {

    static String login;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try
    {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
     
    
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hostel","root","15c4131");
   
    
            
           
           HttpSession session=request.getSession();
           String s1=request.getParameter("t1");
           int id=Integer.parseInt(s1);
           String s2=request.getParameter("t2");
           Statement stmt=con.createStatement();
           ResultSet rs=stmt.executeQuery("select UserID, Pword from Admin");
           int uid;
           String Pw;
           int flag=1;
           while(rs.next())
           {
               uid=rs.getInt(1);
               Pw=rs.getString(2);
               if((id==uid)&&(s2.equals(Pw)))
               {
                   flag=0;
                   login="yes";
                   response.sendRedirect("CheckLogin");
               }
               
               
           }
           if(flag==1)
           {
                    
                   response.sendRedirect("Incorrect.jsp");
           }
}catch(Exception e)
    {
         response.sendRedirect("DataError.jsp");
    }
           
           
          /*  out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Main</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Main at " + request.getContextPath() + "</h1>");
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
