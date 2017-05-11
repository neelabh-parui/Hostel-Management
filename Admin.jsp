<%-- 
    Document   : Admin
    Created on : Mar 28, 2017, 2:24:21 PM
    Author     : Parui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%
    
    String s=(String)request.getSession().getAttribute("user");
    if(s==null)
    {
        response.sendRedirect("index.jsp");
    }
    
    %>
  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hostel Manager</title>
    </head>
    <body>
        <p>  <img src="res/davv-header.jpg" alt="Header" width="2000" height="120"> </p>
    <center><h1>IET Hostel Management System</h1></center>
    <hr>
    <hr>
    <center>
        <p><h1>Options</h1></p>
        <hr>
        <p><a href="Record.jsp">Search Records</a></p>
        <p><a href="Register.jsp">Add Records</a></p>
        <p><a href="Fees.jsp">Fees Submission</a></p>
        <p><a href="Edit.jsp">Delete Records</a></p>
        <hr>
        <p><a href="AddAdmin.jsp">Add Admin</a></p>
        <p><a href="Fpw.jsp">Change Password</a>
        <hr>
        <hr>
        <p><a href="www.dauniv.ac.in/hostels.php">Know More</a></p>
        <p><a href="Logout">Logout</a></p>
    </center>
        
    </body>
</html>
