<%-- 
    Document   : Register
    Created on : Mar 28, 2017, 7:37:14 PM
    Author     : Parui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Student</title>
    </head>
   <%
    
    String s=(String)request.getSession().getAttribute("user");
    if(s==null)
    {
        response.sendRedirect("index.jsp");
    }
    
    %>
    <body>
    <center>
        <h1>Student Registration</h1>
        <hr>
        <hr>
        <p><font style="font-style: italic">All fields are Required</font></p>
        <form action="Reg">
            <p>Student Scholar Number : <input type="text" name="t1"></p>
            <p>Student Name :<input type="text" name="t2"></p>
            <p>Student Age : <input type="text" name="t3"></p>
            <p>Room Number : <input type="text" name="t4" ></p>
            <p>Fees Paid : <input type="text" name="t5"></p>
            <p>Year  : <input type="text" name="t6"></p>
            <p>Branch  : <input type="text" name="t7"></p>
            <p>Contact :<input type="text" name="t8"></p>
            <p>E-mail id : <input type="text" name="t9"></p>
            <p><input type="submit" value="Submit"></p>
            
        </form>
        <hr>
        <hr>
        <p><a href="Admin.jsp">Home</a></p>
        <p><a href="Logout">Logout</a></p>
    </center>
    </body>
</html>
