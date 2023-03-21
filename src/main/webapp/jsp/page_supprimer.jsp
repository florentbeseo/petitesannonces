<%--
  Created by IntelliJ IDEA.
  User: tgeor
  Date: 21/03/2023
  Time: 00:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html html xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <title>Page_Supprimer</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
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

  <h2>Supprimer compte</h2><br>

  <form class="login">
    <label><b>Nom d'utilisateur</b></label>
    <input type="text" name="Nu" id="Uname" placeholder="Username" required>
    <br><br>
    <label><b>Mot de passe</b></label>
    <input type="Password" name="Mdp" id="Pass" placeholder="Password" required>
    <br><br>
    <input type="submit" name="log" id="log" value="Supprimer">
    <br><br>
  </form>

</body>
</html>
