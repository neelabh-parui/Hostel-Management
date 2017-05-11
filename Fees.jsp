<%-- 
    Document   : Fees
    Created on : Mar 28, 2017, 8:17:22 PM
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
        <title>Fees Submission Portal</title>
    </head>
    <body>
    <center>
        <h1>Fees Submission Portal</h1>
        <hr>
        <hr>
        <p>Enter Scholar number for Student</p>
        <form action="Fee">
            <p><input type="text" name="t1"></p>
            <p><input type="submit" value="Submit"</p>
        </form>
    </center>    
    </body>
</html>
