<%--
  Created by IntelliJ IDEA.
  User: Florent
  Date: 07/03/2023
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html html xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <title>Page Aide</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="HTML/style/styles.css">
</head>

<body>
    <header>
        <div class="inner-width">
            <a href="Controller?id=accueil">
                <h1 class="logo img">Annonces<span style="color:red;">et</span>Vous</h1>
                <i class="menu-toggle-btn fas fa-bars"></i>
            </a>
            <nav class="navigation-menu">
                <a href="Controller?id=accueil_biens"></i> Produits</a>
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

    <h2>Une petite aide</h2><br>

    <h1>Question frequente </h1>

    <div class="faq-content">
        <div class="faq-question">
            <input id="q1" type="checkbox" class="panel">
            <div class="plus">+</div>
            <label for="q1" class="panel-title">Comment publier ?</label>
            <div class="panel-content">En mangeant de la soupe</div>
        </div>

        <div class="faq-question">
            <input id="q2" type="checkbox" class="panel">
            <div class="plus">+</div>
            <label for="q2" class="panel-title">Bonjpur ca va ?</label>
            <div class="panel-content">salut ca va </div>
        </div>

        <div class="faq-question">
            <input id="q3" type="checkbox" class="panel">
            <div class="plus">+</div>
            <label for="q3" class="panel-title">Quel est la dif entre un bien et un service ?</label>
            <div class="panel-content">service = actions/ biens = produit</div>
        </div>
    </div>
</body>
</html>
