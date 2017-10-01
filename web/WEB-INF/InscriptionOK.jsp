<%--
  Created by IntelliJ IDEA.
  User: François
  Date: 01-10-17
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscripion</title>
</head>
<body>
<%@ include file="menu.jsp"%>
    <h1>Vous êtes inscrit</h1>
    <p>
        Prenom :
    <c:out value="${utilisateur.prenom}"/>
    </p>
    <p>
        Nom :
    <c:out value="${utilisateur.nom}"/>
    </p>
    <p>
        Login :
    <c:out value="${utilisateur.login}"/>
    </p>
    <p>
        Pass :
    <c:out value="${utilisateur.pass}"/>
    </p>
    <p >
        Mail :
    <c:out value="${utilisateur.mail}"/>
    </p>
    <p>
        Ville :
    <c:out value="${utilisateur.ville}"/>
    </p>
    <p>
        Adress :
    <c:out value="${utilisateur.adress}"/>
    </p>

</body>
</html>
