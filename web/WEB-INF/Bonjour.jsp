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
${auteur.prenom}
<c:out value="eheh"></c:out>
<p>Salut les copains</p>
<p>
    <%
    String var =(String) request.getAttribute("var");
    out.println(var);
        String name =(String) request.getAttribute("name");
        out.println(name);
    %>
</p>
<p>

    <%
        for (int i = 0; i <10 ; i++) {
            out.println(i);
        }
    %>
</p>
bitch
</body>
</html>
