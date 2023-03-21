<%--
  Created by IntelliJ IDEA.
  User: tgeor
  Date: 21/03/2023
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
  <meta charset="utf-8">
    <title>Page Mes_Annonces</title>
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

  <c:if test="${connecte}">
    <div>
      <a href="Controller?id=creation_annonce">Nouvelle Annonce</a>
    </div>
  </c:if>

  <c:forEach var="annonce" items="${requestScope.liste_annonce}">
    <div class="annonce">
      <h2 class="annonce-titre">Titre : ${annonce.titre}</h2>
      <p class="annonce-prix">Prix : ${annonce.prix}</p>
      <div style="float: left"></div>
      <img class="photo" src="https://cdn.futura-sciences.com/sources/images/diaporama/1009-diapo-ponts/170314-album-pont2.jpg">
      <p class="vendeur" style="float: right">Vendeur : ${annonce.vendeur}</p>
      <div class="annonce-description">Description : ${annonce.descriptif}</div>
    </div>
  </c:forEach>

</body>
</html>
