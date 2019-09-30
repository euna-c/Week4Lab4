<%-- 
    Document   : login
    Created on : Sep 26, 2019, 4:23:49 PM
    Author     : 784564
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
         <h1>Login</h1>
        <div>
            <form action="login" method="post">
                User name: <input type="text" name="username" value="${userName}"><br>
                Password: <input type="password" name="password" value=""><br>
                <input type="submit" name="button" value="Login">
            </form>
        </div>
        <div>
            ${message}
        </div>
    </body>
</html>
