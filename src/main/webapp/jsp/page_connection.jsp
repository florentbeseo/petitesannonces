<%--
  Created by IntelliJ IDEA.
  User: tgeor
  Date: 07/03/2023
  Time: 08:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<html>
<head>
    <title>Connetions</title>
    <link rel="stylesheet" type="text/css" href="HTML/style/styles.css">
</head>
<body>
    <h2>Connections</h2><br>
    <form class="login" method='POST' action='Controller?id=connection'>
        <label><b>Nom d'utilisateur
        </b>
        </label>
        <input type="text" name="Nu" id="Nu" placeholder="Username">
        <br><br>
        <label><b>Mot de passe
        </b>
        </label>
        <input type="Password" name="Mdp" id="Mdp" placeholder="Password">
        <br><br>
        <input type="submit" name="log" id="log" value="Se connecter">
        <br><br>
        <input type="checkbox" id="check">
        <span>Se rappeler de moi.</span>
        <br><br>
    </form>
    <a href="Controller?id=inscription">Inscription</a>
</body>
</html>
