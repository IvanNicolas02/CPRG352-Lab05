<%-- 
    Document   : home
    Created on : Feb 11, 2022, 11:39:20 AM
    Author     : ivanc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        
    </head>
    <body>
        <h1>Home Page</h1>
        <h3><b>Hello ${validUser.username}.</b></h3>
        <div>
            <a href="login?logout">Log Out</a>
        </div> 
    </body>
</html>
