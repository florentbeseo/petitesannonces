<%--
  Created by IntelliJ IDEA.
  User: tgeor
  Date: 08/03/2023
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page_Inscription</title>
    <link rel="stylesheet" type="text/css" href="HTML/style/styles.css">
</head>
<body>
    <h2>Creation compte</h2><br>
    <form class="login" method="POST" action="Controller?id=inscription">
        <label><b>Nom de famille :
        </b>
        </label>
        <input type="text" name="Nom" id="Uname" placeholder="Nom">
        <br><br>
        <label><b>Prenom :
        </b>
        </label>
        <input type="text" name="Nom" id="name" placeholder="Prenom">
        <br><br>
        <label><b>Pseudo :
        </b>
        </label>
        <input type="text" name="pseudo" id="pseudo" placeholder="Pseudo ">
        <br><br>
        <label><b>Mail personnel :
        </b>
        </label>
        <input type="email" name="mail" id="mail" placeholder="Mail ">
        <br><br>
        <label><b>Date de naissance :
        </b>
        </label>
        <input type="date" name="date" id="date" placeholder="Date ">
        <br><br>
        <label><b>Telephone :
        </b>
        </label>
        <input type="number" name="telephone" id="tel" placeholder="Tel  ">
        <br><br>
        <label><b>Mot de passe :
        </b>
        </label>
        <input type="password" name="Mdp" id="Pass" placeholder="Mot de passe   ">

        <br><br>
        <input type="button" name="log" id="log" value="Creer un compte">
    </form>
</body>
</html>
