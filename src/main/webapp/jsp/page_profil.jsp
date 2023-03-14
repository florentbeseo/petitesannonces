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
    <label><b>Nom de famille :</b></label>
    <p>${sessionScope.nom}</p>
    <br><br>
    <label><b>Prenom :</b></label>
    <p>${sessionScope.prenom}</p>
    <br><br>
    <label><b>Pseudo :</b></label>
    <p>${sessionScope.pseudo}</p>
    <br><br>
    <label><b>Mail personnel :</b></label>
    <p>${sessionScope.mail}</p>
    <br><br>
    <label><b>Date de naissance :</b></label>
    <p>${sessionScope.date}</p>
    <br><br>
    <label><b>Telephone :</b></label>
    <p>${sessionScope.tel}</p>
    <br><br>
    <label><b>Mot de passe :</b></label>
    <p>${sessionScope.mdp}</p>
    <br><br>
    <%-- <button type="button" name="log" id="log">Supprimer le Compte</button> --%>
    <a href="Controller?id=modifier">Modification</a>
</body>
</html>
