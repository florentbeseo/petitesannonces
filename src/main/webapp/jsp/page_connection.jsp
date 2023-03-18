<%--
  Created by IntelliJ IDEA.
  User: tgeor
  Date: 07/03/2023
  Time: 08:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Connetions</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
    <header>
        <div class="inner-width">
            <a href="Controller?id=accueil">
                <h1 class="logo img">Annonces<span style="color:red;">et</span>Vous</h1>
                <i class="menu-toggle-btn fas fa-bars"></i>
            </a>
        </div>
    </header>

    <h2>Connections</h2><br>

    <form class="login" method='POST' action='Controller?id=connection'>
        <label><b>Nom d'utilisateur</b></label>
        <input type="email" name="Nu" id="Nu" placeholder="Username" required>
        <br><br>
        <label><b>Mot de passe</b></label>
        <input type="Password" name="Mdp" id="Mdp" placeholder="Password" required>
        <br><br>
        <input type="submit" name="log" id="log" value="Se connecter">
        <br><br>
        <input type="checkbox" id="check">
        <span>Se rappeler de moi.</span>
        <br><br>
        <a href="Controller?id=inscription">Inscription</a>

    </form>

    <br>

    <c:if test="${!empty M_error}">
        <p>ERREUR MDP OU MAIL INCORRECT !</p>
    </c:if>
    <c:if test="${!empty error}">
        <p>ERREUR VEUILLEZ REMPLIR TOUS LES CHAMPS</p>
    </c:if>
</body>

</html>
