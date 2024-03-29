<%--
  Created by IntelliJ IDEA.
  User: tgeor
  Date: 21/03/2023
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html html xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <title>Page Annonce</title>
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

    <br>
    <div class="container presentation">
        <div class="row">
            <div class="col photo">
                <img class="img-fluid" src="https://cdn.futura-sciences.com/sources/images/diaporama/1009-diapo-ponts/170314-album-pont2.jpg"/>
            </div>
            <div class="col coordinate">
                <h1>Titre</h1>
                <br>
                <dl>
                    <dt>Prix:</dt><dd>12$</dd>
                    <br>
                    <dt>Extra:</dt><dd>objet</dd>
                    <br>
                    <dt>Etat:</dt><dd>neuf</dd>
                    <br>
                    <dt>Type: </dt><dd>Véhicule</dd>
                    <br>
                    <dt>Categorie: </dt><dd>Bien</dd>
                    <br>
                </dl>
            </div>
        </div>
    </div>
    <br><br>
    <form class="login">
        <p>Descriptif</p>
    </form>


</body>
</html>
