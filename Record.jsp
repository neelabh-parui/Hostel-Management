<%-- 
    Document   : Record
    Created on : Mar 28, 2017, 6:59:28 PM
    Author     : Parui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Record</title>
    </head>
    
    <body>
       <%
    
    String s=(String)request.getSession().getAttribute("user");
    if(s==null)
    {
        response.sendRedirect("index.jsp");
    }
    
    %>
    <center>
        <h1>Search for a Record</h1>
        <hr>
        <hr>
        <form action="Rec">
            <p>Enter Student Scholar Number:</p>
            <p><input type="text" name="t1"></p>
            <p><input type="submit" value="Search"></p>
        </form>
    </center>    
    </body>
</html>

