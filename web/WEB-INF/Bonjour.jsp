<%--
  Created by IntelliJ IDEA.
  User: François
  Date: 30-09-17
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bonjour</title>
</head>
<body>
<%@ include file="menu.jsp"%>
<h1>Bonjour, voici la liste des inscrits : </h1>
<ul>
    <c:forEach var ="utilisateurs" items ="${utilisateurs}">
        <li>
            <c:out value="${utilisateurs.nom}"/>
            <c:out value="${utilisateurs.prenom}"/>
        </li>
    </c:forEach>
</ul>
</body>
</html>
