<%--
  Created by IntelliJ IDEA.
  User: Florent
  Date: 20/03/2023
  Time: 17:01
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
            <%-- <a href="Controller?id=accueil"><i class="fas fa-home home"></i> Home</a> --%>
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

    <input type="checkbox" id="maCheckbox">
    <label for="maCheckbox">bonjour coche :</label>
    <p id="texte1" style="display: none;">Texte quand la checkbox est cochée. A REMPLIR</p>
    <p id="texte2" style="display: block;">Texte quand la checkbox est décochée. A remplir</p>
    <script>
        // On récupère la checkbox et les éléments de texte
        var checkbox = document.getElementById("maCheckbox");
        var texte1 = document.getElementById("texte1");
        var texte2 = document.getElementById("texte2");

        // On ajoute un écouteur d'événement sur le changement de la checkbox
        checkbox.addEventListener("change", function() {
            // On teste si la checkbox est cochée ou non
            if (checkbox.checked) {
                // Si oui, on affiche le premier texte et on cache le deuxième
                texte1.style.display = "block";
                texte2.style.display = "none";
            } else {
                // Si non, on fait l'inverse
                texte1.style.display = "none";
                texte2.style.display = "block";
            }
        });
    </script>
</body>
</html>
