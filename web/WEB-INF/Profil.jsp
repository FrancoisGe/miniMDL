<%--
  Created by IntelliJ IDEA.
  User: François
  Date: 01-10-17
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profil</title>
</head>
<body>

<%@ include file="menu.jsp"%>
<h1>Voici vos info perso</h1>
<p>
    Prenom :
    <c:out value="${sessionScope.prenom}"/>
</p>
<p>
    Nom :
    <c:out value="${sessionScope.nom}"/>
</p>
<p>
    Login :
    <c:out value="${sessionScope.login}"/>
</p>
<p>
    Pass :
    <c:out value="${sessionScope.pass}"/>
</p>
<p >
    Mail :
    <c:out value="${sessionScope.mail}"/>
</p>
<p>
    Ville :
    <c:out value="${sessionScope.ville}"/>
</p>
<p>
    Adress :
    <c:out value="${sessionScope.adress}"/>
</p>

</body>
</html>
