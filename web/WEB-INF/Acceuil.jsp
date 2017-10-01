<%--
  Created by IntelliJ IDEA.
  User: François
  Date: 30-09-17
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accueil</title>
</head>
<body>
<%@ include file="menu.jsp"%>

<c:if test="${!empty sessionScope.login && !empty sessionScope.pass}">salut ${sessionScope.login}</c:if>


    <form method="post" action="">
        <p>
            <label for="login">Id :</label>
            <input type="text" id ="login" name ="login">
        </p>

        <p>
            <label for="pass">Pass :</label>
            <input type="text" id ="pass" name ="pass">
        </p>
        <input type="submit"/>
    </form>


</body>
</html>
