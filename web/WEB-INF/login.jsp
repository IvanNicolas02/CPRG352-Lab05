<%-- 
    Document   : login
    Created on : Feb 11, 2022, 11:39:34 AM
    Author     : ivanc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="login">
            <label>Username:</label>
            <input type="text" name="username" value="${username}"><br>
            <label>Password:</label>
            <input type="password" name="password" value=""><br>
            <input type="submit" name="login" value="Log in">
        </form>
        <p>${error}</p><p>${logoutMessage}</p>
    </body>
</html>
