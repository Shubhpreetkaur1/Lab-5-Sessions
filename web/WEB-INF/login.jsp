

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <form method= "post" action="login">
            <label> Username: </label>
            <input typr ="text" name="username" value="${username}">
            <br>
            <label> Password: </label>
            <input type ="password" name="password" value="${password}">
            <br>
            <input type="submit" value="Log in">
        </form>
            <c:if test="${message != null}"> 
                <p> ${message}</p>
            </c:if>
    </body>
</html>
