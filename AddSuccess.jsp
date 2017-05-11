<%-- 
    Document   : AddSuccess
    Created on : Mar 28, 2017, 3:39:39 PM
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
        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">
        <title>Hostel Management</title>
    </head>
    <body>
    <center><h1>
        Successfully Added!!!
        </h1>
        <hr>
        <hr>
        <a href=\"Admin.jsp\">Home</a>
        
    </center>
    </body>
</html>
