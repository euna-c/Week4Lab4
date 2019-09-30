<%-- 
    Document   : home
    Created on : Sep 26, 2019, 5:38:53 PM
    Author     : 784564
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
         <div>
             <form action="home.jsp" method="get">
                <h2>HOME PAGE</h2>
                <h3>Welcome ${userName}</h3>
             </form>
        </div>
             <a href="/login?logout">Log out</a>
    </body>
</html>
