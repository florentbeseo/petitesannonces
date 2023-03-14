<%--
  Created by IntelliJ IDEA.
  User: Florent
  Date: 07/03/2023
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Page Profile</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
    <h2>Session de ${sessionScope.mail}</h2><br>
    <%-- <ul>
        <li><a href="">Nom du site</a></li>
        <li><a href="">Biens</a></li>
        <li><a href="">Service</a></li>
        <li><a href="" >Profil</a></li>
        <li><a href="" >Aide</a></li>
    </ul> --%>
    <div class="login" method="POST" action="Controller?id=profil">
        <label><b>Nom de famille :</b></label>
        <p type="text" name="nom" id="Uname">${sessionScope.nom}</p>
        <br><br>
        <%-- <label><b>Prenom :</b></label>
        <input type="text" name="prenom" id="name" placeholder="Prenom">
        <br><br>
        <label><b>Pseudo :</b></label>
        <input type="text" name="pseudo" id="pseudo" placeholder="Pseudo ">
        <br><br>
        <label><b>Mail personnel :</b></label>
        <input type="email" name="mail" id="mail" placeholder="Mail ">
        <br><br>
        <label><b>Date de naissance :</b></label>
        <input type="date" name="date" id="date" placeholder="Date ">
        <br><br>
        <label><b>Telephone :</b></label>
        <input type="number" name="telephone" id="tel" placeholder="Tel  ">
        <br><br>
        <label><b>Mot de passe :</b></label>
        <input type="password" name="mdp" id="Pass" placeholder="Mot de passe   ">
        <br><br> --%>
        <%-- <button type="button" name="log" id="log">Supprimer le Compte</button> --%>
    </div>
</body>
</html>
