<%--
  Created by IntelliJ IDEA.
  User: Florent
  Date: 20/03/2023
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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

    <div>

    </div>

</body>
</html>
