<%--
  Created by IntelliJ IDEA.
  User: tgeor
  Date: 14/03/2023
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Page Modification Profile</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
    <header>
        <div class="inner-width">
            <a href="Controller?id=accueil">
                <h1 class="logo img">Annonces<span style="color:red;">et</span>Vous</h1>
                <i class="menu-toggle-btn fas fa-bars"></i>
            </a>
            <nav class="navigation-menu">

                <c:if test="${connecte}">
                    <a href="Controller?id=mes_annonces" class="aj_btn">Mes Annonces</a>
                </c:if>

                <a href="Controller?id=accueil_biens"></i> Biens</a>
                <a href="Controller?id=accueil_services"></i> Services</a>
                <a href="Controller?id=aide"></i> Aide</a>

                <c:if test="${connecte}">
                    <a href="Controller?id=profile" class="aj_btn">${sessionScope.pseudo}</a>
                </c:if>
                <c:if test="${!connecte}">
                    <a href="Controller?id=connection" class="aj_btn">Se Connecter</a>
                </c:if>

            </nav>
        </div>
    </header>

    <h2>Session de ${sessionScope.pseudo}</h2><br>

    <form class="login" method="POST" action="Controller?id=modification">
        <label><b>Nom de famille :</b></label>
        <input type="text" name="nom" id="Uname" placeholder=${sessionScope.nom}>
        <br><br>
        <label><b>Prenom :</b></label>
        <input type="text" name="prenom" id="name" placeholder=${sessionScope.prenom}>
        <br><br>
        <label><b>Pseudo :</b></label>
        <input type="text" name="pseudo" id="pseudo" placeholder=${sessionScope.pseudo}>
        <br><br>
        <label><b>Mail personnel :</b></label>
        <input type="email" name="mail" id="mail" placeholder=${sessionScope.mail}>
        <br><br>
        <label><b>Telephone :</b></label>
        <input type="text" name="telephone" id="tel" placeholder=${sessionScope.tel}>
        <br><br>
        <%-- <label><b>Mot de passe :</b></label>
        <input type="password" name="mdp" id="Pass" placeholder=${sessionScope.mdp}>
        <br><br> --%>
        <input type="submit" name="log" id="log" value="Appliquer modifications">
        <br><br>
        <a href="Controller?id=supprimer">Supprimer Compte</a>
        <br>
    </form>
</body>
</html>
