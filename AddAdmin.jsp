<%-- 
    Document   : AddAdmin
    Created on : Mar 28, 2017, 2:45:29 PM
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
       

        <title>Add Admin</title>
    </head>
    <body>
        
    <center>
        <h1>Add New Admin</h1>
        <hr>
        <hr>
        <form action="AdminAdd">
            <p> Set Password       <input type="password" name="t1"></p>
            <p>Retype Password    <input type="password" name="t2"></p>
            <p>Security Question  <input type="text" name="t3"></p>
            <p>Security Answer    <input type="text" name="t4"></p>
            <p><input type="submit" value="Add"></p>
        </form>
    </center>
    </body>
</html>
