<%-- 
    Document   : Edit
    Created on : Mar 28, 2017, 9:46:24 PM
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
        <title>Hostel Management</title>
    </head>
    <body>
    <center>
        <h1>Edit Records</h1>
        <hr>
        <hr>
        <form action="Edt">
            <p>Enter Student Scholar Number: </p>
            <p><input type="text" name="t1"></p>
            <p><input type="submit" value="Submit"></p>
        </form>
        <hr>
        <hr>
        
        <p><a href="Admin.jsp">Back</a></p>
        <p><a href="Login">Logout</a></p>
    </center>
    </body>
</html>
